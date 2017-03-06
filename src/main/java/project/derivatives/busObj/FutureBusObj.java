package project.derivatives.busObj;

import java.util.List;

import project.derivatives.model.Future;

public interface FutureBusObj {
	
	public void create(Future future);
	public void update(Future future);
	public Future edit (Long Contract_No);
	public void delete (Long Contract_No);
	public Future findFContract(Long Contract_No);
	public List<Future> findFContract2(Long user_Id);
	public List<Future> getAll();

}
