package tests.userTests;

import model.userModel.UserRequestModel;
import model.userModel.GetUserResponseModel;
import model.userModel.ResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class GetUserTest extends BaseTest {

    @Test(priority = 1)
    public void postCreateListUser() {
        UserRequestModel userRequestModel = new UserRequestModel(
                595959595995595L,"UserTest992","string","string","string","UserTest992","string",0);
        List<UserRequestModel> usersList = new ArrayList<>();
        usersList.add(userRequestModel);
        ResponseModel model = USER_API.postCreateListUser(usersList);
        Assert.assertEquals(model.getCode(), "200");
    }

    @Test(priority = 2)
    public void getUserByUser() {
        GetUserResponseModel model = USER_API.getUserByUserName("UserTest992");
        Assert.assertEquals(model.getUsername(), "UserTest992");
    }


    @Test(priority = 3)
    public void putChangeUser() {
        UserRequestModel userRequestModel = new UserRequestModel(
                595959595995595L,"UserTest992","string","string","string","UserTest992","string",0);
        ResponseModel model = USER_API.putChangeUser("UserTest992",userRequestModel);
        Assert.assertEquals(model.getCode(), "200");
    }

    @Test(priority = 4)
    public void postCreateUser() {
        UserRequestModel userRequestModel = new UserRequestModel(
                5959595959955952L,"UserTest992","string","string",
                "string","UserTest992","string",0);
        ResponseModel model = USER_API.postCreateUser(userRequestModel);
        Assert.assertEquals(model.getCode(), "200");
    }

    @Test(priority = 7)
    public void deleteUser() {
        ResponseModel model = USER_API.deleteUser("UserTest992");
        Assert.assertEquals(model.getCode(), "200");
    }

    @Test(priority = 5)
    public void getLogin() {
        ResponseModel model = USER_API.getLogin("string","string");
        Assert.assertEquals(model.getCode(), "200");
    }


    @Test(priority = 6)
    public void getLogout() {
        ResponseModel model = USER_API.getLogout();
        Assert.assertEquals(model.getCode(), "200");
    }


}
