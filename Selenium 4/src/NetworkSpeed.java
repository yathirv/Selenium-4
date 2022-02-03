import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.CELLULAR2G)));
		
		
		devtools.addListener(Network.loadingFailed(), loadingfailed ->
		{
		
			System.out.println(loadingfailed.getErrorText());
			System.out.println(loadingfailed.getTimestamp());
			
		});
		
		long startTime = System.currentTimeMillis();
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		
		long EndTime = System.currentTimeMillis();
		System.out.println(EndTime - startTime);
		
		
	}

}
