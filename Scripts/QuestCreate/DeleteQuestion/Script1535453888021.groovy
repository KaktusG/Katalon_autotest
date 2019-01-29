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

q_num = 2

if (q_num == 1) {
    WebUI.scrollToPosition(0, 0)
} else {
    WebUI.scrollToElement(findTestObject('NodeEditPages/QuestEditPage/question_item_context_menu', [('index') : q_num - 
                1]), 0)
}

//delete question
WebUI.click(findTestObject('NodeEditPages/QuestEditPage/question_item_context_menu', [('index') : q_num]))

WebUI.verifyElementPresent(findTestObject('Common/context_menu'), 3)

WebUI.click(findTestObject('Common/context_menu_item', [('index') : 5]))

WebUI.verifyElementPresent(findTestObject('ModalWindows/ModalWindow'), 3)

WebUI.click(findTestObject('ModalWindows/ConfirmationWindow/btn_confirm'))

WebUI.delay(3)

q_num_next = q_num + 1

String strNum = q_num_next.toString()

WebUI.verifyElementText(findTestObject('NodeEditPages/QuestEditPage/answer_block', [('index') : q_num_next]), strNum)
