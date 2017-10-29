package is.ru.hugb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.net.URL;


public abstract class SeleniumTestWrapper {
  static RemoteWebDriver driver;
  static String baseUrl;
  static String port;
  static DesiredCapabilities caps;

  public static final String USERNAME = "saethor";
  public static final String ACCESS_KEY = "58be9c4f-2748-40db-8860-dc19e569ac22";
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

  @BeforeClass
  public static void openBrowser() throws Exception {
    caps = DesiredCapabilities.chrome();
    String appName = System.getenv("HEROKU_APP_NAME");
    port = System.getenv("PORT");
    if (port == null) {
      port = "4567";
    }
    
    if (appName == null){
      appName = "localhost";
      baseUrl = "http://" + appName + ":" + port;
    }
    else {
      baseUrl = "https://" + appName + ".herokuapp.com";
    }
    driver = new RemoteWebDriver(new URL(URL), caps);
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  }

  @AfterClass
  public static void closeBrowser(){
    driver.quit();
  }
}
