package project.derivatives.busObjImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.busObj.FutureBusObj;
import project.derivatives.dao.FutureDao;
import project.derivatives.model.Future;

@Service("futureBusObj")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class FutureBusObjImpl implements FutureBusObj {
	
	@Autowired
	FutureDao futureDao;

	@Override
	public void create(Future future) {
		// TODO Auto-generated method stub
		futureDao.create(future);
	}

	@Override
	public void update(Future future) {
		// TODO Auto-generated method stub
		futureDao.update(future);
	}

	@Override
	public Future edit(Long Contract_No) {
		// TODO Auto-generated method stub
		return futureDao.edit(Contract_No);
	}

	@Override
	public void delete(Long Contract_No) {
		// TODO Auto-generated method stub
		futureDao.delete(Contract_No);
	}

	@Override
	public Future findFContract(Long Contract_No) {
		// TODO Auto-generated method stub
		return futureDao.findFContract(Contract_No);
	}

	@Override
	public List<Future> findFContract2(Long user_Id) {
		// TODO Auto-generated method stub
		return futureDao.findFContract2(user_Id);
	}

	@Override
	public List<Future> getAll() {
		// TODO Auto-generated method stub
		return futureDao.getAll();
	}
	

}
