package com.hertz.cosmos.pojo;

public class RamChargeInd extends AbstractCosmosPojo {

	public RamChargeInd(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT * FROM " + getCollectionId();
	}	
	
}