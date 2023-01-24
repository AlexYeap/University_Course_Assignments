import java.util.*;
public class FiveRowsTable_Observer implements Observer {
    private ArrayList<Double> data;
    private Subject s;
    public void update(ArrayList<Double> arr){
       data = arr;
       display();
    }
    public FiveRowsTable_Observer(Subject sub){
        s = sub;
        sub.registerObserver(this);
    }
    public void display(){
        System.out.println(" \nNotification to Five-Rows Table Observer: Data Changed:");
        int k = 0;
        for(int i = 0; i < 5; k += 5){
            if(k >= data.size()){
                System.out.print("\n");
                i++;
                k = 0 + i;
                if(i == 5){
                    continue;
                } 
            }
            System.out.print(data.get(k)+ " ");
            
        }
    }
}

