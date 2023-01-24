import java.util.*;
public class OneRow_Observer implements Observer{
    private ArrayList<Double> data;
    public void update(ArrayList<Double> arr){
        data = arr;
        display();
    }
    public OneRow_Observer(DoubleArrayListSubject arrayList){
        arrayList.registerObserver(this);
    }
    public void display(){
        System.out.println("\nNotification to One-Rows Table Observer: Data Changed:");
        for(int i = 0; i < data.size(); i++){
            System.out.print(data.get(i) + " ");
        }
    }
}
