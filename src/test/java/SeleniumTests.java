import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SeleniumTests {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test(){
        System.out.println("test1");
        System.setProperty("webdriver.driver.chrome", "C:/Drivers/chromedriver.exe");
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        System.out.println(driver.getTitle());

        driver.findElement(By.id("sum1")).sendKeys("10");
        driver.findElement(By.id("sum2")).sendKeys("20");
        driver.findElement(By.xpath("//button[text()='Get Sum']")).click();

        String actual =  driver.findElement(By.id("addmessage")).getText();
        System.out.println(actual);

        Assert.assertEquals(actual,"20");
    }

    @Test
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
        driver.quit();
    }
}