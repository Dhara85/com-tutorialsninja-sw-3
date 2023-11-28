package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome"; // declared globally

    public static WebDriver driver; // scope of driver is within the method so declared public and not in public void openbrowser method

    public void openBrowser(String baseUrl) {  // send the code in baseUrl so it opens browser and open Url
        if (browser.equalsIgnoreCase("Chrome")) {  // If else from Java
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public void closeBrowser() {
        driver.quit();
    }
}
