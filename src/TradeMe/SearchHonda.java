package TradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchHonda {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\seleniumjarsdrivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        // Launch Browser
        driver.get("https://www.trademe.co.nz");
        driver.manage().window().maximize();

        // Navigate to 'Motors' section of TradeMe
        driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-dynamic-homepage/tm-homepage-search-header/nav/div[2]/ul/li[3]/a")).click();

        // Wait 3 seconds. Allowing dynamic elements to load on page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Enter text for BMW in the 'Keyword' field
        driver.findElement(By.name("keyword")).sendKeys("Honda"+ "\n");

        // Identity element needed to show cars results
        WebElement e = driver.findElement(By.xpath("//h3[@class='tm-search-header-result-count__heading ng-star-inserted']"));

        // Results showing number of cars
        System.out.println(e.getText());

        // Close Browser
        driver.quit();
    }
}
