import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.CyclicBarrier.Generation as Generation
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.scrollToElement(findTestObject('NodeEditPages/QuestEditPage/btn_generate_answers'), 2)

WebUI.click(findTestObject('NodeEditPages/QuestEditPage/btn_generate_answers'))

WebUI.verifyElementPresent(findTestObject('ModalWindows/ModalWindow'), 5)

countAnswers = WebUI.getAttribute(findTestObject('ModalWindows/GenerateAnswersDialog/input_count_generation'), 'value')

numCountAnswers = Integer.parseInt(countAnswers)
println numCountAnswers

WebUI.click(findTestObject('ModalWindows/GenerateAnswersDialog/btn_generate'))

WebUI.verifyElementNotPresent(findTestObject('ModalWindows/ModalWindow'), 2)

WebUI.scrollToPosition(0, 0)

WebUI.verifyElementPresent(findTestObject('NodeEditPages/QuestEditPage/choices_block', [('index') : 1]), 20)

//check data choices
right_answer_text = WebUI.getText(findTestObject('NodeEditPages/QuestEditPage/answer_block', [('index') : 1]))
q = 1
//while (right_answer_text != '') {
    for (i = 1; i <= numCountAnswers; i++) {
        ad_answer_text = WebUI.getText(findTestObject('NodeEditPages/QuestEditPage/choice_block',[('index1') : q, ('index2') : i]))
		if (ad_answer_text == '') {
			KeywordUtil.markFailed('additional answer [' + i +'] has not text')
		}
		WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/choice_image_block", [('index1') : q, ('index2') : i]), 'class', "image-place ", 2)
		WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/has_choice_audio", [('index1') : q, ('index2') : i, ('index3') : 1]), 'class', 'audio-marker acr-audio', 2)
		
    }
//}

