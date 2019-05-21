package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @since Web主服务器
 * @author Administrator
 *
 */
public class WebServer {
	private ServerSocket server;
	
	public WebServer() {
		try {
			server=new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() {
		try {
			System.out.println("等待链接");
			Socket socket=server.accept();
			System.out.println("一个用户链接");
			
			ClientHandler hander =new ClientHandler(socket);
			Thread rand =new Thread(hander);
			rand.start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		WebServer server =new WebServer();
		server.start();
		
	}
}
