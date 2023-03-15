package com.example.Pruebalogin;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class ProbarLoginExistoso {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testProbarLoginExistoso() throws Exception {
    driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    driver.findElement(By.id("txt-username")).clear();
    driver.findElement(By.id("txt-username")).sendKeys("John Doe");
    driver.findElement(By.id("txt-password")).clear();
    driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
    driver.findElement(By.id("btn-make-appointment")).click();
    driver.findElement(By.id("txt-username")).click();
    driver.findElement(By.xpath("//section[@id='login']/div/div/div[2]/form/div[2]")).click();
    driver.findElement(By.id("txt-username")).click();
    driver.findElement(By.id("txt-username")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=txt-username | ]]
    driver.findElement(By.id("txt-username")).click();
    driver.findElement(By.id("txt-password")).click();
    driver.findElement(By.id("txt-password")).click();
    driver.findElement(By.id("txt-password")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=txt-password | ]]
    driver.findElement(By.id("txt-password")).click();
    driver.findElement(By.id("txt-password")).click();
    driver.findElement(By.id("txt-password")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=txt-password | ]]
    driver.findElement(By.id("btn-login")).click();
    driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=//section[@id='appointment']/div/div/div/h2 | ]]
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=//section[@id='appointment']/div/div/div/h2 | ]]
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).click();
    try {
      assertEquals("Make Appointment", driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
