import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

// From GeeksforGeeks https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
// Java program to implement
// a Singly Linked List
public class linkedList {
    Node head = null; /* Head of the list */
    Node tail = null; /* Tail of the list */
    Node curr = null; /* Current node in the list */

   
    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    class Node {
        Node next;
        String item;
    
        Node(String item, Node next) {
            this.next = next;
            this.item = item;
        }
    }

    public static void main(String[] args) throws IOException
    {
        //String inputFile = args[0];
        //String outputFile = args[1];

        String[] inputArray = readFromInputStream("example_3.txt");
        long startTime2 = System.nanoTime();
        insertion_sort(inputArray,inputArray.length);  
        long endTime2 = System.nanoTime();
        System.out.print("Time Taken: " + (endTime2 - startTime2)*0.000000001 + "s ");
        System.out.println("");
        int length = inputArray.length;
        linkedList listArray[] = new linkedList[length];
        for (int i = 0 ; i < length; i++){
            listArray[i] = new linkedList();
        }


        sortToLinkedList(listArray, inputArray); // sorted all anagrams into the linkList

        String[] array = new String[listArray.length];
        array = ListtoArray(listArray);               // failed to convert listArray to String[] which resulted in wrong output
        //implementation from https://stackoverflow.com/questions/4150233/remove-null-value-from-string-array-in-java
        List<String> list = new ArrayList<String>();

        for(String s : array) {
           if(s != null && s.length() > 0) {
              list.add(s);
           }
        }
    
        array = list.toArray(new String[list.size()]);
      
        OutputArray(array, "out.txt");

        // Print the LinkedList
        printList(listArray);
    }

    public static String[] ListtoArray(linkedList[] listArray)
    {
        String[] array = new String[listArray.length];
        for (int i = 0 ; i< listArray.length; i++){
            Node currNode = listArray[i].head;
    
            // Traverse through the LinkedList
            while (currNode != null) {
             // Print the data at current node
                array[i] = currNode.item + " " ;
                currNode = currNode.next;    
                
            }
        }
        return array;
    }
    // from W3schools
    public static void OutputArray(String[] array, String format) throws IOException{ 

        
        File outputfile = new File(format);
        if (outputfile.createNewFile()) {
            System.out.println("File created: " + outputfile.getName());
            FileWriter myWriter = new FileWriter(format);
            for (int i = 0; i < array.length; i++){
                myWriter.write(array[i] + System.lineSeparator());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            }
        else{
            System.out.println("Unsuccessfully wrote in the file");

        }
    }

    

    private static void sortToLinkedList(linkedList[] listArray, String[] inputArray) {
        int index = 0;
        boolean contain = false;
        for (int i = 0; i < inputArray.length; i++){
            for(int j = 0; j < listArray.length; j++){
                if (search(listArray[j].head,inputArray[i]) == true){
                    contain = true;
                }
            }
            if (contain == false){
                listArray[index].add(inputArray[i]);
                for (int k = i + 1; k < inputArray.length; k++){
                    if (inputArray[k] != null){
                        if (anagram(inputArray[i], inputArray[k]) == true){
                            listArray[index].add(inputArray[k]); 
                        }
    
                    }
                }
            }
            contain = false;

            index++;
                                
        }
    }
    // implementation from https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
    public static boolean search(Node head, String inputArray)
    {
        Node current = head;    
        while (current != null)
        {
            if (current.item == inputArray){
                return true;  
            }            

            current = current.next;
        }
        return false;    
    }

        
      
    //implementation https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
    private static boolean anagram(String strArray, String strArray2) {

            // check if length is same
        if (strArray.length() != strArray2.length()){
            return false;
        }
        

            // convert strings to char array
        char[] charArray1 = strArray.toCharArray();
        char[] charArray2 = strArray2.toCharArray();

        // sort the char array
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // if sorted char arrays are same
        // then the string is anagram
        
        for (int i = 0; i < strArray.length(); i++){
            if (charArray1[i] !=charArray2[i]){
                return false;
            }
        }
        return true;
    }
    // idea/ development from tutorial sessions
    public static String[] readFromInputStream(String inputFile) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        int lines = 0;
        while (br.readLine() != null) {
            lines++;
        }
        br.close();
        BufferedReader bR = new BufferedReader(new FileReader(inputFile));
        String[] stringArray = new String[lines];
        String st;
         int index = 0;
        while( (st = bR.readLine()) != null){
            stringArray[index++] = st;
        }
        bR.close();
        return stringArray;

  }

     // implementation from geeksfor geeks
    public void add(String item) {
        if (curr != null) {
            Node newNode = new Node(item, curr.next);
            curr.next = newNode;
            curr = newNode;
        } else {
            head = tail = new Node(item, null);
            curr = head;
        }
    }
    // implementation from https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
    // Method to print the LinkedList.
    public static void printList(linkedList[] listArray)
    {
        for (int i = 0 ; i< listArray.length; i++){
            Node currNode = listArray[i].head;
    
          
    
            // Traverse through the LinkedList
            while (currNode != null) {
             // Print the data at current node
                System.out.print(currNode.item + " " );
    
                // Go to next node
                currNode = currNode.next;
            }
        System.out.print(System.lineSeparator());

        }
    }
    // implementation from Lecture Notes
    public static void quickSort(int[] array, int low, int high) {
        int mid = (low+high)/2;
        int pivot = array[mid];
        int L = low; // Index of the first element of the array
        int R = high; // Index of the last element of the array 
        
        while(L<=R) {
            while(array[L]<pivot) { // Greater than Pivot
                L++;
            }
            while(array[R]>pivot) { // Lesser than Pivot
                R--;
            }
            if(L<=R) {
                int Temp = array[L];
                array[L] = array[R];
                array[R] = Temp;
                
                L++;
                R--;
            }
        }
        if(low<R) { // Passing the Left subarray for quicksort
            quickSort(array,low,R);
        }
        if(high>L) { // Passing the right subarray for quicksort
            quickSort(array,L,high);
        }
    }


    public static String[] insertion_sort(String[] array, int n){
        String temp = "";
        int j = 0;
        for(int i = 0; i < n; i++){ // for arraystr1
            for(j = i + 1; j < n; j++){ // for arraystr2
                if (array[j]!= null){
                    if(array[i].compareTo(array[j]) > 0){ // if arrayst1 has a higher ascii value for first letter than array str1 will give > 0
                        temp = array[i]; // place greater ascii array in temp
                        array[i] = array[j]; // strarray1 will have the lower ascii B (EX Blue) 
                        array[j] = temp;// strarray 2 will have the higher ascii L (Law)
                    }
                }
                }
        } 
        return array;          
    } 

   
}