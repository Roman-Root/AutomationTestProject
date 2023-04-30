package apiNegative;

import api.model.LoginRequest;
import api.model.LoginResponse400;
import api.model.RegisterRequest;
import api.model.RegisterResponse;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserLoginNegative {

    private final String URL = "https://reqres.in/";
    @Test
    public void login400() {
        //expected result
        String error = "Missing password";
        //body
        LoginRequest bodyRequest = new LoginRequest("eve.holt@reqres.in","");
        LoginResponse400 response400 = given()
                .body(bodyRequest).contentType(ContentType.JSON)
                .when()
                .post(URL + "api/login")
                .then().log().all()
                .extract().as(LoginResponse400.class);

        Assert.assertNotNull(response400);
        Assert.assertEquals(error, response400.getError());
    }
}
