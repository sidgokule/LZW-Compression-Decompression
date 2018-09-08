

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Siddhant
 *
 */
public class DecoderMain {

	public static void main(String[] args) throws IOException {

		ArrayList<Integer> encodedData = new ArrayList<>();
		String encodedFileName = "";
		int bitLength = 0;
		
		/**
		 * Check if all the command line arguments are provided
		 */
		if(args.length  > 0) {
			encodedFileName = args[0];
			bitLength = Integer.parseInt(args[1]);
		}else {
			System.err.println("Please enter the input file name followed by number of bits!");
			System.exit(0);
		}
		
		
		
		
		String[] file = encodedFileName.split("\\.");
		String decodedFileName = file[0] + "_decoded.txt";
		int val=0;
		
		/**
		 * Read the encoded file 
		 */
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try
		{
			is = new FileInputStream(encodedFileName);
			isr = new InputStreamReader(is, "UTF-16BE");
			br = new BufferedReader(isr);
			while((val=br.read())!=-1)
			{
				encodedData.add(val);
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
		finally
		{
			isr.close();
			br.close();
		}
		
		/**
		 * Create an object for Decoding class and decode the input file contents by calling "encoding" method if Encoding class
		 */
		Decoding dec = new Decoding();
		ArrayList<String>decodedString = dec.decoding(encodedData,bitLength);
		BufferedWriter out = new BufferedWriter(new FileWriter(decodedFileName));
		Iterator<String>itr1 = decodedString.iterator();
		
		
		/**
		 * Write the decoded output to text file
		 */
		try
		{
			while(itr1.hasNext())
			{
				out.write(itr1.next());
			}
		}
		finally
		{
			out.close();
		}
		
			System.out.println("Succesfully decoded the file in: "+decodedFileName);
		
	}

}
