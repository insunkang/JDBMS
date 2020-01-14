package api.util;

import java.awt.print.Printable;
import java.util.HashSet;

public class HashSetExam {

	public static void main(String[] args) {
		//������ ���� ���������� HashSet��ü 2�� �ۼ��ϱ�
		//set1 -> 1���� 10������ ����
		//set2 -> 5���� 15������ ����
		HashSet<String> set1 = new HashSet<>();
		for(int i=1;i<=10;i++) {
			String a = Integer.toString(i);
			set1.add(a);
		}
		HashSet<String> set2 = new HashSet<>();
		for(int i=5;i<=15;i++) {
			String a = Integer.toString(i);
			set2.add(a);
		}
		
		
		//set1�� set2 ������ ����ϱ�
//		set1.addAll(set2);
//		for (String data : set1) {
//			System.out.println("������ =>"+data);
//		}
//		System.out.println("===========================");
//		
		
		//set1�� set2 ������ ����ϱ�
		set1.retainAll(set2);
		for (String data : set1) {
			System.out.println("������=>"+data);
		}
		System.out.println("===========================");
		
		
		
		
		
	}

}
