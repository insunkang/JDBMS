package jdbc.customer.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.board.exam.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {
	public int insert(CustomerDTO customer) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into customer values(?,?,?,sysdate,1000,?)";
		
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPass());
			stmt.setString(3, customer.getName());
			stmt.setString(4, customer.getAddr());
			
			result = stmt.executeUpdate();
			System.out.println(result+"개 행 삽입 성공");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}return result;
	}
	public int update(String id, String addr) {
		PreparedStatement stmt = null;
		Connection con = null;
		String sql = "update customer set addr = ? where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, addr);
			stmt.setString(2, id);
			result = stmt.executeUpdate();
			System.out.println(result+"개 행 수정 성공");
			
		}catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int delete(String id) {
		PreparedStatement stmt = null;
		Connection con = null;
		String sql = "delete customer where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			System.out.println("연결성공"+con);
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
}
