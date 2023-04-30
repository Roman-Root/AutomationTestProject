//package ui;
//
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import ui.LoginPage;
//
//import java.util.concurrent.TimeUnit;
//
//public class Main {
//    static WebDriver driver;
//    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\korne\\IdeaProjects\\TestProjeckt\\drivers\\geckodriver.exe");
//       //System.setProperty("webdriver.chrome.driver", "C:\\Users\\korne\\IdeaProjects\\TestProjeckt\\drivers\\chromedriver.exe");
//        driver = new FirefoxDriver();
//        //driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(900, 500));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.get("https://www.w3schools.com/");
//
//        StartPage startPage = new StartPage(driver);
//        startPage.clickLogin();
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.registerAccount("hfhfhf", "fhghghg");
//        System.out.println(loginPage.getErrorText());
//
//
//    }
//}
