package czescC;

public class Sort {
    private int [] table;
    private int nElems;

    public Sort(int maxSize)
    {
        table = new int[maxSize];
        nElems = 0;
    }


    public void add(int value)
    {
        if (nElems >= table.length)
        {
            int [] locTable = new int[table.length*2];
            for (int i=0; i<table.length; i++) locTable[i]=table[i];
            table = locTable;
        }

        table[nElems] = value;
        nElems++;
    }

    public int get(int index)
    {
        return table[index];
    }

    public int size()
    {
        return nElems;
    }

    public boolean remove(int index)
    {
        if (nElems==0) return false;
        for (int j = index; j < nElems-1; j++)
        {
            table[j] = table[j + 1];
        }
        nElems--;
        return true;
    }

    public int find(int searchElem)
    {
        for (int j = 0; j < nElems; j++)
        {
            if (table[j] == searchElem) return j;
        }
        return -1;
    }

    public void selectionSort()
    {
        for (int i = 0; i < nElems - 1; i++)
        {
            int minPos = i;
            for (int j = i + 1; j < nElems; j++)
            {
                if (table[j] < table[minPos])
                {
                    minPos = j;
                }
            }
            swap(i, minPos);
        }
    }
    private void swap(int one, int two)
    {
        int temp = table[one];
        table[one] = table[two];
        table[two] = temp;
    }

    public void print()
    {
        for (int i = 0; i < nElems; i++)
        {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int maxSize = 2;

        Sort array = new Sort(maxSize); 	// tworzymy tablice

        //15 22 13 27 12 10 20 25 - dane dla metod sortowania
        array.add(15);
        array.add(22);
        array.add(13);
        array.add(27);
        array.add(12);
        array.add(10);
        array.add(20);
        array.add(25);
        array.print();

        array.selectionSort();


        array.print();

    }
}
