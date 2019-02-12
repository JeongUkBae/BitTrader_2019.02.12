package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;

import proxy.Proxy;
import service.CustomerServiceImpl;


public class ListCommand extends Command{
// sysout 
	// 가장 최근에 입력된 5명의 목록
		public ListCommand(HttpServletRequest request,
				HttpServletResponse responset) {
			super(request, responset);

			//sysout cmd=list&page=list&page_num=2&page_size=5
			System.out.println("ListCommand =====입장 ====");
			System.out.println("cmd:::"+request.getParameter("cmd"));
			System.out.println("page:::"+request.getParameter("page"));
			System.out.println("page_num:::"+request.getParameter("page_num"));
			System.out.println("page_size:::"+request.getParameter("page_size"));
			System.out.println("페이지는?::"+super.getView());
			
			List<CustomerDTO> list = CustomerServiceImpl
									.getInstance().bringAllCustomersList(
											new Proxy().getPage());
			request.setAttribute("list", list);
		}
}
