import static com.kms.katalon.core.testobject.ObjectRepository.*
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def response = WS.sendRequest(findTestObject('GET_GetUser'))

WS.verifyResponseStatusCode(response, 200)

def body = response.getResponseBodyContent()
println("Response Body:")
println(body)

assert body.contains("userId") : "Response tidak mengandung userId"