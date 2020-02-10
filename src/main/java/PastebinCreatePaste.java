import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatePaste {
    public static final String HOMEPAGE = "https://pastebin.com/";
    private WebDriver driver;
   // private WebDriverWait wait;
    @FindBy(css = "textarea#paste_code")
    private WebElement pasteCodeArea;
    @FindBy(xpath = "//div[@class='form_right']//option[@value='10M']")
    private WebElement pasteExpiration;
    @FindBy(xpath = "//div[@class='form_right']//option[text()=\"Bash\"][1]")
    private WebElement syntaxBash;
    @FindBy(xpath="//input[@name='paste_name']")
    private WebElement pasteName;
    @FindBy(xpath="//input[@name='submit']")
    private WebElement submitButton;
    By title = By.xpath("//div[@class='paste_box_line1']/h1");
    public PastebinCreatePaste(WebDriver driver) {
        this.driver = driver;
      //  wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
    public void openPage(){
        driver.get(HOMEPAGE);
       // waitForElementLocated(driver, pasteCodeArea);

    }
    public void fillCodeArea(){
        pasteCodeArea.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
    }
    public void setPasteExpiration(){
        pasteExpiration.click();
    }
    public void setSyntaxBash(){
        syntaxBash.click();
    }
    public void setPasteName(){
        pasteName.sendKeys("how to gain dominance among developers");
    }
    public void setSubmitButton(){
        submitButton.click();
        waitForElementLocated(driver, title);
    }

    private static void waitForElementLocated(WebDriver driver, By by) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
