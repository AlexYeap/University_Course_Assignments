
//Ideas and Implentation from tutorial Notes

import java.util.ArrayList;
import java.util.List;


public class HashTable {
    
	private class HashEntry{
		int element; 	
		boolean isActive;
		
		HashEntry(int e){
			this(e, true);
		}
		HashEntry(int e, boolean i){
			element = e;
			isActive = i;
		}
	}


	private int longestSearchChain = 0;
	private int totalReads = 0;
	private double totalRecords;
	private HashEntry[] array; 
	private int capacity; 

	private static int DEFAULT_CAPACITY = 11344; 
	private int myHash(int e) {
		return e % capacity;
	}

	public HashTable() {
		this(DEFAULT_CAPACITY);
	}
	

	public HashTable(int c) {
		capacity = c;
		// initialize the hash table and make it logically empty
		array = new HashEntry[c];
		for (int i=0; i < array.length; i++) {
			array[i] = null;
		}
	}
	

	
	public Integer LinearProbingPosition(Integer e) {	
		// first compute the hash value h(e)
		Integer currentPosition = myHash(e);
		// resolve collisions
		for (int i = 0; i < capacity-1; i++) {
			if (array[currentPosition] == null ||!array[currentPosition].isActive||array[currentPosition].element == e){

				return currentPosition;
			}
			currentPosition = (currentPosition + 1) % capacity;
		}

		return currentPosition;
	}
	public void SearchLinearProbingPosition(Integer e) {	
        int numReads = 1;
        int currentPosition = myHash(e);

        while(array[currentPosition] != null || array[currentPosition].isActive) {
            numReads++;

            if (numReads > longestSearchChain) {
                longestSearchChain = numReads;
            }
            if (array[currentPosition].element == (e)) {
                totalReads += numReads;
                return;
            }
            currentPosition = (currentPosition + 1) % capacity;
			
		}
    }
	
	
	public boolean isActive(int pos) {
		return array[pos] != null && array[pos].isActive;
	}
	
	public void insertL(Integer e) {
		// first find a position to insert
		Integer pos = LinearProbingPosition(e);
		
		// check whether the position is open or not
		if (isActive(pos)){
			return;
		}
		else{
			array[pos] = new HashEntry(e);
		}
	}


	public void printRecords() {
		int total = 0;
		for (int i = 0; i < capacity; i++) {
			if (isActive(i)) {
				total++;
			}
		}
		totalRecords = total;
		//System.out.println("Records:" + totalRecords);
	}
	


	public void printStats(){
		int tableSize =  this.capacity;
		System.out.println("Total Reads: " +  getTotalReads()) ;
		double AvgReadsPerRecord = getTotalReads()/totalRecords;
		System.out.println("Average number of reads per record:" + AvgReadsPerRecord);
		double loadFactor = (double)totalRecords/tableSize;
		System.out.println("Load Factor: " + loadFactor * 100 + "%");
		double hashEfficiency = loadFactor/AvgReadsPerRecord;
		System.out.println("Hash Efficiency: " + hashEfficiency * 100);
		System.out.println("The size of Longest Search Chain:" + getLongestSearchChain());

	}
	public int getTotalReads(){
		return totalReads;
	}
	public double getTotalRecords(){
		return totalRecords;
	}
	public int getLongestSearchChain() {
		return longestSearchChain;
	}


    public List <String> statsToList() {
		List <String> list = new ArrayList<String>();
		int tableSize =  this.capacity;

		double AvgReadsPerRecord = getTotalReads()/totalRecords;
		list.add("Average number of reads per record: " + AvgReadsPerRecord);
		double loadFactor = (double)totalRecords/tableSize;
		list.add(System.lineSeparator());
		list.add("Load Factor: " + loadFactor * 100 + "%");
		double hashEfficiency = loadFactor/AvgReadsPerRecord;
		list.add(System.lineSeparator());
		list.add("Hash Efficiency: " + hashEfficiency * 100);
		list.add(System.lineSeparator());
		list.add("The size of Longest Search Chain:" + getLongestSearchChain());


        return list;
    }
}

	
