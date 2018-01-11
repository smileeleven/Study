package net.i2finance.socketAD;

import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
  
public class TCPEchoServerPool {  
    public static void main(String[] args) throws IOException {  
        int threadPoolSize = 3; // Fixed ThreadPoolSize  
  
        final ServerSocket servSock = new ServerSocket(5500);  
        final Logger logger = Logger.getLogger("practical");  
  
        // Spawn a fixed number of threads to service clients  
        for (int i = 0; i < threadPoolSize; i++) {  
            Thread thread = new Thread() {  
                public void run() {  
                    while (true) {  
                        try {  
                            Socket clntSock = servSock.accept(); // Wait for a connection  
                            EchoProtocol.handleEchoClient(clntSock, logger); // Handle it  
                        } catch (IOException ex) {  
                            logger.log(Level.WARNING, "Client accept failed", ex);  
                        }  
                    }  
                }  
            };  
            thread.start();  
            logger.info("Created and started Thread = " + thread.getName());  
        }  
    }  
}  
