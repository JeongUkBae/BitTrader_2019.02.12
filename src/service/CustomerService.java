package service;

import java.util.List;



import domain.CustomerDTO;
import proxy.Pagination;

public interface CustomerService {
	public void registCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringAllCustomersList(Pagination page);
	public List<CustomerDTO> retrieveCustomers(String searchWord);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomerID(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
