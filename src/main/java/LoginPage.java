import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By singUp = By.xpath("//*[@id='root']/div/div/div[4]/div[1]/div/div[2]/form/div[1]/div[1]/span/span");
    private By emailField = By.xpath("//*[@id='modalusername']");
    private By showPassword = By.xpath("//*[@id='root']/div/div/div[4]/div[1]/div/div[2]/form/div[2]/div[1]/span");
    private By passwordField = By.xpath("//*[@id='current-password']");
    private By loginButton = By.xpath("//*[@id='root']/div/div/div[4]/div[1]/div/div[4]/div[1]/button");
    private By forgotPassword = By.xpath("//*[@id='root']/div/div/div[4]/div[1]/div/div[4]/div[2]/a");
    private By forgotPassworddddd = By.xpath("//*[@id='root']/div/div/div[4]/div[1]/div/div[4]/div[2]/a");


    public LoginPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }
    public LoginPage registerAccount(String email, String password){
        this.typeEmail(email);
        this.typePassword(password);
        this.clickLoginButton();
        return new LoginPage(driver);
    }
}
