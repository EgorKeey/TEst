package api;

import io.restassured.http.ContentType;
import model.userModel.UserRequestModel;
import model.userModel.GetUserResponseModel;
import model.userModel.ResponseModel;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserApi {

    public ResponseModel postCreateListUser(List<UserRequestModel> userRequestModel) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .body(userRequestModel)
                .when()
                .log().all()
                .post("/user/createWithList")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(ResponseModel.class);
    }

    public ResponseModel postCreateUser(UserRequestModel userRequestModel) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .body(userRequestModel)
                .when()
                .log().all()
                .post("/user")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(ResponseModel.class);
    }

    public ResponseModel putChangeUser(String user,UserRequestModel userRequestModel) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .body(userRequestModel)
                .when()
                .log().all()
                .put("/user/" + user)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(ResponseModel.class);
    }



    public GetUserResponseModel getUserByUserName(String userName) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/user/" + userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GetUserResponseModel.class);
    }

    public ResponseModel getLogin(String username, String password) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/user/login" + "?username" + "=" + username + "&password" + "=" + password)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(ResponseModel.class);
    }



    public ResponseModel getLogout() {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/user/logout")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(ResponseModel.class);
    }

    public ResponseModel deleteUser(String user) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .delete("/user/" + user)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(ResponseModel.class);
    }

}
