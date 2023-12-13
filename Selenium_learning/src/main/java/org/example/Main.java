package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    private static WebElement firstbutton;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Implicit wait set to 10 seconds.");

        driver.manage().window().maximize();
        System.out.println("Window maximized.");

        driver.get("https://hqa2.bigbasket.com/auth/login/?nc=close");
        System.out.println("Navigated to the login page.");

        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.id("otpEmail")).sendKeys("6949112233");
        System.out.println("Entered OTP email.");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        System.out.println("Clicked on submit button for OTP email.");

        driver.findElement(By.id("otp")).sendKeys("214263");
        System.out.println("Entered OTP.");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        System.out.println("Clicked on submit button for OTP.");
        WebElement firstButton;

        firstButton = driver.findElement(By.xpath("/html/body/div[1]/div[8]/carousel-product-widget[1]/section/div[2]/div/div[1]/div/div[1]/div/div/product-template-in-container/div[1]/div[4]/div[3]/div/div[5]/div[2]/button"));
            System.out.println("First button displayed.");
       // if (firstButton.isDisplayed()) {
         //   System.out.println("First button displayed.");
           // WebElement closePopup;
           // closePopup = driver.findElement(By.xpath("//div[@class='popup']/a[1]/i"));
           // closePopup.click();
           // System.out.println("Closed popup.");
            //driver.findElement(By.xpath("//div[@class='popup']/div[4]/button[2]")).click();
            //System.out.println("Clicked on the second button.");
       // } else {
           // System.out.println("First button not displayed.");

            driver.findElement(By.className("btn btn-add col-xs-9")).click();
            System.out.println("Item added to the cart successfully!");
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[9]/div/bigbasket-cart-template/div/div[2]/a/span[1]/i")).click();
            System.out.println("Clicked Basket icon");
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[9]/div/bigbasket-cart-template/div/div[2]/ul/li[2]/div[2]/div[2]/button")).click();
            System.out.println("View Basket icon");
            driver.findElement(By.xpath("/html/body/div[24]/div[2]/div/section/div[3]/div[2]/div/div[5]/div[1]/div[1]/button/p")).click();
            System.out.println("Clicked on 'Proceed to Checkout' button.");
            driver.findElement(By.cssSelector(".btn-lg")).click();
            System.out.println("Clicked on 'Proceed to Payment' button.");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[1]/div[1]/div[7]/div/div/div/div[1]/div/div[3]/div/div[1]/div[1]/article")));
            System.out.println("Clicked on 'Cash on Delivery' button.");
            // Continue with other actions based on your scenario
        }
    }

