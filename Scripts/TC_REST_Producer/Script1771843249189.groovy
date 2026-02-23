import static com.kms.katalon.core.testobject.ObjectRepository.*
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def response = WS.sendRequest(findTestObject('POST_CreateUser'))

WS.verifyResponseStatusCode(response, 201)

println("Response Body:")
println(response.getResponseBodyContent())