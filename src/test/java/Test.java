import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;;
import java.util.concurrent.TimeUnit;

public class Test {

    @org.testng.annotations.Test
    public void navigateToSite () {

        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.autohero.com/de/search/");

        driver.findElement(By.cssSelector("div.root___1ZGR8:nth-child(3) > div:nth-child(1) > span:nth-child(1)")).click();

        Select dropdownYear = new Select(driver.findElement(By.cssSelector("div.root___1ZGR8:nth-child(3) > div:nth-child(2) > div:nth-child(1) > select:nth-child(4)")));
        dropdownYear.selectByVisibleText("2015");
        int year = Integer.parseInt(driver.findElement(By.xpath("/html/body/div[1]/div/main/div[4]/div/div[1]/div/div/div/div[3]/div[2]/div/div[1]")).getText());

        Select dropdownPrice = new Select(driver.findElement(By.cssSelector("div.form-control:nth-child(3) > select:nth-child(4)")));
        dropdownPrice.selectByVisibleText("Höchster Preis");
        WebElement price = driver.findElement(By.cssSelector("div.form-control:nth-child(3) > div:nth-child(2)"));

        Assert.assertEquals(year, 2015);
        Assert.assertEquals(price.getText(), "Höchster Preis");

        driver.quit();
    }
}