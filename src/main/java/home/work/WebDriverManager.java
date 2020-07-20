package home.work;

/**
 * Класс для работы с вэбдрайвером
 * Автор Васильев И.Н. atcc@mail.ru
 * 02.12.2018
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    public static WebDriver driver;

    //    protected static final Logger logger = Logger.getLogger(WebDriverManager.class);
    private WebDriverManager() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(option);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            } catch (UnreachableBrowserException e) {
//                logger.error("Невозможно инциализировать драйвер!", e);
            }
        }
        return driver;
    }


    public static void quit() {
        try {
            driver.quit();
            driver = null;
        } catch (UnreachableBrowserException e) {
//            logger.error("Невозможно закрыть браузер!");
        }
    }
}