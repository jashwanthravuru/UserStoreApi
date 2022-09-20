package Day9;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;
public class UserStore {

	
	
	@Test(priority=1)
	public void test_CreatenewUser()
	{
		HashMap data=new HashMap();
		data.put("id", "1");
		data.put("username", "sunitha");
		data.put("firstName", "k");
		data.put("lastName","yadav");
		data.put("email","sunithayadav@gmail.com" );
		data.put("password","sunithayadav");
		data.put("phone", "9550712964");
		data.put("userStatus", "0");
		
		ValidatableResponse res=given()
				.contentType("application/json")
				.body(data)
				.when()
				.post("https://petstore.swagger.io/v2/user")
				
		
				.then()
				.statusCode(200);
		
		
		
		
	}
	
	
	@Test(priority=2)
	
	public void test_GetUserDetails()
	{
		given()
		.when()
		.get("https://petstore.swagger.io/v2/user/sunitha")
		.then()
		.statusCode(200);
	}
	
	@Test(priority=3)
	public void test_updateUserDetails()
	{
		HashMap data=new HashMap();
		data.put("id", "1");
		data.put("username", "jashwanthrachuru");
		data.put("firstName", "jashu");
		data.put("lastName","sai");
		data.put("email","jashurachuru123@gmail.com" );
		data.put("password","jashwanthrachuru");
		data.put("phone", "123456");
		data.put("userStatus", "0");
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.put("https://petstore.swagger.io/v2/user/jashwanth")
		.then()
		.statusCode(200);
		
	}
	
	@Test(priority=4)
	
	public void test_DeleteuserDetails()
	{
		ValidatableResponse res=given()
				.when()
				.delete("https://petstore.swagger.io/v2/user/sunitha")
				.then()
				.statusCode(200);
	}
}
