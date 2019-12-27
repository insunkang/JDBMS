package api.util;

import java.util.ArrayList;

public class ArrayListExam01 {

	public static void main(String[] args) {
		//79,55,100,98,99를 ArrayList에 담고 총점과 평균을 출력하세요.
		//[출력형태]
		//총점:
		//평균:
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
		System.out.println("총점: "+a);
		System.out.println("평균: "+a/(double)size);
		

	}

}
