package com.acroplia

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.sun.jna.AltCallingConvention

import WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CommonUtilities {

	@Keyword
	public void getCurrentDate() {
		Date date = new Date();
		String datePart = date.format('MM-dd-yyy');
		String timePart = date.format('HH:mm');
		String curDate = datePart + ' ' + timePart;
		println curDate

		GlobalVariable.questTitle = 'Quest ' + curDate;
		GlobalVariable.lessonTitle = 'Lesson ' + curDate;
		GlobalVariable.groupTitle = 'Group ' + curDate;
	}

	@Keyword
	public static void Wait_untils_all_processes_completed() {
		WebUI.executeJavaScript("document.getElementById('active_connection_count').style.display='block'", null)
		for (int i = 0; i < 10; i++) {
			WebUI.delay(2);
			if (WebUI.getText(findTestObject('Dashboard/ActiveConnectionCount')) == '0') {
				break;
			}
		}
		if (WebUI.getText(findTestObject('Dashboard/ActiveConnectionCount')) != '0') {
			WebUI.refresh()
		}
		WebUI.waitForPageLoad(3)
		WebUI.verifyElementText(findTestObject('Dashboard/ActiveConnectionCount'), '0')
	}

	@Keyword
	public void Wait_until_all_data_saved() {
		for (int i = 0; i < 10; i++) {
			WebUI.delay(2);
			if (WebUI.getText(findTestObject('NodeEditPages/info_for_saving')) == 'Сохранено несколько секунд назад') {
				break;
			}
		}
	}

	@Keyword
	public void selectLanguage () {
		WebUI.click(findTestObject("Landing/dd_lang"))
		WebUI.verifyElementAttributeValue(findTestObject("Landing/dd_lang"), "aria-expanded", "true", 2)
		WebUI.click(findTestObject("Landing/lang_ru"))
		WebUI.verifyElementAttributeValue(findTestObject("Landing/dd_lang"), "aria-expanded", "false", 2)
	}

	@Keyword
	public void goToDashboard() {
		WebUI.click(findTestObject('Dashboard/logo'))
		WebUI.waitForPageLoad(10)
		//Wait_untils_all_processes_completed()
		WebUI.verifyElementAttributeValue(findTestObject("Dashboard/TabMyStudies/myStudiesPage"), 'class', 'tab-panel active', 2)
	}

	@Keyword
	public void goToCreateTab() {
		WebUI.click(findTestObject("Dashboard/tab_Create"))
		Wait_untils_all_processes_completed()
		WebUI.verifyElementAttributeValue(findTestObject("Dashboard/TabMyCreate/myCreatePage"), 'class', 'tab-panel active', 2)
	}

	@Keyword
	public void openMyDraftSection() {
		WebUI.click(findTestObject("Dashboard/TabMyCreate/linkMyDrafts"))
		Wait_untils_all_processes_completed()
		WebUI.verifyElementPresent(findTestObject("Dashboard/TabMyCreate/pageMyDrafts"), 2)
	}

	@Keyword
	public void openMyPublishedSection() {
		WebUI.click(findTestObject("Dashboard/TabMyCreate/linkMyPublished"))
		Wait_untils_all_processes_completed()
		WebUI.verifyElementPresent(findTestObject("Dashboard/TabMyCreate/pageMyPublished"), 2)
	}

	@Keyword
	public void goToMyGroupsTab() {
		WebUI.click(findTestObject("Dashboard/tab_MyStudies"))
		Wait_untils_all_processes_completed()
		WebUI.verifyElementAttributeValue(findTestObject("Dashboard/TabMyGroups/myGroupsPage"), 'class', 'tab-panel active', 2)
	}

	@Keyword
	public int getNodeItemFromDashboard (TestObject to, String nodeTitle) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement list = WebUiBuiltInKeywords.findWebElement(to)
		List<WebElement> listNodeCount = list.findElements(By.xpath("//div[@data-xpath='dashboard-item']"))
		int items = listNodeCount.size()
		println(items)
		int nodeCount = 0
		for (int i = 1; i <= items; i++) {
			WebElement nodeItem = driver.findElement(By.xpath("//div[@data-xpath='dashboard-item'][" + i + "]//div[@data-xpath='quest_name']/a"))
			String nodeName = nodeItem.getText()
			println(nodeName)
			println(nodeTitle)
			if (nodeName == nodeTitle) {
				nodeCount = i
				break
			}
		}
		println(nodeCount)
		return nodeCount
	}

	@Keyword
	public static void addImageBySearch (String search_engine, String text) {
		//Wait_untils_all_processes_completed()
		WebUI.verifyElementPresent(findTestObject('ModalWindows/ModalWindow'), 10)

		WebUI.waitForElementNotPresent(findTestObject("ModalWindows/spinner"), 20)

		WebUI.selectOptionByValue(findTestObject('ModalWindows/ImageDialog/dd_search_list'), search_engine, false)

		WebUI.clearText(findTestObject("ModalWindows/ImageDialog/searchInput"))

		WebUI.waitForElementNotPresent(findTestObject("ModalWindows/spinner"), 20)

		WebUI.setText(findTestObject('ModalWindows/ImageDialog/searchInput'), text)

		WebUI.waitForElementNotPresent(findTestObject("ModalWindows/spinner"), 20)
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject("ModalWindows/ImageDialog/imageItem"), 10)
		WebUI.click(findTestObject('ModalWindows/ImageDialog/imageItem'))
		//Wait_untils_all_processes_completed()
		WebUI.verifyElementPresent(findTestObject('ModalWindows/ImageDialog/CropperBox'),20)
		WebUI.delay(5)
		WebUI.verifyElementClickable(findTestObject("ModalWindows/ImageDialog/btn_crop"))
		WebUI.click(findTestObject('ModalWindows/ImageDialog/btn_crop'))
		//WebUI.verifyElementNotPresent(findTestObject('ModalWindows/ImageDialog/CropperBox'), 20)
		WebUI.verifyElementNotPresent(findTestObject('ModalWindows/ModalWindow'),3)
	}

	@Keyword
	public static void downloadImage () {
		//Wait_untils_all_processes_completed()
		WebUI.verifyElementPresent(findTestObject("ModalWindows/ModalWindow"), 30)
		WebUI.uploadFile(findTestObject("ModalWindows/ImageDialog/btn_download"), GlobalVariable.image_path)
		//Wait_untils_all_processes_completed()
		WebUI.verifyElementPresent(findTestObject("ModalWindows/ImageDialog/CropperBox"), 30)
		WebUI.delay(5)
		WebUI.verifyElementClickable(findTestObject("ModalWindows/ImageDialog/btn_crop"))
		WebUI.click(findTestObject("ModalWindows/ImageDialog/btn_crop"))
		//WebUI.verifyElementNotPresent(findTestObject("ModalWindows/ImageDialog/CropperBox"), 20)
		WebUI.verifyElementNotPresent(findTestObject("ModalWindows/ModalWindow"),3)
	}

	@Keyword
	public static void downloadAudio() {
		WebUI.verifyElementPresent(findTestObject("ModalWindows/ModalWindow"), 5)
		WebUI.verifyElementClickable(findTestObject("ModalWindows/AudioDialog/btn_download"))
		WebUI.uploadFile(findTestObject("ModalWindows/AudioDialog/input_download_file"), GlobalVariable.audio_path)
		//Wait_untils_all_processes_completed()
		WebUI.waitForElementNotPresent(findTestObject("ModalWindows/AudioDialog/spinner_in_btn"), 60)
		//WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject("ModalWindows/AudioDialog/audio_place_is_full"), 10)
		WebUI.click(findTestObject("ModalWindows/btn_close"))
		WebUI.verifyElementNotPresent(findTestObject("ModalWindows/ModalWindow"), 10)
	}

	@Keyword
	public static void recordAudio() {
		WebUI.verifyElementPresent(findTestObject("ModalWindows/ModalWindow"), 2)
		WebUI.verifyElementClickable(findTestObject("ModalWindows/AudioDialog/btn_microphone"))
		WebUI.click(findTestObject("ModalWindows/AudioDialog/btn_microphone"))
		WebUI.delay(3)

		//WebUI.acceptAlert()

		/*WebDriver driver= DriverFactory.getWebDriver()
		 Alert alt= driver.switchTo().alert()
		 alt.accept()*/

		WebUI.click(findTestObject("ModalWindows/AudioDialog/btn_microphone"))
		//Wait_untils_all_processes_completed()
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject("ModalWindows/AudioDialog/audio_place_is_full"), 10)
		WebUI.click(findTestObject("ModalWindows/btn_close"))
		WebUI.verifyElementNotPresent(findTestObject("ModalWindows/ModalWindow"), 10)
	}
}
