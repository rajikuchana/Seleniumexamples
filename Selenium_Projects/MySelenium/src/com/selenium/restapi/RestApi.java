package com.selenium.restapi;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RestApi {
	
	@Test
	public void countryNamesTest() {
		
		given()
		.when()
		.get(ServiceURL.raceUrl)
		.then()
		.assertThat()
		.statusCode(200);
		
		Response response = given()
				.when()
				.get(ServiceURL.raceUrl);
		
		String responseValues = response.getBody().asString();
		System.out.println(responseValues);
		
		JsonPath jsonPath = new JsonPath(responseValues);
		String countryName = jsonPath.getString("MRData.CircuitTable.Circuits.Location.country[0]");
		System.out.println(countryName);
		Assert.assertEquals(countryName, "Australia");		
	
	}

}
