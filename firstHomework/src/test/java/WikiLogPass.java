import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WikiLogPass {
    WebDriver wd;


    @BeforeTest

    public void setUp(){

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();

    }

    @Test
    public void testWikiLogPass(){
        openSite("https://www.wikipedia.org/");
        chooseLanguage();
        clickOnLoginButton();
        fillLoginForm();
        confirmLogin();
    }

    public void confirmLogin() {
        wd.findElement(By.id("wpLoginAttempt")).click();
    }

    public void fillLoginForm() {
        wd.findElement(By.id("wpName1")).click();
        wd.findElement(By.id("wpName1")).clear();
        wd.findElement(By.id("wpName1")).sendKeys("RubiReader");

        wd.findElement(By.id("wpPassword1")).click();
        wd.findElement(By.id("wpPassword1")).clear();
        wd.findElement(By.id("wpPassword1")).sendKeys("test11$$");
    }

    public void clickOnLoginButton() {
        wd.findElement(By.id("pt-login")).click();
    }

    public void chooseLanguage() {
        wd.findElement(By.id("js-link-box-en")).click();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
