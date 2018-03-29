package com.hertz.cosmos.pojo;

public class RateType extends AbstractCosmosPojo {

	public RateType(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT * FROM " + getCollectionId();
	}	
	
}