package core;

import java.net.Socket;

import http.HttpRequest;

public class ClientHandler implements Runnable {
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket=socket;
	}

	public void run(){
		System.out.println("开始处理请求！！！！");
		try {
			/*
			 * ClientHandler处理客户端请求大致做三件事:
			 * 1:解析请求
			 * 2:处理请求
			 * 3:发送响应
			 */
			/*
			 * 1 解析请求的过程
			 * 实例化HttpRequest的同时，将Socket传入，以便
			 * HttpRequest可以根据Socket获取输入流，读取客户
			 * 端发送过来的请求内容。
			 */
			HttpRequest request = new HttpRequest(socket);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
