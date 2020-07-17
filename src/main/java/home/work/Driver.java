package home.work;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Driver {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    String adress = "https://avito.ru";
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(adress);

    WebElement params = driver.findElement(By.cssSelector("#category"));
    params.click();

    WebElement category = driver.findElement(By.xpath("//*[@id=\"category\"]/option[38]"));
    category.click();

    WebElement search = driver.findElement(By.cssSelector("#search"));
    search.sendKeys("Принтер");
    search.sendKeys(Keys.ENTER);

    WebElement region = driver.findElement(By.xpath("//div[contains(@data-marker, 'search-form/region')]"));
    region.click();

    WebElement city = driver.findElement(By.xpath("//div/input[contains(@data-marker, 'popup-location/region/input')]"));
    city.sendKeys("Владивосток");
    city.sendKeys(Keys.ENTER);

    WebElement saveButton = driver.findElement(By.xpath("//div/button[contains(@data-marker, 'popup-location/save-button')]"));
    saveButton.click();

    WebElement checkBox = driver.findElement(By.xpath("//div/label[contains(@data-marker, 'delivery-filter')]"));
    if (!checkBox.getAttribute("class").contains("checkbox-checked")) {
      checkBox.click();
    }

    WebElement submitButton = driver.findElement(By.xpath("//div/button[contains(@data-marker, 'search-filters/submit-button')]"));
    submitButton.click();

    WebElement select = driver.findElement(By.className("form-select-v2"));
    select.click();

    WebElement option = driver.findElement(By.xpath("//div/select/option[3][contains(@value, '2')]"));
    option.click();

    List<WebElement> inner = driver.findElements(By.xpath(".//*[contains(@class, 'snippet-list')]/*"));

    for (int i = 0; i < 4; i++) {
      if (i > 0) {
        WebElement innerElemName = inner.get(i).findElement(By.xpath("//*[contains(@itemprop, 'name')]"));
        System.out.println(innerElemName.getText());

        WebElement innerElemPrice = inner.get(i).findElement(By.xpath("//*[contains(@data-marker, 'item-price')]"));
        System.out.println(innerElemPrice.getText());
      }
    }

    try {
      Thread.sleep(200000);
      driver.quit();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
