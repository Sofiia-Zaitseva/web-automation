package test.java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProzoroTest {

    WebDriver webDriver;

    @BeforeTest
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\София\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test(groups = { "include-test-one" })
    public void successfulSearch() throws InterruptedException {
        final String searchQuery = "кактус";

        try {
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://prozorro.gov.ua/tender/search");
            WebElement webElement =
                    webDriver
                            .findElement(By.id("query"));

            webElement.sendKeys(searchQuery);

            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    return webDriver.findElement(By.xpath("//a[@class='selected']//span")).getText().contains(searchQuery);
                }
            });

            webElement.sendKeys(Keys.ENTER);

            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='items-list--header']")));

            Thread.sleep(10000);
            webDriver.findElement(By.xpath(" //*[@class='items-list--header']")).click();

            Assert.assertTrue(webDriver.findElement(By.xpath("//*[contains(text(),'" + searchQuery + "')]"))
                                .isDisplayed(), "Element with text кактус is displayed");


        } finally {
            webDriver.quit();
        }
    }

    @Test (groups = "test-one")
    public void DeveloperApple() {
        webDriver.navigate().to("https://developer.apple.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.findElement(By.xpath("//a[@class = 'ac-gn-link ac-gn-link-discover']")).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class = 'typography-hero-headline']")));

        //String text = webDriver.findElement(By.xpath("//h1")).getText();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        String str = js.executeScript("return arguments[0].childNodes[1].textContent", webDriver.findElement(By.xpath("//h1"))).toString();
        System.out.println(str);
        Assert.assertTrue(str.equals("Infinite Possibilities"), str);
    }

}
