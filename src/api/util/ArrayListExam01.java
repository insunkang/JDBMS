package api.util;

import java.util.ArrayList;

public class ArrayListExam01 {

	public static void main(String[] args) {
		//79,55,100,98,99�� ArrayList�� ��� ������ ����� ����ϼ���.
		//[�������]
		//����:
		//���:
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(79);
		arr.add(55);
		arr.add(100);
		arr.add(98);
		arr.add(99);
		
		int a = 0;
		int size = arr.size();
		for(int i = 0; i< size; i++) {
			
			a= a+arr.get(i);
			
		}
		System.out.println("����: "+a);
		System.out.println("���: "+a/(double)size);
		

	}

}
