import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    private final WebDriver driver=new ChromeDriver();


    @BeforeClass
    public void setUp(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void checkTitle(){
       String actualTitleName = driver.getTitle();
       String expectedTitle="OrangeHRM";

       if(actualTitleName.equals(expectedTitle)){
           System.out.println("Test Passed");
       }else{
           System.out.println("Test Failed");
       }

    }

    @Test(priority = 2)
    public void testLogging(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement inputUserName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        inputUserName.sendKeys("Admin");

        WebElement inputPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        inputPassword.sendKeys("admin123");

        WebElement loginButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
        loginButton.click();

        //Assertions
        WebElement adminWindow=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));

        if (adminWindow.isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Failed");
        }
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
