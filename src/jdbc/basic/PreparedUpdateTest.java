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
			
			System.out.println("******�Խñ� ������Ʈ*******");
			System.out.println("������ ���̵� ����: ");
			String id = key.next();
			System.out.println("������ Boardnum: ");
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
		System.out.println("����̹� �ε� ����");
		
		
		con =
				DriverManager.getConnection(url, user, password);
//		System.out.println("���� ����"+con);
		
		//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
		stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setInt(2, boardnum);
		
		//4. sql �����ϱ�
		int result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
		}catch(ClassNotFoundException e){
					
		}catch(SQLException e) {
					System.out.println("���� ����"+e.getMessage());
				}finally {try {
					if(stmt!=null)stmt.close();
					if(con!=null)con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
					
				}
	}

}
