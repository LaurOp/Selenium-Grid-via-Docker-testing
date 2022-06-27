package LoginTestCases;

import BaseClasses.BaseForLogin;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageURLnoLoginTest extends BaseForLogin {

    @Test
    public void pageURLnoLogin(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }
        catch (Exception ignored){
        }

        try{
            String response =
                    RestAssured.given()
                            .get("https://ciw-main-api.azurewebsites.net/api/messenger/list?take=10&page=1&search=")
                            .then()
                            .statusCode(401)
                            .extract()
                            .asPrettyString();

            System.out.println(response);

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }
}
