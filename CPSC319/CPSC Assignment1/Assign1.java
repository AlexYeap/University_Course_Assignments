import java.util.Random;
import java.io.File;  // Import the File class
import java.io.IOException;  
import java.io.FileWriter;
public class Assign1 {
    public static void main(String[] args) throws IOException{
     
        String order = args[0];
        int size = Integer.parseInt(args[1]);
        String algorithm = args[2];
        String outputFile = args[3];
    
    
        Assign1.run(algorithm, size, order, outputFile);
                
         
        
    }

        
    

	private static void run(String algorithm, int size, String order, String format) throws IOException {
        switch (algorithm){
            case "selection":
                int [] selectedArr = selectedArray(size, order);
                long startTime = System.nanoTime();
                selectionSort(selectedArr);
                long endTime = System.nanoTime();
                System.out.print("Time Taken: " + (endTime - startTime) + "ns ");
                System.out.println("");
                break;

            case "insertion":
                int [] selectedArr2 = selectedArray(size, order);
                long startTime2 = System.nanoTime();
                insertionSort(selectedArr2);
                long endTime2 = System.nanoTime();
                System.out.print("Time Taken: " + (endTime2 - startTime2) + "ns ");
                System.out.println("");
            
                break;

            case "merge":
                int [] selectedArr3 = selectedArray(size, order);
                long startTime3 = System.nanoTime();
                mergeSort(selectedArr3, 0 ,selectedArr3.length - 1);
                long endTime3 = System.nanoTime();
                System.out.print("Time Taken: " + (endTime3 - startTime3) + "ns ");
                System.out.println("");
         
                break;

            case "quick":
                int [] selectedArr4 = selectedArray(size, order);
                long startTime4 = System.nanoTime();
                quickSort(selectedArr4, 0, selectedArr4.length - 1);
                long endTime4 = System.nanoTime();
                System.out.print("Time Taken: " + (endTime4 - startTime4) + "ns ");
                System.out.println("");
                
                break;

            default:
                break;

        }





    }
    
    public static int[] selectedArray(int size, String order) {
        
        if (order == "descending"){
            int[] desArray = descendingArray(size);
            return desArray;
        }
        else if (order  == "ascending"){
            int[] ascArray = ascendingArray(size);
            return ascArray;
        }
        else if (order == "random"){
            int[] randArray = randomArray(size);
            return randArray;
        }
        else{
            System.out.println("Incorrect Order Array");
            int[] incorrectArr = descendingArray(1);
            return incorrectArr;

            
        }
    }
    public static void printArray(int[] array, String format) throws IOException{ // from W3schools

        
        File outputfile = new File(format);
        if (outputfile.createNewFile()) {
            System.out.println("File created: " + outputfile.getName());
            FileWriter myWriter = new FileWriter(format);
            for (int i = 0; i < array.length; i++){
                myWriter.write(array[i] + " ");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            }
        else{
            System.out.println("Unsuccessfully wrote in the file");

        }
    }

    
    public static int[] randomArray(int size) {
        int[] array = new int[size];
        Random rd = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    public static int[] descendingArray(int size){
        int[] array = new int[size];
        int j = 0;
        for (int i = size; i > 1; i--){
            if (j < size){
                array[j] = i-1;
                j++;
            }
        }
        return array;

    }


    public static int[] ascendingArray(int size){
        int[] array = new int[size];
        for (int i = size; i < array.length; i++){
            array[i] = i+1;
        }
        return array;

    }


    static void selectionSort(int[] array){ //Implementation from Lecture Notes
        for (int i = 0; i < array.length -1; i++){
            int min = i; 
            for(int j = i + 1; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
            }

        }
    

    }
    static void insertionSort(int[] array){//Implementation from Lecture Notes
        for (int i = 1, j; i < array.length; i++){
            int temp = array[i];
            for (j = i; j > 0 && temp < array[j-1]; j--){
                array[j] = array[j-1];
            }
            array[j] = temp;

        }
      

    }
    static void mergeSort(int[] array, int first, int last){//Implementation from Lecture Notes
        if (first < last){
            int mid = (first + last) / 2;
            mergeSort(array, first, mid);
            mergeSort(array, mid+1, last);
            merge(array, first, mid, last);

        }
     
    }
    static void merge(int[] array, int l, int m, int r){// implentation from geeksforgeeks.org
            // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
      
            /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
      
            /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i){
            L[i] = array[l + i];

        }
            
        for (int j = 0; j < n2; ++j){
            R[j] = array[m + 1 + j];
        }
            /* Merge the temp arrays */
      
            // Initial indexes of first and second subarrays
        int i = 0, j = 0;
      
            // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                 j++;
            }
            k++;
            }
      
            /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
      
            /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
        
    }
  

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    static int partition(int[] arr, int low, int high)
    {
        
        // pivot
        int pivot = arr[high];
        
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++)
        {
            
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {
                
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
    */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
    
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    


    }
