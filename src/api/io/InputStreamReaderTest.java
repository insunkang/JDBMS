package api.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

//InputSteam을 이용해서 키보드로 입력받는 한글 문자열을 읽기 - Scanner클래스의 next메소드의 기능을 구현
public class InputStreamReaderTest {

	public static void main(String[] args) {		
		InputStreamReader in = new InputStreamReader(System.in);   
		PrintStream out = System.out;
		
		while(true) {
			//1. 스트림의 데이터를 1byte 읽기
			try {
				int data = in.read();
				if(data==13) {
					break;				
				}
				out.print((char)data);
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		}

	}

}
