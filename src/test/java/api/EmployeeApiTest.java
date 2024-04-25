package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Employee;
import org.config.Constants;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class EmployeeApiTest extends BaseTest{

    @Test
    public void testEmployeeAPI() {
        Response response = RestAssured.given()
                .when()
                .get(Constants.EMPLOYEES_ENDPOINT)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        List<Employee> employees = response.jsonPath().getList("data", Employee.class);

        // Java Stream API ile filtreleme ve doğrulama
        List<String> names = employees.stream()
                .filter(e -> e.getEmployeeSalary() == Constants.EXPECTED_SALARY)
                .map(Employee::getEmployeeName)
                .collect(Collectors.toList());

        // Beklenen ismin listede olup olmadığını kontrol et
        assertTrue(names.contains(Constants.EXPECTED_NAME), "The expected name is not in the list");
    }
}