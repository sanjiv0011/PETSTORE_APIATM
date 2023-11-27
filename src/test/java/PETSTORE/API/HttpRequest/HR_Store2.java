package PETSTORE.API.HttpRequest;

import static io.restassured.RestAssured.*;


import PETSTORE.API.EndPoint.EP_Store;
import PETSTORE.API.payload.PL_Store;
import io.restassured.response.Response;



public class HR_Store2 {

	// PLACE AN ORDER FOR PET
	public static Response placeAnOrderForPet(PL_Store payload) {
		
	        
		Response response = given().contentType("application/json").accept("application/json").body(payload)

				.when().post(EP_Store.post_placeAnOrderForPet);
		
		return response;

	}

//FIND PURCHASE ORDER BY ID
	public static Response findPurchaseOrderById(int id) {
		Response response = given().contentType("application/json").accept("application/json").pathParam("id", id)

				.when().get(EP_Store.get_FindPurchageOrderById);

		return response;
	}

	// DELETE PURCHASE ORDER BY ID
	public static Response deletePurchaseOrderById(int id) {
		Response response = given().contentType("application/json")
				.accept("application/json")
				.pathParam("id", id)

				.when().delete(EP_Store.delete_deletePurchaseOrderById);

		return response;
	}

	public static Response petInventoryByStatus() {
		Response response = given().contentType("application/json").accept("application/json")

				.when().get(EP_Store.get_returnPetInventoryByStatus);

		return response;

	}
}
