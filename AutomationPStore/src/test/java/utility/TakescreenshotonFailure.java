package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class TakescreenshotonFailure {
	
	
	public static void  takescrshotonFailure(WebDriver driver ,String testname)  {
		
		TakesScreenshot ts =( (TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest="./reports/screenshots/"+testname+".png";
		File  newpathFile = new File(dest);
		try {
			Files.copy(src, newpathFile);
		} catch (IOException e) {
			System.out.println("File not found "+ e.getMessage());
		}
		
		}		
		}	
