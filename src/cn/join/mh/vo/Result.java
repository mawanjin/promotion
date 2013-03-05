package cn.join.mh.vo;


public class Result<T> {
	/** 0正常 1失败 */
	private int result = 0;
	
	private Page<T> page;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}
	
	
	
}
