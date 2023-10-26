package PETSTORE.API.EndPoint;

public class EP_Store {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String post_placeAnOrderForPet = base_url+"/store/order";
	public static String get_FindPurchageOrderById = base_url+"/store/order/{id}";
	public static String delete_deletePurchaseOrderById = base_url+"/store/order/{id}";
	public static String get_returnPetInventoryByStatus = base_url+"/store/inventory";
	

}
