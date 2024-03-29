
package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    public static WebDriver driver;
    private static Map<String, Object> testData = new HashMap<>();

    private static String timestamp;

    public static void setTimeStamp(){
        timestamp = new SimpleDateFormat("+yyyy-MM-dd-hh-mm-ss").format(new Date());
    }
    public static String getTimestamp(){
        return timestamp;
    }

    public static void saveData(String key, Object data){
        testData.put(key, data);
    }

    public static Integer readTestDataInteger(String key){

        return (Integer) testData.get(key);
    }

    public static String readTestDataString(String key){

        return (String) testData.get(key);
    }

    public static Map<String, Object> readTestDataMap(String key){

        return (Map<String, Object>) testData.get(key);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initialize() {
        initialize(getConfig().browser, getConfig().runType, getConfig().headless);
    }

    public static void teardown() {
        driver.quit();
    }

    public static Map<String, String> getData(String dataKey){
       return getData(dataKey,"config");
    }

    public static Config getConfig() {
        InputStream stream = getStream("config");
        Config config = new Yaml().loadAs(stream, Config.class);
        return config;
    }

    public static Map<String, String> getPositionDataFromFile(String dataKey, String project){
        Map<String, String> position = getData(dataKey, project);
//        Random rand = new Random();
//        int num = rand.nextInt(10000) + 1;

        String timestamp = new SimpleDateFormat("+yyyy-MM-dd-hh-mm-ss").format(new Date());
        String originalTitle = position.get("title");
        String newTitle = originalTitle + " " + timestamp;
        position.put("title", newTitle);

        return position;
    }

    public static Candidate getCandidateFromFile(String fileName){
        InputStream stream = getStream(fileName);
        Candidate candidate = new Yaml().loadAs(stream, Candidate.class);
        String originalEmail = candidate.getEmail();
        if (originalEmail != null && !originalEmail.isEmpty()){
            String[] emailParts = originalEmail.split("@");
            String newEmail = emailParts[0] + timestamp + "@" + emailParts[1];
            candidate.setEmail(newEmail);
        }

        return candidate;
////        Random rand = new Random();
////        int num = rand.nextInt(10000) + 1;
//
//        String timestamp = new SimpleDateFormat("+yyyy-MM-dd-hh-mm-ss").format(new Date());
//        String originalTitle = candidate.get("title");
//        String newTitle = originalTitle + " " + timestamp;
//        candidate.put("title", newTitle);
//
//        return candidate;
    }

    public static Map<String, String> getCandidateDataFromFile(String dataKey, String project){
        Map<String, String> candidate = getData(dataKey, project);
//        Random rand = new Random();
//        int num = rand.nextInt(10000) + 1;
        //Creating unique email
        String timestamp = new SimpleDateFormat("+yyyy-MM-dd-hh-mm-ss").format(new Date());
        String originalEmail = candidate.get("email");
        String newEmail = originalEmail + " " + timestamp;
        candidate.put("email", newEmail);

        return candidate;
    }

    public static Map<String, String> getData(String dataKey, String project){
        InputStream stream = getStream(project);
        Map<String, Map<String, String>> mapOfMaps = new Yaml().load((stream));
        Map<String, String> testData = mapOfMaps.get(dataKey);

        return testData;
    }


    private static InputStream getStream(String project){
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/data/" + project + ".yml";
            return new FileInputStream(filePath);
        }catch (FileNotFoundException e){
            throw new Error(e);
        }
    }


    public static void initialize(String browser, String testEnv, boolean isHeadless) {
        Dimension size = new Dimension(getConfig().browserWidth, getConfig().browserHeight);
        Point position = new Point(0, 0);
        if (testEnv.equals("local")) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> chromePreferences = new HashMap<>();
                    chromePreferences.put("profile.default_content_settings.geolocation", 2);
                    chromePreferences.put("profile.default_content_settings.popups", 0);
                    chromePreferences.put("download.prompt_for_download", false);
                    chromePreferences.put("download.directory_upgrade", true);
                    chromePreferences.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/downloads");
                    chromePreferences.put("safebrowsing.enabled", false);
                    chromePreferences.put("plugins.always_open_pdf_externally", true);
                    chromePreferences.put("plugins.plugins_disabled", new ArrayList<String>(){{ add("Chrome PDF Viewer"); }});
                    chromePreferences.put("credentials_enable_service", false);
                    chromePreferences.put("password_manager_enabled", false);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.setExperimentalOption("prefs", chromePreferences);
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    if (isHeadless) {
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().window().setPosition(position);
                    driver.manage().window().setSize(size);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Driver is not implemented for: " + browser);
            }
       }
        else if (testEnv.equals("grid")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.ANY);
            try {
                URL hubUrl = new URL("http://localhost:4444/wd/hub");
                driver = new RemoteWebDriver(hubUrl, capabilities);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("Unsupported test environment: " + testEnv);
        }
    }

    public static void selectByText(WebElement departmentDropdown, String department) {
    }

}
