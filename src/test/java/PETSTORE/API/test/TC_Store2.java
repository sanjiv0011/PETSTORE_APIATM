package PETSTORE.API.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import PETSTORE.API.HttpRequest.HR_Store;
import PETSTORE.API.payload.PL_Store;
import PETSTORE.API.utilitites.ExtentReport2;
import io.restassured.response.Response;

public class TC_Store2 {

	public Faker faker = new Faker();
	public PL_Store payload = new PL_Store();
	public ExtentTest extentTest;

	public Logger logger = LogManager.getLogger(this.getClass());
	int orderId;
	String requestBody;
	String responseBody;

	@BeforeClass
	public void setup() {
		orderId = faker.number().numberBetween(1, 3);
		payload.setOrderId(orderId);
		payload.setPetId(faker.number().numberBetween(1, 3));
		payload.setQuantity(faker.number().numberBetween(1, 2));
		payload.setShipDate(Date.DateTimeExample.Date());
		payload.setStatus("placed");
		payload.setComplete(true);

	}
	
	public void request() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		requestBody = gson.toJson(payload);
		logger.info("RequestBody:\n"+requestBody);
		ExtentReport2.extentTest.log(Status.INFO, "Request Body:\n ");
		ExtentReport2.extentTest.log(Status.INFO,requestBody);
	}
	
	public void response() {
		logger.info("Response Body:\n"+responseBody );
		ExtentReport2.extentTest.log(Status.INFO, "Response Body:\n ");
		ExtentReport2.extentTest.log(Status.INFO," "+responseBody);
	}





	
	@Test(priority = 1)
	public void test_PlaceAnOrderForPet() {
		logger.info("*Start test_PlaceAnOrderForPet*");
		request();
		Response response  = HR_Store.placeAnOrderForPet(payload);
		responseBody = response.asPrettyString();
		response();
		Assert.assertEquals(response .getStatusCode(), 200);
		logger.info("*End test_PlaceAnOrderForPet*\n");

	}

	//@Test(priority = 2)
	public void test_FindPurchaseOrderById() {
		logger.info("*start test_FindPurchaseOrderById*");
		
		Gson gson = new Gson();
		String requestBody = gson.toJson(payload);
		logger.info("RequestBody:\n"+requestBody);
		extentTest.log(Status.INFO, "<pre>" + gson.toJson(requestBody) + "</pre>");
		
		Response response = HR_Store.findPurchaseOrderById(orderId);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End test_FindPurchaseOrderById*\n");

	}

	//@Test(priority = 3)
	public void test_DeteleOrdersById() {
		logger.info("*Start test_DeteleOrdersById*");
		
		Gson gson = new Gson();
		String requestBody = gson.toJson(payload);
		logger.info("RequestBody:\n"+requestBody);
		
		extentTest = extentTest.log(Status.INFO, "Request Body: " + requestBody);
		
		
		Response response = HR_Store.deletePurchaseOrderById(orderId);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End test_DeteleOrdersById*\n");
	}

	//@Test(priority = 4)
	public void test_InventoryDetails() {
		logger.info("* start test_InventoryDetails*");
		
		Gson gson = new Gson();
		String requestBody = gson.toJson(payload);
		logger.info("RequestBody:\n"+requestBody);
		
		
		extentTest = extentTest.log(Status.INFO, "Request Body: " + requestBody);
		
		Response response = HR_Store.petInventoryByStatus();
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_InventoryDetails*\n");
	}
	
	

}
