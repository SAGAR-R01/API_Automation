import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


@Test
public class postRequest {
    String getToken;
    public void authToken() {
        String payload = """
                {
                  "username" : "admin",
                   "password" : "password123"
                }""";
        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/auth")
                .then().log().all().extract().response();

        getToken = response.jsonPath().getString("token");
        System.out.println("Token : " + getToken);
    }
}

