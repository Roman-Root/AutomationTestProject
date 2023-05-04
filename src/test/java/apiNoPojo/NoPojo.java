package apiNoPojo;

import api.model.specification.Specification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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

}
