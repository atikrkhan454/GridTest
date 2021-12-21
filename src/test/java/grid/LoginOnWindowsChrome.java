package grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginOnWindowsChrome {


    WebDriver driver;

    @BeforeTest
    void openWeb() throws MalformedURLException {
       
        String nodeURL="http://192.168.43.47:4444";
        DesiredCapabilities cap= new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL),cap);
        driver.get("http://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    void login(){

        driver.findElement(By.id("username")).sendKeys("atikrkhan454@outlook.com");
        driver.findElement(By.id("password")).sendKeys("Login@atik@123456789");
        driver.findElement(By.name("login")).click();

        String findtext=driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]")).getText();

        if (findtext.contains("atikrkhan454")){

            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }

        driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]/a")).click();

        driver.quit();
    }
}
