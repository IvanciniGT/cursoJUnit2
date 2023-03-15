package com.curso;


import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

import com.curso.impl.Utilidades;

public class LoginTest {

  private WebDriver driver;

  @BeforeAll
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
  }

  @Test
  public void testProbarLoginExistoso() throws Exception {
    driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    driver.findElement(By.id("txt-username")).clear();
    driver.findElement(By.id("txt-username")).sendKeys("John Doe");
    driver.findElement(By.id("txt-password")).clear();
    driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
    driver.findElement(By.id("btn-make-appointment")).click();
    Assertions.assertEquals("Make Appointment", driver.findElement(By.xpath("//section[@id='appointment']//h2")).getText());
  }

  @AfterAll
  public void tearDown() throws Exception {
    driver.quit();
  }
    
}
