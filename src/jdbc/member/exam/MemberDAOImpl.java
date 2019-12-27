package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.board.exam.DBUtil;

public class MemberDAOImpl implements MemberDAO {
	public int insert(MemberDTO member) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into member values(?,?,?,?,?,sysdate,1000)";
		
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPass());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getAddr());
			stmt.setString(5, member.getDeptno());
			result = stmt.executeUpdate();
			System.out.println(result+"�� �� ���� ����");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}return result;
	}
	public int update(String id, String addr) {
		PreparedStatement stmt = null;
		Connection con = null;
		String sql = "update member set addr = ? where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, addr);
			stmt.setString(2, id);
			result = stmt.executeUpdate();
			System.out.println(result+"�� �� ���� ����");
			
		}catch(SQLException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int delete(String id) {
		PreparedStatement stmt = null;
		Connection con = null;
		String sql = "delete member where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			System.out.println("���Ἲ��"+con);
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
}
