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
 * Home object for domain model class MhpromotionPic.
 * @see org.org.persist.dao.MhpromotionPic
 * @author Hibernate Tools
 */
public class MhpromotionPicHome extends BaseHome<MhpromotionPic>{

	public MhpromotionPicHome() {
		super(MhpromotionPic.class);
	}

	private static final Log log = LogFactory.getLog(MhpromotionPicHome.class);

	
	
	public MhpromotionPic findById(MhpromotionPicId id) {
		log.debug("getting MhpromotionOnline instance with id: " + id);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			MhpromotionPic instance = (MhpromotionPic) session.get(MhpromotionPic.class.getName(), id);
			
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			tx.commit();
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			log.error("get failed", re);
			tx.rollback();
		}finally{
			session.close();
		}
		return null;
	}
	
}
