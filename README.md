# 🧪 Proyecto de Automatización: SauceDemo Login

Este proyecto consiste en la automatización del proceso de inicio de sesión de la web [SauceDemo](https://www.saucedemo.com/) utilizando **Selenium WebDriver**, **Java** y **JUnit 5**. Se aplica el patrón de diseño **Page Object Model (POM)** para mejorar la escalabilidad y el mantenimiento de las pruebas.

---

## 🚀 Funcionalidades
El sistema cuenta con las siguientes capacidades de automatización:
* **Gestión de Sesiones:** Apertura y cierre automático del navegador Chrome.
* **Pruebas Positivas:** Validación de acceso correcto con el usuario `standard_user`.
* **Pruebas Negativas:** Verificación de mensajes de error ante credenciales inválidas.
* **Interacción con Elementos:** Limpieza de campos, escritura y clics en elementos HTML.
* **Sincronización:** Uso de pausas controladas para facilitar la observación de la ejecución.

---

## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java 11+
* **Framework de Pruebas:** JUnit 5
* **Automatización Web:** Selenium WebDriver
* **Gestión de Drivers:** WebDriverManager
* **Construcción:** Maven

---

## 📁 Estructura del Código
* `src/main/java/pages/LoginPage.java`: Clase que encapsula los localizadores (By) y los métodos de acción sobre la página de login.
* `src/test/java/test/LoginTest.java`: Clase que contiene los casos de prueba, las pre-condiciones (`@BeforeEach`) y las validaciones (`assertTrue`).

---

## 📚 Cuestiones y Respuestas Teóricas

### 1. ¿Qué hace la anotación `@BeforeEach`?
Es una instrucción de JUnit que obliga al sistema a ejecutar el código dentro de ese método **antes de cada test individual**. En este proyecto, se utiliza para inicializar el navegador y cargar la URL, garantizando que cada prueba comience desde un estado limpio.

### 2. ¿Para qué sirve `assertTrue`?
Es un método de validación (aserción). Evalúa una condición booleana; si el resultado es **verdadero**, el test continúa con éxito. Si es **falso**, el test falla inmediatamente y reporta el error, permitiéndonos identificar fallos en la aplicación de forma automática.

### 3. ¿Qué diferencia hay entre `findElement()` y `findElements()`?
* **`findElement()`**: Busca un solo elemento. Si no lo encuentra, lanza una excepción (`NoSuchElementException`) y detiene la ejecución.
* **`findElements()`**: Busca todos los elementos que coincidan con el localizador y los devuelve en una lista. Si no encuentra ninguno, devuelve una lista vacía en lugar de dar error, lo cual es útil para verificar la presencia o ausencia de elementos (como mensajes de error).

### 4. ¿Por qué utilizamos una clase `LoginPage` en lugar de escribir todo en el test?
Por el patrón **Page Object Model (POM)**, que ofrece:
* **Reutilización:** Los métodos de login pueden usarse en múltiples clases de test.
* **Fácil Mantenimiento:** Si la web cambia (por ejemplo, el ID del botón de login), solo se modifica en la clase `LoginPage` y no en todos los tests.
* **Claridad:** Separa la "mecánica" de la web (clics, escritura) de la "intención" del test (validar que el login funciona).

---

## ⚙️ Instrucciones de Ejecución
1. Abrir el proyecto en **VS Code**.
2. Asegurarse de tener instalada la extensión **Extension Pack for Java**.
3. Abrir el archivo `LoginTest.java`.
4. Hacer clic en el botón **Run Test** que aparece sobre los métodos `@Test`.

---
<img width="225" height="132" alt="image" src="https://github.com/user-attachments/assets/e5bb3bb3-8924-443a-b9eb-48c7b136a168" />
