package is.ru.hugb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class SeleniumTestWrapper {
  static ChromeDriver driver;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
  }

  @AfterClass
  public static void closeBrowser(){
    driver.quit();
  }
}
