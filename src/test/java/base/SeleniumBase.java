package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class SeleniumBase {
    public static WebDriver driver;
    private String baseUrl = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
