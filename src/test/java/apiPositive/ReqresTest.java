package apiPositive;

import api.model.*;
import io.restassured.http.ContentType;

import org.testng.Assert;
import org.testng.annotations.Test;



import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;


public class ReqresTest {

    private final String URL = "https://reqres.in/";

    @Test
    public void checkAvatar() {
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        assertNotNull(users);

    }

    @Test
    public void registr200() {
        //expected result
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        //body
        RegisterRequest user = new RegisterRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse200 response = given()
                .body(user).contentType(ContentType.JSON)
                .when()
                .post(URL + "api/register")
                .then().log().all()
                .extract().as(RegisterResponse200.class);

        Assert.assertEquals(id, response.getId());
        Assert.assertEquals(token, response.getToken());

    }

    @Test
    public void login200() {
        //expected result
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        //body
        LoginRequest userdata = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        LoginResponse200 response200 = given()
                .body(userdata).contentType(ContentType.JSON)
                .when()
                .post(URL + "api/login")
                .then().log().all()
                .extract().as(LoginResponse200.class);

        Assert.assertNotNull(response200);
        Assert.assertEquals(token, response200.getToken());

    }
}