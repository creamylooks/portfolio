package project.derivatives.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.dao.VolatilityDao;
import project.derivatives.model.Volatility;
@Repository("volatilityDao")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class VolatilityDaoImpl implements VolatilityDao{
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Override
	public void create(Volatility vol) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		session.beginTransaction();
		if(vol!=null){
			session.save(vol);
			session.getTransaction().commit();
			session.close();
		}
		
	}

	@Override
	public void update(Volatility vol) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(vol);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Volatility edit(Long volatility_Id) {
		// TODO Auto-generated method stub
		return findVol(volatility_Id);
	}

	@Override
	public void delete(Long volatility_Id) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(volatility_Id);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Volatility findVol(Long volatility_Id) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		Volatility vola= null;
		vola = (Volatility) session.get(Volatility.class,volatility_Id);
		session.getTransaction().commit();
		session.close();
		return vola;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Volatility> findVols(Long asset_ID) {
		// TODO Auto-generated method stub
		List<Volatility> volas=  null;
		String hql = "from volatility where volatility.asset_Asset_Id =?";
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		 query.setParameter(0, asset_ID);
		 volas= query.list();
		 session.getTransaction().commit();
			session.close();
		return volas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Volatility> findVols2(String asset_name) {
		// TODO Auto-generated method stub
		List<Volatility> volas=  null;
		String hql = "from volatility where volatility.asset_Asset_Id IN (select asset.Asset_Id from asset where Asset_Name =?)";
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		 query.setParameter(0, asset_name);
		volas= query.list();
		 session.getTransaction().commit();
			session.close();
		return volas;
	}

}
