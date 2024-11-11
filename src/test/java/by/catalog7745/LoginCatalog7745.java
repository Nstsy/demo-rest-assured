package by.catalog7745;

import org.junit.jupiter.api.Test;
import ru.taplink.LoginRequestTaplink;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginCatalog7745 {
    @Test
    public void test1() {
        String body = "//prefix:375\n" +
                "login:(37) 529-23-09 01\n" +
                "password:23423\n" +
                "//remember:on\n" +
                "//target:\n" +
                "//looking_page:Nzc0NS5ieS9jYXRhbG9nL2J5dG92YXlhLXRleG5pa2E=";

        given()
                .body(body)
                .header("x-csrf-token", "26QpQQchlgFz8FpvMMpewZNxs3lxU0N6bSUB8YwB")
        .when()
                .post(LoginRequestCatalog7745.URL)
                .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo("false"))
                .body("errors.login[0]", equalTo("Извините, указанный номер телефона или пароль неверны. Попробуйте набрать снова."));
    }
}
