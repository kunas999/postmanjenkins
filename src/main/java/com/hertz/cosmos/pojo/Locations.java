package com.hertz.cosmos.pojo;

public class Locations extends AbstractCosmosPojo {

	public Locations(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT * FROM " + getCollectionId();
	}	
	
}