package PETSTORE.API.EndPoint;

public class EP_Pet {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String post_uploadAnImage = base_url+"pet/{id}/uploadImage";
	public static String post_addNewPetToStore = base_url+"/pet";
	public static String put_updatePet = base_url+"/pet";
	public static String get_findPetByStatus = base_url+"/pet/findByStatus?status=pending";
	public static String get_findPetById= base_url+"/pet/{id}";
	public static String post_updatePetInStoreByFormData = base_url+"/pet/{id}";
	public static String delete_deletePetById = base_url+"/pet/{id}";
	
}
