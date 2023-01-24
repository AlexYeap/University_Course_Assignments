

import java.util.ArrayList;
public class InsertionSorter <E extends Number & Comparable<E>>implements Sorter<E>{
    
    public void sort(ArrayList<Item<E>> arr){
        for(int i = 0, j; i < arr.size(); i++){
            Item<E> current = arr.get(i);
            for(j = i; j > 0 && arr.get(j-1).getItem().compareTo(current.getItem()) > 0; j--){
                arr.set(j, arr.get(j-1));
            }
            arr.set(j, current);
        }
    }
}
