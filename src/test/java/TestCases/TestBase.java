package TestCases;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class TestBase   {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    // method to start emulator
    @BeforeTest
    public void setUp() throws IOException {


        //code to start appium server automatic without cmd manual
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//h//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //Create object of Android driver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("YoussefEmulator");
        options.setChromedriverExecutable("C://Users//h//Downloads//Compressed//chromedriver_win32//chromedriver.exe");
        options.setApp("E://AppiumProjects//AppiumFrameworkDesign//src//test//java//resources//General-Store.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    // method to close emulator
    @AfterTest
    public void setDown() throws InterruptedException {
        //stop server
        Thread.sleep(1000);
        driver.quit();
        service.stop();
    }





}
