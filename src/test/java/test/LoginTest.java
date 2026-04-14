package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // PARTE 2: Test de login correcto
    @Test
    void loginCorrecto() throws InterruptedException {
        // Usamos los métodos de la Parte 1 y pausas de la Parte 4
        loginPage.ingresarUsuario("standard_user");
        Thread.sleep(1000); 
        
        loginPage.ingresarPassword("secret_sauce");
        Thread.sleep(1000);
        
        loginPage.clickLogin();
        Thread.sleep(2000); // Pausa para ver que entramos

        // Comprobación: URL contiene "inventory"
        assertTrue(loginPage.obtenerUrlActual().contains("inventory"),
                "La URL debería contener 'inventory' tras un login exitoso");
    }

    // PARTE 3: Test de login incorrecto
    @Test
    void loginIncorrecto() throws InterruptedException {
        // Usamos el método de la Parte 5 para simplificar
        loginPage.login("standard_user", "password_incorrecto");
        Thread.sleep(2000);

        // Comprobación: Mensaje de error visible
        assertTrue(loginPage.errorVisible(), 
                "Debería mostrarse un mensaje de error");
    }
}