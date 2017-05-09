import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by taoxu on 2017/5/9.
 */
public class SendMobileNumber {
    private AndroidDriver driver;

    public SendMobileNumber(AndroidDriver driver) {
        this.driver = driver;
    }

    public void sendMobileNumber(String text){
        char [] chars = text.toCharArray();
        for (int i=0;i<chars.length;i++){
            int c = Integer.valueOf(String.valueOf(chars[i]));
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
            driver.pressKeyCode(number);
        }
    }
}
