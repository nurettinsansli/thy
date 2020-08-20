package com.testinium.thy;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import com.thy.selector.Selector;
import com.thy.selector.SelectorFactory;
import com.thy.selector.SelectorType;


import org.openqa.selenium.support.ui.FluentWait;

public class HookImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumFluentWait;
    protected static Selector selector;

    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
                logger.info("Local Browser");
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.turkishairlines.mobile");
                dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.turkishairlines.mobile.ui.main.MainActivity");
                dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                dc.setCapability(MobileCapabilityType.VERSION, "9.0");
                dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
                dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                //dc.setCapability(MobileCapabilityType.FULL_RESET, false);
                dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
                dc.setCapability("autoGrantPermissions",true);
                //dc.setCapability("unicodeKeyboard", true);
                //dc.setCapability("resetKeyboard", true);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AndroidDriver(url, dc);
    }

    @AfterScenario
    public void afterScenario() {
                if(appiumDriver != null)
                    appiumDriver.quit();
    }
}