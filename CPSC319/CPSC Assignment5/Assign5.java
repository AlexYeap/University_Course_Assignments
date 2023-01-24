
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Assign5{
    public static void main(String[] args) throws IOException{
		String fileName = args[0] + ".txt";
		String outputFile = args[1] + ".txt";
		FileInputStream file = new FileInputStream(fileName);
		Scanner sc = new Scanner(file);
		double totalStrings = 11344;
		int tableSize =  (int) Math.round(totalStrings * 1.4);
		HashTable table = new HashTable(tableSize);

		while(sc.hasNextLine()){
			String line = sc.nextLine();
			int hash = hash(line, tableSize);
			table.insertL(Math.abs(hash));
		}
		sc.close();

		FileInputStream file2 = new FileInputStream(fileName);
		Scanner sc2 = new Scanner(file2);
		while(sc2.hasNextLine()){
			String line = sc2.nextLine();
			int hash = hash(line,tableSize);
			table.SearchLinearProbingPosition(Math.abs(hash));
		}
		sc2.close();


		table.printRecords();
		//table.printTable();
		table.printStats();

		List <String> ListStats = table.statsToList();
		FileWriter writer = new FileWriter(outputFile); 
		for(String str: ListStats ){
			writer.write(str);
		}
		writer.close();
		System.out.println("Successfully created and writen in Outputfile");

	}




	
        
        
    public static int hash(String key, int tableSize) {
		int ans = 0;
		char[] arr = key.toCharArray();
		if(arr.length % 2 == 1){
			for (int i=0; i < arr.length-1; i+=2) {
				// concat ascii code of arr[i] and arr[i+1]
				ans = (ans + concatInt((int)arr[i], (int)arr[i+1]));
			}
			ans = (ans + concatInt((int)arr[arr.length-1], 32));
		}
	   
		// pad white space if arr.length is odd
		else{
			for (int i=0; i < arr.length; i+=2) {
				// concat ascii code of arr[i] and arr[i+1]
				ans = (ans + concatInt((int)arr[i], (int)arr[i+1]));
			}    
		}
		ans = ans * (int)arr[0];
		return ans;
 }
		
	
	 // Concatenate two integers
	public static int concatInt(int a, int b) {
		int initialB = b;
		while (b > 0) {
			a *= 10;
			b /= 10;
		}
		return a + initialB;
	}
	
}