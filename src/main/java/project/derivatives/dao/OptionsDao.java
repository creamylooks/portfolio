package project.derivatives.dao;

import java.util.List;

import project.derivatives.model.Options;



public interface OptionsDao {
	
	
	public void create(Options options);
	public void update(Options options);
	public Options edit (Long Contract_No);
	public void delete (Long Contract_No);
	public Options findOContract(Long Contract_No);
	public List<Options> findOContract2(Long user_Id);
	public List<Options> getAll();

}
