package org.persist.dao;

// Generated 2013-2-27 14:30:54 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 * Home object for domain model class MhpromotionOnline.
 * @see org.org.persist.dao.MhpromotionOnline
 * @author Hibernate Tools
 */
public class MhpromotionOnlineHome extends BaseHome<MhpromotionOnline>{

	public MhpromotionOnlineHome() {
		super(MhpromotionOnline.class);
	}
	
	private static final Logger log = LogManager.getLogger(MhpromotionOnlineHome.class.getName());
	
	public List<MhpromotionOnline> findByCategoryId(String cid,int start,int size){
		log.debug("findByCategoryId() called.");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<MhpromotionOnline> results = (List<MhpromotionOnline>) session
					.createQuery("from MhpromotionOnline where mhpromotion.mhpromotionCategoryRef.mhpromotionCategory.id=? and hot=0 order by porder desc")
					.setString(0, cid)
					.setFirstResult(start)
					.setMaxResults(size)
					.list();
			log.debug("find by CategoryId successful, result size: "
					+ results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
		}finally{
			session.close();
		}
		return null;
	}
	
	public List<MhpromotionOnline> findHotByCategoryId(String cid){
		log.debug("findHotByCategoryId() called.");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<MhpromotionOnline> results = (List<MhpromotionOnline>) session
					.createQuery("from MhpromotionOnline where mhpromotion.mhpromotionCategoryRef.mhpromotionCategory.id=? and hot=1 order by porder desc")
					.setString(0, cid)
					.list();
			log.debug("find by findHotByCategoryId successful, result size: "
					+ results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by findHotByCategoryId failed", re);
		}finally{
			session.close();
		}
		return null;
	}
	
	public long getCountOffindByCategoryId(String cid){
		log.debug("getCountOffindByCategoryId() called.");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			long results = Long.parseLong( session
					.createQuery("select count(*) from MhpromotionOnline where mhpromotion.mhpromotionCategoryRef.mhpromotionCategory.id=? and hot=0")
					.setString(0, cid)
					.list().get(0).toString());
			log.debug("find by getCountOffindByCategoryId successful, result size: "
					+ results);
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			return 0;
		}finally{
			session.close();
		}
	}
	
}
