package domparser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.lang.reflect.Method; 
import java.lang.reflect.Field; 
import java.lang.reflect.Constructor; 

public class ReadXMLFile {
	
	static void testAdd() {
		
		System.out.println("Inside testAdd");
		
	}
	
	static void testSubstract() {
		
		System.out.println("Inside testSubstract");
		
	}
	
	static void testMultiply() {
		
		System.out.println("Inside testMultiply");
		
	}

  public static void main(String argv[]) {

    try {

    	File fXmlFile = new File("file\\test.xml");
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document doc = dBuilder.parse(fXmlFile);
			
    	//optional, but recommended
    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    	doc.getDocumentElement().normalize();

    	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
    	NodeList nList = doc.getElementsByTagName("test");
			
    	ReadXMLFile obj = new ReadXMLFile();
    	Class cls = obj.getClass(); 

		for (int temp = 0; temp < nList.getLength(); temp++) {

     		Node nNode = nList.item(temp);

			Element eElement = (Element) nNode;

			String methodName = eElement.getElementsByTagName("method").item(0).getTextContent();
			String flag = eElement.getElementsByTagName("flag").item(0).getTextContent();
			Method methodcall = cls.getDeclaredMethod(methodName);
			
			if(flag.equals("Y")) {
				methodcall.invoke(obj);
			}
			
		
		}
    
    } catch (Exception e) {
    	
    	e.printStackTrace();
    
    }
  }

}