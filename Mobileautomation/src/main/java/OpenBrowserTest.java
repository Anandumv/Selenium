import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OpenBrowserTest {
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver;
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set device capabilities
        caps.setCapability("deviceName", "Testdevice");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2"); // Specify the automation name
        caps.setCapability("browserName", "Chrome"); // Change to "Browser" for older devices

        // Appium server URL
        String appiumURL = "http://192.168.106.180:4723/wd/hub";

        try {
            // Initialize the driver
            driver = new AndroidDriver<>(new URL(appiumURL), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Navigate to a websiteet.com
            driver.get("https://www.bigbasket.com");

            // Perform your test actions here

            // Close the session
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
