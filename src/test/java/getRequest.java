import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Test

public class getRequest {

    public void getBookingIds() {
        int bookingID = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .when()
                .get("/booking")
                .then()
                .extract()
                .response()
                .path("bookingid[0]");
        System.out.println("BookingId : " + bookingID);

        //assert using Hamcrest
        assertThat(bookingID,equalTo(1881));

        //assert using TestNG
        Assert.assertEquals(bookingID,1881);

    }

}
