package apiNegative;

import api.model.login.LoginResponse400;
import api.model.login.LoginRequest;
import api.model.register.RegisterRequest;
import api.model.register.RegisterResponse400;
import api.model.specification.Specification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ReqresUnsuccess {

    private final String URL = "https://reqres.in/";

    @Test
    public void registr400() {
        //Specification request and response
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification400());
        //expected result
        String error = "Missing password";
        //body
        RegisterRequest user = new RegisterRequest("eve.holt@reqres.in", "");
        RegisterResponse400 response = given()
                .body(user)
                .when()
                .post(URL + "api/register")
                .then().log().all()
                .extract().as(RegisterResponse400.class);

        Assert.assertNotNull(response);
        Assert.assertEquals(error, response.getError());
    }

    @Test
    public void login400() {
        //expected result
        String error = "Missing password";
        //Specification request and response
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification400());
        //body
        LoginRequest bodyRequest = new LoginRequest("eve.holt@reqres.in", "");
        LoginResponse400 response400 = given()
                .body(bodyRequest)
                .when()
                .post(URL + "api/login")
                .then()//.log().all()
                .extract().as(LoginResponse400.class);

        Assert.assertNotNull(response400);
        Assert.assertEquals(error, response400.getError());
        System.out.println("Expected result: " + error + "\nActual result: " + response400.getError());
    }
}