

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Siddhant
 *
 */
public class EncoderMain {

	public static void main(String[] args) throws IOException {

		
		File inputFile  = null;
		BufferedReader br = null;
		String currentLine = "";
		String fileContents = "";
		String encodedFileName = args[0];
		int bitLength = 0;
		
		/**
		 * Check if all the command line arguments are provided
		 */
		if(args.length  > 1) {
			inputFile = new File(args[0]);
			bitLength =  Integer.parseInt(args[1]);
		}else {
			System.err.println("Please enter the input file name followed by number of bits!");
			System.exit(0);
		}
		
		/**
		 * Read the input file 
		 */
		try {
			br = new BufferedReader(new FileReader(inputFile));
			while((currentLine = br.readLine()) != null) {
				fileContents = fileContents + currentLine;
				fileContents = fileContents + "\n";
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
			System.out.println("File Not found. Please check file name and location!");
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println(e);
			System.exit(0);
        } 

        finally {
            try {
                if (br != null)
                	br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
		/**
		 * Create an object for Encoding class and encode the input file contents by calling "encoding" method if Encoding class
		 */
		Encoding enc = new Encoding();
		ArrayList<Integer>encodedString = new ArrayList<>();
		encodedString = enc.encoding(fileContents,bitLength);
		
		
		String[] file = encodedFileName.split("\\.");
		encodedFileName = file[0] + ".lzw";
		
		
		/**
		 * Write the encoded output to lzw file
		 */
		OutputStream os = new FileOutputStream(encodedFileName);
		Writer osw = new OutputStreamWriter(os, "UTF-16BE"); 
		Iterator<Integer> itr = encodedString.iterator();
		try {
			while(itr.hasNext())
			{
				Integer temp = (Integer) itr.next();
				osw.write(temp);
			}
		}
		finally {
			osw.close();
			os.close();
			
		}
		System.out.println("Succesfully encoded the file in: "+encodedFileName);
		

	}

}
