package StepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static StepDefinitions.LoginSD.driver;

public class ForgotPasswordSD {

    /*Forgot password scenario*/

    @When("The user clicks on the forgot password link")
    public void theUserClicksOnTheForgotPasswordLink()
    {
        driver.findElement(By.xpath("//*[text()='Forgot your password?']")).click();
    }

    @And("The user enter the movie name")
    public void theUserEnterTheMovieName()
    {
        String movieName="Border";
        driver.findElement(By.id("name")).sendKeys(movieName);
    }

    @And("The user click on the submit button")
    public void theUserClickOnTheSubmitButton()
    {
        driver.findElement(By.name("submit")).click();
    }

    @Then("The use can see the message")
    public void theUseCanSeeTheMessage()
    {
        driver.findElement(By.xpath("//p[normalize-space()='Answer Is Wrong']")).getText();
    }

    @Given("launch the browser")
    public void LaunchTheBrowser()
    {
        driver =  new ChromeDriver();
    }

    @And("maximize the browser")
    public void MaximizeTheBrowser()
    {
        driver.manage().window().maximize();
    }


}
