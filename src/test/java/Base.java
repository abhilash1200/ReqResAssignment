import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Base {
    public RequestSpecification reqResRequestSpec() {
        RequestSpecification requestSpec = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("api/users");
        return requestSpec;

    }

}