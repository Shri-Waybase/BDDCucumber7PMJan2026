package StepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static StepDefinitions.LoginSD.driver;

public class AddCustomerSD {


    /*Add Customer scenarios*/

    @And("The user click on the Add Customer link")
    public void theUserClickOnTheAddCustomerLink()
    {
        driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
    }

    String name = "Tailor";
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
        Assert.assertEquals(expected, actual);
    }

    /*Duplicate Customer Scenarios*/
    @Then("The user can see duplicate customer entry")
    public void theUserCanSeeDuplicateCustomerEntry()
    {

        String expectedDuplicate ="Dublicat Entry. Please Verify";
        String actualDuplicate = driver.findElement(By.xpath("//div[text()='Dublicat Entry. Please Verify']")).getText();
        Assert.assertEquals("User Added",expectedDuplicate,actualDuplicate);
    }

    @When("The user enters valid {string} and {string}")
    public void theUserEntersValidAnd(String username, String password) {
        driver.findElement(By.id("login-username")).sendKeys(username);
        driver.findElement(By.id("login-password")).sendKeys(password);
    }
}
