import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Demo {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        //启动appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","N918St");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","4.4.2");
        capabilities.setCapability("appPackage","com.zhihu.android");
        capabilities.setCapability("appActivity","com.zhihu.android.app.ui.activity.MainActivity");
        capabilities.setCapability("unicodeKeyboard","True");
        //unicodeKeyboard 是使用 unicode 编码方式发送字符串
        capabilities.setCapability("resetKeyboard","True");
        //resetKeyboard 是将键盘隐藏起来
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addContact(){
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.a.c[5]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/guest_header_button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/go_to_btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/text_left_func"))).click();
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/edit_text")));
        TouchAction ta = new TouchAction(driver);
        ta.tap(name, 400, 50).release().perform();
        name.sendKeys("aaaa");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zhihu.android:id/password"))).sendKeys("as8371912");
    }
    public void sendMobileNumber(String text){
        char [] chars = text.toCharArray();
        for (int i=0;i<chars.length;i++){
            int c = Integer.valueOf(String.valueOf(chars));
            int number = 0;
            switch (c){
                case  0:
                    number = AndroidKeyCode.KEYCODE_0;
                    break;
                case  1:
                    number = AndroidKeyCode.KEYCODE_1;
                    break;
                case  2:
                    number = AndroidKeyCode.KEYCODE_2;
                    break;
                case  3:
                    number = AndroidKeyCode.KEYCODE_3;
                    break;
                case  4:
                    number = AndroidKeyCode.KEYCODE_4;
                    break;
                case  5:
                    number = AndroidKeyCode.KEYCODE_5;
                    break;
                case  6:
                    number = AndroidKeyCode.KEYCODE_6;
                    break;
                case  7:
                    number = AndroidKeyCode.KEYCODE_7;
                    break;
                case  8:
                    number = AndroidKeyCode.KEYCODE_8;
                    break;
                case  9:
                    number = AndroidKeyCode.KEYCODE_9;
                    break;
                default:
                    System.out.println("语法错误");
                    break;
            }
        }
    }
}
