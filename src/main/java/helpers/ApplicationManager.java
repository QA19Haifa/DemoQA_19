package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public interface ApplicationManager {

    WebDriver wd = new ChromeDriver();

    default void init(){
        wd.navigate().to("https://demoqa.com/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



}
