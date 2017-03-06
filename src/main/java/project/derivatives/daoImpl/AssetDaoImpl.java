package project.derivatives.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.dao.AssetDao;
import project.derivatives.model.Asset;


@Repository("assetDao")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class AssetDaoImpl implements AssetDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void create(Asset asset) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		session.beginTransaction();
		if(asset!=null){
			session.save(asset);
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public void update(Asset asset) {
		// TODO Auto-generated method stub
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(asset);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Asset edit(Long Asset_Id) {
		// TODO Auto-generated method stub
		return findAsset(Asset_Id);
	}

	@Override
	public void delete(Long Asset_Id) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(Asset_Id);;
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	
	
	@Override
	public Asset findAsset(Long Asset_Id) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.beginTransaction();
		Asset s = null;
		s = (Asset) session.get(Asset.class, Asset_Id);
		session.getTransaction().commit();
		session.close();
		return s;
	}

	//Start from here ................Finish up and Commit
	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> findAsset2(Long user_Id) {
		List<Asset> a=  null;
		String hql = "from asset where asset.Asset_Id IN (select users_asset.assets_Asset_Id from users_asset where users_userId =?)";
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		 query.setParameter(0, user_Id);
		 a= query.list();
		 session.getTransaction().commit();
			session.close();
		
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public List<Asset> getAll() {
		session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Asset> Ast= session.createCriteria(Asset.class).list();
		session.getTransaction().commit();
		session.close();
		return Ast;
	}

	@Override
	public Asset findSymbol(String Asset_symbol) {
		// TODO Auto-generated method stub
		Asset asset=  null;
		String hql = "from asset where asset.Symbol =?";
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		 query.setParameter(0,Asset_symbol);
		 asset= (Asset) query.uniqueResult();
		 session.getTransaction().commit();
			session.close();
		return asset;
	}

}
