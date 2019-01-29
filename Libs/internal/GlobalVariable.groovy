package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object url_dev
     
    /**
     * <p></p>
     */
    public static Object url_demo
     
    /**
     * <p></p>
     */
    public static Object url_prod
     
    /**
     * <p></p>
     */
    public static Object user1_email
     
    /**
     * <p></p>
     */
    public static Object user1_password
     
    /**
     * <p></p>
     */
    public static Object user1_name
     
    /**
     * <p></p>
     */
    public static Object questTitle
     
    /**
     * <p></p>
     */
    public static Object lessonTitle
     
    /**
     * <p></p>
     */
    public static Object groupTitle
     
    /**
     * <p></p>
     */
    public static Object nodeSubtitle
     
    /**
     * <p></p>
     */
    public static Object image_path
     
    /**
     * <p></p>
     */
    public static Object numbers
     
    /**
     * <p></p>
     */
    public static Object audio_path
     

    static {
        def allVariables = [:]        
        allVariables.put('default', [:])
        allVariables.put('GlobalVariables', allVariables['default'] + ['url_dev' : 'https://app-dev.acroplia.com', 'url_demo' : 'https://demo.acroplia.com', 'url_prod' : 'https://acroplia.com', 'user1_email' : 'for.autotest.selenium@gmail.com', 'user1_password' : '123456', 'user1_name' : 'Auto QA', 'questTitle' : '', 'lessonTitle' : '', 'groupTitle' : '', 'nodeSubtitle' : 'created by Autotest', 'image_path' : 'C:\\\\acroplia-avtotests\\\\files\\\\image.JPG', 'numbers' : ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten'], 'audio_path' : 'C:\\\\acroplia-avtotests\\\\files\\\\sound1.mp3'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        def selectedVariables = allVariables[profileName]
		
		for(object in selectedVariables){
			String overridingGlobalVariable = RunConfiguration.getOverridingGlobalVariable(object.key)
			if(overridingGlobalVariable != null){
				selectedVariables.put(object.key, overridingGlobalVariable)
			}
		}

        url_dev = selectedVariables["url_dev"]
        url_demo = selectedVariables["url_demo"]
        url_prod = selectedVariables["url_prod"]
        user1_email = selectedVariables["user1_email"]
        user1_password = selectedVariables["user1_password"]
        user1_name = selectedVariables["user1_name"]
        questTitle = selectedVariables["questTitle"]
        lessonTitle = selectedVariables["lessonTitle"]
        groupTitle = selectedVariables["groupTitle"]
        nodeSubtitle = selectedVariables["nodeSubtitle"]
        image_path = selectedVariables["image_path"]
        numbers = selectedVariables["numbers"]
        audio_path = selectedVariables["audio_path"]
        
    }
}
