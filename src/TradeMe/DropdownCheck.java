package TradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownCheck {
        WebDriver driver = new ChromeDriver();

        @BeforeTest
        public void setUp() {
            // Launch Browser
            System.out.println("launching TradeMe website");
            driver.get("https://www.trademe.co.nz");
            driver.manage().window().maximize();
        }

        @Test
        public void dropdownCheck() {
            // Navigate to 'Motors' section of TradeMe
            driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-dynamic-homepage/tm-homepage-search-header/nav/div[2]/ul/li[3]/a")).click();
            // Wait 3 seconds. Allowing dynamic elements to load on page
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            // List number of car makes in 'Make' dropdown menu
            Select carmake = new Select(driver.findElement(By.xpath("//select[@name='selectedMake']")));
            List<WebElement> options = carmake.getOptions();
            System.out.println(("The number of Car Makes available are " + options.size()));
            // List names of the car models in the 'Make' dropdown menu
            for (WebElement e : options) {
                System.out.println(e.getText());
            }
        }
        @AfterTest
        public void closeBrowser() {
        // Close Browser
        driver.quit();
    }
}
