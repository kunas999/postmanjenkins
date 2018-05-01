package com.hertz.cosmos.pojo;

public class Rms extends AbstractCosmosPojo {

	public Rms(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT TOP 50 * FROM " + getCollectionId();
	}
	
}
