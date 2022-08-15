package Pages;

import org.apache.maven.shared.utils.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class registerationelements {
    WebDriver driver;
    By pop_allow = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    By JAP_button = By.xpath("//body/div[@id='root']/div[@id='app-container']/div[@class='menu']/header[contains(@class,'outside-event-header sign-up-tab')]/div[contains(@class,'menu-wrapper')]/div[@class='menu-links']/a[@class='participant']/span[1]");
    By txt_name = By.name("first");
    By txt_lastname = By.name("last");
    By txt_email_add = By.name("email");
    By txt_pwd = By.name("password");
    By txt_cpwd = By.name("passwordConfirmation");
    By upload_pic = By.xpath("(//label[@for='file'])[1]");
    By check_box = By.xpath("//input[@value='agreeToPrivacyPolicy']");
    By sub_btn = By.xpath("//button[normalize-space()='Sign up']");
    By OTP_num = By.xpath("(//input[@type='text'])[1]");
    By country_field_identifier = By.id("mui-component-select-country");
    By country_ukraine = By.xpath("//li[normalize-space()='Ukraine']");
    By checkbox2 = By.xpath("//input[@value='agreeToEventPrivacyPolicy']");

    By complete_Registeration = By.xpath("//button[normalize-space()='Complete Registration']");
    By field_message = By.xpath("//*[@id=\"app-container\"]/div[3]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/p");

    By txt_messagebox = By.id("newPost");

    By myaccount = By.id("myaccount");
    By logoutbtn = By.xpath("//div[@class='row logout-row']");

    public registerationelements(WebDriver dr) {

        this.driver = dr;
    }

    public void click_onJAPbtn() {
        driver.findElement(pop_allow).click();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(JAP_button).click();

    }

    public void fill_registerationform(String fname, String lname, String pwd, String cpwd) {
        driver.findElement(txt_name).sendKeys(fname);
        driver.findElement(txt_lastname).sendKeys(lname);
        int min = 1;
        int max = 10000;
        int number = (int) Math.floor(Math.random() * (max - min + 1) + min);
        driver.findElement(txt_email_add).sendKeys("testbot-swd-" + number + "@onvent.online");
        driver.findElement(txt_pwd).sendKeys(pwd);
        driver.findElement(txt_cpwd).sendKeys(cpwd);

    }

    public void upload_picture(String pic_path) throws InterruptedException, AWTException {
        WebElement upfield = driver.findElement(upload_pic);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", upfield);
        Thread.sleep(5000);
        StringSelection stringSelection = new StringSelection(pic_path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = new Robot();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(check_box).click();
        driver.findElement(sub_btn).click();
        Thread.sleep(5000);
    }

    public void fetch_OTP(String num) throws InterruptedException {
        driver.findElement(OTP_num).sendKeys(num);

    }

    public void select_country() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(country_field_identifier).click();
        WebElement UKR_select = driver.findElement(country_ukraine);
        JavascriptExecutor UKR = (JavascriptExecutor) driver;
        UKR.executeScript("arguments[0].click();", UKR_select);

    }

    public void finalizing_registeration() {
        driver.findElement(checkbox2).click();
        driver.findElement(complete_Registeration).click();

    }

    public void take_screenshot() throws IOException {
        String projPath = System.getProperty("user.dir");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String formattedDate = sdf.format(date);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        // capture screenshot and store the image
        File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(s, new File(projPath + "\\src\\main\\java\\First" + formattedDate + "png"));
    }

    public void post_message() throws InterruptedException {
        Date objDate = new Date();
        String strDateFormat = "YYYY-MM-dd hh:mm:ss a ";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        System.out.println(objSDF.format(objDate));
        driver.findElement(txt_messagebox).sendKeys("The current date and time is" + objSDF.format(objDate));
        String expected_text = "The current date and time is" + objSDF.format(objDate);
        driver.findElement(txt_messagebox).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        try {
            assertTrue(driver.getPageSource().contains(expected_text));
            System.out.println("The current date and time was posted successfully on the Live Wall");
        } catch (Exception e) {
            System.out.println("Desired text not found");

        }
    }
        public void logout () {
            driver.findElement(myaccount).click();
            driver.findElement(logoutbtn).click();
        }
    }



















