package http;

import java.io.InputStream;
import java.net.Socket;


/**
 * 请求对象
 * 该类的每个实例用于表示客户端浏览器发送过来的一个具体
 * 的请求信息。
 * 一个请求包含三部分:请求行，消息头，消息正文
 *@author Administrator
 *
 */
public class HttpRequest {
	//请求行相关信息定义
	//请求方式
	private String method;
	//请求路径
	private String url;
	//协议版本
	private String protocol;

	//消息头相关信息定义


	//消息正文相关信息定义
	
	/*
	 * 和客户端连接相关的属性
	 */
	private Socket socket;
	private InputStream in;
	
	/**
	 * 构造方法，用来初始化请求对象
	 * 初始化就是解析请求的过程。这里会根据Socket获取
	 * 输入流，用来读取客户端发送过来的请求内容，将内容
	 * 解析出来并设置到请求对象的对应属性上。
	 * 
	 */
	public HttpRequest(Socket socket) {
		
		try {
			this.socket=socket;
			//通过socket获取输入流，用于读取客户端发送的请求内容
			this.in=socket.getInputStream();
			/*
			 * 解析请求内容需要做三件事:
			 * 1:解析请求行内容
			 * 2:解析消息头内容
			 * 3:解析消息正文内容
			 */
			//解析请求行
			parseRequestLine();
			//解析消息头
			parseHeaders();
			//解析消息正文
			parseContent();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 解析消息正文
	 */
	private void parseRequestLine() {
		System.out.println("HttpRequest:解析请求行...");
		/*
		 * 先通过输入流读取第一行字符串(CRLF结尾)，因为一个请求中
		 * 第一行内容就是请求行内容
		 */
			String line=readLine();
			System.out.println("请求行："+line);
			/*
			 * 将请求行中的三部分信息:
			 * method url protocol
			 * 截取出来，并设置到对应的属性上
			 * 
			 * GET /index.html HTTP/1.1
			 */
			/*
			 * 以下代码可能会出现数组下标越界的情况，
			 * 后面会解决。
			 */
			String[] data =line.split("\\s");
			method = data[0];
			url = data[1];
			protocol = data[2];
			
			System.out.println("\\s");
			System.out.println("Method:"+method);
			System.out.println("URL:"+url);
			System.out.println("Protocol:"+protocol);

	}
	/**
	 * 解析请求行
	 */
	private void parseContent() {
		System.out.println("HttpRequest:解析消息正文...");
		
		System.out.println("HttpRequest:解析消息正文完毕...");
	}
	/**
	 * 解析消息头
	 */
	private void parseHeaders() {
		System.out.println("HttpRequest:解析消息头...");

		System.out.println("HttpRequest:解析消息头完毕");
	}
	
	/**
	 * 通过输入流in读取一行字符串。
	 * 连续读取若干字符，当读取到CRLF时停止，并将之前
	 * 读取的所有字符以一个字符串形式返回。返回的字符串
	 * 中不含有最后的CRLF。
	 * CR:回车符  对应ASC编码值13
	 * LF:换行符  对应ASC编码值10
	 * @return
	 */
	private String readLine() {
		StringBuilder builder =new StringBuilder();
		try {
			int pre=-1;//记录上次读取到的字符
			int cut=-1;//记录本次读取到的字符
			while((cut=in.read())!=-1) {
				if(pre==13 && cut==10) {
					break;
				}
				System.out.println(cut);
				builder.append((char)cut);
				pre=cut;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString().trim();
	}
	public String getMethod() {
		return method;
	}
	public String getUrl() {
		return url;
	}
	public String getProtocol() {
		return protocol;
	}
}
