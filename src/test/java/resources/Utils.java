package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	public RequestSpecification RequestSpecification() throws IOException
	{
		if(req==null)
		{
        PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
	}
		return req;
	
	}
		
	public String getGlobalValue(String key) throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fin=new FileInputStream("C:\\Users\\e096194\\eclipse-workspace\\ShowOffAPIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fin);
		return prop.getProperty(key);	
		
	}
	
	public String getJsonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath json=new JsonPath(resp);
		return json.get(key).toString();
	}
}