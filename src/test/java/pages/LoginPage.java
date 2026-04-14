package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Localizadores
    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- PARTE 1: Métodos individuales ---
    public void ingresarUsuario(String user) {
        driver.findElement(userField).clear();
        driver.findElement(userField).sendKeys(user);
    }

    public void ingresarPassword(String pass) {
        driver.findElement(passField).clear();
        driver.findElement(passField).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // --- PARTE 5: Método mejorado ---
    public void login(String user, String pass) {
        ingresarUsuario(user);
        ingresarPassword(pass);
        clickLogin();
    }

    // Métodos de apoyo para los tests
    public String obtenerUrlActual() {
        return driver.getCurrentUrl();
    }

    public boolean errorVisible() {
        return !driver.findElements(errorMessage).isEmpty();
    }
}