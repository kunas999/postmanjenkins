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
public class FlightScheduleConnectivityTest {
	
	Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	CosmosUtils cosmosFlightScheduleUtil = null;
		
	@Before
	public void startUp() throws DocumentClientException, IOException {		
		
		try {
			cosmosFlightScheduleUtil.deleteCollection();
		}
		catch (DocumentClientException de) {
			//swallow exception in case the collection is not there.
		}
		
		try {
			cosmosFlightScheduleUtil.createCollection();
		}
		catch (DocumentClientException de) {
			//swallow exception in case the collection is not there.
		}			
		
	}
	
	@After
	public void shutdown() throws DocumentClientException, Exception {
		
		cosmosFlightScheduleUtil.deleteCollection();
				
	}	
	
	@Test
	public void shouldFindAll() throws Exception {
			
		cosmosFlightScheduleUtil.save(IOUtils.getResourceAsString("data/flightschedule/flight1.json", FlightScheduleConnectivityTest.class));						
				
		List<Document> results = cosmosFlightScheduleUtil.findAll();
				
		assertEquals(1, results.size());
		
        logger.info("results: {}", results.size());
        
	}
	
/*	@Test
	public void shouldFindBy() throws Exception {
						
		cosmosFlightScheduleUtil.save(IOUtils.getResourceAsString("data/flightschedule/flight2.json", FlightScheduleConnectivityTest.class));						
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("FLTNBR1", "4910");
		params.put("CARRIER1", "DL");
		params.put("S_DEP_DT", "20070203");
		
		List<Document> results = cosmosFlightScheduleUtil.findBy(params);
				
		assertEquals(1, results.size());
		
        logger.info("results: {}", results.size());
        
	}*/	
	
}
