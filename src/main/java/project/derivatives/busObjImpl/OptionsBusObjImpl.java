package project.derivatives.busObjImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.busObj.OptionsBusObj;
import project.derivatives.dao.OptionsDao;

import project.derivatives.model.Options;

@Service("optionsBusObj")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class OptionsBusObjImpl implements OptionsBusObj {
	
	@Autowired
	OptionsDao optionsDao;

	@Override
	public void create(Options options) {
		// TODO Auto-generated method stub
		optionsDao.create(options);
		
	}

	@Override
	public void update(Options options) {
		// TODO Auto-generated method stub
		optionsDao.update(options);
		
	}

	@Override
	public Options edit(Long Contract_No) {
		// TODO Auto-generated method stub
		return optionsDao.edit(Contract_No);
	}

	@Override
	public void delete(Long Contract_No) {
		// TODO Auto-generated method stub
		optionsDao.delete(Contract_No);
		
	}

	@Override
	public Options findOContract(Long Contract_No) {
		// TODO Auto-generated method stub
		return optionsDao.findOContract(Contract_No);
	}

	@Override
	public List<Options> findOContract2(Long user_Id) {
		// TODO Auto-generated method stub
		return optionsDao.findOContract2(user_Id);
	}

	@Override
	public List<Options> getAll() {
		// TODO Auto-generated method stub
		return optionsDao.getAll();
	}

}
