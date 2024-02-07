package pages;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaracion de una variable estatica 'driver' de tipo WebDriver.
     * Esta variable va a ser compartida entre todas las clases que hereden de BasePage
     */
    protected static WebDriver driver;
    /*
     * Declaracion de una variable wait de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia de WebDriverWait utilizando el 'driver' estatico
     * WebDriverWait se usa para poner esperas explicitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargado y configurando automaticamente el driver del navegador. 
     */
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    /*
     * Constructor de la clase BasePage.
     * Sirve para inicializar el 'driver' estatico
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /*
     * Espera la presencia de un elemento ubicado por el XPath especificado en la cadena locator. 
     * Luego devuelve el WebElement que representa el elemento ubicado.
     * Solo va a ser utilizada dentro de esta clase
     */
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String keysToSend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));
        List<WebElement> options = dropdown.getOptions();
        return options.size();
    }

    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
        return values;
    }
}
