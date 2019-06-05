package utils;

public class Page {
	private Integer pageno;
	private Integer pagesize;
	private Integer countnumber;
	private Integer countpage;
	
	public Integer getPageno() {
		return pageno;
	}
	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getCountnumber() {
		return countnumber;
	}
	public void setCountnumber(Integer countnumber) {
		this.countnumber = countnumber;
	}
	
	public Integer getCountpage() {
		if(countnumber%pagesize==0){
			return countnumber/pagesize;
		}else if(countnumber%pagesize!=0){
			return countnumber/pagesize+1;
		}
		return 0;
	}
	
	
	public void setCountpage(Integer countpage) {
		this.countpage = countpage;
	}
	public Page(Integer pageno, Integer pagesize, Integer countnumber,
			Integer countpage) {
		super();
		this.pageno = pageno;
		this.pagesize = pagesize;
		this.countnumber = countnumber;
		this.countpage = countpage;
	}
	public Page() {
		super();
	}
	@Override
	public String toString() {
		return "Page [pageno=" + pageno + ", pagesize=" + pagesize
				+ ", countnumber=" + countnumber + ", countpage=" + countpage
				+ "]";
	}
}
