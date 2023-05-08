package apiNoPojo;

import api.model.specification.Specification;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class NoPojo {

    private final String URL = "https://reqres.in/";
    @Test
    public void checkAvatarNoPojo(){
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification200());
        Response response = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .body("data.id", notNullValue())
                .body("page", equalTo(2))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        List<String> avatars = jsonPath.get("data.avatar");

        for (int i = 0; i<avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }
        Assert.assertTrue(emails.stream().allMatch(x->x.endsWith("@reqres.in")));
    }

    @Test
    public void registrNoPojo1(){
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void registr200NoPojo2(){
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        Response response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        Assert.assertEquals(4, id);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", token);
    }

    @Test
    public void register400Nopojo(){
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification400());
        Map<String, String> error = new HashMap<>();
        error.put("email", "sydney@fife");
        Response response = given()
                .body(error)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String erorrs = "Missing password";
        Assert.assertEquals(jsonPath.get("error"), erorrs);
    }




}
