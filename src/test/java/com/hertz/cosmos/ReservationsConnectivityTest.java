package com.hertz.cosmos;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mule.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hertz.cosmos.utils.CosmosUtils;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClientException;

import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:beans-config.xml", 
        "classpath:test-beans.xml"})
public class ReservationsConnectivityTest {
	
	Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	CosmosUtils cosmosReservationUtil = null;
			
	@Before
	public void startUp() throws DocumentClientException, IOException {		
		
		try {
			cosmosReservationUtil.deleteCollection();
		}
		catch (DocumentClientException de) {
			//swallow exception in case the collection is not there.
		}
		
		try {
			cosmosReservationUtil.createCollection();
		}
		catch (DocumentClientException de) {
			//swallow exception in case the collection is not there.
		}			
		
	}
	
	@After
	public void shutdown() throws DocumentClientException, Exception {
		
		cosmosReservationUtil.deleteCollection();
				
	}
	
	@Test
	public void shouldSave() throws Exception {
						
		cosmosReservationUtil.save(IOUtils.getResourceAsString("data/reservations/res1.json", ReservationsConnectivityTest.class));
		
		cosmosReservationUtil.save(IOUtils.getResourceAsString("data/reservations/res2.json", ReservationsConnectivityTest.class));			
		
		List<Document> results = cosmosReservationUtil.findAll();
		
		assertEquals(2, results.size());
		
        logger.info("results: {}", results.size());
        
	}
	
	@Test
	public void shouldFind() throws Exception {
						
		cosmosReservationUtil.save(IOUtils.getResourceAsString("data/reservations/res3.json", ReservationsConnectivityTest.class));						
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("OTA_VehResRQ.pos.source[0].airlineVendorID", "UAL");
		
		List<Document> results = cosmosReservationUtil.findBy(params);
				
		assertEquals(1, results.size());
		
        logger.info("results: {}", results.size());
        
	}
	
}
