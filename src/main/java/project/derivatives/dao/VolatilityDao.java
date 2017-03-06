package project.derivatives.dao;

import java.util.List;


import project.derivatives.model.Volatility;

public interface VolatilityDao {
	public void create(Volatility vol);
	public void update(Volatility vol);
	public Volatility edit (Long volatility_Id);
	public void delete (Long volatility_Id);
	public Volatility findVol(Long volatility_Id);
	public List<Volatility> findVols(Long asset_ID);
	public List<Volatility> findVols2(String asset_name);

}
