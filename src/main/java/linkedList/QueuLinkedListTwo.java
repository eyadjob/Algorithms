package linkedList;

public class QueuLinkedListTwo<T> {

   private Nod first;
    private Nod last;
    private int N;
    private T item;



    public T dequeue() {

        Nod newFirst = first;


        if ( !isEmpty()) {
            T item = (T) first.item;
            first = first.next;
            N--;
            return item;
        } else {
            first =last  = null;
        return null;}

    }

    public void enqueue(T item) {

        Nod oldLast = last;
        last = new Nod();
        last.next = null;
        last.item = item;
        if ( isEmpty()) { first = last;} else { oldLast.next = last;}
        N++;
    }


    public boolean isEmpty() { return N==0?Boolean.TRUE:Boolean.FALSE; }



    public int getSize() {

        return N;
    }



}
