import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WikiLogPass {
    WebDriver wd;


    @BeforeTest

    public void setUp(){

        wd = new ChromeDriver();

    }

    @Test
    public void testWikiLogPass(){
        wd.get("https://www.wikipedia.org/");

        wd.findElement(By.id("js-link-box-en")).click();
        wd.findElement(By.id("pt-login")).click();

        wd.findElement(By.id("wpName1")).click();
        wd.findElement(By.id("wpName1")).clear();
        wd.findElement(By.id("wpName1")).sendKeys("RubiReader");

        wd.findElement(By.id("wpPassword1")).click();
        wd.findElement(By.id("wpPassword1")).clear();
        wd.findElement(By.id("wpPassword1")).sendKeys("test11$$");

        wd.findElement(By.id("wpLoginAttempt")).click();


    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
