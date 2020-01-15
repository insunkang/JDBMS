package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScoreTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		 
		try {
			//1.파일 오픈하기
			//fs = new FileReader("src/data/test.txt");
			//br = new BufferedReader(fr);//보조스트림 - 기본스트림과연결
			//BufferedReader는 보조스트림으로 원시데이터와 연결할 수 없으므로
			//원시데이터를 읽을 수 있는 기본스트림을 생성해서 넘겨주어야 한다.
			br = new BufferedReader(new FileReader("src/data/score.txt"));
			//2.파일 액세스
			int count = 0;
			int total = 0;
			
			while(true) {
				String line = br.readLine();
				
				
				
				if(line==null) {				
					break;
				}
				String[] data = line.split(",");
				total = total+Integer.parseInt(data[1]);
				count++;
				System.out.println(data[0]+"의 점수는"+data[1]+"점");
				
			}
			System.out.println("총점=>"+total);
			System.out.println("평균=>"+(total/count));
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3.파일 닫기
			try {
				if(br!=null)br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
