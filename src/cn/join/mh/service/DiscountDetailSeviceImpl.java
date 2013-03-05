package cn.join.mh.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.persist.dao.MhpromotionOnline;
import org.persist.dao.MhpromotionOnlineHome;

import cn.join.mh.vo.DetailResult;
import cn.join.mh.vo.Page;

public class DiscountDetailSeviceImpl implements DiscountDetailSevice {
	Logger log = LogManager.getLogger(DiscountDetailSeviceImpl.class.getName());
	
	MhpromotionOnlineHome onlineDao = new MhpromotionOnlineHome();
	
	public DetailResult get(String categoryId, int pageIndex,boolean last) {
		log.info("get() called.categoryId="+categoryId+";pageIndex="+pageIndex);
		DetailResult dr = new DetailResult();
		Page<MhpromotionOnline> newPage = new Page<MhpromotionOnline>();
		//分别对应前一条、当前条、后一条
		newPage.setPageSize(3);
		List<MhpromotionOnline> list = null;
		
		if(last){
			log.info("get last ");
			list = onlineDao.findByCategoryId(categoryId, pageIndex-1,2);
			if(list!=null){
				if(list.size()>0){
					dr.setPre(list.get(0).getMhpromotion());
					dr.setPreIndex(pageIndex-1);
				}
				if(list.size()>1){
					dr.setNow(list.get(1).getMhpromotion());
					dr.setNowIndex(pageIndex);
				}
			}
		}else if(pageIndex<1){//只取右边的
			log.info("get only next ");
			list = onlineDao.findByCategoryId(categoryId, 0,2);
			if(list!=null){
				if(list.size()>0){
					dr.setNow(list.get(0).getMhpromotion());
					dr.setNowIndex(pageIndex);
				}
				if(list.size()>1){
					dr.setNxt(list.get(1).getMhpromotion());
					dr.setNxtIndex(pageIndex+1);
				}
			}
			
		}else if(pageIndex>0){
			log.info("get three ");
			list = onlineDao.findByCategoryId(categoryId, pageIndex-1,3);
			if(list!=null){
				if(list.size()>0){
					dr.setPre(list.get(0).getMhpromotion());
					dr.setPreIndex(pageIndex-1);
				}
				if(list.size()>1){
					dr.setNow(list.get(1).getMhpromotion());
					dr.setNowIndex(pageIndex);
				}
				if(list.size()>2){
					dr.setNxt(list.get(2).getMhpromotion());
					dr.setNxtIndex(pageIndex+1);
				}
					
			}
		}
		
		return dr;
	}

}
