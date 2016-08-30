import java.io.File;

import commands.CountQuarters;

public class MusicAnalyzerCLI {
  public static void main(String[] args) {
	  if (args[0].equals("count-quarters") || args[0].equals("c")) {
	    System.out.println(CountQuarters.getReport(new File(args[1])).toString());
	  } else {
		  System.err.print("Invalid command: " + args[0]);
	  }
  }
}
