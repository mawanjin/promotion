package cn.join.mh.vo;

import org.persist.dao.Mhpromotion;

public class DetailResult {
	private Mhpromotion pre;
	private Mhpromotion nxt;
	private Mhpromotion now;
	private Page page;
	private int nowIndex;
	private int nxtIndex;
	private int preIndex;
	private String categoryId;
	
	public Mhpromotion getPre() {
		return pre;
	}

	public void setPre(Mhpromotion pre) {
		this.pre = pre;
	}

	public Mhpromotion getNxt() {
		return nxt;
	}

	public void setNxt(Mhpromotion nxt) {
		this.nxt = nxt;
	}

	public Mhpromotion getNow() {
		return now;
	}

	public void setNow(Mhpromotion now) {
		this.now = now;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getNowIndex() {
		return nowIndex;
	}

	public void setNowIndex(int nowIndex) {
		this.nowIndex = nowIndex;
	}

	public int getNxtIndex() {
		return nxtIndex;
	}

	public void setNxtIndex(int nxtIndex) {
		this.nxtIndex = nxtIndex;
	}

	public int getPreIndex() {
		return preIndex;
	}

	public void setPreIndex(int preIndex) {
		this.preIndex = preIndex;
	}

}
