import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Demo {
    private AndroidDriver driver;
    private SendMobileNumber sd;
    @Before
    public void setUp() throws Exception {
        //启动appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","MI 4W");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","4.4.4");
        capabilities.setCapability("appPackage","com.zhihu.android");
        capabilities.setCapability("appActivity","com.zhihu.android.app.ui.activity.MainActivity");
        capabilities.setCapability("unicodeKeyboard","True");
        //unicodeKeyboard 是使用 unicode 编码方式发送字符串
        capabilities.setCapability("resetKeyboard","True");
        //resetKeyboard 是将键盘隐藏起来
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        sd = new SendMobileNumber(driver);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addContact() throws InterruptedException {
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.a.c[5]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/guest_header_button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/go_to_btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/text_left_func"))).click();
        AndroidElement name = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/edit_text")));
        TouchAction ta = new TouchAction(driver);
        ta.tap(name, 400, 50).release().perform();
        Thread.sleep(1000);
        sd.sendMobileNumber("12345678");
        AndroidElement pwd = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/password")));
        pwd.sendKeys("");
        pwd.clear();
        pwd.sendKeys("123456");
    }

}
