import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/ASUS/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> url = driver.getWindowHandles();
		Iterator<String> window = url.iterator();
		String parent = window.next();
		String child = window.next();
		driver.switchTo().window(child);
		driver.get("https://www.rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		System.out.println(courseName);
		driver.switchTo().window(parent);

		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));
		nameEditBox.sendKeys(courseName);
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		File file = nameEditBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

		//dimensions
		System.out.println(nameEditBox.getRect().getDimension().getHeight());
		System.out.println(nameEditBox.getRect().getDimension().getWidth());

	}
}
