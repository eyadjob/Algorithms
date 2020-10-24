package oldstudy.linkedList;

public class StackUsingLinkedList<T>{

    private T item;
    private Nod[] nod =null;
    private Nod first;
    private int N = 0;


    public void push(T item) {

        Nod oldFirst = first;
        first = new Nod();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public boolean isEmpty() { return N==0?Boolean.TRUE:Boolean.FALSE;}

    public T popup() {

        if ( first != null ) {
            T item = (T) first.item;
            first = first.next;
            N--;
            return item;
        }

        return null;

    }

    public int getSize() { return N;}




}
