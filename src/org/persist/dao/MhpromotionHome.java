package org.persist.dao;

// Generated 2013-2-27 14:30:54 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Home object for domain model class Mhpromotion.
 * @see org.org.persist.dao.Mhpromotion
 * @author Hibernate Tools
 */
public class MhpromotionHome<T> extends BaseHome<T>{

	public MhpromotionHome(Class clazz) {
		super(clazz);
	}

	private static final Logger log = LogManager.getLogger(MhpromotionHome.class.getName());

	public List<T> findByCategoryId(String cid,int firstResult,int maxResult){
		log.debug("findByCategoryId() called.");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			List<T>  results = (List<T>) session.createQuery("From Mhpromotion where mhpromotionOnline. and mhpromotionCategoryRef.mhpromotionCategory.id=?")
			.setString(0, cid)
			.setFirstResult(firstResult)
			.setMaxResults(maxResult)
			.list();
			
			log.debug("find by example successful, result size: "
					+ results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			tx.rollback();
		}finally{
			session.close();
		}
		return null;
	}
	
	public long getCountOfByCategoryId(String cid) {
		log.debug("getCountOfByCategoryId() called.");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			long rs = Long
					.parseLong(sessionFactory
							.getCurrentSession()
							.createQuery(
									"select count(*) From Mhpromotion where mhpromotionCategoryRef.mhpromotionCategory.id=?")
									.setString(0, cid)
									
							.list().get(0).toString());
			tx.commit();
			return rs;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			tx.rollback();
			return 0;
		}finally{
			session.close();
		}
	}
	
	
	
	
}
