package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.LoginPage;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }
    private By upgrade = By.xpath("//div[3]/div[2]/a[1]");
    private By getCertified = By.xpath("//*[@id='cert_navbtn']");
    private By free_website = By.xpath("//div[3]/div[2]/a[1]");
    private By login = By.xpath("//*[@id='w3loginbtn']");
    private By field = By.xpath("//*[@id='search2']");
    private By thref = By.xpath("//*[@id='main']/div[1]/div/h4/a");

    public LoginPage clickLogin(){
        driver.findElement(login).click();
        return new LoginPage(driver);
    }

}
