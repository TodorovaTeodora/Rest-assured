package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class FootballApiConfig {

    @BeforeClass
    public static void setup() {
        RestAssured.setBaseUri("http://api.football-data.org");
        RestAssured.setBasePath("/v4/");
        
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("X-Auth-Token", "fae8b099875d41f395c58dbb7f35556b")
                .addHeader("X-Response-Control", "minified")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

       RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

    }
}
