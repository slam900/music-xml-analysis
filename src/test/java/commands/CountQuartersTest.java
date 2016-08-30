package commands;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CountQuartersTest extends TestCase {
  public CountQuartersTest(String testName) {
    super(testName);
  }
  
  public static Test suite() {
    return new TestSuite(CountQuartersTest.class);
  }
  
  public void testApp() {
    assertEquals(3, (int)CountQuarters.getReport(new File("src/test/resources/example.xml")).getData());
  }
}
