package jdbc.customer.exam;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	CustomerDAO dao = new CustomerDAOImpl();
	public void insertMenu(){
		//입사일 오늘날짜 - sysdate, point = 1000가 삽입되도록
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();

		
		
		
		//여기에서 EmpDAO의 메소드를 호출하세요
		CustomerDTO customer = new CustomerDTO(id,pass,name,addr);
		int result = dao.insert(customer);
		if(result >0) {
			System.out.println("사원 등록 성공");
		}else {
			System.out.println("사원 등록 실패");
		}
	}
	public void updateMenu(){
		CustomerDAO dao = new CustomerDAOImpl();
		System.out.println("*******사원수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		int result = dao.update(id, addr);
		if(result>0) {
			System.out.println("사원 수정 성공");
		}else {
			System.out.println("사원 수정 실패");
		}
	}
	public void deleteMenu(){
		CustomerDAO dao = new CustomerDAOImpl();
		System.out.println("*******사원삭제********");
		System.out.print("아이디:");
		String id = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		
		
		int result = dao.delete(id);
		if(result>0) {
			System.out.println("사원 삭제 성공");
		}else {
			System.out.println("사원 삭제 실패");
		}
	}
	public void findByAddrMenu(){
		System.out.println("*******사원검색********");
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
	}
	
	
	public void selectMenu(){
		CustomerDAO dao = new CustomerDAOImpl();
		System.out.println("*******사원조회********");
		//여기에서 EmpDAO의 메소드를 호출하세요 - 전체사원조회
		
		
	}
}


















