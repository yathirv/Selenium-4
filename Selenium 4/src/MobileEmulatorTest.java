import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
//		devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		

		Map<String,Object> deviceMatrics = new HashMap<String,Object>();
		deviceMatrics.put("width", 600);
		deviceMatrics.put("height", 1000);
		deviceMatrics.put("deviceScaleFactor",60);
		deviceMatrics.put("mobile", true);
		
		driver.executeCdpCommand( "Emulation.setDeviceMetricsOverride" ,deviceMatrics);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Library")).click();
	}

}
