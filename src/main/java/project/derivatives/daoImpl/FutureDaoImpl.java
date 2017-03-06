package project.derivatives.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.dao.FutureDao;
import project.derivatives.model.Future;

@Repository("futureDao")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class FutureDaoImpl implements FutureDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void create(Future future) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		session.beginTransaction();
		if(future!=null){
			session.save(future);
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public void update(Future future) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(future);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Future edit(Long Contract_No) {
		// TODO Auto-generated method stub
		return findFContract(Contract_No);
		
	}

	@Override
	public void delete(Long Contract_No) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(Contract_No);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Future findFContract(Long Contract_No) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		Future ftr= null;
		ftr = (Future) session.get(Future.class,Contract_No);
		session.getTransaction().commit();
		session.close();
		return ftr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Future> findFContract2(Long user_Id) {
		// TODO Auto-generated method stub
		
		List<Future> ft=  null;
		String hql = "from futurestable where futurestable.user_userId =?";
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		 query.setParameter(0, user_Id);
		 ft= query.list();
		 session.getTransaction().commit();
			session.close();
		return ft;
	}

	@Override
	public List<Future> getAll() {
		// TODO Auto-generated method stub
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Future>fut= session.createCriteria(Future.class).list();
		session.getTransaction().commit();
		session.close();
		return fut;
	}

}
