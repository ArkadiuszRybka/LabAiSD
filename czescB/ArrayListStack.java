package czescB;

import java.util.ArrayList;

public class ArrayListStack {
    private ArrayList<Person> stack;

    public ArrayListStack(){
        stack = new ArrayList<Person>();
    }

    public void push(Person person){
        stack.add(person);
    }
    public Person pop(){

        return stack.remove(stack.size()-1);

    }

    public Person peek(){
        return stack.get(stack.size()-1);
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
