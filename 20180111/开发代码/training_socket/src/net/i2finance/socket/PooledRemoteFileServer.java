package net.i2finance.socket;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class PooledRemoteFileServer {
	/** 最大连接数. */
	protected int maxConnections;

	//端口
	protected int listenPort;

	//服务端
	protected ServerSocket serverSocket;

	/**
	 * Instantiates a new pooled remote file server.
	 * 
	 * @param aListenPort
	 *            the a listen port
	 * @param maxConnections
	 *            the max connections
	 */
	public PooledRemoteFileServer(int aListenPort, int maxConnections) {
		listenPort = aListenPort;// 监听端口
		this.maxConnections = maxConnections;// 最大同时连接
	}

	/**
	 * 初始化池：每次创建一个Runnable实例，然后创建线程对象
	 */
	public void setUpHandlers() {
		for (int i = 0; i < maxConnections; i++) {
			PooledConnectionHandler currentHandler = new PooledConnectionHandler();
			// 线程启动后将一直监控Socket队列，以轮询的方式
			// 监控是否有新的客户端请求到来，如果有的话则取
			// 出处理，无的话则继续等待直至请求到来
			new Thread(currentHandler, "Handler" + i).start();
		}
	}

	/**
	 * 接收客户端连接
	 */
	public void acceptConnections() {
		try {
			System.out.println("服务端要启动了。。。。");
			ServerSocket server = new ServerSocket(listenPort, 5);
			Socket incomingConnection = null;
			while (true) {
				incomingConnection = server.accept();
				handleConnection(incomingConnection);
			}
		} catch (BindException be) {
			System.out.println("");
		} catch (IOException ioe) {
			System.out.println("" + listenPort);
		}
	}

	/**
	 * 在池中处理Socket请求
	 * 
	 * @param connectionToHandle
	 *            the connection to handle
	 */
	protected void handleConnection(Socket connectionToHandle) {
		PooledConnectionHandler.processRequest(connectionToHandle);
	}

	public static void main(String args[]) {
		PooledRemoteFileServer server = new PooledRemoteFileServer(5500, 3);
		// 初始化线程池
		server.setUpHandlers();
		// 开始在指定端口等待到来的请求
		server.acceptConnections();
	}
}
