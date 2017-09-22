package com.hertz.cosmos.pojo;

public class Reservation extends AbstractCosmosPojo {

	public Reservation(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT * FROM " + getCollectionId();
	}
	
}
