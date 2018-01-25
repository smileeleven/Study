import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aiboleepro
 * @date 2018-01-18 下午7:52
 **/
public class BankServer {

    // 监听的端口号
    private static final int PORT = 8081;

    private static ExecutorService executorService = Executors.newFixedThreadPool(50);

    private void init(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket socket = serverSocket.accept();
                // 这里如果不处理客户端请求，会在这里阻塞，所以需要多线程尽快处理客户端请求
                executorService.submit(new DealSocket(socket));
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        BankServer server = new BankServer();
        server.init();


    }
}
