package czescA;

public class DoublyLinkedList {
    private DListElem first;
    private DListElem last;

    public DoublyLinkedList(){
        first=null;
        last =null;
    }
    public boolean isEmpty(){
        return (first==null);
    }
    public void insertFirst(int value){
        DListElem newElem= new DListElem(value);

        if(isEmpty()) last=newElem;
        else first.previous=newElem;

        newElem.next=first;
        first=newElem;
    }

    public void insertLast(int value){
        DListElem newElem = new DListElem(value);

        if(isEmpty()) first=newElem;
        else {
            last.next=newElem;
            newElem.previous=newElem;
        }
        last = newElem;
    }

    public DListElem deleteFirst(){
        if(isEmpty()) return null;

        DListElem temp = first;
        if(first.next==null) last=null;
        else first.next.previous=null;
        first=first.next;
        return temp;
    }

    public DListElem deleteLast(){
        if(isEmpty()) return null;
        DListElem temp=last;
        if(first.next==null) first=null;
        else last.previous.next = null;
        last=last.previous;
        return temp;
    }

    public void print(){
        DListElem current=first;
        while(current!=null){
            System.out.println(current.toString()+ " ");
            current=current.next;
        }
    }

    public static void main(String[] args)
    {
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.print();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.print();

        theList.deleteLast();

        theList.print();

    }
}
