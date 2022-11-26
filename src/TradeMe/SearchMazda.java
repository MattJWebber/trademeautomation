package TradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchMazda {

    WebDriver driver=new ChromeDriver();

    @BeforeTest
    public void setUp() {
        // Launch Browser
        System.out.println("launching TradeMe website");
        driver.get("https://www.trademe.co.nz");
        driver.manage().window().maximize();
    }

    @Test
    public void searchMazda() {
        // Navigate to 'Motors' section of TradeMe
        driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-dynamic-homepage/tm-homepage-search-header/nav/div[2]/ul/li[3]/a")).click();
        // Wait 3 seconds. Allowing dynamic elements to load on page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Enter text for BMW in the 'Keyword' field
        driver.findElement(By.name("keyword")).sendKeys("Mazda"+ "\n");
        // Identity element needed to show cars results
        WebElement e = driver.findElement(By.xpath("//h3[@class='tm-search-header-result-count__heading ng-star-inserted']"));
        // Results showing number of cars
        System.out.println(e.getText());
    }

    @AfterTest
    public void closeBrowser() {
        // Close Browser
        driver.quit();
    }

}

