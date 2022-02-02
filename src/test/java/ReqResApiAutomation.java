import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ReqResApiAutomation extends Base {

    @Test
    public void getReqRes(){
        given()
                .spec(reqResRequestSpec())
                .queryParams("page", "2")
                .when()
                .get()
                .then()
                .statusCode(200);

    }
    @Test
    public void postReqRes(){
        CreateCustomer customer = dataFaker();
System.out.println(customer);
        given()
                .spec(reqResRequestSpec())
                .contentType(ContentType.JSON)
                .body(customer)
                .when()
                .post()
                .then()
                .statusCode(201)
                .and().assertThat()
                .body("name", equalTo(customer.getName()))
                .body("job", equalTo(customer.getJob()))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());

    }
    @Test
    public void putReqRes(){
        given()
                .spec(reqResRequestSpec())
                .when()
                .put()
                .then()
                .statusCode(200);

    }
    @Test
    public void deleteReqRes(){
        given()
                .spec(reqResRequestSpec())
                .when()
                .delete("/2")
                .then()
                .statusCode(204);

    }

    public CreateCustomer dataFaker(){

        Faker faker = Faker.instance();
        return CreateCustomer.builder()
                .name(faker.name().fullName())
                .job(faker.job().title())
                .build();

    }

}
