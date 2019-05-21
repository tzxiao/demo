package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @since 转码
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		FileInputStream flm =new FileInputStream("http.txt");
		InputStreamReader isr=new InputStreamReader(flm,"GBK");
		BufferedReader bf = new BufferedReader(isr);
		
		FileOutputStream of = new FileOutputStream("http_utf8.txt");
		OutputStreamWriter ow =new OutputStreamWriter(of,"Utf-8");
		BufferedWriter bw = new BufferedWriter(ow);
		PrintWriter pw = new PrintWriter(bw);
		String line =null;
		while((line=bf.readLine())!=null) {
			pw.print(line);
		}
		System.out.println("装码完成");
		bf.close();
		pw.close();
	}
}
