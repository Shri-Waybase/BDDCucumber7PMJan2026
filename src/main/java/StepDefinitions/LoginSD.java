package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginSD {

    public static WebDriver driver;

    @Given("The user is on the Login page")
    public void the_user_is_on_the_login_page()
    {
        /*driver = new ChromeDriver();
        driver.manage().window().maximize();*/
        driver.get("https://stock.scriptinglogic.in/");
    }

    @When("The user enters valid username and password")
    public void the_user_enters_valid_username_and_password()
    {
        driver.findElement(By.id("login-username")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("admin");

    }

    //@When() // @And() --> This and become when, either can be used.
    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button()
    {
        driver.findElement(By.name("submit")).click();
    }


    @Then("The user can see the dashboard")
    public void the_user_can_see_the_dashboard()
    {
       String expectedResult = "POSNIC - Dashboard";
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.titleIs(expectedResult));

       String actualResult = driver.getTitle();
       Assert.assertEquals("User not logged in.",expectedResult, actualResult);

    }

    @When("The user enters invalid username and password")
    public void theUserEntersInvalidUsernameAndPassword()
    {
        driver.findElement(By.id("login-username")).sendKeys("admin1");
        driver.findElement(By.id("login-password")).sendKeys("admin2");

    }

    @Then("The user can see error message")
    public void theUserCanSeeErrorMessage()
    {
        String expected = "Wrong Username or Password";
        String actual = driver.findElement(By.xpath("//*[text()='Wrong Username or Password']")).getText();

        Assert.assertEquals("User logged in.",expected,actual);
    }

    @When("The user enters blank username and password")
    public void theUserEntersBlankUsernameAndPassword()
    {

        driver.findElement(By.id("login-username")).sendKeys("");
        driver.findElement(By.id("login-password")).sendKeys("");

    }

    @Then("The user can see two error messages")
    public void theUserCanSeeTwoErrorMessages()
    {
        ArrayList<String> expectedError = new ArrayList<>();

        expectedError.add("Please enter a username".toUpperCase());
        expectedError.add("Please provide a password".toUpperCase());

        String actualUser = driver.findElement(By.xpath("//label[text()='Please enter a username']")).getText();
        String actualPass= driver.findElement(By.xpath("//label[text()='Please provide a password']")).getText();

        ArrayList<String> actualError = new ArrayList<>();
        actualError.add(actualUser);
        actualError.add(actualPass);
        Assert.assertEquals("User logged in",expectedError,actualError);
    }

    @When("The user enters valid {string} as username and {string} as password")
    public void theUserEntersValidAsUsernameAndAsPassword(String userName, String passWord)
    {
        driver.findElement(By.id("login-username")).sendKeys(userName);
        driver.findElement(By.id("login-password")).sendKeys(passWord);
    }

    @When("The user enters invalid {string} as  username and {string} as password")
    public void theUserEntersInvalidAsUsernameAndAsPassword(String invUserName, String invPassword)
    {
        driver.findElement(By.id("login-username")).sendKeys(invUserName);
        driver.findElement(By.id("login-password")).sendKeys(invPassword);
    }

    @When("The user enters blank {string} as username and {string} as password")
    public void theUserEntersBlankAsUsernameAndAsPassword(String blankUserName, String blankPassword)
    {
        driver.findElement(By.id("login-username")).sendKeys(blankUserName);
        driver.findElement(By.id("login-password")).sendKeys(blankPassword);
    }


    /*Data table example*/

    @Given("I am on the Login page")
    public void iAmOnTheLoginPage() {
        /*driver = new ChromeDriver();
        driver.manage().window().maximize();*/
        driver.get("https://stock.scriptinglogic.in/");

    }

    @When("I enter user credentials")
    public void iEnterUserCredentials(DataTable dataTable) {

        List<List<String>>  myList =dataTable.asLists();

        String username = myList.get(1).get(0);
        String password = myList.get(1).get(1);

        driver.findElement(By.id("login-username")).sendKeys(username);
        driver.findElement(By.id("login-password")).sendKeys(password);

    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.name("submit")).click();
    }

    @Then("I can see dashboard")
    public void iCanSeeDashboard() {
        String expectedResult = "POSNIC - Dashboard";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedResult));

        String actualResult = driver.getTitle();
        Assert.assertEquals("User not logged in.",expectedResult, actualResult);
    }

    @When("The user enters  {string} and {string}")
    public void theUserEntersAnd(String userName  , String passWord)
    {

        driver.findElement(By.id("login-username")).sendKeys(userName);
        driver.findElement(By.id("login-password")).sendKeys(passWord);

    }

    @Given("User launch the browser")
    public void userLaunchTheBrowser()
    {
        driver =  new ChromeDriver();
    }

    @And("User maximize the browser")
    public void userMaximizeTheBrowser()
    {
        driver.manage().window().maximize();
    }


    /*Forgot password scenario*//*

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
    }*/

   /* *//*Add Customer scenarios*//*

    @And("The user click on the Add Customer link")
    public void theUserClickOnTheAddCustomerLink()
    {
        driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
    }

    String name = "Kantra Pant";
    @And("The user enters Name,Address,ContactOne,ContactTwo")
    public void theUserEntersNameAddressContactOneContactTwo()
    {
       driver.findElement(By.id("name")).sendKeys(name);
       driver.findElement(By.name("address")).sendKeys("123 Main St");
       driver.findElement(By.id("buyingrate")).sendKeys("1237634");
       driver.findElement(By.id("sellingrate")).sendKeys("12354343");

    }

    @And("The user click on add button")
    public void theUserClickOnAddButton()
    {
        driver.findElement(By.xpath("//input[@name='Submit']")).click();
    }

    @Then("The user is added successfully")
    public void theUserIsAddedSuccessfully()
    {
        String expected = "[ " + name + " ] Customer Details Added !";

        String actual = driver
                .findElement(By.xpath("//*[text()='[ " + name + " ] Customer Details Added !']"))
                .getText();
    }

    *//*Duplicate Customer Scenarios*//*
    @Then("The user can see duplicate customer entry")
    public void theUserCanSeeDuplicateCustomerEntry()
    {

        String expectedDuplicate ="Dublicat Entry. Please Verify";
        String actualDuplicate = driver.findElement(By.xpath("//div[text()='Dublicat Entry. Please Verify']")).getText();
        Assert.assertEquals("User Added",expectedDuplicate,actualDuplicate);
    }*/
}
