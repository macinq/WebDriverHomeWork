package steps;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Hook {
  @BeforeClass
  public void driverPath() {
    System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
  }

  @AfterClass
  public void driverClose() {
    try {
      Thread.sleep(200000);
      AvitoSteps avitoSteps = new AvitoSteps();
      avitoSteps.driver.quit();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
