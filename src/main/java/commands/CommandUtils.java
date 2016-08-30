package commands;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class CommandUtils {
	// Suppress default constructor for noninstantiability
    private CommandUtils() { throw new AssertionError(); }
    
    private static Document doc;
    
    public static Document init(File xmlFile) {
      validateMusicXmlFile(xmlFile);
      return doc;
    }
    
    private static void validateMusicXmlFile(File xmlFile) {
      try {
    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
    
        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();
        
        String rootNodeName = doc.getDocumentElement().getNodeName();
        if (!rootNodeName.equals("score-partwise"))
          throw new AssertionError("Root node name must be \"score-partwise\". Found " + rootNodeName + ".");
    
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
