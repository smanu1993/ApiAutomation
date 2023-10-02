package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class CrudWithBDD extends BaseClass {
    @Test
    public void createUser() {

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
    public void getUser() {
        baseURI = baseUri;
        int expResp = 2;
        Response resp = when().get("users/2");
        int actResp = resp.jsonPath().get("data.id");
        Assert.assertEquals(expResp, actResp);
        resp.then().assertThat().time(Matchers.lessThan(50L), TimeUnit.SECONDS)
                .statusCode(200)
                .contentType(ContentType.JSON).log().all();
    }

    @Test
    public void updateUser() {
        baseURI = baseUri;

        JSONObject obj = new JSONObject();
        obj.put("name", "Manu" + getRandomNumber());
        obj.put("job", "SDET");

        given()
                .body(obj)
                .contentType(ContentType.JSON)
                .when().put("users/2")
                .then().assertThat().statusCode(200)
                .contentType(ContentType.JSON).log().all();
    }

    @Test
    public void deleteUser() {
        baseURI = baseUri;
        when().delete("users/2")
                .then().assertThat().statusCode(204).log().all();
    }
}
