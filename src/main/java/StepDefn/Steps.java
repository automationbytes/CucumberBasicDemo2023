package StepDefn;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Steps {

    //Hooks - Annotations
    @Before()
    public void initBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After(order = 0)
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
//
//    @After(order = 1)
//    public void takeScreenshot(Scenario scenario){
//        if(scenario.isFailed()){
//          byte[] source =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(source,"image/png",scenario.getName());
//        }
//    }



    @AfterStep(order = 1)
    public void takeScreenshot(Scenario scenario){
        //if(scenario.isFailed()){
            byte[] source =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source,"image/png",scenario.getName());
        //}
    }


    public WebDriver driver;
    @Given("the user launches the facebook url")
    public void the_user_launches_the_facebook_url() {
       driver.get("https://www.facebook.com/");

    }
    @Then("the user verifies the facebook home page")
    public void the_user_verifies_the_facebook_home_page() {
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=\"Facebook\"]")).isDisplayed());
    }
    @When("the user enters {string} in username editbox")
    public void the_user_enters_in_username_editbox(String username) {
        // Write code here that turns the phrase above into concrete actions
       driver.findElement(By.id("email")).sendKeys(username);
    }
    @When("the user enters {string} in password editbox")
    public void the_user_enters_in_password_editbox(String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("pass")).sendKeys(password);
    }
    @Then("the user clicks on Login button")
    public void the_user_clicks_on_login_button() {
       driver.findElement(By.name("logi")).click();
    }
}
