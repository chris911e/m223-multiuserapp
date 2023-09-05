package ch.zli.m223;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.h2.H2DatabaseTestResource;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)
@TestSecurity(user = "emily9898@exmaple.ch", roles = "Admin")
public class BookingResourceTest {

  @Test
  @Order(1)
  public void testIndexEndpoint() {
    given()
        .when()
        .get("/booking")
        .then()
        .statusCode(200)
        .body("size()", is(3));
  }

  @Test
  @Order(2)
  public void testSingleBookingEndpoint() {
    given()
        .when()
        .get("/booking/" + 1)
        .then()
        .statusCode(200)
        .body("size()", is(3));
  }
  
  @Test
  @Order(3)
  public void testDeleteEndpoint() {
      given()
              .when().delete("/booking/delete/" + 1)
              .then()
              .statusCode(500);

      given()
              .when().get("/booking")
              .then()
              .statusCode(200)
              .body("size()", is(3));
  }

}