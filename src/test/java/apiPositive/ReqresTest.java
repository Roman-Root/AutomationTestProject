package apiPositive;

import api.model.*;
import api.model.login.LoginResponse200;
import api.model.login.LoginRequest;
import api.model.register.RegisterRequest;

import api.model.register.RegisterResponse200;
import api.model.specification.Specification;
import api.model.users.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;


public class ReqresTest {

    private final String URL = "https://reqres.in/";

    @Test
    public void checkAvatar() {
        //Specification request and response
        Specification.InstallSpecification( Specification.requestSpecification(URL), Specification.responseSpecification200());
        //Users list
        List<UserData> users = given()
                .when()
                .get( "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        assertNotNull(users);

    }

    @Test
    public void registr200() {
        //expected result
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        //Specification request and response
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification200());
        //body
        RegisterRequest user = new RegisterRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse200 response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(RegisterResponse200.class);

        Assert.assertEquals(id, response.getId());
        Assert.assertEquals(token, response.getToken());

    }

    @Test
    public void login200() {
        //expected result
        String token = "QpwL5tke4Pnpja7X4";
        //Specification request and response
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification200());
        //body
        LoginRequest userdata = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        LoginResponse200 response200 = given()
                .body(userdata)
                .when()
                .post( "api/login")
                .then().log().all()
                .extract().as(LoginResponse200.class);

        Assert.assertNotNull(response200);
        //Comparing expected token with actual token
        Assert.assertEquals(token, response200.getToken());

    }

    @Test
    public void unknowCheckYears(){
        //Specification request and response
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification200());
        //Get response list
        List<Unknow> colorsData = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", Unknow.class);
        //List years
        List<Integer> years = colorsData.stream().map(Unknow::getYear).collect(Collectors.toList());
        //Sorted list years
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        //Comparing years list and sortedYears list
        Assert.assertEquals(years, sortedYears);
        //Print result
        System.out.println("Expected result: " + sortedYears);
        System.out.println("Actual result:   " + years);

    }

    @Test
    public void deleteUser(){
        //Specification request and response
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecificationUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();

    }
}