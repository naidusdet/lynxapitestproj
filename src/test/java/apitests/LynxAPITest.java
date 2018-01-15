package apitests;

import com.jayway.restassured.RestAssured;


import com.jayway.restassured.response.Response;
import lynxutil.LynxAssertHelperUtil;
import lynxutil.LynxConfigConstants;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


/**
 * Created by maheshboyalla on 15/01/2018.
 */
public class LynxAPITest {

    private Response res = null;

    public LynxAPITest(){
        RestAssured.baseURI = LynxConfigConstants.LYNX_API_URI;
    }

    @Before
    public void setup (){
        //Test Setup
          }

    @Test
    public void requestAllCountriesInformation() {
       res =
                given().relaxedHTTPSValidation().
                        contentType("application/json").
                        when().
                        get("/rest/v1/all/").
                        then().
                        statusCode(200).
                        extract().response();
    }

    @Test
    public void requestASpecificCountryInformation(String pathVariable) {
        res =
                given().relaxedHTTPSValidation().
                        contentType("application/json").
                        when().
                        get("/rest/v1/name/" + pathVariable).
                        then().
                        extract().response();
    }

    @Test
    public void verifyResponseBody(String pathVariable) {
        res =
                given().relaxedHTTPSValidation().
                        contentType("application/json").
                        when().
                        get("/rest/v1/name/" + pathVariable).
                        then().body(containsString(pathVariable)).
                        extract().response();
    }

    @Test
    public void verifyResponseBodyFor404(String pathVariable) {
        //Verify the http response status returned. Check Status Code is 200?
        res = given().relaxedHTTPSValidation().
                contentType("application/json").
                when().
                get("/rest/v1/name/" + pathVariable).
                then().body(containsString(pathVariable)).
                extract().response();

        int statusCode = res.getStatusCode();
        String test = "";

    LynxAssertHelperUtil.checkStatusIs404(res);
    }


    @Test
    public void responseStatusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
         LynxAssertHelperUtil.checkStatusIs200(res);
    }

    @After
    public void afterTest (){
        //Reset Values

    }

}
