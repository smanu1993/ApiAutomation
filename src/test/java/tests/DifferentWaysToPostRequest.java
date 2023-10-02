package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pojo.SampleUser;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DifferentWaysToPostRequest extends BaseClass {
    @Test
    public void createUserWithHashMap() {
        baseURI = baseUri;

        HashMap map = new HashMap();
        map.put("name", "Manu" + getRandomNumber());
        map.put("job", "SDET");

        given()
                .body(map)
                .contentType(ContentType.JSON)
                .when().post("users")
                .then().assertThat().statusCode(201)
                .contentType(ContentType.JSON).log().all();
    }

    @Test
    public void createUserWithJsonObject() {
        baseURI = baseUri;

        JSONObject obj = new JSONObject();
        obj.put("name", "Manu" + getRandomNumber());
        obj.put("job", "SDET");

        given()
                .body(obj)
                .contentType(ContentType.JSON)
                .when().post("users")
                .then().assertThat().statusCode(201)
                .contentType(ContentType.JSON).log().all();
    }

    @Test
    public void createUserWithJsonFile() {
        baseURI = baseUri;

        File file = new File("./data/user.json");

        given()
                .body(file)
                .contentType(ContentType.JSON)
                .when().post("users")
                .then().assertThat().statusCode(201)
                .contentType(ContentType.JSON).log().all();
    }

    @Test
    public void createUserWithPojoClass() {
        baseURI = baseUri;

        SampleUser user = new SampleUser("Manu" + getRandomNumber(), "SDET");

        given()
                .body(user)
                .contentType(ContentType.JSON)
                .when().post("users")
                .then().assertThat().statusCode(201)
                .contentType(ContentType.JSON).log().all();
    }
}
