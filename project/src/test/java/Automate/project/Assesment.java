package Automate.project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assesment {
    public static void main(String[] args) throws InterruptedException {
    	
    	
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.amazon.in/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    	
    	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wrist watches");
    	driver.findElement(By.id("nav-search-submit-button")).click();
    	
    	WebElement leather=	driver.findElement(By.xpath("//span[text()='Leather']"));
		leather.click();
		
		WebElement Fast=driver.findElement(By.linkText("Fastrack"));
		Fast.click();
		
		WebElement Img=driver.findElement(By.linkText("Men Quartz Analog Black Dial Leather Strap Watch for Guys-NS38051SL02"));
		Img.click();
		Thread.sleep(1000);
		
		
		Set<String> s=driver.getWindowHandles();
		ArrayList ar=new ArrayList(s);
		
		
		driver.switchTo().window((String)ar.get(1));
			
		WebElement Add=driver.findElement(By.xpath("//span[@id=\"submit.add-to-cart\"]"));
		Add.click();
		
		
		driver.findElement(By.xpath("//span[@id=\"attachSiNoCoverage\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']")).click();
			
		
    }
}
