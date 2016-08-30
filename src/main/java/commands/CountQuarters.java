package commands;

import java.io.File;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import reports.CountQuartersReport;

public class CountQuarters {
  private CountQuarters() { throw new AssertionError(); }
    
	public static CountQuartersReport getReport(File musicXmlFile) {
		// will throw error upon invalid music xml file
		Document doc = CommandUtils.init(musicXmlFile);
		
		// now count the number of quarters
    XPath xPath = XPathFactory.newInstance().newXPath();
    NodeList nodes = null;
    try {
      nodes = (NodeList)xPath.evaluate(
        "/score-partwise/part/measure/note/type[text()=\"quarter\"]"
        , doc.getDocumentElement()
        , XPathConstants.NODESET
      );
    } catch (XPathExpressionException e) {
      throw new RuntimeException(e);
    }
    
		Integer data = nodes.getLength();
		
		// finally create the report object
		return new CountQuartersReport(data);
	}
}
