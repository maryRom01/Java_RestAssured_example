import com.beust.jcommander.Parameter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.*;
import util.RestAssuredUtil;
import util.TestUtil;

import java.util.ArrayList;

public class BaseTest {
    protected Response response = null;
    protected JsonPath jsonPath = null;
    protected RestAssuredUtil utilsRestAssured = new RestAssuredUtil();
    protected TestUtil utilsTest = new TestUtil();


    @BeforeClass
    public void setup() {
        String mode = "";
        if(System.getProperty("propertyMode") == null) {
           mode  = utilsRestAssured.getMode();
        } else {
            mode = System.getProperty("propertyMode");
        }
        utilsRestAssured.setBaseURI(mode);
        utilsRestAssured.setBasePath("api");
        utilsRestAssured.setContentType(ContentType.JSON);
    }

    @AfterClass
    public void cleanup() {
        utilsRestAssured.resetBaseURI();
        utilsRestAssured.resetBasePath();
    }
}

