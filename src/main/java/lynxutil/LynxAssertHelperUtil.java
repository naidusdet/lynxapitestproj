package lynxutil;

import com.jayway.restassured.response.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by maheshboyalla on 15/01/2018.
 */
public class LynxAssertHelperUtil {

    /*
   Verify the http response status returned. Check Status Code is 200?
   We can use Rest Assured library's response's getStatusCode method
   */
    public static void checkStatusIs200 (Response res) {
        assertEquals("Status Check Failed!", 200, res.getStatusCode());
    }

    /*
  Verify the http response status returned. Check Status Code is 404?
  We can use Rest Assured library's response's getStatusCode method
  */
    public static void checkStatusIs404 (Response res) {
        assertEquals("Status Check Failed!", 404, res.getStatusCode());
    }
}
