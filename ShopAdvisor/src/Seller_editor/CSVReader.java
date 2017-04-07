package Seller_editor;

//Reads a Comma Separated Value file and prints its contents.
import java.io.*;
import java.util.Arrays;

public class CSVReader{

public static void main(String[] arg) throws Exception {

BufferedReader CSVFile = new BufferedReader(new FileReader("src/Seller_editor/Example.csv"));

String dataRow = CSVFile.readLine(); // Read first line.
// The while checks to see if the data is null. If it is, we've hit the end of the file. If not,processes the data.

while (dataRow != null){
String[] dataArray = dataRow.split(",");
for (String item:dataArray) { 
System.out.print(item + "\t"); 
}
System.out.println(); // Print the data line.
dataRow = CSVFile.readLine(); // Read next line of data.
}
// Close the file once all data has been read.
CSVFile.close();

// End the printout with a blank line.
System.out.println();

} //main()
} // CSVRead 