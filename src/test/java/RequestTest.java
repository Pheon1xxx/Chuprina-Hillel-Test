import io.restassured.RestAssured;
import org.apache.hc.core5.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import utils.UserDTO;

import static utils.Specifications.requestSpecification;

public class RequestTest {
    @Test
    public void getRequestCheckStatusCode() {
        RestAssured.given()
                .spec(requestSpecification())
                .get("/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(requestSpecification())
                .get("/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data.id", Matchers.is(2))
                .body("data.email", Matchers.is("janet.weaver@reqres.in"))
                .body("data.first_name", Matchers.is("Janet"))
                .body("data.last_name", Matchers.is("Weaver"));
    }

    @Test
    public void postRequestCheckStatusCode() {
        RestAssured.given()
                .spec(requestSpecification())
                .body(new UserDTO("morpheus", "leader"))
                .post("/api/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void postRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(requestSpecification())
                .body(new UserDTO("morpheus", "leader"))
                .post("/api/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("name", Matchers.is("morpheus"))
                .body("job", Matchers.is("leader"));
    }
}
