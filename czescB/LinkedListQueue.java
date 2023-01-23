package czescB;

import java.util.LinkedList;

public class LinkedListQueue {
    private LinkedList<Person> queue;
    public LinkedListQueue(){
        queue = new LinkedList<Person>();
    }
    private void insert(Person elem){
        queue.addLast(elem);
    }
    public Person remove(){
        return queue.removeFirst();

    }
    public Person peek(){
        return queue.peekFirst();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public int size(){
        return queue.size();
    }
    public static void main(String[] args){
        LinkedListQueue theQueue = new LinkedListQueue();
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
