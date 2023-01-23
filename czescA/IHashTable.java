package czescA;

import java.util.LinkedList;

public class IHashTable {
    private LinkedList[] hashArray;    // tablica mieszajaca
    private int arraySize; //rozmiar tablicy mieszajacej

    public IHashTable(int size)       // konstruktor
    {
        arraySize = size;
        hashArray = new LinkedList[size];

        for (int i=0; i<size; i++) //Utworzenie pustych list na kazdym miejscu w tablicy mieszajacej
        {
            hashArray[i] = new LinkedList();
        }
    }

    public LinkedList getLinkedList(int index) //Zwrocenie listy o podanym numerze z tablicy mieszajacej
    {
        return hashArray[index];
    }

    public int size() //Zwrocenie rozmiaru tablicy mieszajacej
    {
        return arraySize;
    }

    private int hashFunc(int elem) // funkcja mieszajaca
    {
        return elem % arraySize;
    }

    public void insert(int data)  // wstaw element do tablicy mieszajacej
    {
        int hashVal = hashFunc(data);   // oblicz indeks
        if (!hashArray[hashVal].contains(data)) //Sprawdz czy element jest juz na liscie
        {
            hashArray[hashVal].addFirst(data); // wstaw na liste na pozycji hashVal
        }
    }

    public void delete(int elem)       // usuń element z tablicy mieszajacej
    {
        int hashVal = hashFunc(elem);   // oblicz indeks
        hashArray[hashVal].remove((Object)elem); // usuń element listy
    }

    public boolean find(int elem)   // sprawdz czy element jest w tablicy mieszajacej
    {
        int hashVal = hashFunc(elem);   // oblicz indeks
        return hashArray[hashVal].contains(elem);
    }

    public static void main(String[] args) //test tablicy mieszjacej
    {

        IHashTable hashTable = new IHashTable(10);

        hashTable.insert(1);
        hashTable.insert(11);
        hashTable.insert(2);
        hashTable.insert(32);
        hashTable.insert(42);
        hashTable.insert(3);
        hashTable.insert(33);
        hashTable.insert(4);

        //hashTable.print();

        boolean result1 = hashTable.find(3);
        System.out.println("Wynik wyszukiwania 3:"+result1);

        hashTable.delete(3);

        //hashTable.print();

        boolean result2 = hashTable.find(3);
        System.out.println("Wynik wyszukiwania 3:"+result2);

    }
}
