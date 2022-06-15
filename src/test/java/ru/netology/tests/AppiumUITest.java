package ru.netology.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppiumUITest {

    private AndroidDriver driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\user\\Desktop\\StudioProjects\\mqa-homeworks1\\2.2 UI Automator\\sample\\app\\build\\intermediates\\apk\\debug\\app-debug.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest1() {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el1.click();
        el1.sendKeys("  ");
        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el2.click();
        MobileElement els1 = (MobileElement) driver.findElementById("textToBeChanged");

        Assertions.assertEquals("Hello UiAutomator!", els1.getText());
    }

    @Test
    public void sampleTest2() {
        MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el3.click();
        el3.sendKeys("2");
        MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout");
        el5.click();
        MobileElement els2 = (MobileElement) driver.findElementById("text");

        Assertions.assertEquals("2", els2.getText());
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}


