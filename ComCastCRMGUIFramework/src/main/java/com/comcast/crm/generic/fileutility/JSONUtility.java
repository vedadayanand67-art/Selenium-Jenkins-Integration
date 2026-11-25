package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
public String getDataFromJSONfile(String key) throws IOException, ParseException
{
	FileReader fileR=new FileReader("C:\\Users\\vedas\\OneDrive\\Desktop\\data\\commondata.json");
	JSONParser parser=new JSONParser();
	Object obj=parser.parse(fileR);
	//Step 2:Convert java object into JSON object using downcasting
	JSONObject map=(JSONObject)obj;
	//Step 3:Get the value from json file using key
	String data=(String)map.get(key);
	return data;
}
}
