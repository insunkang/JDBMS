package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
			String url = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
			String user = "scott";
			String password = "tiger";
			String sql = "update tb_board set id = 'kang' where boardnum = 2";
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			Connection con =
					DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공"+con);
			
			//3. sql을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 connection 객체를 이용해서 생성
			Statement stmt = con.createStatement();
			System.out.println("SQL을 실행하기 위한 객체 정보: "+stmt);
			
			//4. sql 실행하기
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"개 행 삽입 성공");
			
			}catch(ClassNotFoundException e){
						
			}catch(SQLException e) {
						System.out.println("연결 실패"+e.getMessage());
					}

	}

}
