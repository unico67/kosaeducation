package day12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class URLTest8 {

	public static void main(String[] args) {
		try {
			URL req = new URL(
					"http://openapi.seoul.go.kr:8088/796143536a756e69313134667752417a/json/LampScpgmtb/1/100/");

			InputStream is = req.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));	

			JSONObject obj = null;
			JSONParser parser = new JSONParser();

			try {
				obj = (JSONObject) parser.parse(br);
			} catch (Exception e) {
				System.out.println("파싱 오류");
				e.printStackTrace();
			}

			System.out.println(obj.toJSONString());
			System.out.println(obj.keySet());
			JSONObject lamp = (JSONObject)obj.get("LampScpgmtb");
			JSONArray row = (JSONArray)lamp.get("row");
			
			for(Object e : row) {
				System.out.println(((JSONObject)e).get("CLS_NM"));
			}	
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}
	}
}
