package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedUpdateTest {

	public static void main(String[] args) {
			Scanner key = new Scanner(System.in);
			PreparedUpdateTest obj = new PreparedUpdateTest();
			
			System.out.println("******게시글 업데이트*******");
			System.out.println("변경할 아이디 내용: ");
			String id = key.next();
			System.out.println("변경할 Boardnum: ");
			int boardnum = key.nextInt();
			
			obj.update(id, boardnum);
			

	}
	
	
	public void update(String id, int boardnum) {
		String url = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "update tb_board set id = ? where boardnum = ?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공");
		
		
		con =
				DriverManager.getConnection(url, user, password);
//		System.out.println("연결 성공"+con);
		
		//3. sql을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 connection 객체를 이용해서 생성
		stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setInt(2, boardnum);
		
		//4. sql 실행하기
		int result = stmt.executeUpdate();
		System.out.println(result+"개 행 수정 성공");
		
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
