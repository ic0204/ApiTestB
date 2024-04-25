package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.config.Configuration;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Configuration.getBaseURI();
    }
}