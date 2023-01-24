import java.util.*;
public class ThreeColumnTable_Observer implements Observer{
    private ArrayList<Double> data;
    public void update(ArrayList<Double> arr){
        data = arr; 
        display();
    }
    public ThreeColumnTable_Observer(DoubleArrayListSubject arrayList){
        arrayList.registerObserver(this);
    }
    public void display(){
        System.out.println("\nNotification to Three Column Table Observer: Data Changed:");
        int k = 0;
        for(int i = 0; i < data.size(); k++){
            if(k >= 3){
                System.out.print("\n");
                k = 0;
            }
            System.out.print(data.get(i)+ " ");
            i++;
        }
    }
}
