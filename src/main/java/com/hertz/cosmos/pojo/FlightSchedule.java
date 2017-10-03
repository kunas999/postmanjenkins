package com.hertz.cosmos.pojo;

public class FlightSchedule extends AbstractCosmosPojo {

	public FlightSchedule(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT TOP 50 * FROM " + getCollectionId();
	}	
	
}
