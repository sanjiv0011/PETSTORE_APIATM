package PETSTORE.API.EndPoint;

public class EP_User {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String post_createUser = base_url+"/user";
	public static String get_getUserByName = base_url+"/user/{userName}";
	public static String put_upddateUser = base_url+"/user/{userName}";
	public static String get_loginUserInSystem = base_url+"user/login?username={userName}&password={userPassword}";
	public static String get_logoutUser = base_url+"user/logout";
	public static String post_createListOfUserWithGivenInputArray = base_url+"/user/createWithArray";
	public static String delete_deleteUser = base_url+"/user/{userName}";
	

}
