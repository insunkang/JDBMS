package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScoreTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		 
		try {
			//1.���� �����ϱ�
			//fs = new FileReader("src/data/test.txt");
			//br = new BufferedReader(fr);//������Ʈ�� - �⺻��Ʈ��������
			//BufferedReader�� ������Ʈ������ ���õ����Ϳ� ������ �� �����Ƿ�
			//���õ����͸� ���� �� �ִ� �⺻��Ʈ���� �����ؼ� �Ѱ��־�� �Ѵ�.
			br = new BufferedReader(new FileReader("src/data/score.txt"));
			//2.���� �׼���
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
				System.out.println(data[0]+"�� ������"+data[1]+"��");
				
			}
			System.out.println("����=>"+total);
			System.out.println("���=>"+(total/count));
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3.���� �ݱ�
			try {
				if(br!=null)br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
