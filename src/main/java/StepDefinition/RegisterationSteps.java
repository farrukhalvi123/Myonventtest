package StepDefinition;
import Pages.registerationelements;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import java.awt.*;
import java.io.IOException;


public class RegisterationSteps {
    public WebDriver driver;

    registerationelements relem = new registerationelements(driver);
    @Given("User is on Chrome Browser")
    public void user_is_on_chrome_browser() throws InterruptedException{
        String projPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projPath+"\\src\\test\\java\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("User is On MyOnvent Website")
    public void user_is_on_my_onvent_website() {
        String url = "https://app.demo.onvent.online/event/test-event-DUpnBEjXK6";
        driver.get(url);
    }

    @Then("Click on Join as Participant button")
    public void click_on_join_as_participant_button() {
        relem = new registerationelements(driver);
        relem.click_onJAPbtn();
    }

    @Then("Fill the 1st Step of Registeration form")
    public void fill_the_1st_step_of_registeration_form() {
        relem = new registerationelements(driver);
        relem.fill_registerationform("Webdriver", "Selenium","Selenium22#", "Selenium22#");
    }

    @Then("Upload the Image and Check the button")
    public void upload_the_image_and_check_the_button() throws InterruptedException, AWTException {
        relem = new registerationelements(driver);
//        String picpath = System.getProperty("user.dir");
//        String full_pic_path =  picpath+"\\src\\main\\java\\man1.png";
        String projPath = System.getProperty("user.dir");
        relem.upload_picture(projPath + "\\src\\main\\java\\man1.png");

    }

    @Then("Fetch OTP")
    public void fetch_otp_from_email() throws InterruptedException {
        relem = new registerationelements(driver);
        relem.fetch_OTP("123456");
        Thread.sleep(5000);

    }

    @Then("Complete the registeration process")
    public void complete_the_registeration_process() throws InterruptedException {
        relem = new registerationelements(driver);
        relem.select_country();
        relem.finalizing_registeration();

    }

    @Then("Close the browser")
    public void closeTheBrowser() {
        driver.close();
        driver.quit();
    }

    @Then("Take Screenshot")
    public void takeScreenshot() throws IOException {
        relem = new registerationelements(driver);
        relem.take_screenshot();
    }

    @Then("Post Message on live wall")
    public void postMessageOnLiveWall() throws InterruptedException {
        relem = new registerationelements(driver);
        relem.post_message();

    }

    @Then("Logout")
    public void checkTheCorrectTextHasBeenPasted() {
        relem = new registerationelements(driver);
        relem.logout();
    }
}
