package com.hertz.cosmos.pojo;

public class RamCarClass extends AbstractCosmosPojo {

	public RamCarClass(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT * FROM " + getCollectionId();
	}	
	
}