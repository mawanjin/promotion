package org.persist.dao;

import static org.hibernate.criterion.Example.create;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

public class BaseHome<T> {
	
	private static final Logger log = LogManager.getLogger(BaseHome.class.getName());
	protected final SessionFactory sessionFactory = getSessionFactory();
	
	Class clazz;
	
	public BaseHome(Class clazz){
		this.clazz = clazz;
	}
	
	protected SessionFactory getSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory");
		}
	}
	
	public boolean persist(T clazz) {
		
		log.debug("persisting "+clazz.getClass().getName()+" instance");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(clazz);
			log.debug("persist successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			return false;
		}finally{
			session.close();
		}
		return true;
	}
	
	public List<T> findByExample(T instance) {
		log.debug("finding "+instance.getClass().getName()+" instance by example");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<T> results = (List<T>) session
					.createCriteria(instance.getClass().getName())
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
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
	
	public List<T> findByExample(T instance,String orderby) {
		log.debug("finding "+instance.getClass().getName()+" instance by example");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<T> results = (List<T>) session
					.createCriteria(instance.getClass().getName())
					.addOrder(Order.desc(orderby))
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
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
	
	public long getCountOfFindByExample(T instance){

		log.debug("finding "+instance.getClass().getName()+" count by getCountOfFindByExample");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<T> results = (List<T>) session
					.createCriteria(instance.getClass().getName())
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			tx.commit();
			return results.size();
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
		}finally{
			session.close();
		}
		return 0;
	}
	
	
	/**
	 * 
	 * @param instance
	 * @param orderby
	 * @param start 开始索引
	 * @param size 个数
	 * @return
	 */
	public List<T> findByExample(T instance,String orderby,int start,int size) {
		log.debug("finding "+instance.getClass().getName()+" instance by example");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<T> results = (List<T>) session
					.createCriteria(instance.getClass().getName())
					.addOrder(Order.desc(orderby))
					.setFirstResult(start)
					.setMaxResults(size)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
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
	
	
	public T findById(java.lang.String id) {
		log.debug("getting MhpromotionOnline instance with id: " + id);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			T instance = (T) session.get(clazz.getName(), id);
			
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
		}finally{
			session.close();
		}
		return null;
	}
	
	public boolean delete(T t) {
		log.debug("deleting "+t.getClass().getName()+" instance");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(t);
			log.debug("delete successful");
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			tx.rollback();
			return false;
		}finally{
			session.close();
		}
	}
	
	public T merge(T t) {
		log.debug("merging "+t.getClass().getName()+" instance");
		Session session = sessionFactory.openSession();
		try {
			T result = (T) session.merge(t);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}finally{
			session.close();
		}
	}
	
}
