#INTRODUCTION
	The programming project aims at implementing the LZW algorithm which is a lossless data compression and decompression algorithm. The algorithm comprises of 2 steps:

1) Encoding: Also called as Compression, where the datais grouped as strings and is then encoded into integer codes.
2) Decoding: Also called as Decompression, the encoded data is decoded back into group of strings.

# PROGRAM DESIGN
	The programming project is implemented as 2 parts viz Encoding and Decoding with each part consisting of 2 classes respectively. The Encoding part contains classes EncoderMain.java and Encoding.java similar to Decoding part having classes DecoderMain.java and Decoding.java. The EncoderMain class takes inputs from commandline, reads the file and passes it to Encoding class method:'encoding()'. This method returns the encoded data back which is written to the file of lzw format by EncoderMain class. 
	Similar to encoding, the DecoderMain takes the lzw and bit length as inputs from commandline, stores the contents in integer array list and passes it to Decoding class method: 'decoding()'. This method returns the decoded data back to the DecoderMain class' main method, which then writes it back to a new text file.
	
# DATA STRUCTURES IMPLEMENTED:
	- String: The contents from the input text file are stored in a string variable, with each line being appended one by one while reading the file
	- Integer: The bit lengths passed while running encoding and decoding are stored  in integer
	- HashMap: ASCII table used from encoding/decoding is implemented as a hashmap. The key is the integer value representing the ASCII code and value being the character corresponding to the key.
	- ArrayList of Integer: Encoded representation of the passed file contents is stored in the array list of integer. Also, while reading the lzw file contents, each character is read one by one, converted to integer and stored in the integer array list.
	- ArrayList of String: The decoded string is stored in array list of strings before being written to a text file.
	- Array of Strings: Used to split the and store file name to extract the file name without extension.
	
# FILES BREAKDOWN 
	Each class performs following tasks:
	
	i)EncoderMain.java: 
	- It is the entrypoint for encoding part containing the main method for encoder
	- Called from commandline prompt passing input text file and bit length as parameters
	- Reads the file passed as argument and stores its contents
	- Creates an object of Encoding.java class, calls the 'encoding()' method of it and stores the result in a variable
	- Writes the encoded result from 'encoding()' method to encoded file of the format 'file_name.lzw' using "UTF-16BE" charset
	
	ii) Encoding.java:
	- This class contains the methods required to encode the group of strings into integer codes
	- Takes the input string and bit length as parameters and returns the array list of integers as result
	- Initializes the ASCII table to be used for encoding
	- Calls the methods 'checkTable()' and 'getKey()' that check if the table already contains the passed string and get the key of a particular string respectively.
	- 'checkTable()' is a boolean returning method which takes string and ASCII table hash map as input and returns TRUE or FALSE after checking if the table contains passed string
	- 'getKey()' takes string and ASCII table as input parameters and returns the key corrsponding to the passed string from the ASCII table
	
	iii) DecoderMain.java:
	- Contains the main method for decoder acting as the entrypoint
	- This class is called from commandline prompt passing the lzw file and bit length as input parameters
	- Reads the lzw file using the "UTF-16BE" charset and stores each character as an integer in an array list
	- Creates an object of Decoding.java class and calls the 'decoding()' method passing the integer array list and bit length as parameters
	- Stores the result returned from above method and writes the result in a new text file with name 'inputfilename_decoded.txt'
	
	iv) Decoding.java:
	- Contains the methods required for decoding the encoded data from the file
	- Array list of integers and bit length are passed as parameters an returns the array list of strings as output
	- Intializes the ASCII table used for decoding
	- Contains the decoding algorithm and 'checkTable()' table method used in decoding algorithm
	- 'checkTable()' method takes ASCII table and integer code as input and returns TRUE or FALSE depending on if the code is present in table
	
# WHAT WORKS OR FAILS IN THE PROGRAM:
	As per my observations, the program works fine for all the inputs, and compression is achieved in the encoded file thereby satisfying the objective of the algorithm. But the compression isn't that effective in case of small sized files and becomes more effective when file size increases.

# PROGRAMMING LANGUAGE AND COMPILER USED
	All of the program classes were developed in JAVA. 'javac 1.8.0_051' was the compiler that was used while development.
	
# STEPS TO THE RUN THE PROGRAM:

1) Unzip and extract the files on local system.
2) Run the terminal/command prompt in the 'Java Files' folder.
3) Compile 'EncoderMain.java' and 'DecoderMain.java' separately using 'javac Classname.java'.
4) Run the compiled files by passing the input parameters as apprpriate input files and bit length using command 'java Classname inputfile bitlength'.(NOTE: Input file should be in same folder as the class files)
5) Repeat the same procedure for decoder using the lzw file created by encoder.
6) Verify the ouptut by checking the file after decoding. (inputFileName_decoded.txt)

