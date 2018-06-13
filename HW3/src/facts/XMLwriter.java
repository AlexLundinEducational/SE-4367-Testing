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
 
//*** class re-work
// implement (abstract extension) on StringConstants
// this way all path's are always available and easily changeable
public class XMLwriter implements StringConstants {
 
	// *** method re-work
	
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
    
    // *** method re-work
    
    // this method wraps the write function inside a loop
    private void writeFactsElem(XMLStreamWriter writer, FactList factList) throws XMLStreamException {
        writer.writeStartDocument("utf-8", "1.0");
        
        writer.writeCharacters("\n");
        writer.writeStartElement("Fact-List");
        
        // loop re-work
		for (int i = 0; i < factList.getSize(); i++)
		{
			Fact fact = factList.get(i);
			writeFactElem(writer, fact);
			writer.writeCharacters("\n");
			writer.writeEndElement();
		}        
        
 
        writer.writeEndDocument();
    }
 
    
    // this method actually pulls to data from the fact object and writes to the xml file
    private void writeFactElem(XMLStreamWriter writer, Fact fact) throws XMLStreamException {
    	
    	writer.writeCharacters("\n\t");
    	writer.writeStartElement("Fact");

	    	writer.writeCharacters("\n\t\t");
	        writer.writeStartElement("fact-text");
	        writer.writeCharacters(fact.getText());
	        writer.writeEndElement();
	        
	        writer.writeCharacters("\n\t\t");
	        writer.writeStartElement("author");
	        writer.writeCharacters(fact.getAuthor());
	        writer.writeEndElement();
	 
	        writer.writeCharacters("\n\t\t");
	        writer.writeStartElement("fact-type");
	        writer.writeCharacters(fact.getType());
	        writer.writeEndElement();
 
        writer.writeCharacters("\n\t");
        writer.writeEndElement();
    }
 
    
}
