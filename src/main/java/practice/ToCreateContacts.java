package practice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToCreateContacts {

	public static void main(String[] args) {
		// To Launch Browser
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("http://localhost:8888/");
		
		//To Login the application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//To Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//To store data in mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Sathiyamoorthy");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//To Validate the expected data with actual data
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains("Sathiyamoorthy")) {
			System.out.println(name+"--name is passed");
		}
		else
			System.out.println(name+"name is failed");
		
		//To logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action= new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//To close
		driver.quit();
		

	}

}
