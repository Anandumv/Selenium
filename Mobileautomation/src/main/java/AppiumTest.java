import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Testdevice"); // Replace with your emulator device name
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);

        // Replace the URL with your Appium server address
        URL url = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, caps);

        // Add your test actions here
        // Example: Click on a button
        // driver.findElementById("button_id").click();

        // Close the session
        driver.quit();
    }
}

