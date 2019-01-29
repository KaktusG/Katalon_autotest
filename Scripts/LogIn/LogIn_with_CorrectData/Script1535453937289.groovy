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

WebUI.verifyElementPresent(findTestObject('Landing/btn_openSignInForm'), 2)

WebUI.click(findTestObject('Landing/btn_openSignInForm'))

WebUI.waitForElementPresent(findTestObject('AuthenticationForm/SignIn/SignInForm'), 2)

WebUI.click(findTestObject('AuthenticationForm/SignIn/input_email'))

WebUI.setText(findTestObject('AuthenticationForm/SignIn/input_email'), GlobalVariable.user1_email)

WebUI.click(findTestObject('AuthenticationForm/SignIn/btn_nextStep'))

WebUI.waitForElementPresent(findTestObject('AuthenticationForm/SignIn/Step2_message'), 10)

WebUI.setText(findTestObject('AuthenticationForm/SignIn/input_password'), GlobalVariable.user1_password)

WebUI.click(findTestObject('AuthenticationForm/SignIn/btn_SignIn'))

WebUI.waitForPageLoad(3)

WebUI.verifyElementPresent(findTestObject('Dashboard/userFoto'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

