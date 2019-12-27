package jdbc.customer.test;


public interface CustomerDAO {
	 int insert(CustomerDTO customer);
	 int update(String addr, String id);
	 int delete(String id);
}
