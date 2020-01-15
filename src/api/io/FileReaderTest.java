package api.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//문자단위로 읽어서 파일 input하기
public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fs = null;
		
		 
		try {
			//1.파일 오픈하기
			fs = new FileReader("src/api/io/FileTest01.java");
			//2.파일 액세스
			int count=0;//실행횟수
			long start = System.nanoTime();
			while(true) {
				int data = fs.read();
				if(data==-1) {
					break;
				}
				count++;
				//System.out.print((char)data);
			}
			long end = System.nanoTime();
			System.out.println("실행횟수=>"+count);
			System.out.println("실행시간=>"+(end-start));
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3.파일 닫기
			try {
				if(fs!=null)fs.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
