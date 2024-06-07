package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginsteps {
    WebDriver driver;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Inside Step- browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is: "+projectPath);
        System.setProperty("web driver.chrome.driver",projectPath+"/C:/Users/ksb209/IdeaProjects/CucumberLoginPage/driver/chromedriver 1.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);

        // Set timeouts using the Timeouts interface
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


    }

    @And("^user is on login page$")
    public void user_is_on_login_page() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);

    }

    @When("user enters Username and Password")
    public void user_enters_username_and_password() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        Thread.sleep(2000);


    }


    @And("user clicks on login button")
    public void userClicksOnLogin() throws InterruptedException {
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);

    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() throws InterruptedException {
        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("//a[@href='https://practicetestautomation.com/practice-test-login/']")).click();

        // Navigate back to the previous page
        //driver.navigate().back();

    }

}