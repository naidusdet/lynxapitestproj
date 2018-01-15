package steps;

import apitests.LynxAPITest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by maheshboyalla on 15/01/2018.
 */
public class LynxAPIStepdefs {

    LynxAPITest lynxAPITest;

    /*
    We should do setup operations, get JSON response from the API and put it into JsonPath object
    Then we will do query and manipulations with JsonPath class’s methods.
    We can do all of the preparation operations after @Before Junit annotation.
    */

    @Given("^Countries retrieval rest endpoint is up$")
    public void countriesRetrievalRestEndpointIsUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        lynxAPITest = new LynxAPITest();
    }

    @When("^User access all countries information$")
    public void userSeeAllCountriesInformation() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        lynxAPITest.requestAllCountriesInformation();
    }

    @Then("^Returned JSON object is not null$")
    public void returnedJSONObjectIsNotNull() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        lynxAPITest.responseStatusCodeTest();
    }

    @When("^User retrieve a specific \"([^\"]*)\" information at a time$")
    public void userRetrieveASpecificCountryInformationAtATime(String country) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        lynxAPITest.requestASpecificCountryInformation(country);
    }

    @Then("^Returned JSON object body should contain \"([^\"]*)\"$")
    public void returnedJSONObjectBodyShouldContain(String content) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        lynxAPITest.verifyResponseBody(content);
    }

    @Then("^Returned JSON object body For Invalid Entry should contain \"([^\"]*)\"$")
    public void returnedJSONObjectBodyShouldContain404(String content) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        lynxAPITest.verifyResponseBodyFor404(content);
    }
}
