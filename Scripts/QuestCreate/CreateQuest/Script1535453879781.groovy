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

WebUI.callTestCase(findTestCase('QuestCreate/OpenNewQuest_EditPage'), [:], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.acroplia.createQuest.addTitle'(GlobalVariable.questTitle)

CustomKeywords.'com.acroplia.createQuest.addSubTitle'(GlobalVariable.nodeSubtitle)

CustomKeywords.'com.acroplia.createQuest.addTags'(3)

CustomKeywords.'com.acroplia.CommonUtilities.Wait_until_all_data_saved'()

WebUI.callTestCase(findTestCase('Common/CheckNode_is_Created'), [('nodeTitle') : GlobalVariable.questTitle], FailureHandling.CONTINUE_ON_FAILURE)

nodeCount = CustomKeywords.'com.acroplia.CommonUtilities.getNodeItemFromDashboard'(findTestObject('Dashboard/TabMyCreate/pageMyDrafts'), 
    GlobalVariable.questTitle)

WebUI.click(findTestObject('Dashboard/nodeCard/linkNodeTitle', [('index') : nodeCount]))

CustomKeywords.'com.acroplia.CommonUtilities.Wait_untils_all_processes_completed'()

WebUI.verifyElementAttributeValue(findTestObject('NodeEditPages/input_NodeTitle'), 'value', GlobalVariable.questTitle, 2)

WebUI.callTestCase(findTestCase('QuestCreate/AddCoverImage'), [:], FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('QuestCreate/AddIntroduction'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/FillQuestionData'), [('qcount') : 5], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/GenerateAnswers'), [('qcount') : 5], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/CheckQuestModeView'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/CloneQuestion'), [('q_num') : 2], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/DeleteQuestion'), [('q_num') : 2], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/AddTTS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('QuestCreate/SwapQuestion-Answer'), [:], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.acroplia.CommonUtilities.Wait_until_all_data_saved'()

