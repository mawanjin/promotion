package cn.join.mh.vo;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	/** 结果集 */
	private List<T> list = new ArrayList<T>();
	/** 当前页码 */
	private int pageNo = 1;
	/** 第页条数 */
	private int pageSize = 4;
	/** 总页数 */
	private int pageCount;
	/** 总记录数*/
	private long count=-1;
	
	private boolean hasNext;
	
	private boolean hasPre;
	
	public int getFirstResult(){
		return (pageNo-1)*pageSize;
	}
	
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		if(count<0)return 0;
		return (int) ((count%pageSize==0)?(count/pageSize):(count/pageSize+1));
		
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public long getCount() {
		return count;
	}


	public void setCount(long count) {
		this.count = count;
	}
	
	

	public boolean isHasNext() {
		return (pageNo<getPageCount())?true:false;
	}


	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}


	public boolean isHasPre() {
		return (pageNo>1)?true:false;
	}


	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

}
