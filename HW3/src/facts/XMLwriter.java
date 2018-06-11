package facts;
 
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
 
public class XMLwriter {
 
    public void writeToXml(Path path, List<Fact> factList) throws IOException, XMLStreamException {
        try (OutputStream os = Files.newOutputStream(path)) {
            XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = null;
            try {
                writer = outputFactory.createXMLStreamWriter(os, "utf-8");
                writeBooksElem(writer, factList);
            } finally {
                if (writer != null)
                    writer.close();
            }
        }
    }
 
    private void writeFactsElem(XMLStreamWriter writer, List<Fact> factList) throws XMLStreamException {
        writer.writeStartDocument("utf-8", "1.0");
     
         
        writer.writeStartElement("Fact-List");
        for (Fact fact : factList)
            writeFactElem(writer, fact);
        writer.writeEndElement();
 
        writer.writeEndDocument();
    }
 
    private void writeFactElem(XMLStreamWriter writer, Fact fact) throws XMLStreamException {
        writer.writeStartElement("text");
        writer.writeAttribute("fact-text", fact.getText());
 
 
        writer.writeStartElement("author");
        writer.writeCData(fact.getAuthor());
        writer.writeEndElement();
 
        writer.writeStartElement("type");
        writer.writeCharacters(fact.getType();
        writer.writeEndElement();
 
     
 
        writer.writeEndElement();
    }
 
    
}