import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW4Diary {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Первый сценарий: авторизация.

        driver.get("https://diary.ru/user/login");
        driver.findElement(By.id("loginform-username")).sendKeys("Applanatest1");
        driver.findElement(By.id("loginform-password")).sendKeys("Student2020!");

        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(5000);

        driver.findElement(By.id("login_btn")).click();

        Thread.sleep(3000);

        // Второй сценарий: создание новой записи.

        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();

        driver.findElement(By.id("postTitle")).sendKeys("TEST-TEST");
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("TEST-TEST-TEST");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();

        //Третий сценарий: редактирование записи.

        driver.findElement(By.xpath("//span/a[@title='Редактировать']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("postTitle")).sendKeys("TEST-TEST2");
        driver.findElement(By.id("rewrite")).click();






    }
}
