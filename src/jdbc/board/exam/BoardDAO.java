package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board ���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
public class BoardDAO {
	public void PreparedSelect() {
		
		String sql = "select * from tb_board";
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			
			con = DBUtil.getConnect();
					
			stmt = con.prepareStatement(sql);
			
			//select���� ����
			rs = stmt.executeQuery();
//			System.out.println("rs: "+rs);
			
			//ResultSet�� ���ڵ尡 �����ϴ� ���� �ݺ����� ����
			while(rs.next()) {//=> ���ڵ带 ��ȸ�ϱ� ���ؼ���
											// 		 ���ڵ尡 �� ���� �ݵ�� Ŀ���� �̵����Ѿ� �Ѵ�.
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString("content")+"\t");
				System.out.print(rs.getDate(5)+"\t");
				System.out.println(rs.getInt(6));
				
				
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {try {
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
			if(rs!=null)rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		}
		
	}
	public void delete(int boardnum) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board");
		sql.append("where boardnum = ?");
//		String sql = "delete tb_board where boardnum = ?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
		
		System.out.println("����̹� �ε� ����");
		con = DBUtil.getConnect();
		
		System.out.println("���� ����"+con);
		
		//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
		stmt = con.prepareStatement(sql.toString());
		stmt.setInt(1, boardnum);
		
		System.out.println("SQL�� �����ϱ� ���� ��ü ����: "+stmt);
		
		//4. sql �����ϱ�
		int result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
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
	public void insert(String id, String title, String content) {
		
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		Connection con = null;

		PreparedStatement stmt = null;
		try {
		
		con = DBUtil.getConnect();
				
		//1. PreparedStatement ����
		stmt = con.prepareStatement(sql);
		//2. ?d�� �� �����ϱ�
		stmt.setString(1, id );
		stmt.setString(2, title);
		stmt.setString(3, content);
		
		//3. �����ϱ�
		int result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
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
	public void update(String id, int boardnum) {
		
		String sql = "update tb_board set id = ? where boardnum = ?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
		
		
		
		con = DBUtil.getConnect(); //DBMS ����
				
//		System.out.println("���� ����"+con);
		
		//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
		stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setInt(2, boardnum);
		
		//4. sql �����ϱ�
		int result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
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
