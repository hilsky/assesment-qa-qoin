import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

def userId = GlobalVariable.userId
def response = WS.sendRequest(findTestObject('Get Single User', [('id') : userId]))

println("Response: " + response.getResponseText())

WS.verifyResponseStatusCode(response, 200)
assert response.getStatusCode() == 200 : "Actual Status Code: ${response.getStatusCode()}"

def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

assert jsonResponse.data.id.toString() == userId : "Actual userId: ${jsonResponse.data.id}"