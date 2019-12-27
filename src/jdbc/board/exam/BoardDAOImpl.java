package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board 테이블을 액세스하는 기능이 정의된 클래스
public class BoardDAOImpl implements BoardDAO {
	public int insert(BoardDTO board) {
		System.out.println("dto사용메소드: "+board);
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		
		int result = 0; // 메소드 실행결과가 저장될 변수
		try {
		
		con = DBUtil.getConnect();
				
		//1. PreparedStatement 생성
		stmt = con.prepareStatement(sql);
		//2. ?d에 값 전달하기
		stmt.setString(1, board.getId() );
		stmt.setString(2, board.getTitle());
		stmt.setString(3, board.getContent());
		
		//3. 실행하기
		result = stmt.executeUpdate();
		System.out.println(result+"개 행 삽입 성공");
		
		}catch(SQLException e) {
					System.out.println("연결 실패"+e.getMessage());
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
			
			//select문을 실행
			rs = stmt.executeQuery();
//			System.out.println("rs: "+rs);
			
			//ResultSet에 레코드가 존재하는 동안 반복문을 실행
			while(rs.next()) {//=> 레코드를 조회하기 위해서는
											// 		 레코드가 한 개라도 반드시 커서를 이동시켜야 한다.
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
		System.out.println("연결 성공"+con);
		
		//3. sql을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 connection 객체를 이용해서 생성
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, boardnum);
		
		System.out.println("SQL을 실행하기 위한 객체 정보: "+stmt);
		
		//4. sql 실행하기
		result = stmt.executeUpdate();
		System.out.println(result+"개 행 삭제 성공");
		
		}catch(SQLException e) {
					System.out.println("연결 실패"+e.getMessage());
				}finally {
					DBUtil.close(null, stmt, con);
					
				}return result;
	}
	public int insert(String id, String title, String content) {
		
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		Connection con = null;
		int result = 0; // 메소드 실행결과가 저장될 변수
		PreparedStatement stmt = null;
		try {
		
		con = DBUtil.getConnect();
				
		//1. PreparedStatement 생성
		stmt = con.prepareStatement(sql);
		//2. ?d에 값 전달하기
		stmt.setString(1, id );
		stmt.setString(2, title);
		stmt.setString(3, content);
		
		//3. 실행하기
		result = stmt.executeUpdate();
		System.out.println(result+"개 행 삽입 성공");
		
		}catch(SQLException e) {
					System.out.println("연결 실패"+e.getMessage());
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
		
		
		
		con = DBUtil.getConnect(); //DBMS 연결
				
//		System.out.println("연결 성공"+con);
		
		//3. sql을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 connection 객체를 이용해서 생성
		stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setInt(2, boardnum);
		
		//4. sql 실행하기
		result = stmt.executeUpdate();
		System.out.println(result+"개 행 수정 성공");
		
		}catch(SQLException e) {
					System.out.println("연결 실패"+e.getMessage());
				}finally {
					DBUtil.close(null, stmt, con);
					
				}
	return result;	
	}
	
}
