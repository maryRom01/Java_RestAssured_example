import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.RestAssuredUtil;
import util.TestUtil;

public class BaseTest {
    protected Response response = null;
    protected JsonPath jsonPath = null;
    protected RestAssuredUtil utilsRestAssured = new RestAssuredUtil();
    protected TestUtil utilsTest = new TestUtil();

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

