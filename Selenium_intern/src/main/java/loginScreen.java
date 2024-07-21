import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginScreen {

    WebDriver driver;

    public loginScreen(WebDriver driver, String url){
        this.driver = driver;
        this.driver.get(url);
    }

    public void searchUsername(String value){
        this.driver.findElement(By.name("username")).sendKeys(value);
    }

    public void searchPassword(String value){
        this.driver.findElement(By.name("password")).sendKeys(value);
    }

    public void login(){
        this.driver.findElement(By.cssSelector("[type='submit']")).click();
    }

    public String getErrorMessage() {
        WebElement errorMessageElement = this.driver.findElement(By.xpath("//div[contains(@class, 'oxd-alert oxd-alert--error')]//p[contains(@class, 'oxd-alert-content-text')]")); // Update the locator based on the actual element
        return errorMessageElement.getText().trim();
    }
}
