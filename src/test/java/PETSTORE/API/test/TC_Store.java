package PETSTORE.API.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import PETSTORE.API.HttpRequest.HR_Store;
import PETSTORE.API.payload.PL_Store;
import io.restassured.response.Response;

public class TC_Store {
	
	public Faker faker = new Faker();
	public PL_Store payload = new PL_Store();
	
	public Logger logger = LogManager.getLogger(this.getClass());
	int orderId;
	@BeforeClass
	public  void setup()
	{
		orderId = faker.number().numberBetween(1,3);
		payload.setOrderId(orderId);
		payload.setPetId(faker.number().numberBetween(1, 3));
		payload.setQuantity(faker.number().numberBetween(1,2));
		payload.setShipDate(Date.DateTimeExample.Date());
		payload.setStatus("placed");
		payload.setComplete(true);	
	
	}
	
	

	
	
	@Test(priority =1)
	public void test_PlaceAnOrderForPet()
	{
		logger.info("*Start test_PlaceAnOrderForPet*");
		Response resposne = HR_Store.placeAnOrderForPet(payload);
		resposne.then()
			.log().all();
		
		Assert.assertEquals(resposne.getStatusCode(),200);
		logger.info("*End test_PlaceAnOrderForPet*\n");
	
	}
	
	
	@Test(priority =2 )
	public void test_FindPurchaseOrderById()
	{
		logger.info("*start test_FindPurchaseOrderById*");
		Response response = HR_Store.findPurchaseOrderById(orderId);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End test_FindPurchaseOrderById*\n");
	
	}

	
	@Test(priority = 3)
	public void test_DeteleOrdersById()
	{
		logger.info("*Start test_DeteleOrdersById*");
		Response response = HR_Store.deletePurchaseOrderById(orderId);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End test_DeteleOrdersById*\n");
	}
	
	
	@Test(priority =4)
	public void test_InventoryDetails()
	{
		logger.info("* start test_InventoryDetails*");
		Response response = HR_Store.petInventoryByStatus();
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_InventoryDetails*\n");
	}
	
	

}
