package cn.join.mh.service;

import java.util.List;

import org.persist.dao.Mhpromotion;
import org.persist.dao.MhpromotionCategory;
import org.persist.dao.MhpromotionCategoryHome;
import org.persist.dao.MhpromotionHome;
import org.persist.dao.MhpromotionOnline;
import org.persist.dao.MhpromotionOnlineHome;

import cn.join.mh.vo.Page;
import cn.join.mh.vo.Result;

public class IndexServiceImpl implements IndexService {
	MhpromotionHome<Mhpromotion> dao = new MhpromotionHome<Mhpromotion>(
			Mhpromotion.class);
	MhpromotionOnlineHome onlineDao = new MhpromotionOnlineHome();
	MhpromotionCategoryHome categoryDao = new MhpromotionCategoryHome();

	public List<MhpromotionOnline> find() {
		return onlineDao.findByExample(new MhpromotionOnline(), "porder");
	}

	public List<MhpromotionCategory> findCategory() {
		MhpromotionCategory instance = new MhpromotionCategory();
		instance.setOnline(1);
		return categoryDao.findByExample(instance, "porder");
	}
	
	public Mhpromotion getHotByCategoryId(String categoryId){
		List<MhpromotionOnline> rs = onlineDao.findHotByCategoryId(categoryId);
		if(rs==null||rs.size()==0)return null;
		else
			return rs.get(0).getMhpromotion();
	}

	public Result<MhpromotionOnline> findPromotionPagination(String categoryId,
			Page<MhpromotionOnline> page) {
		Result<MhpromotionOnline> rs = new Result<MhpromotionOnline>();

		if (page.getCount() == -1) {
			page.setCount(onlineDao.getCountOffindByCategoryId(categoryId));
		}
		page.setList(onlineDao.findByCategoryId(categoryId, page.getFirstResult(),
				page.getPageSize()));
		
		rs.setPage(page);
		rs.setResult(0);
		return rs;
	}

	public Mhpromotion getOnePromotionForHot(String categoryId) {
		List<MhpromotionOnline> rs = onlineDao.findByCategoryId(categoryId, 0, 1);
		if(rs!=null&&rs.size()>0){
			return rs.get(0).getMhpromotion();
		}else
			return null;
	}

	public Mhpromotion getPromotionById(String id) {
		return dao.findById(id);
	}
	
}
