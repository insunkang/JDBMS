package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedDeleteTest {

	public static void main(String[] args) {
			Scanner key = new Scanner(System.in);
			PreparedDeleteTest obj = new PreparedDeleteTest();
			System.out.println("*******�Խñ� ����*******");
			System.out.println("������ �� boardnum: ");
			int boardnum = key.nextInt();
			obj.delete(boardnum);
	}
	public void delete(int boardnum) {
		String url = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board");
		sql.append("where boardnum = ?");
//		String sql = "delete tb_board where boardnum = ?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����");
		con =
				DriverManager.getConnection(url, user, password);
		System.out.println("���� ����"+con);
		
		//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
		stmt = con.prepareStatement(sql.toString());
		stmt.setInt(1, boardnum);
		
		System.out.println("SQL�� �����ϱ� ���� ��ü ����: "+stmt);
		
		//4. sql �����ϱ�
		int result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
		}catch(ClassNotFoundException e){
					
		}catch(SQLException e) {
					System.out.println("���� ����"+e.getMessage());
				}finally {try {
					if(stmt!=null)stmt.close();
					if(con!=null)con.close();
				}catch(SQLException e ) {
					e.printStackTrace();
				}
					
				}
	}

}
