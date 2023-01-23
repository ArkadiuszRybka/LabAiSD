package czescB;

import java.util.ArrayList;

public class ArrayListList {
    private ArrayList<Person> alList;
    ArrayListList()//konstruktor
    {
        alList = new ArrayList<Person>();
    }
    public boolean addLast(Person p)//dodawanie
    {
        return alList.add(p);
    }
    public Person removeLast()//usuwanie
    {
        return alList.remove(alList.size() - 1);
    }
    public Person get(int index)//pobieranie
    {
        return alList.get(index);
    }
    public Person find(Person p)//szukanie
    {
        for(int i = 0; i < alList.size(); i++)
        {
            if(alList.get(i).getImie().equals(p.getImie())
                    && alList.get(i).getNazwisko().equals(p.getNazwisko())
                    && alList.get(i).getWiek() == p.getWiek()) return alList.get(i);
        }
        return null;
    }
    public int size()
    {
        return alList.size();
    }//size
    public void print()//wypisywanie wszystkiego
    {
        for(int i = 0; i < alList.size(); i++)
        {
            System.out.println(alList.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayListList alList = new ArrayListList();
        alList.addLast(new Person("Jacek", "Murański", 66));
        alList.addLast(new Person("Mateusz", "Nowak", 55));
        alList.addLast(new Person("Michał", "Baron", 44));
        alList.addLast(new Person("Julia", "Najman", 33));
        alList.addLast(new Person("Maria", "Kowalski", 22));
        alList.print();
        System.out.println(alList.size());
        System.out.println(alList.get(4));
        System.out.println(alList.find(new Person("Jacek", "Murański", 66)));
        //System.out.println(alList.find(new Person("Jacek", "Muranski", 66)));
    }
}
