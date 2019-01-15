package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper 
{
	//method to take screenshot when the test case fail
	public static void captureScreenShotOnFailure(WebDriver driver, String screenShotName)
	{
		Path destenation= Paths.get("./screenShots", screenShotName+".png" );
		try {
			Files.createDirectories(destenation.getParent());
			FileOutputStream out= new FileOutputStream(destenation.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
	}
}
