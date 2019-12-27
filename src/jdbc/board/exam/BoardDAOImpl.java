package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board ���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
public class BoardDAOImpl implements BoardDAO {
	public int insert(BoardDTO board) {
		System.out.println("dto���޼ҵ�: "+board);
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		
		int result = 0; // �޼ҵ� �������� ����� ����
		try {
		
		con = DBUtil.getConnect();
				
		//1. PreparedStatement ����
		stmt = con.prepareStatement(sql);
		//2. ?d�� �� �����ϱ�
		stmt.setString(1, board.getId() );
		stmt.setString(2, board.getTitle());
		stmt.setString(3, board.getContent());
		
		//3. �����ϱ�
		result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
		}catch(SQLException e) {
					System.out.println("���� ����"+e.getMessage());
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public void Select() {
		
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
		}finally {
			DBUtil.close(rs, stmt, con);
			
		}
		
	}
	public int delete(int boardnum) {
		PreparedStatement stmt = null;
		Connection con = null;
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete tb_board");
//		sql.append("where boardnum = ?");
		String sql = "delete tb_board where boardnum = ?";
		int result = 0;
		
		try {
		con = DBUtil.getConnect();
		System.out.println("���� ����"+con);
		
		//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, boardnum);
		
		System.out.println("SQL�� �����ϱ� ���� ��ü ����: "+stmt);
		
		//4. sql �����ϱ�
		result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
		}catch(SQLException e) {
					System.out.println("���� ����"+e.getMessage());
				}finally {
					DBUtil.close(null, stmt, con);
					
				}return result;
	}
	public int insert(String id, String title, String content) {
		
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		Connection con = null;
		int result = 0; // �޼ҵ� �������� ����� ����
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
		result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
		}catch(SQLException e) {
					System.out.println("���� ����"+e.getMessage());
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int update(String id, int boardnum) {
		PreparedStatement stmt = null;
		Connection con = null;
		String sql = "update tb_board set id = ? where boardnum = ?";
		int result = 0;
		
		
		try {
		
		
		
		con = DBUtil.getConnect(); //DBMS ����
				
//		System.out.println("���� ����"+con);
		
		//3. sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� connection ��ü�� �̿��ؼ� ����
		stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setInt(2, boardnum);
		
		//4. sql �����ϱ�
		result = stmt.executeUpdate();
		System.out.println(result+"�� �� ���� ����");
		
		}catch(SQLException e) {
					System.out.println("���� ����"+e.getMessage());
				}finally {
					DBUtil.close(null, stmt, con);
					
				}
	return result;	
	}
	
}
