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
			System.out.println("����̹� �ε� ����");
			Connection con =
					DriverManager.getConnection(url, user, password);
			System.out.println("���� ����"+con);
			
			//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
			Statement stmt = con.createStatement();
			System.out.println("SQL�� �����ϱ� ���� ��ü ����: "+stmt);
			
			//4. sql �����ϱ�
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"�� �� ���� ����");
			
			}catch(ClassNotFoundException e){
						
			}catch(SQLException e) {
						System.out.println("���� ����"+e.getMessage());
					}

	}

}
