import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.RestAssuredUtil;
import util.TestUtil;

public class BaseTest {
    public Response response = null;
    public JsonPath jsonPath = null;

    RestAssuredUtil utilsRestAssured = new RestAssuredUtil();
    TestUtil utilsTest = new TestUtil();

    @BeforeClass
    public void setup() {
        utilsRestAssured.setBaseURI();
        utilsRestAssured.setBasePath("api");
        utilsRestAssured.setContentType(ContentType.JSON);
    }

    @AfterClass
    public void cleanup() {
        utilsRestAssured.resetBaseURI();
        utilsRestAssured.resetBasePath();
    }
}

