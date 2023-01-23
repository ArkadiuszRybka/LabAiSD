package czescB;

import java.util.LinkedList;

public class LinkedListStack {
    private LinkedList<Person> stack;

    public LinkedListStack(){
        stack = new LinkedList<Person>();
    }
    public void push(Person person){
        stack.push(person);
    }
    public Person pop(){
        return stack.pop();
    }
    public Person peek(){
        return stack.peek();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public static void main(String[] args){
        ArrayListStack theStack = new ArrayListStack();
        theStack.push(new Person("Arek","Rybka",16));
        theStack.push(new Person("Arek1","Rybka1",17));
        theStack.push(new Person("Arek2","Rybka2",18));

        //theStack.pop();
        while(!theStack.isEmpty()){
            System.out.println(theStack.pop());
        }
        System.out.println();
    }
}


