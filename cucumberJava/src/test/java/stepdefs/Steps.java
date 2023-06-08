package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am in the homepage of the Demoblaze Application")
    public void i_am_in_the_homepage_of_the_Demoblaze_Application() {
        driver.get("https://www.demoblaze.com/");
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_and(String string, String string2) {
        driver.findElement(By.id("login2")).click();
        sleep();
        driver.findElement(By.id("loginusername")).sendKeys(string);
        driver.findElement(By.id("loginpassword")).sendKeys(string2);
        driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();
    }

    @Then("I should login successfully")
    public void i_should_login_successfully() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
        driver.findElement(By.id("nameofuser")).isDisplayed();
    }

    @And("I click first product")
    public void i_click_first_product(){
        driver.findElement(By.cssSelector("#tbodyid > div:nth-child(1) > div > a > img")).click();
        sleep();
    }

    @Then("I click add to cart")
    public void i_click_add_to_cart(){
        driver.findElement(By.cssSelector("#tbodyid > div.row > div > a")).click();
        sleep();
        driver.switchTo().alert().accept();
        sleep();
    }

    @And("I go to cart")
    public void i_go_to_cart(){
        driver.findElement(By.id("cartur")).click();
        sleep();
    }

    @Then("I click place order")
    public void i_click_place_order(){
        driver.findElement(By.cssSelector("#page-wrapper > div > div.col-lg-1 > button")).click();
        sleep();
    }

    @And("I complete purchase")
    public void i_complete_purchase(){
        driver.findElement(By.id("name")).sendKeys("name");
        driver.findElement(By.id("country")).sendKeys("country");
        driver.findElement(By.id("city")).sendKeys("city");
        driver.findElement(By.id("card")).sendKeys("card");
        driver.findElement(By.id("month")).sendKeys("month");
        driver.findElement(By.id("year")).sendKeys("year");
        driver.findElement(By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary")).click();
        sleep();

        driver.findElement(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > h2")).isDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
