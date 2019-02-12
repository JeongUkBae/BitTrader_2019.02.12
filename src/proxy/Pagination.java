package proxy;

import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Capable{
	private String pageNum, pageSize, blockSize, 
			startRow, endRow, startPage, endPage,
			prevBlock, nextBlock;
	private int totalcount;
	private boolean existprev, existNext;

	
	@Override
	public void carryOut() {
		HttpServletRequest request = Receiver.cmd.getRequest();
		System.out.println("프록시 페이지네이션 도착");
		
		this.pageNum = (request.getParameter("page_num")==null)?"1":request.getParameter("page_num");
		
		String pageSize = request.getParameter("page_size");
		this.pageSize = (pageSize==null)?"5":pageSize;
		System.out.println("pageSize:::"+this.pageSize);
		this.totalcount = CustomerServiceImpl.getInstance().countCustomer();
		//this.startRow = String.valueOf(totalcount-Integer.parseInt(this.pageSize));
		//this.endRow = String.valueOf(Integer.parseInt(this.startRow) +Integer.parseInt(this.pageSize)) ;  
		System.out.println("pageNUM??"+this.pageNum);
		System.out.println("pageSize??"+this.pageSize);
	
		int pageSize1 = Integer.parseInt(this.pageSize);
		int pageNum1 = Integer.parseInt(this.pageNum);
		this.startRow = String.valueOf((totalcount-((pageSize1*pageNum1)-1)));
		this.endRow = String.valueOf(((totalcount-((pageSize1*pageNum1)-1))+4));
		
		System.out.println("totalcount:::"+this.totalcount);
		System.out.println("startRow:::"+this.startRow);
		System.out.println("endrow:::"+this.endRow);
		
		
	}
	
}
