/*import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    @FindBy(css = ".buy-small-btn__icon") WebElement icon;

    @Test
    public void Test() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\София\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito"
                ,"--disable-blink-features"
        //,"user-data-dir=./chromeprofile"
        ,"--disable-extensions"
        ,"--disable-plugins-discovery"
        ,"--start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        //options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        ChromeDriver driver = new ChromeDriver(options);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("source", "Object.defineProperty(navigator, 'webdriver', { get: () => undefined })");
        driver.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", params);
        ((JavascriptExecutor)driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        //WebDriver driver = new ChromeDriver();
        //driver.navigate().to("https://gmail.com/");
        //driver.findElement(By.id("identifierId")).sendKeys("zaytsevasg@gmail.com");
        //driver.findElement(By.name("password")).sendKeys("zaytsevasg@gmail.com");

        driver.navigate().to("https://comfy.ua/");
        //driver.switchTo().frame("mail widget");
        // Click on the search text box and send value
        //Thread.sleep(5000);
        //List<WebElement> elements = driver.findElements(By.cssSelector(".buy-small-btn__icon"));
        //WebElement icon = driver.findElement(By.cssSelector(".buy-small-btn__icon"));
        icon.click();
        //System.out.println(elements.size());
        //driver.findElement(By.id("id-input-login")).sendKeys("javatpoint tutorials");

        // Click on the search button
        //driver.findElement(By.name("btnK")).click();
    }

    @Test
    public void successfulGoogleSearch() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\София\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Facebook");

        //Thread.sleep(2000);                          // Put this sleep command.

        driver.findElement(By.name("btnK")).click();
        Assert.assertTrue("facebook - Google Search", true);
        driver.quit();
    }

    @Test
    public void successfulSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\София\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        final String searchQuery = "кактус";
        WebDriver webDriver = new ChromeDriver();
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

            Boolean t = webDriver.findElement(By.xpath(" //*[@class='items-list--header']")).isEnabled();

            if (t) {
                webDriver.findElement(By.xpath(" //*[@class='items-list--header']")).click();
            }
            Assert.assertTrue("Element with text кактус is displayed", webDriver.findElement(By.xpath("//*[contains(text(),'" + searchQuery + "')]"))
                    .isDisplayed());


        } finally {
            webDriver.quit();
        }
    }
    @Test
    public void successfulSearch1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\София\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        final String searchQuery = "кактус";
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            webDriver.get("https://prozorro.gov.ua/tender/search");
            WebElement webElement = webDriver
                    .findElement(By.cssSelector("#query"));

            webElement.sendKeys(searchQuery);


            new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    return webDriver.findElement(By.xpath("//a[@class='selected']//span")).getText().contains(searchQuery);
                }
            });

            webElement.sendKeys(Keys.ENTER);

            //new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(
            //        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='items-list--header']) [1]")));

            Thread.sleep(5000);
            webDriver.findElement(By.xpath("(//*[@class='items-list--header']) [1]")).click();

            Assert.assertTrue("Element with text кактус is displayed", webDriver.findElement(By.xpath("//*[contains(text(),'"+searchQuery+"') or contains(text(),'кактус')]"))
                                .isDisplayed());


        } finally {
            webDriver.quit();
        }
    }

}
*/