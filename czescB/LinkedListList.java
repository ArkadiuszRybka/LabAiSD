package czescB;

import java.util.LinkedList;

public class LinkedListList {
    private LinkedList<Person> llList;
    LinkedListList()
    {
        llList = new LinkedList<Person>();
    }
    public boolean isEmpty()
    {
        return llList.isEmpty();
    }
    public void insertFirst(Person p)
    {
        llList.addFirst(p);
    }
    public void insertLast(Person p)
    {
        llList.addLast(p);
    }
    public Person deleteLast()
    {
        return llList.removeLast();
    }
    public Person deleteFirst()
    {
        return llList.removeFirst();
    }
    public Person getFirst()
    {
        return llList.getFirst();
    }
    public Person getLast()
    {
        return llList.getLast();
    }
    public int size()
    {
        return llList.size();
    }
    public void print()
    {
        for(int i = 0; i < llList.size(); i++)
        {
            System.out.println(llList.get(i));
        }
    }

    public static void main(String[] args) {
        LinkedListList llList = new LinkedListList();
        llList.insertFirst(new Person("Marina", "Pazdzioch", 77));
        llList.insertFirst(new Person("Janusz", "Kowalski", 33));
        llList.insertFirst(new Person("Kazimierz", "Nowak", 22));
        llList.insertFirst(new Person("Władysława", "Kozioł", 42));
        llList.insertFirst(new Person("Paweł", "Wąs", 19));
        System.out.println(llList.getFirst());
        System.out.println(llList.getLast());
        System.out.println(llList.deleteLast());
        System.out.println(llList.getLast());
        llList.print();
    }
}
