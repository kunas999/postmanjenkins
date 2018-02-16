package com.hertz.cosmos.pojo;

public class ValueAddedServices extends AbstractCosmosPojo {

	public ValueAddedServices(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT * FROM " + getCollectionId();
	}	
	
}