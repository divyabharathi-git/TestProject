package com;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONToXMLFinal {

	public static void main(String[] args)
			throws IOException, ParseException, ParserConfigurationException, TransformerException {

		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("D:\\google.json");
		Object obj = jsonParser.parse(reader);

		Document doc = DocumentHelper.createDocument();

		String str = getUserDefinedName(obj.getClass().getSimpleName());
		Element rootElement = doc.addElement(str);
		createXML(obj, str, doc, rootElement);

		FileWriter out = new FileWriter("D:\\google.xml");
		doc.write(out);
		out.close();
	}

	private static void createXML(Object obj, String str, Document doc, Element rootElement)
			throws TransformerException {

		if (str.equals("object")) {
			System.out.println("main object kull vantuchu");
			
			Set<String> keys = ((HashMap) obj).keySet();
			JSONObject jsonObject = (JSONObject) obj;

			for (String k : keys) {
				

				String str1;

				if (jsonObject.get(k) != null) {

					str1 = getUserDefinedName(jsonObject.get(k).getClass().getSimpleName());
				} else {
					str1 = "null";

				}

				if (str1.equals("object")) {

					System.out.println("child object kull vantuchu");
					if (jsonObject.get(k) != null) {
						Element subElement = rootElement.addElement("object");
						subElement.addElement("name", k);
						createXML((jsonObject.get(k)), getUserDefinedName(jsonObject.get(k).getClass().getSimpleName()),
								doc, subElement);

					} else {
						Element subElement = rootElement.addElement("object");
						subElement.addElement("name", k);
						createXML("null", getUserDefinedName("null"), doc, subElement);
					}

				} else if (str1.equals("array")) {
					
					System.out.println("main array kull vantuchu");
					Element subElement = rootElement.addElement("array");
					subElement.addAttribute("name", k);
					JSONArray jsonArray = (JSONArray) jsonObject.get(k);
					addChildNode(jsonArray, doc, subElement);

				} else if (str1.equals("null")) {
					Element subElement = rootElement.addElement(str1);
					subElement.addAttribute("name", k);
					addChildNode("null", doc, subElement);

				} else {
					System.out.println("child class kull vantuchu");
					Element subElement = rootElement.addElement(str1);
					subElement.addAttribute("name", k);
					addChildNode(jsonObject.get(k), doc, subElement);

				}

			}

		} else if (str.equals("array")) {
			System.out.println(" child array kull vantuchu");
			JSONArray jsonArray = (JSONArray) obj;
			addChildNode(jsonArray, doc, rootElement);

		} else {

			System.out.println(" class kull vantuchu");
			if (obj != null)
				rootElement.addText(obj.toString());

		}

	}

	public static void addChildNode(JSONArray arr, Document doc, Element arrElement) throws TransformerException {

		Iterator itr = arr.iterator();

		while (itr.hasNext()) {
			
			Object value = itr.next();
			
			
			if(value != null) {
				if (getUserDefinedName(value.getClass().getSimpleName()).equals("object")) {

					Element subElement = arrElement.addElement("object");
					createXML(value, getUserDefinedName(value.getClass().getSimpleName()), doc, subElement);
				}else if(getUserDefinedName(value.getClass().getSimpleName()).equals("array")) {
					
					Element subElement = arrElement.addElement("array");
					JSONArray jsonArray = (JSONArray) value;
					addChildNode(jsonArray, doc, subElement);
				}
				else {
					String nameItr = getUserDefinedName(value.getClass().getSimpleName());
					Element subElement = arrElement.addElement(nameItr);
					if (value != null)
						subElement.addText(value.toString());
				}
			}

		}

	}

	public static void addChildNode(Object jsonObject, Document doc, Element objElement) {

		if (jsonObject != null)
			objElement.addText((jsonObject.toString()));
	}

	private static String getUserDefinedName(String className) {
		String userName = "";
		if (className.equals("JSONObject")) {
			userName = "object";
		} else if (className.equals("JSONArray")) {
			userName = "array";
		} else if (className.equals("Double")) {
			userName = "number";
		} else if (className.equals("Long")) {
			userName = "number";
		} else {
			userName = className.toLowerCase();
		}
		return userName;

	}

}
