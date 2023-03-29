package day18;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpServer5 {
	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 서버소켓을 생성하여 8888번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(8888);
			System.out.println("서버가 준비되었습니다.");
 
			socket = serverSocket.accept();

			Sender   sender   = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
} 

class Sender extends Thread {
	Socket socket;
	OutputStreamWriter out;
	String name;

	Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new OutputStreamWriter(socket.getOutputStream());
			name = "["+socket.getInetAddress()+":"+socket.getPort()+"]";
		} catch(Exception e) {
			System.out.println("1"+e);
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(out!=null) {
			try {
				out.write(name+scanner.nextLine());		
			} catch(IOException e) {
				System.out.println("3"+e);
			}
		}
		scanner.close();
	} 
}

class Receiver extends Thread {
	Socket socket;
	InputStreamReader in;
	Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new InputStreamReader(socket.getInputStream());
		} catch(IOException e) {
			System.out.println("2"+e);
		}

	}
	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.read());
			} catch(IOException e) {
				System.out.println("4"+e);
			}
		}
	} 
}
