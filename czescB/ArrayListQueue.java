package czescB;

import java.util.ArrayList;

public class ArrayListQueue {
    private ArrayList<Person> queue;

    public ArrayListQueue(){
        queue = new ArrayList<Person>();
    }
    public void insert(Person elem){
        queue.add(elem);
    }
    public Person remove(){
        return queue.remove(0);
    }
    public Person peek(){
        return queue.get(0);
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public int size(){
        return queue.size();
    }
    public static void main(String[] args){
        ArrayListQueue theQueue = new ArrayListQueue();
        theQueue.insert(new Person("Arek","Rybka",16));
        theQueue.insert(new Person("Arek1","Rybka1",17));
        theQueue.insert(new Person("Arek2","Rybka2",18));

        //theStack.pop();
        while(!theQueue.isEmpty()){
            System.out.println(theQueue.remove());
        }
        System.out.println();
    }
}
