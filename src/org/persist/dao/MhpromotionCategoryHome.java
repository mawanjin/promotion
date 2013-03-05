package org.persist.dao;

// Generated 2013-2-27 14:30:54 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MhpromotionCategory.
 * @see org.org.persist.dao.MhpromotionCategory
 * @author Hibernate Tools
 */
public class MhpromotionCategoryHome extends BaseHome<MhpromotionCategory>{


	public MhpromotionCategoryHome() {
		super(MhpromotionCategory.class);
	}

	private static final Log log = LogFactory
			.getLog(MhpromotionCategoryHome.class);
	
	public MhpromotionCategory merge(MhpromotionCategory detachedInstance) {
		log.debug("merging MhpromotionCategory instance");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			MhpromotionCategory result = (MhpromotionCategory) session.merge(detachedInstance);
			log.debug("merge successful");
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("merge failed", re);
			throw re;
		}finally{
			session.close();
		}
	}

}
