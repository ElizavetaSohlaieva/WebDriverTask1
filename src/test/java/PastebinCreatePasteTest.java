import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinCreatePasteTest {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSepUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test(description = "Just first test")
    public void createNewPasteTest() {
        PastebinCreatePaste pastebinCreatePaste = PageFactory.initElements(driver, PastebinCreatePaste.class);
        pastebinCreatePaste.openPage();
        pastebinCreatePaste.fillCodeArea();
        pastebinCreatePaste.setPasteExpiration();
        pastebinCreatePaste.setSyntaxBash();
        pastebinCreatePaste.setPasteName();
        pastebinCreatePaste.setSubmitButton();
       Assert.assertTrue(driver.getTitle().contains("how to gain dominance among developers"));

    }
    @AfterMethod(alwaysRun = true)
    public void browserClose(){
        driver.quit();
        driver=null;
    }

}

