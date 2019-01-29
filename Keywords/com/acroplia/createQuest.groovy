package com.acroplia

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.TexturePaintContext.Int

import javax.swing.plaf.metal.MetalLookAndFeel.AATextListener

import com.google.common.collect.FilteredEntryMultimap.Keys
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.sun.org.apache.xalan.internal.xsltc.compiler.If
import com.sun.org.apache.xalan.internal.xsltc.compiler.Import
import com.sun.org.apache.xpath.internal.compiler.Keywords
import com.sun.xml.internal.bind.v2.runtime.output.FastInfosetStreamWriterOutput.TablesPerJAXBContext
import com.acroplia.CommonUtilities as CommonUtilities

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class createQuest {

	@Keyword
	public void addTitle(String title) {
		WebUI.click(findTestObject('NodeEditPages/input_NodeTitle'));
		WebUI.setText(findTestObject('NodeEditPages/input_NodeTitle'),  title);
	}

	@Keyword
	public void addSubTitle(String subtitle) {
		WebUI.click(findTestObject('NodeEditPages/input_NodeSubTitle'));
		WebUI.setText(findTestObject('NodeEditPages/input_NodeSubTitle'),  subtitle);
	}

	@Keyword
	public void addTags(int tags) {
		WebUI.click(findTestObject('NodeEditPages/input_tags'));
		for (int i = 1; i <= tags; i++ ) {
			WebUI.setText(findTestObject('NodeEditPages/input_tags'),  'tag_name'+ i);
			WebUI.sendKeys(findTestObject('NodeEditPages/input_tags'), Keys.chord(Keys.ENTER))
		}
		WebUI.clearText(findTestObject('NodeEditPages/input_tags'))
	}

	@Keyword
	public void enterQuestionAnswerText(int qnum) {
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/question_block", [('index') : qnum]))
		WebUI.setText(findTestObject('NodeEditPages/QuestEditPage/question_block', [('index') : qnum]), GlobalVariable.numbers[qnum-1])
		String strNum = qnum.toString()
		WebUI.click( findTestObject('NodeEditPages/QuestEditPage/answer_block', [('index') : qnum]))
		WebUI.setText(findTestObject('NodeEditPages/QuestEditPage/answer_block', [('index') : qnum]), strNum)
	}

	@Keyword
	public void addQuestionImage(int qnum) {
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/question_image_block", [('index') : qnum]))
		CommonUtilities.addImageBySearch('flickr', GlobalVariable.numbers[qnum-1])
		//CommonUtilities.downloadImage()
		//check image is added
		//WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/question_image_block", [('index') : qnum]), 'class', "image-place ", 10)

	}

	@Keyword
	public void addAnswerImage(int qnum) {
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/answer_image_block", [('index') : qnum]))
		CommonUtilities.addImageBySearch('bing', GlobalVariable.numbers[qnum-1])
		//check image is added
		//WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/answer_image_block", [('index') : qnum]), 'class', " is-empty", 10)
	}

	@Keyword
	public void addQuestionAudio(int qnum) {
		//WebUI.click(findTestObject("NodeEditPages/QuestEditPage/question_block", [('index') : qnum]))
		//add download audio
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_question_add_audio", [('index') : qnum]))
		CommonUtilities.downloadAudio()
		//check audio is added
		WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/has_question_audio",[('index1') : qnum, ('index2') : 1]), 'class', 'audio-marker acr-audio', 10)
		//add record audio
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_question_add_audio", [('index') : qnum]))
		//CommonUtilities.recordAudio()
		CommonUtilities.downloadAudio()
		WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/has_question_audio",[('index1') : qnum, ('index2') : 2]), 'class', 'audio-marker acr-audio', 10)
	}

	@Keyword
	public void addAnswerAudio(int qnum) {
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/answer_block", [('index') : qnum]))
		//add download audio
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_answer_add_audio", [('index') : qnum]))
		CommonUtilities.downloadAudio()
		//check audio is added
		WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/has_answer_audio", [('index1') : qnum, ('index2') : 1]), 'class', 'audio-marker acr-audio', 10)
		//add record audio
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_answer_add_audio", [('index') : qnum]))
		//CommonUtilities.recordAudio()
		CommonUtilities.downloadAudio()
		WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/has_answer_audio", [('index1') : qnum, ('index2') : 2]), 'class', 'audio-marker acr-audio', 10)
	}

	@Keyword
	public void addHintAudio(int qnum) {
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/hint_block", [('index') : qnum]))
		//add download audio
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_hint_add_audio", [('index') : qnum]))
		CommonUtilities.downloadAudio()
		//check audio is added
		WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/has_hint_audio", [('index1') : qnum, ('index2') : 1]), 'class', 'audio-marker acr-audio', 10)
		//add audio record
		/*WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_hint_add_audio", [('index') : qnum]))
		 CommonUtilities.recordAudio()
		 //check record is added
		 WebUI.verifyElementAttributeValue(findTestObject("NodeEditPages/QuestEditPage/has_hint_audio", [('index1') : qnum], [('index2') : 2]), 'class', 'audio-marker acr-audio', 10)*/
	}

	@Keyword
	public void addHintData(int qnum) {
		//enter Text
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/hint_block", [('index') : qnum]))
		String strNum = qnum.toString()
		WebUI.setText(findTestObject("NodeEditPages/QuestEditPage/hint_block", [('index') : qnum]), "hint " + strNum)
		//add image
		WebUI.click(findTestObject("NodeEditPages/QuestEditPage/hint_image_block", [('index') : qnum]))
		CommonUtilities.addImageBySearch("bing", "flowers")
		//add audio
		addHintAudio(qnum)
	}

	/*@Keyword
	 public void fillQuestionsData(int qcount) {
	 for (int i = 1; i <= qcount; i++) {
	 enterQuestionAnswerText(i)
	 addQuestionsImage(i)
	 addAnswersImage(i)
	 addQuestionAudio(i)
	 addAnswerAudio(i)
	 }
	 //open Hint block
	 WebUI.scrollToPosition(0, 0)
	 WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_showHide_hint"))
	 WebUI.verifyElementPresent(findTestObject("NodeEditPages/QuestEditPage/hint_block", [('index') : 1]), 5)
	 //fill data
	 //for (int i = 1; i <= qcount; i++) {
	 addHintData(1)
	 //}
	 //close Hint block
	 WebUI.scrollToElement(findTestObject("NodeEditPages/QuestEditPage/btn_showHide_hint"), 2)
	 WebUI.click(findTestObject("NodeEditPages/QuestEditPage/btn_showHide_hint"))
	 }*/

	@Keyword
	public void checkGenerationAnswers(int qcount, int acount) {
		for (int i = 1; i <= qcount; i++) {
			for (int j = 1; j <= acount; j++) {
				String atext = WebUI.getText(findTestObject("NodeEditPages/QuestEditPage/choice_block", [('index1') : i], [('index2') : j]))
			}
		}
	}
}
