package PETSTORE.API.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import PETSTORE.API.HttpRequest.HR_Pet;
import PETSTORE.API.payload.PL_Pet;
import io.restassured.response.Response;

public class TC_Pet {
	
	public Faker faker = new Faker();
	public PL_Pet payload = new PL_Pet();
	
	public Logger logger = LogManager.getLogger(this.getClass());
	int petId;
	int petId2 = 600;
	
	@BeforeClass
	public  void setup()
	{
		petId = faker.number().numberBetween(1,3);
		payload.setPetId(petId);
		payload.setCategoryId(faker.number().numberBetween(1, 3));
		payload.setTagId(faker.number().numberBetween(1,2));
		payload.setCategoryName(faker.animal().name());
		payload.setPetName(faker.animal().name());
		payload.setStatus("available");
		payload.setTagName("TagName_"+faker.animal().name());
	
	}
	
	

	
	
	//@Test(priority =1)
	public void test_AddNewPetToStore()
	{
		logger.info("*Start test_AddNewPetToStore*");
		Response resposne = HR_Pet.addNewPetToStore(payload);
		resposne.then()
			.log().all();
		
		Assert.assertEquals(resposne.getStatusCode(),200);
		logger.info("*End test_AddNewPetToStore*\n");
	
	}
	
	
	//@Test(priority =2 )
	public void test_UploadPetImage()
	{
		logger.info("*start test_UploadPetImage*");
		Response response = HR_Pet.uplaodImage(petId);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End test_UploadPetImage*\n");
	
	}

	
	@Test(priority = 3)
	public void test_UpdatPet()
	{
		logger.info("*Start test_UpdatPet*");
		Response response = HR_Pet.updateExistingPet(payload,petId2);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*End test_UpdatPet*\n");
	}
	
	
	//@Test(priority =4)
	public void test_FindPetByStatus()
	{
		logger.info("* start test_FindPetByStatus*");
		Response response = HR_Pet.findPetByStatus(this.payload.getStatus());
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_FindPetByStatus*\n");
	}
	
	@Test(priority =5)
	public void test_FindPetById()
	{
		logger.info("* start test_FindPetById*");
		Response response = HR_Pet.findPetById(petId2);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_FindPetById*\n");
	}
	
	
	//@Test(priority =6)
	public void test_updatePetInStoreByFormData()
	{
		logger.info("* start test_updatePetInStoreByFormData*");
		Response response = HR_Pet.updatePetInStoreByFormData(payload,petId);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_updatePetInStoreByFormData*\n");
	}
	
	@Test(priority =7)
	public void test_deletePetById()
	{
		logger.info("* start test_deletePetById*");
		Response response = HR_Pet.deletePetById(petId2);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("* end test_deletePetById*\n");
	}
	
}
