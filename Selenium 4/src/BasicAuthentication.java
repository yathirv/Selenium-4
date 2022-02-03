import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;
public class BasicAuthentication {

	public static void main(String[] args)
	
	{
		
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Predicate<URI> UriPredicate = uri -> uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(UriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
	}

}
