package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Base {

    public static CommonMethods commonMethods = new CommonMethods();

    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private static AndroidDriver androidDriver = null;

    @BeforeClass
    //Initializing Android driver
    public void setup() {
        initDriver();
    }

    //Getting Android driver
    public AndroidDriver getDriver() {
        return androidDriver;
    }

    private void initDriver() {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, Base.readProperty("device.android.version"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, Base.readProperty("device.android.name"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.APP, new File(Base.readProperty("app.android.path")).getAbsolutePath());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Base.readProperty("app.package"));
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Base.readProperty("app.activity"));

        String serverURL = "http://" + Base.readProperty("run.ip") + ":" + Base.readProperty("run.port") + "/wd/hub";

        try {
            androidDriver = new AndroidDriver(new URL(serverURL), capabilities);
        } catch (NullPointerException | MalformedURLException exception) {
            throw new RuntimeException("Appium server could not be initialized for this device");
        }

    }

    //Setting configuration file
    public static String readProperty(String property) {

        Properties properties;
        String value = null;

        try {
            properties = new Properties();
            properties.load(new FileInputStream(new File("/Users/oshikzigler/Automation/HouzzAppiumAndroid/config")));

            value = properties.getProperty(property);

            if (value == null) {
                throw new Exception(("value not set or empty"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    @AfterClass
    public void tearDown(){
        androidDriver.quit();
    }

}
