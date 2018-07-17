package andreev.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\loki\\IdeaProjects\\andreev.test\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru");
    }

    @Test
    public void firstTest() {

        WebElement searchField = driver.findElement(By.id("text"));
        searchField.sendKeys("Погода Пенза");
        WebElement searchButton = driver.findElement(By.cssSelector(".search2__button button"));
        searchButton.click();
        WebElement firstString = driver.findElement(By.cssSelector("a[accesskey='1']"));
        String weather = firstString.getText();
        Assert.assertEquals("Погода в Пензе", weather);
    }

    @AfterClass
    public static void end() {
        driver.quit();
    }
}
