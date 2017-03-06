package project.derivatives.dao;

import java.util.List;

import project.derivatives.model.Asset;


public interface AssetDao {
	
	
	public void create(Asset asset);
	public void update(Asset asset);
	public Asset edit (Long Asset_Id);
	public void delete (Long Asset_Id);
	public Asset findAsset(Long Asset_Id);
	public List<Asset> findAsset2(Long user_Id);
	public List<Asset> getAll();

}
