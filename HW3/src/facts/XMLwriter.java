package facts;
 
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
 
// implement (abstract extension) on StringConstants
// this way all path's are always available and easily changeable
public class XMLwriter implements StringConstants {
 
	// wrong argument type
	// used to be List<Fact> factList
	// needs to be FactList
	
	// this method accepts the factList and attempts to write it to XML
    public void writeToXml(FactList factList) throws IOException, XMLStreamException {
    	
    	// create path from the xmlFile variable which implements from StringConstants.java
    	Path path = Paths.get(xmlFile);
    	
        try (OutputStream os = Files.newOutputStream(path)) {
            XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = null;
            try {
                writer = outputFactory.createXMLStreamWriter(os, "utf-8");
                // Typo here
                // used to call writeBooksElem, this method does not exist
                writeFactsElem(writer, factList);
            } finally {
                if (writer != null)
                    writer.close();
            }
        }
    }
    
	// wrong argument type
	// used to be List<Fact> factList
	// needs to be FactList
    
    // this method wraps the write function inside a loop
    private void writeFactsElem(XMLStreamWriter writer, FactList factList) throws XMLStreamException {
        writer.writeStartDocument("utf-8", "1.0");
     
         
        writer.writeStartElement("Fact-List");
        
        // wrong iteration type, cannot iterate over a FactList with the method you originally chose
        // this does not work
        // 		for (Fact fact : factList)
        //			writeFactElem(writer, fact);
        // 			writer.writeEndElement();
        //
        // should have used same type of loop inside the FactList.java file
		for (int i = 0; i < factList.getSize(); i++)
		{
			Fact fact = factList.get(i);
			writeFactElem(writer, fact);
			writer.writeEndElement();
		}        
        
 
        writer.writeEndDocument();
    }
 
    
    // this method actually pulls to data from the fact object and writes to the xml file
    private void writeFactElem(XMLStreamWriter writer, Fact fact) throws XMLStreamException {
        writer.writeStartElement("text");
        writer.writeAttribute("fact-text", fact.getText());
 
 
        writer.writeStartElement("author");
        writer.writeCData(fact.getAuthor());
        writer.writeEndElement();
 
        writer.writeStartElement("type");
        // typo here
        // used to be
        // writer.writeCharacters(fact.getType();
        // missing outer parenthesis
        writer.writeCharacters(fact.getType());
        writer.writeEndElement();
 
     
 
        writer.writeEndElement();
    }
 
    
}