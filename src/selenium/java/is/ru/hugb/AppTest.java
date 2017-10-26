package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class AppTest extends SeleniumTestWrapper {
  @Test
  public void testTitleMatches() {
    driver.get(baseUrl);
    assertEquals("Tic Tac Toe", driver.getTitle());
  }

  // Leikur endar
  // Jafntefli
  // Ýta á sama reit 2x
  // sé hægt að ýta á alla reiti

  @Test
  public void testDoFirstMove() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.id("one"));
    el.click();
    assertEquals("X", el.getText());
  }

  @Test
  public void testDoSecondMove() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.id("two"));
    el.click();
    assertEquals("O", el.getText());
  }

  @Test
  public void testDoSecondMove() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.id("two"));
    el.click();
    assertEquals("O", el.getText());
  }
}
