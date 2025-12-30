package Saikiran_test.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RAHUL_EXAMPLE.landingPag;

public class Base_Test {

    // ---------------- STATIC CONFIG ----------------
    public static String BROWSER;

    static {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                "C:\\Users\\saiki\\OneDrive\\Desktop\\New folder\\maven project\\Ecom\\src\\main\\java\\resources\\GlobalData.properties");
            prop.load(fis);
            BROWSER = prop.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ---------------- INSTANCE VARIABLES ----------------
    private WebDriver driver;           // non-static for parallel execution
    public landingPag landingPage;      // page object

    // ---------------- WEBDRIVER INITIALIZATION ----------------
    public WebDriver initializeWebDriver() {
       
            driver = new ChromeDriver();
      
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    // ---------------- LAUNCH APPLICATION ----------------
    @BeforeMethod(alwaysRun = true)
    public landingPag launchApplication() {
        driver = initializeWebDriver();
        landingPage = new landingPag(driver);
        landingPage.goTo(); // URL handled inside landingPag
        return landingPage;
    }

    // ---------------- SCREENSHOT UTILITY ----------------
    public String getScreenShot(String TestCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "//extentReport//" + TestCaseName + ".png");
        FileUtils.copyFile(source, dest);
        return dest.getAbsolutePath();
    }

    // ---------------- JSON DATA UTILITY ----------------
    public List<HashMap<String, String>> getJsonData(String filepath) throws IOException {
        File file = new File(filepath);
        String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
    }

    // ---------------- TEARDOWN ----------------
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // quit is safer than close
        }
    }

    
    
    
    
    
    
    
    
    
    // ---------------- GETTER ----------------
    public WebDriver getDriver() {
        return driver; // allows passing driver to other pages
    }

    // ---------------- STATIC METHOD ----------------
    public static void printConfig() {
        System.out.println("Browser: " + BROWSER);
    }
}
