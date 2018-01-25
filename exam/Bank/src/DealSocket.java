import bean.Money;
import bean.RequestParam;
import util.JaxbUtil;
import util.JdbcUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 利用线程来处理客户端socket请求
 *
 * @author aiboleepro
 * @date 2018-01-18 下午7:55
 **/
public class DealSocket implements Runnable {

    private Socket socket;

    public DealSocket(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            this.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理客户端请求
     * */
    public void execute() throws IOException {
        // 读取客户端数据
        DataInputStream input = new DataInputStream(socket.getInputStream());
        //这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
        String paramXml = input.readUTF();
        RequestParam requestParam = JaxbUtil.convertToJavaBean(paramXml,RequestParam.class);
        Money money = this.query(requestParam);
        // 给客户端发数据
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String resultXml = JaxbUtil.convertToXml(money);
        out.writeUTF(resultXml);
        input.close();
        out.close();
    }

    /**
     * 查询用户的银行资产
     * */
    public Money query(RequestParam requestParam){
        Money money = new Money();
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM money where userId=? and bankName=?");
            ps.setString(1,requestParam.getUserId());
            ps.setString(2,requestParam.getBankName());
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                money.setId(resultSet.getString("id"));
                money.setMoney(resultSet.getInt("money"));
                money.setName(resultSet.getString("name"));
                money.setBankName(resultSet.getString("bankName"));
                money.setUserId(resultSet.getString("userId"));
            }
            return money;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.release(connection,ps,resultSet);
        }
        return money;
    }


}
