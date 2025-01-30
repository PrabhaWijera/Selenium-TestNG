import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RegisterForm {

    private WebDriver driver;




    @BeforeClass
    public void setup(){
        driver= new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();

    }


    @Test(priority = 1)
    public void checkTitle(){

        System.out.println("The title is: " + driver.getTitle());
        String actualTitle= driver.getTitle();
        String expectedTitle="Tutorialspoint";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("The title is correct");
        }else{
            System.out.println("The title is incorrect");
        }
    }

    @Test(priority = 2)
    public void fillFormWithPositiveData(){

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));


        WebElement FirstName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        FirstName.sendKeys("Sumanapala");


        WebElement Email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.sendKeys("sumanapala@gmail.com");

        //check all
        List<WebElement> genders = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//input[@id='gender' and contains(@class, 'form-check-input')]")
        ));

        for (WebElement genderClick : genders) {
            genderClick.click();
        }



        // select 1
        WebElement maleG=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='gender'])[1]")));
        maleG.click();

        WebElement phoneNumber=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mobile']")));
        phoneNumber.sendKeys("0342235588");


        WebElement dtaeofB=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dob']")));
        dtaeofB.sendKeys("01/30/2025");


        WebElement subject=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subjects']")));
        subject.sendKeys("Maths,English");


        List<WebElement>hobbies=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='hobbies']")));
        for(WebElement hobbiess:hobbies){
            hobbiess.click();
        }

        WebElement hobiie=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='hobbies'])[1]")));
        hobiie.click();



        WebElement fileChoose=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='picture']")));
        fileChoose.sendKeys("E:\\Practice-Selenium&Cypress\\Selenium\\src\\assets\\my-notion-face-transparent.png");


        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='picture']")));
        address.sendKeys("Selenium - Automation Practice Form");

//
//        WebElement stateDrop=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='state']")));
//        stateDrop.click();
//
//        WebElement city=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='city']")));
//        city.click();


        Select stateDrop= new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='state']"))));
        stateDrop.selectByVisibleText("NCR");


        Select cityDrop= new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='city']"))));
        cityDrop.selectByVisibleText("Agra");


        WebElement loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Login']")));
        loginBtn.click();
    }



//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }







}
