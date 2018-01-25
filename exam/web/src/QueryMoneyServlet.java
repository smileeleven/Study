import bean.Money;
import bean.RequestParam;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author aiboleepro
 * @date 2018-01-18 下午7:50
 **/
public class QueryMoneyServlet extends HttpServlet {

    // 创建线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=utf-8");
        // 1.接受客户端参数
        String userId = request.getParameter("userId");
        // 2.参数错误处理
        if(null == userId || ("").equals(userId)){
            request.setAttribute("error","您的请求参数有误!");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
        // 3.查询用户所有的银行
        List<RequestParam> requestParams = this.queryBank(userId);
        // 4.返回查询用户资产所需要的worker
        List<Worker> workers = this.addWorker(requestParams);
        // 5.组织返回结果
        List<Money> monies = this.getResult(workers);
        // 6.更新或保存结果到本地
        this.updateOrSave(monies);
        request.setAttribute("monies",monies);
        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }

    public void updateOrSave(List<Money> monies){
        for(Money money : monies){
            if(checkSame(money)){
                this.updateLocal(money);
            }else{
                this.saveLocal(money);
            }
        }
    }

    /**
     * 更新到本地
     * */
    public void updateLocal(Money money){
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps = connection.prepareStatement("UPDATE zhixiao SET money=? WHERE userId=? and proud=?");
            ps.setInt(1, money.getMoney());
            ps.setString(2,money.getUserId());
            ps.setString(3,money.getBankName());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(connection,ps,resultSet);
        }
    }

    /**
     * 保存产品到本地
     * */
    public void saveLocal(Money money){
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps = connection.prepareStatement("INSERT INTO zhixiao(id,name,proud,money,userId) VALUES(?,?,?,?,?)");
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2,money.getName());
            ps.setString(3,money.getBankName());
            ps.setInt(4,money.getMoney());
            ps.setString(5,money.getUserId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(connection,ps,resultSet);
        }
    }

    /**
     * 检查是否有相同产品
     * */
    public Boolean checkSame(Money money){
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps = connection.prepareStatement("SELECT * FROM zhixiao WHERE userId=? and proud=?");
            ps.setString(1,money.getUserId());
            ps.setString(2,money.getBankName());
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            jdbcUtil.release(connection,ps,resultSet);
        }
    }

    /**
     * 返回线程池处理结果
     * */
    private List<Money> getResult(List<Worker> workers){
        List<Money> list = new ArrayList<>();
        try {
            List<Future<Money>> futures = executorService.invokeAll(workers);
            for(Future<Money> future : futures){
                list.add(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return list;
    }

    /**
     * 返回查询用户资产所需要的worker
     * 相当于根据用户所拥有的产品去做分别的资产查询
     * */
    private List<Worker> addWorker(List<RequestParam> requestParams){
        List<Worker> workers = new ArrayList<>();
        RequestParam P2P = this.hasBank("P2P",requestParams);
        if(null != P2P){
            workers.add(new WorkerA(P2P));
        }
        RequestParam P2B = this.hasBank("P2B",requestParams);
        if(null != P2B){
            workers.add(new WorkerA(P2B));
        }
        RequestParam Fund = this.hasBank("Fund",requestParams);
        if(null != Fund){
            workers.add(new WorkerA(Fund));
        }
        return workers;
    }

    /**
     * 查询用户所有的银行
     * 相当于查询用户所拥有的产品
     * */
    private List<RequestParam> queryBank(String userId){
        List<RequestParam> list = new ArrayList<>();
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps = connection.prepareStatement("SELECT * FROM money WHERE userId=?");
            ps.setString(1,userId);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                RequestParam requestParam = new RequestParam();
                requestParam.setBankName(resultSet.getString("bankName"));
                requestParam.setUserId(resultSet.getString("userId"));
                list.add(requestParam);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            jdbcUtil.release(connection,ps,resultSet);
        }
        return list;
    }

    /**
     * 检查列表里是否有对应银行
     * */
    private RequestParam hasBank(String bankName, List<RequestParam> requestParams){
        for(RequestParam requestParam : requestParams){
            if(bankName.equals(requestParam.getBankName())){
                return requestParam;
            }
        }
        return null;
    }


}
