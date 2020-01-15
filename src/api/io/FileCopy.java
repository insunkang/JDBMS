package api.io;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		//FileTest01.java���� copy�ϱ�
		//1. FileReader�� �а� FileWriter�� ����ϱ�
		//2. src/data/copy_result.txt �� �����ϱ�
		//3. �ַܼε� ��µǵ��� �ۼ�
		FileReader fs = null;
		FileWriter fw = null;
		 
		try {
			//1.���� �����ϱ�
			fs = new FileReader("src/api/io/FileTest01.java");
			fw = new FileWriter("src/data/copy_result.txt",true);
			//2.���� �׼���
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
			//3.���� �ݱ�
			try {
				if(fs!=null)fs.close();
				if(fw!=null)fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
