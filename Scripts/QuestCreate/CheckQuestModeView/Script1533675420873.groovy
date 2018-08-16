import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('NodeEditPages/QuestEditPage/btn_quest_view'))

WebUI.verifyElementPresent(findTestObject('Common/context_menu'), 0)

//check full view
WebUI.click(findTestObject('Common/context_menu_item', [('index') : 1]))

for (i = 1; i <= 5; i++) {
    WebUI.scrollToElement(findTestObject('NodeEditPages/QuestEditPage/answer_block', [('index') : i]), 2)

    WebUI.verifyElementPresent(findTestObject('NodeEditPages/QuestEditPage/choices_block', [('index') : i]), 20)
}

//check preview
WebUI.click(findTestObject('NodeEditPages/QuestEditPage/btn_quest_view'))
WebUI.click(findTestObject('Common/context_menu_item', [('index') : 3]))

WebUI.verifyElementPresent(findTestObject('NodeEditPages/QuestEditPage/quest_preview'), 10)

//check compact view
WebUI.click(findTestObject('NodeEditPages/QuestEditPage/btn_quest_view'))
WebUI.click(findTestObject('Common/context_menu_item', [('index') : 2]))

for (i = 1; i <= 5; i++) {
	WebUI.scrollToElement(findTestObject('NodeEditPages/QuestEditPage/answer_block', [('index') : i]), 2)

	WebUI.verifyElementNotPresent(findTestObject('NodeEditPages/QuestEditPage/choices_block', [('index') : i]), 20)
}
