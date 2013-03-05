package cn.join.mh.service;

import java.util.List;

import org.persist.dao.Mhpromotion;
import org.persist.dao.MhpromotionCategory;
import org.persist.dao.MhpromotionOnline;

import cn.join.mh.vo.Page;
import cn.join.mh.vo.Result;

public interface IndexService {
	public List<MhpromotionOnline> find();
	public List<MhpromotionCategory> findCategory();
	
	public Result<MhpromotionOnline> findPromotionPagination(String categoryId,Page<MhpromotionOnline> page);
	public Mhpromotion getHotByCategoryId(String categoryId);
	public Mhpromotion getOnePromotionForHot(String categoryId);
	public Mhpromotion getPromotionById(String id);
}
