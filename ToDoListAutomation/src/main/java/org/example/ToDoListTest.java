package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ToDoListTest {
    public static void main(String[] args) {
        // Set path to your chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver-win32\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        // Create ChromeOptions and disable automation banner
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Start Chrome with the options
        WebDriver driver = new ChromeDriver(options);


        try {
            // Load the local HTML file
            driver.get("file:///D:/Testing-Projects/todo-app/index.html");

            // Wait for page to load
            Thread.sleep(1000);

            // Enter task
            WebElement input = driver.findElement(By.id("taskInput"));
            input.sendKeys("Test Task");

            // Click Add button
            WebElement addBtn = driver.findElement(By.xpath("//button[text()='Add']"));
            addBtn.click();

            Thread.sleep(1000); // Wait for task to be added

            // Click on task to mark it complete
            WebElement taskSpan = driver.findElement(By.xpath("//ul[@id='taskList']/li/span"));
            taskSpan.click();

            Thread.sleep(1000); // Wait to observe completed toggle

            // Click delete button
            WebElement deleteBtn = driver.findElement(By.xpath("//ul[@id='taskList']/li/button"));
            deleteBtn.click();

            Thread.sleep(1000); // Wait to observe task removal

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
