package czescA;

public class OrdDynArray {
    private Person[] table;
    private int nElem;

    public OrdDynArray(int maxSize){
        table = new Person[maxSize];
        nElem=0;
    }
    public int size(){
        return nElem;
    }
    public Person get(int index){
        return table[index];
    }

    public void add(Person value){
        if(nElem>= table.length){
            Person[] locTable= new Person[table.length*2];
            for(int i=0;i<nElem;i++) locTable[i]=table[i];
            table=locTable;
        }
        int j;
        for(j=0;j<nElem;j++)
            if(table[j].compareTo(value)>0) break;

        for(int k=nElem;k>j;k--) table[k]=table[k-1];
        table[j]=value;
        nElem++;
    }

    public int find(Person searchElem){
        for(int i=0;i<nElem;i++)
            if(table[i].compareTo(searchElem)==0) return i;
        return -1;
    }

    public boolean remove(int index){
        if(nElem==0 || index<0 || index>nElem) return false;
        for(int i=index;i<nElem-1;i++) table[i]=table[i+1];
        nElem--;
        return true;
    }
    public void print(){
        for(int i=0;i<nElem;i++) System.out.println(get(i).toString()+"\n");
    }

    public static void main(String[] args)
    {
        int maxSize = 3;
        OrdDynArray array = new OrdDynArray(maxSize);

        array.add(new Person("Ola", "Ząb", 58)); // 15
        array.add(new Person("Ola", "Olczyk", 58)); // 14
        array.add(new Person("Ala", "Olczyk", 58)); // 13
        array.add(new Person("Ola", "Ząb", 18)); // 5
        array.add(new Person("Ola", "Olczyk", 18)); // 4

        array.print();

        array.remove(1);
        array.print();

        array.add(new Person("Lolek", "Las", 18));
        Person p2 = new Person("Ala", "Alowska", 44);
        array.add(p2);
        Person p3 = new Person("Ala", "Alowiak", 44);
        array.add(p3);
        array.print();


        int find = array.find(p2);
        System.out.println(""+find);

        int find2 = array.find(new Person("Ula", "Alowska", 44));
        System.out.println(""+find2);

        int find3 = array.find(new Person("Lolek", "Las", 18));
        System.out.println(""+find3);

    }


}
