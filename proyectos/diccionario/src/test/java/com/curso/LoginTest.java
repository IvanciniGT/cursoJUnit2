package com.curso;


import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.net.URL;
import java.util.Optional;
import java.nio.file.*;
import java.io.*;

import com.curso.impl.Utilidades;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {

  private WebDriver driver;

  @BeforeEach
  public void setUp() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    driver = new RemoteWebDriver( new URL("http://34.243.13.64:4444/wd/hub"), capabilities );
  }

@ParameterizedTest
@DisplayName("Comprobar pantalla de login con datos correctos")
@CsvFileSource(resources="/datos_correctos_login.csv", numLinesToSkip=1 )
  public void testProbarLoginExistoso(String usuario, String password) throws Exception {
    driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    driver.findElement(By.id("txt-username")).clear();
    driver.findElement(By.id("txt-username")).sendKeys(usuario);
    driver.findElement(By.id("txt-password")).clear();
    driver.findElement(By.id("txt-password")).sendKeys(password);
    driver.findElement(By.id("btn-login")).click();
    Assertions.assertEquals("Make Appointment", driver.findElement(By.xpath("//section[@id='appointment']//h2")).getText());
    capturarPantalla(driver, "login_ok");
  }
@ParameterizedTest
@DisplayName("Comprobar pantalla de login con datos correctos")
@CsvFileSource(resources="/datos_incorrectos_login.csv", numLinesToSkip=1 )
  public void testProbarLoginFallido(String usuario, String password) throws Exception {
    driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    driver.findElement(By.id("txt-username")).clear();
    driver.findElement(By.id("txt-username")).sendKeys(usuario);
    driver.findElement(By.id("txt-password")).clear();
    driver.findElement(By.id("txt-password")).sendKeys(password);
    capturarPantalla(driver, "login_nok_antes_"+usuario );
    driver.findElement(By.id("btn-login")).click();
    Assertions.assertEquals("Login failed! Please ensure the username and password are valid.", driver.findElement(By.xpath("//section[@id='login']//p[2]")).getText());
    capturarPantalla(driver, "login_nok_despues_"+usuario );
  }

  public static void capturarPantalla(WebDriver driver, String nombre) throws Exception{
      TakesScreenshot capturador=(TakesScreenshot)driver;
      File imagen = capturador.getScreenshotAs(OutputType.FILE);
      Files.copy(imagen.toPath(), Paths.get("./"+nombre+".png"), StandardCopyOption.REPLACE_EXISTING);
  }

  @AfterEach
  public void tearDown() throws Exception {
    driver.quit();
  }
    
}
