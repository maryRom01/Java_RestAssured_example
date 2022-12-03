package util;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredUtil {
    static PropertiesController propertiesController = new PropertiesController();

    public static void setBaseURI() {
        RestAssured.baseURI = propertiesController.getProperty("sample.api.base.url");
    }

    public static void setBasePath(String basePath) {
        RestAssured.basePath = basePath;
    }

    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    public static void setContentType( ContentType contentType) {
        given().contentType(contentType);
    }

    public static Response getResponse(String path) {
        return given().get(path);
    }

    public static JsonPath getJsonPath(Response response) {
        String json = response.asString();
        return new JsonPath(json);
    }
}

