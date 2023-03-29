package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpMultichatClient {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("USAGE: java TcpIpMultichatClient 대화명");
			System.exit(0);
		}

		try {
			String serverIp = "127.0.0.1";
			// 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			Thread sender = new ClientSender(socket, args[0]);
			Thread receiver = new ClientReceiver(socket);
			sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
		}
	}

	static class ClientSender extends Thread {
		Socket socket;
		OutputStreamWriter out;
		String name;

		ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				out = new OutputStreamWriter(socket.getOutputStream());
				this.name = name;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void run() {
			try {
				Scanner scanner = new Scanner(System.in);
				if (out != null) {
					out.write(name+"\\n");
					out.flush();
				}
				while (out != null) {
					out.write("[" + name + "]" + scanner.nextLine());
					out.flush();
				}
				scanner.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class ClientReceiver extends Thread {
		Socket socket;
		BufferedReader in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			} catch (IOException e) {
			}
		}

		public void run() {
			while (in != null) {
				try {
					System.out.println(in.readLine());
				} catch (IOException e) {
				}
			}
		}
	}
}
