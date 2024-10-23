package com.escrowstack;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assesment {

    public static WebDriver driver;

    String browserName = "chrome";

    @BeforeClass
    public void InitilizeBrowser() {

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wrist watches");
        driver.findElement(By.id("nav-search-submit-button")).click();

        WebElement leather = driver.findElement(By.xpath("//span[text()='Leather']"));
        leather.click();

        WebElement Fast = driver.findElement(By.linkText("Fastrack"));
        Fast.click();

        WebElement Img = driver
                .findElement(By.linkText("Men Quartz Analog Black Dial Leather Strap Watch for Guys-NS38051SL02"));
        Img.click();
        Thread.sleep(1000);

        Set<String> s = driver.getWindowHandles();
        ArrayList ar = new ArrayList(s);

        driver.switchTo().window((String) ar.get(1));

        WebElement Add = driver.findElement(By.xpath("//span[@id=\"submit.add-to-cart\"]"));
        Add.click();

        driver.findElement(By.xpath("//span[@id=\"attachSiNoCoverage\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']")).click();

    }

    @AfterClass
    public void teardown() {
        driver.quit();

    }

}
