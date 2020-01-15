package api.io;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		//FileTest01.java파일 copy하기
		//1. FileReader로 읽고 FileWriter로 출력하기
		//2. src/data/copy_result.txt 로 생성하기
		//3. 콘솔로도 출력되도록 작성
		FileReader fs = null;
		FileWriter fw = null;
		 
		try {
			//1.파일 오픈하기
			fs = new FileReader("src/api/io/FileTest01.java");
			fw = new FileWriter("src/data/copy_result.txt",true);
			//2.파일 액세스
			while(true) {
				int data = fs.read();
				if(data==-1) {
					break;
				}		
				fw.write((char)data);
				System.out.print((char)data);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}finally {
			//3.파일 닫기
			try {
				if(fs!=null)fs.close();
				if(fw!=null)fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
