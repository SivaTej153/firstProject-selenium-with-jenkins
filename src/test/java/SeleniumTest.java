import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.driver.chrome", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void test(){
        System.out.println("test1");
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        System.out.println(driver.getTitle());

        driver.findElement(By.id("sum1")).sendKeys("20");
        driver.findElement(By.id("sum2")).sendKeys("20");
        driver.findElement(By.xpath("//button[text()='Get Sum']")).click();

        String actual =  driver.findElement(By.id("addmessage")).getText();
        System.out.println(actual);

        Assert.assertEquals(actual,"40");
    }

    @Test(priority = 2)
    public void compareDefaultTextInTextbox(){
        System.out.println("test2");
        System.setProperty("webdriver.driver.chrome", "C:/Drivers/chromedriver.exe");
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        System.out.println(driver.getTitle());

        String actual = driver.findElement(By.id("sum1")).getAttribute("placeholder");

        Assert.assertEquals(actual, "Please enter first value");
    }

    @AfterTest
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
