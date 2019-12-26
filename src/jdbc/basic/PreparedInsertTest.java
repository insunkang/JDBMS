package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedInsertTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("******게시글 등록*********");
		System.out.println("아이디: ");
		String id = key.next();
		System.out.println("제목: ");
		String title= key.next();
		System.out.println("내용: ");
		String content = key.next();
		System.out.println();
		
		
		obj.insert(id, title, content);
		

	}

	public void insert(String id, String title, String content) {
		String url = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
		String user = "scott";
		String password = "tiger";
//		String sql = "insert into tb_board values(board_seq.nextval,'"+id+"','"+title+"','"+content+"',sysdate,0)";
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공");
		con =
				DriverManager.getConnection(url, user, password);
		//1. PreparedStatement 생성
		stmt = con.prepareStatement(sql);
		//2. ?d에 값 전달하기
		stmt.setString(1, id );
		stmt.setString(2, title);
		stmt.setString(3, content);
		
		//3. 실행하기
		int result = stmt.executeUpdate();
		System.out.println(result+"개 행 삽입 성공");
		
		}catch(ClassNotFoundException e){
					
		}catch(SQLException e) {
					System.out.println("연결 실패"+e.getMessage());
		}finally {try {
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	
		}

	}
	
}

	

