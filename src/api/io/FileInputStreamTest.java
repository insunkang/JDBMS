package api.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//advancedJava프로젝트폴더 아래 저장된 test.txt의 내용을 읽어서 콘솔에 출력하기
public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		 
		try {
			//1.파일 오픈하기
			fis = new FileInputStream("src/data/test.txt");
			//2.파일 액세스
			while(true) {
				int data = fis.read();
				if(data==-1) {
					break;
				}
				System.out.print((char)data);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3.파일 닫기
			try {
				if(fis!=null)fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
