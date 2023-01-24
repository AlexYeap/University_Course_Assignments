
import java.util.ArrayList;
public class BubbleSorter <E extends Number & Comparable<E>> implements Sorter<E>{
    public void sort(ArrayList<Item<E>> arr){  
        Item<E> temp;  
        for(int i=0; i < arr.size(); i++){  
            for(int j=1; j < (arr.size()-i); j++){  
                if(arr.get(j-1).getItem().compareTo(arr.get(j).getItem()) > 0){  
                    temp = arr.get(j-1);  
                    arr.set(j-1,arr.get(j));
                    arr.set(j,temp);
                }
            }  
        }  
    }
}
