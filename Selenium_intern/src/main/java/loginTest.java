import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class loginTest {

    WebDriver dr = new ChromeDriver();
    final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    public void test1() throws InterruptedException {
        loginScreen ls = new loginScreen(dr,url);
        Thread.sleep(4000);
        ls.searchUsername("Admin");
        ls.searchPassword("admin123");
        Thread.sleep(4000);
        Assert.assertEquals(ls.driver.getTitle(),"OrangeHRM");
        System.out.println("test1 done");
    }

    public void test2() throws InterruptedException {
        loginScreen ls2 = new loginScreen(dr,url);
        Thread.sleep(4000);
        ls2.searchUsername("Admin");
        ls2.searchPassword("admin1234");
        Thread.sleep(4000);
        String expectedErrorMessage = "Invalid credentials";
        String actualErrorMessage = ls2.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        System.out.println("test2 done");
    }

    public static void main(String[] args) throws InterruptedException {
        loginTest t1 = new loginTest();
        t1.test1();
        t1.test2();
    }
}
