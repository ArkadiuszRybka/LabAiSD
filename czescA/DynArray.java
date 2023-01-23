package czescA;

public class DynArray {
    private Student[] table;
    private int nElem;

    public DynArray(int maxSize){
        table = new Student[maxSize];
        nElem=0;
    }
    public int size(){
        return nElem;
    }
    public Student get(int index){
        return table[index];
    }
    public void add(Student value){
        if(nElem>=table.length){
            Student[] locTable = new Student[table.length*2];
            for(int i=0;i< table.length;i++) locTable[i]=table[i];
            table=locTable;
        }
        table[nElem]=value;
        nElem++;
    }
    public boolean remove(int index){
        if(nElem==0 || index<0 || index>nElem) return false;
        for(int i=index;i<nElem-1;i++) table[i]=table[i+1];
        nElem--;
        return true;
    }
    public int find(Student searchElem){
        for(int i=0;i<nElem;i++)
            if(table[i].equals(searchElem)) return i;
        return -1;
    }
    public void print(){
        for(int i=0;i<nElem;i++)
            System.out.println(get(i).toString()+"\n");
    }

    public static void main(String[] args)
    {
        int maxSize = 1;
        DynArray array = new DynArray(maxSize);

        Student s1;
        s1 = new Student("Ola", "Nowak", 12345);
        array.add(s1);

        Student s2= new Student("Ola2", "Nowak2", 123456);
        array.add(s2);

        Student s3 = new Student();
        s3.setImie("Ala");
        s3.setNazwisko("AAAA");
        s3.setAlbum(6543);
        array.add(s3);

        array.add(new Student("Olek", "Tolek", 6789754));

        array.print();

        System.out.println(array.find(s3));
        System.out.println(array.find(s2));
        System.out.println(array.find(new Student("Ola2", "Nowak2", 123456)));
        Student s5 = s2;
        System.out.println(array.find(s5));


    }
}
