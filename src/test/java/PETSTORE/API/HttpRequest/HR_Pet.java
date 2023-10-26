package PETSTORE.API.HttpRequest;

import static io.restassured.RestAssured.*;

import PETSTORE.API.EndPoint.EP_Pet;
import PETSTORE.API.payload.PL_Pet;
import io.restassured.response.Response;

public class HR_Pet {

	// TO UPDATE AN IMAGE
	public static Response uplaodImage(int id) {
		Response response = given().contentType("application/json").accept("application/json").pathParam("id", id)

				.when().post(EP_Pet.post_uploadAnImage);

		return response;

	}

	// TO ADD NEW PET TO STORE
	public static Response addNewPetToStore(PL_Pet payload) {

		Response response = given().contentType("application/json").accept("application/json").body(payload)

				.when().post(EP_Pet.post_addNewPetToStore);

		return response;
	}

	// UPDATE PET AN EXISTING PET
	public static Response updateExistingPet(PL_Pet payload, int id) {
		Response response = given().contentType("application/json").accept("application/json").pathParam("id", id)
				.body(payload)

				.when().put(EP_Pet.put_updatePet);

		return response;
	}

	// FIND PET BY STATUS
	public static Response findPetByStatus(String status) {
		Response response = given().queryParam(status).accept("application/json")

				.when().get(EP_Pet.get_findPetByStatus);

		return response;
	}

	// FIND PET BY ID
	public static Response findPetById(int id) {
		Response response = given()
				.pathParams("id",id)
				.accept("application/json")

				.when().get(EP_Pet.get_findPetById);

		return response;
	}

	// UPDATE PET IN STOTE BY FORM DATA
	public static Response updatePetInStoreByFormData(PL_Pet payload, int id) {
		Response response = given()
				.pathParam("id", id)
				.contentType("application/json")
				.accept("application/json")
				.body(payload)

				.when().delete(EP_Pet.post_updatePetInStoreByFormData);

		return response;

	}
	
	
	// DELETE PET BY ID
	public static Response deletePetById(int id) {
		Response response = given()
				.pathParam("id", id)

				.when().delete(EP_Pet.delete_deletePetById);

		return response;

	}
}
