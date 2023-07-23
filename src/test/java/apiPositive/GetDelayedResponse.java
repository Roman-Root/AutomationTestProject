package apiPositive;

import api.dtoModel.specification.Specification;
import api.dtoModel.users.DelayedResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetDelayedResponse {

    private final String URL = "https://reqres.in/";

    @Test
    public void getDelayedResponse(){

        Integer id = 3;
        String fist_name = "Emma";
        Specification.InstallSpecification(Specification.requestSpecification(URL), Specification.responseSpecification200());
        DelayedResponse response = given()
                .get("api/users?delay=3")
                .then()
                .extract().body().as(DelayedResponse.class);
        Assert.assertNotNull(response);
//        Assert.assertEquals(id, response);

        //System.out.println(response.getData().get(1));

        System.out.println(response.getData().get(0));



    }


}
