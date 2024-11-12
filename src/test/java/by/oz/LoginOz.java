package by.oz;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.taplink.LoginRequestTaplink;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginOz {
    @Test
    @DisplayName("Invalid Data")
    public void test1() {
        given()
                .body("{\"phone\":\"375777777777\"}")
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestOz.URL)
                .then()
                .log().all()
                .statusCode(422)
                .body("code", equalTo(422))
                .body("error", equalTo("Введите корректный номер мобильного телефона"))
                .body("message", equalTo("Введите корректный номер мобильного телефона"))
                .body("error", equalTo("Введите корректный номер мобильного телефона"));
    }

    @Test
    @DisplayName("Without Data")
    public void test2() {
        given()
                .body("")
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestOz.URL)
                .then()
                .log().all()
                .statusCode(500)
                .body("error", equalTo("Произошла ошибка на сервисе авторизации."));
    }

    @Test
    @DisplayName("Correct Data")
    public void test3() {
        given()
                .body("{\"phone\":\"375297777777\"}")
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestOz.URL)
                .then()
                .log().all()
                .statusCode(201)
                .body("token", notNullValue());
    }
}
