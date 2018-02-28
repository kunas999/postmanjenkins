package com.hertz.cosmos.pojo;

public class RamLocations extends AbstractCosmosPojo {

	public RamLocations(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT * FROM " + getCollectionId();
	}	
	
}