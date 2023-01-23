package czescB;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetSet {
    private TreeSet<Integer> treeSet;

    public TreeSetSet()    // konstruktor
    {
        treeSet = new TreeSet<Integer>();
    }

    public TreeSet<Integer> getTreeSet()
    {
        return treeSet;
    }

    public int size() //Zwraca liczbe elementow w zbiorze
    {
        return treeSet.size();
    }

    public void insert(int elem)    // wstawia element do zbioru
    {
        if (!member(elem)) // sprawdza, czy dany element nalezy do zbioru
            treeSet.add(elem);
    }

    public boolean member(int elem)  // sprawdza, czy dany element nalezy do zbioru
    {
        return treeSet.contains(elem);
    }

    public boolean delete(int elem)  // usuwa element ze zbioru
    {
        if (member(elem)) // sprawdza, czy dany element nalezy do zbioru
        {
            treeSet.remove(elem);
            return true;
        }
        else return false;
    }


    public TreeSetSet union(TreeSetSet secondSet) //Oblicza sume zbioru biezacego ze zbiorem z parametru metody
    {
        TreeSetSet unionSet = new TreeSetSet();
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            unionSet.insert(locElem);
        }

        Iterator<Integer> iteratorS = secondSet.getTreeSet().iterator();
        while (iteratorS.hasNext())
        {
            int locElem = iteratorS.next().intValue();
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public TreeSetSet intersection(TreeSetSet secondSet) //Oblicza iloczyn zbioru biezacego ze zbiorem z parametru metody
    {
        TreeSetSet intersectionSet = new TreeSetSet();

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            if (secondSet.member(locElem))
                intersectionSet.insert(locElem);
        }

        return intersectionSet;
    }

    public TreeSetSet difference(TreeSetSet secondSet) //Oblicza roznice zbioru biezacego ze zbiorem z parametru metody
    {
        TreeSetSet differenceSet = new TreeSetSet();

        Iterator<Integer> iterator = treeSet.iterator();

        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            if (!secondSet.member(locElem))
                differenceSet.insert(locElem);
        }

        return differenceSet;
    }

    public void print()
    {
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            System.out.print(locElem+" ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        TreeSetSet theSetA = new TreeSetSet();  // tworzymy nowy zbior A
        theSetA.insert(60);     // dodajemy elementy do zbioru
        theSetA.insert(20);
        theSetA.insert(40);
        theSetA.insert(10); //Dodanie jeszcze dwoch elementow
        theSetA.insert(90);

        System.out.println("--------------------------------------------");

        System.out.println("Zbior A:");
        theSetA.print();

        TreeSetSet theSetB = new TreeSetSet();  // tworzymy nowy zbior B
        theSetB.insert(40);     // dodajemy elementy do zbioru
        theSetB.insert(70);
        theSetB.insert(60);
        theSetB.insert(80);

        System.out.println("Zbior B:");
        theSetB.print();


        TreeSetSet unionSet = theSetA.union(theSetB); //Obliczenie sumy zbiorow
        System.out.println("Suma A i B:");
        unionSet.print();

        TreeSetSet intersectionSet = theSetA.intersection(theSetB); //Obliczenie iloczynu zbiorow
        System.out.println("Iloczyn A i B:");
        intersectionSet.print();

        TreeSetSet differenceSet = theSetA.difference(theSetB); //Obliczenie roznicy zbiorow
        System.out.println("Roznica A-B:");
        differenceSet.print();

    }
}
