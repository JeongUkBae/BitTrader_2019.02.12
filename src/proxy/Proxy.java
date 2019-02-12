package proxy;

import lombok.Data;

@Data
public class Proxy implements Capable{

	private Pagination page;
	public void proxy() {carryOut();}
	@Override
	public void carryOut() {
		this.page = new Pagination();
		page.carryOut();
		
	}
}
