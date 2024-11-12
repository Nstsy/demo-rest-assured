package by.nmshop;

import org.junit.jupiter.api.Test;
import ru.taplink.LoginRequestTaplink;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginNmShop {
    @Test
    public void test1() {
        given()
                .body("email=nstsy%40yandex.ru&password=111111")
                .when()
                .post(LoginRequestNmShop.URL)
                .then()
                .log().all()
                .statusCode(200)
                .body(equalTo("{\"error\":\"\\u041d\\u0435\\u043f\\u0440\\u0430\\u0432\\u0438\\u043b\\u044c\\u043d\\u044b\\u0439 \\u043b\\u043e\\u0433\\u0438\\u043d \\u0438\\u043b\\u0438 \\u043f\\u0430\\u0440\\u043e\\u043b\\u044c.\"}"));
    }
}
