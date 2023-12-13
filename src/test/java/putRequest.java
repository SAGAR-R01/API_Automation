import io.restassured.RestAssured;
import org.testng.annotations.Test;

@Test
public class putRequest extends postRequest {

    public void updateBooking(){

        String payload = """
                {
                    "firstname" : "Chandana",
                        "lastname" : "S",
                        "totalprice" : 999,
                        "depositpaid" : true,
                        "bookingdates" : {
                            "checkin" : "2018-01-01",
                            "checkout" : "2019-01-01"
                        },
                        "additionalneeds" : "Breakfast"
                }
                """;
                 RestAssured.given()
                         .baseUri("https://restful-booker.herokuapp.com")
                         .contentType("application/json")
                         .body(payload)
                         .header("Cookie","token="+getToken)
                         .when()
                         .put("/booking/1")
                         .then()
                         .log().all()
                         .assertThat()
                         .statusCode(200);

    }
}
