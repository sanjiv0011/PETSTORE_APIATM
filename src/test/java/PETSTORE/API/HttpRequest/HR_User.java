package PETSTORE.API.HttpRequest;


import static io.restassured.RestAssured.*;


import PETSTORE.API.EndPoint.EP_User;
import PETSTORE.API.payload.PL_User;
import io.restassured.response.Response;

public class HR_User {
	
	
	//CREATE USERS
	public static Response createUser(PL_User payload)
	{
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
		
		
		.when()
			.post(EP_User.post_createUser);
		
		return response;
		
	}


	//GET USER BY NAME
	public static Response findUserByName(String userName)
	{
		Response response = 
		given()
			.pathParam("userName",userName)
		
		.when()
			.get(EP_User.get_getUserByName);
		
		
		return response;
	}
	
	
	//UPDATE USERS
	public static Response updateUser(PL_User payload)
	{
		Response response = 
			given()
			.contentType("application/json")
			.accept("application/json")
			
			.when()
				.put(EP_User.put_upddateUser);
		
		return response;
	}
	
	
	//LOGIN USER FROM SYSTEM
	public static Response loginUserInSystem(String userName, String userPassword )
	{
		Response response = 
				given()
				.contentType("application/json")
				.queryParam("userName", userName)
				.queryParam("userPassword", userPassword)
				.accept("application/json")
				
				.when()
					.get(EP_User.get_loginUserInSystem);
		
		return response;
				
				
	}
	
	//LOGOUT USER IN SYSTEM
		public static Response logoutUser()
		{
			Response response = 
					given()
					
					
					.when()
						.get(EP_User.get_logoutUser);
			
			return response;
					
					
		}
		
		//CREATE LIST OF USER WITH THE GIVEN INPUT ARRAY
		public static Response createListOfUserWithGivenInputArray(PL_User payload )
		{
			Response response = 
					given()
					.contentType("application/json")
					.accept("application/json")
					.body(payload)
					
					.when()
						.post(EP_User.post_createListOfUserWithGivenInputArray);
			
			return response;
					
					
		}
		
		
		//DELETE USER NAME
		public static Response deleteUserName(String userName)
		{
			Response response = 
					given()
					.contentType("application/json")
					.queryParam("userName", userName)
					
					.when()
						.delete(EP_User.delete_deleteUser);
			
			return response;
					
					
		}
}
