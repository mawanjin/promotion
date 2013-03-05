package cn.join.mh.service;

import cn.join.mh.vo.DetailResult;

public interface DiscountDetailSevice {

	/**
	 * 
	 * @param categoryId
	 *            分类编号
	 * @param page
	 *            数据在整个大的分类里的对应的页码
	 * @param pid
	 *            当前要读取的数据的编号
	 * @return
	 */
	public DetailResult get(String categoryId, int pageIndex,boolean last);
}
