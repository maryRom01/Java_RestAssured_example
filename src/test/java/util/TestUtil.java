package util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestUtil {

    public void verifyStatusIs200( Response response ) {
        Assert.assertEquals(response.getStatusCode(), 200, "Status Check failed!");
    }

    public <T> ArrayList<T> getData( JsonPath jsonPath ) {
        return jsonPath.get();
    }

    public void verifyDataIsEqual(ArrayList actual, ArrayList expected) {
        assertEquals(actual, expected, "Data is not equal!");
    }

    public void verifyStringIsEqual(String actual, String expected) {
        assertEquals(actual, expected, "String is not equal!");
    }
}
