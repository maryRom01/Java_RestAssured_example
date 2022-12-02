import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicApiTest extends BaseTest {
    @DataProvider(name = "clientsResponse")
    public Object[][] getClientsResponse() {
        return new Object[][]{
                {new ArrayList<String>(Arrays.asList("ada", "akka-scala", "android",
                        "apex", "bash", "clojure", "cpprest", "csharp", "csharp-dotnet2",
                        "cwiki", "dart", "dart-jaguar", "dynamic-html", "eiffel", "elixir",
                        "elm", "erlang-client", "flash", "go", "groovy", "haskell-http-client",
                        "html", "html2", "java", "javascript", "javascript-closure-angular",
                        "jaxrs-cxf-client", "jmeter", "kotlin", "lua", "objc", "perl",
                        "php", "powershell", "python", "qt5cpp", "r", "ruby", "rust", "scala",
                        "scalaz", "swagger", "swagger-yaml", "swift", "swift3", "swift4", "swift5",
                        "tizen", "typescript-angular", "typescript-angularjs", "typescript-aurelia",
                        "typescript-fetch", "typescript-inversify", "typescript-jquery",
                        "typescript-node", "ue4cpp"))}
        };
    }

    @DataProvider(name = "serversResponse")
    public Object[][] getServersResponse() {
        return new Object[][]{
                {new ArrayList<String>(Arrays.asList("ada-server", "aspnetcore",
                        "erlang-server", "finch", "go-server", "haskell", "inflector",
                        "java-pkmst", "java-play-framework", "java-vertx", "jaxrs",
                        "jaxrs-cxf", "jaxrs-cxf-cdi", "jaxrs-resteasy", "jaxrs-resteasy-eap",
                        "jaxrs-spec", "kotlin-server", "lumen", "msf4j", "nancyfx",
                        "nodejs-server", "php-silex", "php-symfony", "pistache-server",
                        "python-flask", "rails5", "restbed", "rust-server",
                        "scala-lagom-server", "scalatra", "sinatra", "slim",
                        "spring", "undertow", "ze-ph"))}
        };
    }

    @Test(dataProvider = "clientsResponse")
    public void testClientsAPI(ArrayList availableLanguages) {
        response = utilsRestAssured.getResponse("/gen/clients");
        utilsTest.verifyStatusIs200(response);
        jsonPath = utilsRestAssured.getJsonPath(response);
        utilsTest.verifyDataIsEqual(utilsTest.getData(jsonPath), availableLanguages);
        System.out.println(utilsTest.getData(jsonPath));
    }

    @Test(dataProvider = "serversResponse")
    public void testServersAPI(ArrayList availableServers) {
        response = utilsRestAssured.getResponse("/gen/servers");
        utilsTest.verifyStatusIs200(response);
        jsonPath = utilsRestAssured.getJsonPath(response);
        utilsTest.verifyDataIsEqual(utilsTest.getData(jsonPath), availableServers);
        System.out.println(utilsTest.getData(jsonPath));
    }

    @Test
    public void testClientsAndroidAPI() {
        response = utilsRestAssured.getResponse("/gen/clients/android");
        utilsTest.verifyStatusIs200(response);
        jsonPath = utilsRestAssured.getJsonPath(response);

        String jsonPathToOpt = "modelPackage.opt";
        utilsTest.verifyStringIsEqual(jsonPath.get(jsonPathToOpt), "modelPackage");
        System.out.println("opt: " + jsonPath.get(jsonPathToOpt));

        String jsonPathToDescription = "modelPackage.description";
        utilsTest.verifyStringIsEqual(jsonPath.get(jsonPathToDescription), "package for generated models");
        System.out.println("description: " + jsonPath.get(jsonPathToDescription));

        String jsonPathToType = "modelPackage.type";
        utilsTest.verifyStringIsEqual(jsonPath.get(jsonPathToType), "string");
        System.out.println("type: " + jsonPath.get(jsonPathToType));
    }
}
