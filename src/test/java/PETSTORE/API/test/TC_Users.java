package PETSTORE.API.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import PETSTORE.API.HttpRequest.HR_User;
import PETSTORE.API.payload.PL_User;
import io.restassured.response.Response;

public class TC_Users {
	
	public Faker faker = new Faker();
	public PL_User payload = new PL_User();
	
	public Logger logger = LogManager.getLogger(this.getClass());
	int userId = 101;
	String email = faker.internet().emailAddress();
	String userName = faker.name().username();
	String userPassword = "api_key";
	
	
	
	
	
	@BeforeClass
	public  void setup() {
		
		payload.setEmail(email);
		payload.setPhoneNumber(faker.phoneNumber().cellPhone());
		payload.setUserFirstName(faker.name().firstName());
		payload.setUserLastName(faker.name().lastName());
		payload.setUserId(userId);
		payload.setUserName(userName);	
		payload.setUserStatus("");
	
	}
	
	

	
	//CREATE USER 
	@Test(priority =1)
	public void test_createUser()
	{
		logger.info("*Start test_createUser*");
		Response resposne = HR_User.createUser(payload);
		resposne.then()
			.log().all();
		
		Assert.assertEquals(resposne.getStatusCode(),200);
		logger.info("*End test_createUser*\n");
	
	}
	
	//FIND USER BY NAME
	@Test(priority =2 )
	public void test_findUserByName()
	{
		logger.info("*start test_findUserByName*");
		Response response = HR_User.findUserByName(userName);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End test_findUserByName*\n");
	
	}

	
	//UPDATE USERS
	@Test(priority = 3)
	public void test_updateUser()
	{
		logger.info("*Start updateUser*");
		Response response = HR_User.updateUser(payload);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End updateUser*\n");
	}
	
	
	
	//LOGIN USER
	@Test(priority =4)
	public void test_loginUserInSystem()
	{
		logger.info("* start loginUserInSystem*");
		Response response = HR_User.loginUserInSystem(userName,userPassword);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end loginUserInSystem*\n");
	}
	
	
	
	
	//LOG OUT USER
	@Test(priority =5)
	public void test_logoutUser()
	{
		logger.info("* start test_logoutUser*");
		Response response = HR_User.logoutUser();
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_logoutUser*\n");
	}
	
	
	//CREATE LIST OF USER WITH THE GIVEN INPUT ARRAY
	@Test(priority =6)
	public void test_createListOfUserWithGivenInputArray()
	{
		logger.info("* start test_createListOfUserWithGivenInputArray*");
		Response response = HR_User.createListOfUserWithGivenInputArray(payload);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_createListOfUserWithGivenInputArray*\n");
	}
	
	
	//TO DELETE USER NAME
	@Test(priority =7)
	public void test_deleteUserName()
	{
		logger.info("* start test_deleteUserName*");
		Response response = HR_User.deleteUserName(userName);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_deleteUserName*\n");
	}
	
	
	

}
