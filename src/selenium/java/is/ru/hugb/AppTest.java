package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class AppTest extends SeleniumTestWrapper {
  @Test
  public void testTitleMatches() {
    driver.get(baseUrl);
    assertEquals("Tic Tac Toe", driver.getTitle());
  }

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
    el = driver.findElement(By.id("one"));
    el.click();
    assertEquals("O", el.getText());
  }

  @Test
  public void testClickingSameButtonTwice() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.id("two"));
    el.click();
    assertEquals("X", el.getText());
    el.click();
    assertEquals("X", el.getText());
  }

  @Test
  public void testXWinsVerticalFirstColumn() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.id("one"));
    el.click();
    assertEquals(el.getText(), "X");
    el = driver.findElement(By.id("two"));
    el.click();
    el = driver.findElement(By.id("four"));
    el.click();
    el = driver.findElement(By.id("five"));
    el.click();
    el = driver.findElement(By.id("seven"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: X", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }

  @Test
  public void testOWinsVerticalSecondColumn() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.id("one"));
    el.click();
    assertEquals(el.getText(), "X");
    el = driver.findElement(By.id("two"));
    el.click();
    el = driver.findElement(By.id("four"));
    el.click();
    el = driver.findElement(By.id("five"));
    el.click();
    el = driver.findElement(By.id("nine"));
    el.click();
    el = driver.findElement(By.id("eight"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: O", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }

  @Test
  public void testXWinsVerticalThirdColumn() throws Exception {
    driver.get(baseUrl);
    // X
    WebElement el = driver.findElement(By.id("three"));
    el.click();
    assertEquals(el.getText(), "X");
    // O
    el = driver.findElement(By.id("two"));
    el.click();
    // X
    el = driver.findElement(By.id("six"));
    el.click();
    // O
    el = driver.findElement(By.id("four"));
    el.click();
    // X
    el = driver.findElement(By.id("nine"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: X", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }

  @Test
  public void testOWinsHorizontalFirstRow() throws Exception {
    driver.get(baseUrl);
    // X
    WebElement el = driver.findElement(By.id("one"));
    el.click();
    assertEquals(el.getText(), "X");
    // O
    el = driver.findElement(By.id("four"));
    el.click();
    // X
    el = driver.findElement(By.id("two"));
    el.click();
    // O
    el = driver.findElement(By.id("five"));
    el.click();
    // X
    el = driver.findElement(By.id("three"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: X", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }

  @Test
  public void testXWinsHorizontalSecondRow() throws Exception {
    driver.get(baseUrl);
    // X
    WebElement el = driver.findElement(By.id("one"));
    el.click();
    assertEquals(el.getText(), "X");
    // O
    el = driver.findElement(By.id("four"));
    el.click();
    // X
    el = driver.findElement(By.id("two"));
    el.click();
    // O
    el = driver.findElement(By.id("five"));
    el.click();
    // X
    el = driver.findElement(By.id("nine"));
    el.click();
    // O
    el = driver.findElement(By.id("six"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: O", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }

  @Test
  public void testXWinsHorizontalThirdRow() throws Exception {
    driver.get(baseUrl);
    // X
    WebElement el = driver.findElement(By.id("seven"));
    el.click();
    assertEquals(el.getText(), "X");
    // O
    el = driver.findElement(By.id("one"));
    el.click();
    // X
    el = driver.findElement(By.id("eight"));
    el.click();
    // O
    el = driver.findElement(By.id("two"));
    el.click();
    // X
    el = driver.findElement(By.id("nine"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: X", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }

  @Test
  public void testXDiagonalDown() throws Exception {
    driver.get(baseUrl);
    // X
    WebElement el = driver.findElement(By.id("one"));
    el.click();
    assertEquals(el.getText(), "X");
    // O
    el = driver.findElement(By.id("two"));
    el.click();
    // X
    el = driver.findElement(By.id("five"));
    el.click();
    // O
    el = driver.findElement(By.id("six"));
    el.click();
    // X
    el = driver.findElement(By.id("nine"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: X", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }

  @Test
  public void testXDiagonalUp() throws Exception {
    driver.get(baseUrl);
    // X
    WebElement el = driver.findElement(By.id("seven"));
    el.click();
    assertEquals(el.getText(), "X");
    // O
    el = driver.findElement(By.id("two"));
    el.click();
    // X
    el = driver.findElement(By.id("five"));
    el.click();
    // O
    el = driver.findElement(By.id("six"));
    el.click();
    // X
    el = driver.findElement(By.id("three"));
    el.click();
    el = driver.findElement(By.cssSelector("#information p"));
    assertEquals("winner is: X", el.getText());
    el = driver.findElement(By.id("newGame"));
    el.click();
  }
}
