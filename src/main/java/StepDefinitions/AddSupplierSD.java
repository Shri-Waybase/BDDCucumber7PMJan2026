package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static StepDefinitions.LoginSD.driver;

public class AddSupplierSD {


    String supplierName;

    @When("The user enters valid credentials")
    public void theUserEntersValidCredentials(DataTable dataTable) throws Throwable {

        List<List<String>> credentials = dataTable.asLists();
        String username = credentials.get(1).get(0);
        String password = credentials.get(1).get(1);

       driver.findElement(By.id("login-username")).sendKeys(username);
       driver.findElement(By.id("login-password")).sendKeys(password);

    }


    @And("The user click on the add supplier link")
    public void theUserClickOnTheAddSupplierLink() {
        driver.findElement(By.linkText("Add Supplier")).click();
    }


    @And("The user enters the supplier details")
    public void theUserEntersTheSupplierDetails(DataTable dataTable) throws Throwable {
        List<List<String>> supplierDetails = dataTable.asLists();
        supplierName = supplierDetails.get(1).get(0);
        String supplierAddress = supplierDetails.get(1).get(1);
        String supplierContact1 = supplierDetails.get(1).get(2);
        String supplierContact2 = supplierDetails.get(1).get(3);

        /*List<Map<String,String>>  supplierDetails = dataTable.asMaps(String.class, String.class);
        supplierName = supplierDetails.get(1).get(0);
        String supplierAddress  = supplierDetails.get(0).get(1);
        String supplierContact1 = supplierDetails.get(0).get(2);
        String supplierContact2 = supplierDetails.get(0).get(3);*/

        driver.findElement(By.id("name")).sendKeys(supplierName);
        driver.findElement(By.name("address")).sendKeys(supplierAddress);
        driver.findElement(By.id("buyingrate")).sendKeys(supplierContact2);
        driver.findElement(By.id("sellingrate")).sendKeys(supplierContact2);


    }

    @And("The user click on add supplier button")
    public void theUserClickOnAddSupplierButton() {

        driver.findElement(By.name("Submit")).click();

    }

    @Then("The supplier is added successfully")
    public void theSupplierIsAddedSuccessfully() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedSupplier = "[ " + supplierName+ " ] Supplier Details Added !";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualSupplier = driver
                .findElement(By.xpath("//font[normalize-space()='[ "+supplierName+" ] Supplier Details Added !']"))
                .getText();

        Assert.assertEquals("Supplier not added.",expectedSupplier, actualSupplier);

    }

    String name ="";

    @And("The user enters the {string},{string},{string},{string} supplier details")
    public void theUserEntersTheSupplierDetails(String Featurename, String contact1, String contact2, String address)
    {
        name = Featurename;
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("buyingrate")).sendKeys(contact1);
        driver.findElement(By.id("sellingrate")).sendKeys(contact2);
        driver.findElement(By.name("address")).sendKeys(address);

    }

    @Then("All the supplier is added successfully")
    public void allTheSupplierIsAddedSuccessfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedSupplier = "[ " + name+ " ] Supplier Details Added !";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualSupplier = driver
                .findElement(By.xpath("//font[normalize-space()='[ "+name+" ] Supplier Details Added !']"))
                .getText();

        Assert.assertEquals("Supplier not added.",expectedSupplier, actualSupplier);

    }


    @Given("I launch the browser")
    public void iLaunchTheBrowser()
    {
        driver = new ChromeDriver();
    }

    @And("I maximize the browser")
    public void iMaximizeTheBrowser()
    {
        driver.manage().window().maximize();
    }
}
