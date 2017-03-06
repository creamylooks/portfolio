package project.derivatives.busObj;

import java.util.List;

import project.derivatives.model.Asset;

public interface AssetBusObj {
	
	public void create(Asset asset);
	public void update(Asset asset);
	public Asset edit (Long Asset_Id);
	public void delete (Long Asset_Id);
	public Asset findAsset(Long Asset_Id);
	public Asset findSymbol(String Asset_symbol);
	public List<Asset> findAsset2(Long user_Id);
	public List<Asset> getAll();

}
