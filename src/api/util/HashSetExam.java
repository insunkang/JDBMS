package api.util;

import java.awt.print.Printable;
import java.util.HashSet;

public class HashSetExam {

	public static void main(String[] args) {
		//다음과 같은 변수명으로 HashSet객체 2개 작성하기
		//set1 -> 1부터 10까지의 정수
		//set2 -> 5부터 15까지의 정수
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
		
		
		//set1과 set2 합집합 출력하기
//		set1.addAll(set2);
//		for (String data : set1) {
//			System.out.println("합집합 =>"+data);
//		}
//		System.out.println("===========================");
//		
		
		//set1과 set2 교집합 출력하기
		set1.retainAll(set2);
		for (String data : set1) {
			System.out.println("교집합=>"+data);
		}
		System.out.println("===========================");
		
		
		
		
		
	}

}
