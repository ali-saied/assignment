import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.List;


public class practice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        WebElement searchTextBox = driver.findElement(By.id("APjFqb"));
        searchTextBox.sendKeys("vodafone egypt");


        Thread.sleep(3000);
        List<WebElement> searchResults = driver.findElements(By.xpath(("//Li//span")));

        int len = searchResults.size();

        String expectedResult = "vodafone egypt shop";

        boolean srFlag = false;

        for(int i=0; i<len ; i++){
            if(searchResults.get(i).getText().equals(expectedResult)){
                srFlag = true;
                System.out.println(searchResults.get(i).getText().trim()); // trim removes the last and the begin spaces

                break;
            }

        }
        // split removes each past of
        Assert.assertTrue(srFlag);
    }
}
