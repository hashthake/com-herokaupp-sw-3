package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityTest;

public class LoginTest extends UtilityTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        verifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"), "Secure Area");
    }

    @Test
    public void verifyTheUsernameEroorMessage() {
        sendTextToElement(By.id("username"), "tomsmith1");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        verifyText(By.xpath("//div[@id='flash']"), "Your username is invalid!");
    }

    @Test
    public void verifyThePasswordErrorMessage()
    {
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        verifyText(By.xpath("//div[@id='flash']"), "Your password is invalid!");
    }
    @Test
    public void tearDown(){
        closeBrowser();
    }
}