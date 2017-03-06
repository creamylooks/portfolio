package project.derivatives.busObjImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.busObj.AssetBusObj;
import project.derivatives.dao.AssetDao;
import project.derivatives.model.Asset;

@Service("assetBusObj")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class AssetBusObjImpl implements AssetBusObj {
	@Autowired
	AssetDao assetDao;

	@Override
	public void create(Asset asset) {
		// TODO Auto-generated method stub
		assetDao.create(asset);
	}

	@Override
	public void update(Asset asset) {
		// TODO Auto-generated method stub
		assetDao.update(asset);
	}

	@Override
	public Asset edit(Long Asset_Id) {
		// TODO Auto-generated method stub
		return assetDao.edit(Asset_Id);
	}

	@Override
	public void delete(Long Asset_Id) {
		// TODO Auto-generated method stub
		assetDao.delete(Asset_Id);
	}

	@Override
	public Asset findAsset(Long Asset_Id) {
		// TODO Auto-generated method stub
		return assetDao.findAsset(Asset_Id);
	}

	@Override
	public List<Asset> findAsset2(Long user_Id) {
		// TODO Auto-generated method stub
		return assetDao.findAsset2(user_Id);
	}

	@Override
	public List<Asset> getAll() {
		// TODO Auto-generated method stub
		return assetDao.getAll();
	}

}
