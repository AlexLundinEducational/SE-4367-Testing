import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class xmlWriter {
	
	public static void main(String[] args) {
			writeXML();
	}


private static void writeXML() {
	
	try {
		
		//Create Document
	Document doc = new Document();
	
	//Set "fact-list" at the root element in the file
	Element factListElem = new Element("fact-list");
	doc.setRootElement(factListElem);
	
	//Create Elements matching "XML NODES" in handler.java
	Element factElem = new Element("fact");//fact Node
	
	Element factTextElem = new Element("fact-text");//fact-text node
	factTextElem.addContent("This statement is a fact");

	
	Element factAuthorElem = new Element("author");//author node
	factAuthorElem.addContent("Jhon Doe");
	
	Element factTypeElem = new Element("fact-type");//fact-type node
	factTypeElem.addContent("Fact");
	
	//Add fact elements to to fact node
	factElem.addContent(factTextElem);
	factElem.addContent(factAuthorElem);
	factElem.addContent(factTypeElem);
	
	//Add fact to root node fact-list
	factListElem.addContent(factElem);
	
	XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
	xmlOutput.output(doc, new FileOutputStream(new File("./src/jdomMade.xml")));
	
	System.out.println("writing successful");
	
	}
	
	catch (Exception ex) {
		ex.printStackTrace();
	}
	
}
}
