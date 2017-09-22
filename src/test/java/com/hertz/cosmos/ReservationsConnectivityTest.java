package com.hertz.cosmos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.util.IOUtils;

import com.hertz.cosmos.pojo.Reservation;
import com.hertz.cosmos.utils.CosmosUtils;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClientException;

public class ReservationsConnectivityTest {
	
	Logger logger = LogManager.getLogger(this.getClass());
	
	CosmosUtils cosmosUtils = null;
			
	@Before
	public void startUp() throws DocumentClientException {
		
		cosmosUtils = new CosmosUtils(
				"https://mulesoftpoc1.documents.azure.com",
				"sq6J5wTeFURtx5PBy2f5OGuwXaJ0hzYVSr3G8n4PSeU1UvDiU78ntsyMYeNKHbOHlnFSvABZo1p23AQ0vmgXyQ==",
				new Reservation("DB1", "RESERVATION_DEV"));		
		
		try {
			cosmosUtils.deleteCollection();
		}
		catch (DocumentClientException de) {
			//swallow exception in case the collection is not there.
		}
		
		cosmosUtils.createCollection();
		
	}
	
	@After
	public void shutdown() throws DocumentClientException {
		
		cosmosUtils.deleteCollection();
		
	}
	
	@Test
	public void shouldSaveRes() throws Exception {
						
		cosmosUtils.save(IOUtils.getResourceAsString("data/reservations/res1.json", ReservationsConnectivityTest.class));
		
		cosmosUtils.save(IOUtils.getResourceAsString("data/reservations/res2.json", ReservationsConnectivityTest.class));
		
		List<Document> results = cosmosUtils.findAll();
		
		assert 2 == results.size();
		
        logger.info("results: {}", results.toString());
	}
	
	@Test
	public void shouldFind() throws Exception {
						
		cosmosUtils.save(IOUtils.getResourceAsString("data/reservations/res1.json", ReservationsConnectivityTest.class));
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("OTA_VehResRQ.pos.source[0].airlineVendorID", "DL");
		
		List<Document> results = cosmosUtils.findBy(params);
				
		assert 1 == results.size();
		
        logger.info("results: {}", results.toString());
	}	
}
