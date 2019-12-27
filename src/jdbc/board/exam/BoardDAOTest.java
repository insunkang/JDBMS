package jdbc.board.exam;

import java.util.Scanner;

import jdbc.basic.PreparedInsertTest;

public class BoardDAOTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		BoardDAOImpl dao = new BoardDAOImpl();
		System.out.println("******게시글 등록*********");
		System.out.println("아이디: ");
		String id = key.next();
		System.out.println("제목: ");
		String title= key.next();
		System.out.println("내용: ");
		String content = key.next();
		System.out.println();
		
		
		dao.insert(id, title, content);
		

	}
}
