import java.util.*;
public class DoubleArrayListSubject implements Subject{
    private ArrayList<Double> data;
    private ArrayList<Observer> observers;
    public DoubleArrayListSubject(){
        data = new ArrayList<Double>();
        observers = new ArrayList<Observer>();
    }
    public void registerObserver(Observer o){
        observers.add(o);
        o.update(data);
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }
    public void notfyAllObserver(){
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).update(data);
        }
    }
    public void addData(Double s){
        data.add(s);
        notfyAllObserver();
    }
    public void setData(Double s, int index){
        data.set(index,s);
        notfyAllObserver();
    }

    public void populate(double[] array){
        for(int i = 0; i < array.length; i++){
            data.add(array[i]);
        }
    }
    public void display(){
        for(int i = 0; i < data.size(); i++){
            System.out.print(data.get(i)+ " ");
        }

    }
    public void remove(Observer o){
        removeObserver(o);
    }
}
