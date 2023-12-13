import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class chrome {

    public static void main(String[] args) {
// TODO Auto-generated method stub

//setting the driver executable
            System.setProperty("webdriver.chrome.driver", "/home/anandumv/IdeaProjects/Chromee/chrome-linux64");

//Initiating your chromedriver
            WebDriver driver=new ChromeDriver();

//Applied wait time
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//maximize window
            driver.manage().window().maximize();

//open browser with desried URL
            driver.get("https://www.google.com");

//closing the browser
            driver.close();

        }

    }


