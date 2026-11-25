package com.sidechef.genericutility.webdriverutility;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JSON {

	 @Test(enabled = false)
	    public void m1() throws IOException, ParseException {

	        JSONParser parse = new JSONParser();

	        Object obj = parse.parse(
	            new FileReader("./src/test/resources/data.json"));

	        JSONObject jobj = (JSONObject) obj;

	        System.out.println(jobj.get("browser"));
	    }

	    @Test
	    public void jsonData() throws IOException, ParseException {

	        JSONParser parse = new JSONParser();

	        JSONObject jo = (JSONObject) parse.parse(
	            new FileReader("C:\\Users\\vedas\\OneDrive\\Desktop\\LaunchingData.json"));

	        System.out.println("Browser: " + jo.get("browser"));

	        System.out.println("URL: " + jo.get("url"));
	    }
	}