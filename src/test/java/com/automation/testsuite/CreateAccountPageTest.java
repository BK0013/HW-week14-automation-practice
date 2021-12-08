package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signINPage;
    CreateAccountPage createAccountPage;
    SoftAssert softAssert;
    String timeStamp ;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inTt() {
        homePage = new HomePage();
        signINPage = new SignInPage ();
        softAssert = new SoftAssert ();
        createAccountPage = new CreateAccountPage ();
        timeStamp = new SimpleDateFormat ("yyyy.MM.dd.HH.mm.ss").format(new Date ());
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully()
    {
        homePage.setClickOnSignInLink();
        signINPage.setClickOnCreateAnAccount("abc"+timeStamp+"@gmail.com");
        createAccountPage.fillPersonalInformationForm("BK","Patel","abc1234");
        createAccountPage.fillYourAddressDetails("1 The Chine","Wembley","London","HA0 3EH","UK","0123456789","main home");
        String expectedTest= "My account";
        String actualTest= createAccountPage.verifyMyAccountText();
        softAssert.assertEquals(expectedTest,actualTest);
        softAssert.assertAll();
    }


}