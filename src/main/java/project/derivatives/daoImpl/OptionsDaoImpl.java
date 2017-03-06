package project.derivatives.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.derivatives.dao.OptionsDao;
import project.derivatives.model.Options;

@Repository("optionsDao")
public class OptionsDaoImpl implements OptionsDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void create(Options options) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		session.beginTransaction();
		if(options!=null){
			session.save(options);
			session.getTransaction().commit();
			session.close();
		}
		
	}

	@Override
	public void update(Options options) {
		// TODO Auto-generated method stub
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(options);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public Options edit(Long Contract_No) {
		// TODO Auto-generated method stub
		return findOContract(Contract_No);
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
	public Options findOContract(Long Contract_No) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		Options opt= null;
		opt = (Options) session.get(Options.class,Contract_No);
		session.getTransaction().commit();
		session.close();
		return opt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Options> findOContract2(Long user_Id) {
		List<Options> optn=  null;
		String hql = "from optionstable where optionstable.user_userId =?";
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		 query.setParameter(0, user_Id);
		 optn= query.list();
		 session.getTransaction().commit();
			session.close();
		return optn;
	}

	@Override
	public List<Options> getAll() {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Options>Op= session.createCriteria(Options.class).list();
		session.getTransaction().commit();
		session.close();
		
		return Op;
	}

}
