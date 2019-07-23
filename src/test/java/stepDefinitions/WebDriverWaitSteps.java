package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.base.Function;

public class WebDriverWaitSteps {
	
	private void customWait()
	{
		Function<WebDriver, Boolean> wait=new Function<WebDriver,Boolean>()
				{
                      //it will contain wait logic
					public Boolean apply(WebDriver t) {
						if(t.findElements(By.xpath("//input[@value='Log In']")).size()>=1) {
							System.err.println("Webelement located");
						return true;
						}
						System.out.println("Waiting...");
					return false;
					}
			          
				};
	}

}
