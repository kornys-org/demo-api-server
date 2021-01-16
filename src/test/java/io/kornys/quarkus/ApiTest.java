package io.kornys.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ApiTest {

    @Test
    public void testApiEndpoint() {
        given()
                .when().get("/api")
                .then()
                .statusCode(200)
                .body(is("this is api endpoint"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"redhat", "kubernetes", "quarkus"})
    public void testHelloEndpoint(String name) {
        given()
                .when().get("/api/hello/" + name)
                .then()
                .statusCode(200)
                .body(is("hello " + name));
    }

}