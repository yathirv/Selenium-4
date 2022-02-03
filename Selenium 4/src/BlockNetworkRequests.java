import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg" , "*.css")));
		
		long startTime = System.currentTimeMillis();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
	}

}
