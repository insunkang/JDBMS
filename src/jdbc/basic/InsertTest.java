package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
			String url = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
			String user = "scott";
			String password = "tiger";
			String sql = "insert into tb_board values(board_seq.nextval,'jang','����','����',sysdate,0)";
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
			stmt.executeUpdate(sql);
			System.out.println("���� ����");
			
			}catch(ClassNotFoundException e){
						
			}catch(SQLException e) {
						System.out.println("���� ����"+e.getMessage());
					}

	}

}
