package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//����Ŭ�� �����ϱ�
public class ConnectionTest {
	//127.0.0.1 = localhost = ���� �۾� ���� �� pc
	
	public static void main(String[] args) {
		//���� ���ڿ� = � DBMS�� �����Ŀ� ���� ������ �޶�����.
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//String url = "jdbc:oracle:thin:@70.12.115.69:1521:xe";
		//���ݿ� �ִ� ���� DB���� ip
		String url = "jdbc:oracle:thin:@70.12.115.70:1521:xe"; 
		
		//���� ����
		String user = "scott";
		//������ ������ �н�����
		String password = "tiger";
		try {
			    //1. ����Ŭ ����̹� �ε�
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("����̹� �ε� ����!!");
				//2. DBMS�� �����ϱ� - ���� ������ ����
				// -==> DBMS�� �����ϰ� ���������� Connection  Ÿ������ ��ȯ�Ѵ�.
				Connection con =
						DriverManager.getConnection(url, user, password);
				System.out.println("���� ����!!"+con);
				//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
				Statement stmt = con.createStatement();
				System.out.println("SQL�� �����ϱ� ���� ��ü ����: "+stmt);
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}catch(SQLException e) {
			System.out.println("���� ����: "+e.getMessage());
		}
	}

}
