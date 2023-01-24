/*
* File Name: MyVector.java
* Assignment: Lab5 ExA and ExB
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 11/3/2022
*/
import java.util.ArrayList;  
public class MyVector<E extends Number & Comparable<E>>{
	private ArrayList<Item<E>> storageM;
    private Sorter<E> sorter;

    public MyVector(int n){
        this.storageM = new ArrayList<Item<E>>(n);
    }
    public MyVector(ArrayList<Item<E>> arr){
        this.storageM = arr;
    }
    public void add(Item<E> value){
        storageM.add(value);
    }
    public void setSortStrategy(Sorter<E> s){
        sorter = s;
    }

    public void performSort(){
        sorter.sort(storageM);
    }
    public void display(){
        for(int i = 0; i < storageM.size(); i++){
            System.out.print(storageM.get(i).getItem()+ " ");
        }
    }
}