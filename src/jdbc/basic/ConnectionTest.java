package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//오라클에 접속하기
public class ConnectionTest {
	//127.0.0.1 = localhost = 현재 작업 중인 내 pc
	
	public static void main(String[] args) {
		//연결 문자열 = 어떤 DBMS를 쓰느냐에 따라 형식이 달라진다.
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//String url = "jdbc:oracle:thin:@70.12.115.69:1521:xe";
		//원격에 있는 실제 DB서버 ip
		String url = "jdbc:oracle:thin:@70.12.115.70:1521:xe"; 
		
		//접속 계정
		String user = "scott";
		//접속할 계정의 패스워드
		String password = "tiger";
		try {
			    //1. 오라클 드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩 성공!!");
				//2. DBMS에 연결하기 - 연결 정보를 정의
				// -==> DBMS에 연결하고 연결정보를 Connection  타입으로 반환한다.
				Connection con =
						DriverManager.getConnection(url, user, password);
				System.out.println("연결 성공!!"+con);
				//3. sql을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 connection 객체를 이용해서 생성
				Statement stmt = con.createStatement();
				System.out.println("SQL을 실행하기 위한 객체 정보: "+stmt);
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결 실패: "+e.getMessage());
		}
	}

}
