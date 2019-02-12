package dao;

import java.util.List;


import domain.CustomerDTO;
import proxy.Pagination;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	
	public List<CustomerDTO> selectAllCustomersList(Pagination page);
	public List<CustomerDTO> selectCustomers(String searchWord);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomerID(CustomerDTO cus);
	
	public void updateCustomer(CustomerDTO cus);
	public void deleteCustomer(CustomerDTO cus);
}
