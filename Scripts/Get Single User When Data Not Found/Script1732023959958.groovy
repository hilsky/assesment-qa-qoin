import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

def userId = "200000"
def response = WS.sendRequest(findTestObject('Get Single User', [('id') : userId]))

println("Response: " + response.getResponseText())

WS.verifyResponseStatusCode(response, 404)
assert response.getStatusCode() == 404 : "Actual Status Code: ${response.getStatusCode()}"