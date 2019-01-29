import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

CustomKeywords.'com.acroplia.CommonUtilities.goToDashboard'()

WebUI.refresh()

WebUI.waitForPageLoad(20)

// open node edit page
CustomKeywords.'com.acroplia.CommonUtilities.goToCreateTab'()

CustomKeywords.'com.acroplia.CommonUtilities.openMyDraftSection'()

nodeCount = CustomKeywords.'com.acroplia.CommonUtilities.getNodeItemFromDashboard'(findTestObject('Dashboard/TabMyCreate/pageMyDrafts'), 
    GlobalVariable.questTitle)

WebUI.click(findTestObject('Dashboard/nodeCard/threeDots_btn', [('index') : nodeCount]))

WebUI.verifyElementPresent(findTestObject('Common/context_menu'), 5)

WebUI.click(findTestObject('Common/context_menu_item', [('index') : 1]))

CustomKeywords.'com.acroplia.CommonUtilities.Wait_untils_all_processes_completed'()

WebUI.verifyElementAttributeValue(findTestObject('NodeEditPages/input_NodeTitle'), 'value', GlobalVariable.questTitle, 2)

WebUI.click(findTestObject('NodeEditPages/btn_Publish'))

CustomKeywords.'com.acroplia.CommonUtilities.Wait_untils_all_processes_completed'()

WebUI.click(findTestObject('NodeEditPages/dialogForPublish/Publish_btn'))

WebUI.waitForPageLoad(30)

WebUI.verifyElementPresent(findTestObject('NodeLaunchPage/pageNodeLaunch'), 10)

WebUI.verifyElementText(findTestObject('NodeLaunchPage/cardInfo_NodeTitle'), GlobalVariable.questTitle)

