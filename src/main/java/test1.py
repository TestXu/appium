import os
import unittest
from appium import webdriver
from time import sleep
from HTMLTestRunner import HTMLTestRunner
# Returns abs path relative to this file and not cwd
# PATH = lambda p: os.path.abspath(
#     os.path.join(os.path.dirname(__file__), p)
# )
#     appium+unit框架，支持html报告生成和邮件发送
class ContactsAndroidTests(unittest.TestCase):
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.3.1'
        desired_caps['deviceName'] = 'emulator-5554'
        # desired_caps['app'] = PATH(
        #     '../../../sample-code/apps/ContactManager/ContactManager.apk'
        # )
        desired_caps['appPackage'] = 'com.android.calculator2'#应用 的包名
        desired_caps['appActivity'] = '.Calculator'#应用的类名

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        self.driver.quit()

    def test_add_contacts(self):
        self.driver.find_element_by_name("1").click()

        self.driver.find_element_by_name("5").click()

        self.driver.find_element_by_name("9").click()

        # driver.find_element_by_name("delete").click()

        self.driver.find_element_by_name("9").click()

        self.driver.find_element_by_name("5").click()

        self.driver.find_element_by_name("+").click()

        self.driver.find_element_by_name("6").click()

        self.driver.find_element_by_name("=").click()





if __name__ == '__main__':
    # suite = unittest.TestLoader().loadTestsFromTestCase(ContactsAndroidTests)
    # unittest.TextTestRunner(verbosity=2).run(suite)

    testunit = unittest.TestSuite()
    testunit.addTest(ContactsAndroidTests("test_add_contacts"))
    # 定义报告存放路径
    fp = open("./result.html", 'wb')
    print("2222")
    # 定义测试报告
    runner = HTMLTestRunner(stream=fp, title=u'百度搜索测试报告', description=u'用例执行情况：')
    runner.run(testunit)  # 运行测试用例
    print('1221')
    fp.close()  # 关闭报告文件