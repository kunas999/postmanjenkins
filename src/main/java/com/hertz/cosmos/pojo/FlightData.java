package com.hertz.cosmos.pojo;

public class FlightData extends AbstractCosmosPojo {

	public FlightData(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT TOP 50 * FROM " + getCollectionId();
	}	
	
}
