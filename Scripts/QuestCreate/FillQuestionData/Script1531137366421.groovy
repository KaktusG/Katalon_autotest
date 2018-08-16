import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.annotation.Retention as Retention
import java.util.stream.Stream as Stream
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

// fill question and answers blocks
//qcount = 5
for (int i = 1; i <= qcount; i++) {
    CustomKeywords.'com.acroplia.createQuest.enterQuestionAnswerText'(i)

    CustomKeywords.'com.acroplia.createQuest.addQuestionImage'(i)

    CustomKeywords.'com.acroplia.createQuest.addAnswerImage'(i)

    CustomKeywords.'com.acroplia.createQuest.addQuestionAudio'(i)

    CustomKeywords.'com.acroplia.createQuest.addAnswerAudio'(i)
}

// fill Hint block
// ---- open Hint block
WebUI.scrollToPosition(0, 0)

WebUI.click(findTestObject('NodeEditPages/QuestEditPage/btn_showHide_hint'))

WebUI.verifyElementPresent(findTestObject('NodeEditPages/QuestEditPage/hint_block', [('index') : 1]), 5)

//fill data
for (int i = 1; i <= qcount; i++) {
    CustomKeywords.'com.acroplia.createQuest.addHintData'(i)
}

//close Hint block
WebUI.scrollToPosition(0, 0)

WebUI.click(findTestObject('NodeEditPages/QuestEditPage/btn_showHide_hint'))

WebUI.verifyElementNotPresent(findTestObject('NodeEditPages/QuestEditPage/hint_block', [('index') : 1]), 5)

CustomKeywords.'com.acroplia.CommonUtilities.Wait_until_all_data_saved'()

WebUI.callTestCase(findTestCase('QuestCreate/Generate answers'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/CheckQuestModeView'), [:], FailureHandling.STOP_ON_FAILURE)



