package ch.zli.m223;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ch.zli.m223.model.User;
import ch.zli.m223.service.jwtService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)
@TestSecurity(user = "emily9898@exmaple.ch", roles = "Admin")
public class LoginResourceTest {

    @Inject
    EntityManager entityManager;
    jwtService jwtservice;

    String jwt = jwtservice.generateJWT(entityManager.find(User.class, 2)).toString();

    @Test
    public void testSecuredEndpoint() {
        given()
          .header("Authorization", "Bearer " + jwt)
          .when()
          .get("/login")
          .then()
             .statusCode(200)
             .body(is("d"));
    }
}
