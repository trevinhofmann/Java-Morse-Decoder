package MorseDecoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: hofmannt
 * Date: 5/2/14
 * Time: 9:21 AM
 * This class loads the morse code information, gets the files for input and output from the user,
 * and converts morse code into plain text.
 */

public class MorseDecoder {

	/**
	 * Main method of the program
	 * Loads the morse tree, reads encoded input, and writes decoded output
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{
		MorseTree<String> morseTree = loadTree(new File("morsecode.txt"));
		File inputFile = new File(promptFilename("Enter an input filename:", true));
		File outputFile = new File(promptFilename("Enter an output filename:", false));
	}

	private static MorseTree<String> loadTree(File morse) throws FileNotFoundException{
		MorseTree<String> morseTree = new MorseTree<String>();
		Scanner scanner = null;
		try{
			scanner = new Scanner(morse);
			String line;
			while (scanner.hasNextLine()){
				line = scanner.nextLine();
				String symbol = line.split("\t| ")[0];
				String code = line.split("\t| ")[1];
				morseTree.add(symbol, code);
			}
		}
		finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return morseTree;
	}

	/**
	 * Returns a String for a file name, collected through System.in
	 * @param prompt String prompting the input
	 * @param mustExist whether or not the file must exist
	 * @return String file name
	 */
	private static String promptFilename(String prompt, boolean mustExist){
		String filename = null;
		boolean fileExists;
		Scanner in =  new Scanner(System.in);
		do{
			System.out.println(prompt);
			filename = in.next();
			fileExists = (new File(filename)).exists();
			if (!fileExists && mustExist){
				System.out.println("File does not exist. Please try again.");
			}
		} while(!fileExists && mustExist);
		return filename;
	}

}
