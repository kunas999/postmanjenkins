package com.hertz.cosmos.pojo;

public class RmsDel extends AbstractCosmosPojo {

	public RmsDel(String databaseName, String collectionId) {
		super(databaseName, collectionId);
	}

	@Override
	public String getAllQuery() {			
		return "SELECT TOP 50 * FROM " + getCollectionId();
	}
	
}
