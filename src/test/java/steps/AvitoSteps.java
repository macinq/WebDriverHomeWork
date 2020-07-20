package steps;

import home.work.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AvitoSteps {
  public WebDriver driver = WebDriverManager.getDriver();
  private String adress = "https://avito.ru";
  private boolean flag = false;

  @ParameterType(".*")
  public Categories categories(String category) {
    return Categories.valueOf(category);
  }

  @ParameterType(".*")
  public Sorts sorts(String sort) {
    return Sorts.valueOf(sort);
  }

  @Пусть("открыт ресурс авито")
  public void openPage() {
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(adress);
  }

  @И("в выпадающем списке категорий выбрана {categories}")
  public void selectCategory(Categories categories) {
    Select select = new Select(driver.findElement(By.cssSelector("#category")));
    WebElement category = driver.findElement(By.xpath("//*[@id=\"category\"]/option[38]"));
    if (categories.value.equals(category.getAttribute("value"))) {
      select.selectByValue(categories.value);
    }
  }

  @И("в поле поиска введено значение {string}")
  public void enteredValue(String string) {
    WebElement search = driver.findElement(By.cssSelector("#search"));
    if (search.getAttribute("value").isEmpty() || !search.getAttribute("value").equals(string)) {
      search.sendKeys(string);
    }
    search.sendKeys(Keys.ENTER);
  }

  @Тогда("кликнуть по выпадающему списку региона")
  public void clicOnRegion() {
    WebElement region = driver.findElement(By.xpath("//div[contains(@data-marker, 'search-form/region')]"));
    region.click();
  }

  @Тогда("в поле регион введено значение {string}")
  public void enteredRegion(String string) {
    WebElement city = driver.findElement(By.xpath("//div/input[contains(@data-marker, 'popup-location/region/input')]"));
    if (city.getAttribute("value").isEmpty() || !city.getAttribute("value").equals(string)) {
      city.sendKeys(string);
    }
    city.sendKeys(Keys.ENTER);

    WebElement saveButton = driver.findElement(By.xpath("//div/button[contains(@data-marker, 'popup-location/save-button')]"));
    saveButton.click();
  }

  @И("нажата кнопка показать объявления")
  public void buttonToShow() {
    WebElement submitButton = driver.findElement(By.xpath("//div/button[contains(@data-marker, 'search-filters/submit-button')]"));
    submitButton.click();
  }

  @Тогда("открылась страница результаты по запросу {string}")
  public void openResults(String string) {
    WebElement pageTitle = driver.findElement(By.xpath("//div/h1[contains(@data-marker, 'page-title/text')]"));
    if (pageTitle.getText().contains(string) && pageTitle.getText().contains("Владивостоке")) {
      flag = true;
    }

    assertTrue(flag, "Страница не открылась");
  }

  @И("активирован чекбокс только с фотографией")
  public void ifChecked() {
    WebElement checkBox = driver.findElement(By.xpath("//label/input[contains(@data-marker, 'search-form/with-images')]"));
    WebElement clickable = driver.findElement(By.xpath("//label[2]/span[contains(@class, 'checkbox-label')]/."));
    if (!checkBox.getAttribute("class").contains("checkbox-checked")) {
      clickable.click();
    }
  }

  @И("в выпадающем списке сортировка выбрано значение {sorts}")
  public void sortByDesc(Sorts sorts) {
    Select select = new Select(driver.findElement(By.xpath("//div[2]/select")));
    WebElement option = driver.findElement(By.xpath("//div/select/option[3][contains(@value, '2')]"));
    if (sorts.value.equals(option.getAttribute("value"))) {
      select.selectByValue(sorts.value);
    }
  }

  @И("в консоль выведено значение названия и цены {int} первых товаров")
  public void consoleOut(int num) {
    List<WebElement> title = driver.findElements(By.xpath("//div[contains(@class, 'snippet-title-row')]"));
    List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class, 'snippet-price-row')]"));

    for (int i = 0; i < num; i++) {
        System.out.println(title.get(i).getText());
        System.out.println(price.get(i).getText());
    }
  }
}