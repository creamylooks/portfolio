package project.derivatives.busObjImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.busObj.VolatilityBusObj;
import project.derivatives.dao.VolatilityDao;
import project.derivatives.model.Volatility;
@Service("volatilityBusObj")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class VolatilityBusObjImpl implements VolatilityBusObj {
	@Autowired
	VolatilityDao volDao;

	@Override
	public void create(Volatility vol) {
		// TODO Auto-generated method stub
		volDao.create(vol);
	}

	@Override
	public void update(Volatility vol) {
		// TODO Auto-generated method stub
		volDao.update(vol);
	}

	@Override
	public Volatility edit(Long volatility_Id) {
		// TODO Auto-generated method stub
		return volDao.edit(volatility_Id);
	}

	@Override
	public void delete(Long volatility_Id) {
		// TODO Auto-generated method stub
		volDao.delete(volatility_Id);
	}

	@Override
	public Volatility findVol(Long volatility_Id) {
		// TODO Auto-generated method stub
		return volDao.findVol(volatility_Id);
	}

	@Override
	public List<Volatility> findVols(Long asset_ID) {
		// TODO Auto-generated method stub
		return volDao.findVols(asset_ID);
	}

	@Override
	public List<Volatility> findVols2(String asset_name) {
		// TODO Auto-generated method stub
		return volDao.findVols2(asset_name);
	}

}
