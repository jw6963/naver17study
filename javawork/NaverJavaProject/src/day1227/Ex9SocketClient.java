package day1227;

import java.io.IOException;
import java.net.Socket;

public class Ex9SocketClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip="192.168.0.26"; // 강사 pc 임시 ip
		Socket sck =null;
		try {
			sck= new Socket(ip, 6000);	
			System.out.println("서버 접속 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("서버 접속 실패: "+e.getMessage());
		}

	}

}
