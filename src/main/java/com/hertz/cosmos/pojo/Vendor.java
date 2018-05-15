package com.hertz.cosmos.pojo;

public class Vendor extends AbstractCosmosPojo {

	public Vendor(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT TOP 10 * FROM " + getCollectionId();
	}
	
}