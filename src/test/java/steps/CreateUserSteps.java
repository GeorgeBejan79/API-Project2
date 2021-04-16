package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pojo.UserPojo;
import utils.Constants;
import utils.PayloadUtils;

import static io.restassured.RestAssured.given;

public class CreateUserSteps {
    Response response;

    @Given("user get url {string}")
    public void user_get_url_https_gorest_co_in_public_api_users(String url) {
        RestAssured.baseURI=url;
    }
    @When("user is created")
    public void user_is_created() {
        String userBody= PayloadUtils.getPayLoad();
        response = given().header(Constants.ACCEPT,Constants.APPLICATION_JSON)
                .header(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON)
                .header(Constants.AUTHORIZATION, Constants.TOKEN)
                .body(userBody).when().post();
    }
    @Then("verify the status code is {int}")
    public void verify_the_status_code_is(Integer int1) {
        Assert.assertEquals(200, response.getStatusCode());
    }
    @Then("verify if your id it is in the list")
    public void verify_if_your_id_it_is_in_the_list() {

        UserPojo parsedResponse=response.as(UserPojo.class);
        MatcherAssert.assertThat(parsedResponse.getName(), Matchers.is("Bejan"));
    }
    @Then("Update user and verify that status code is {int}")
    public void update_user_and_verify_that_status_code_is(Integer statusCode) {
        String userUpdatedBody= PayloadUtils.updatePayload();
        response = given().header(Constants.ACCEPT,Constants.APPLICATION_JSON)
                .header(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON)   //updates
                .header(Constants.AUTHORIZATION, Constants.TOKEN)
                .body(userUpdatedBody).when().put("/1451").then().statusCode(statusCode).extract().response();

    }
    @Then("delete user and verify that status code is {int}")
    public void delete_user_and_verify_that_status_code_is(Integer statuscode) {
        response.statusCode();
        int status=response.getStatusCode();
        Assert.assertEquals(200, status);

        String deleteUser= PayloadUtils.getPayLoad();
        response = given().header(Constants.ACCEPT,Constants.APPLICATION_JSON)
                .header(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON)   //updates
                .header(Constants.AUTHORIZATION, Constants.TOKEN)
                .when()
                .delete("/1451")
                .then()
                .statusCode(statuscode).body("code",Matchers.equalTo("204")).extract().response();

    }
}
