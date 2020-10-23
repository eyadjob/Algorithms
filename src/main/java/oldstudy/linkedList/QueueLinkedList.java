package oldstudy.linkedList;

public class QueueLinkedList<T> {

    private Nod first;
    private Nod last;
    private int N = 0;
    private T item;


    public int getSize() {
        return N;
    }


    public boolean isEmpty() {
        return N == 0 ? Boolean.TRUE : Boolean.FALSE;
    }


    public void enqueue(T item) {

        Nod oldLast = last;
        last = new Nod();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;

    }


    public T dequeue() {


        if (!isEmpty()) {
            T item = (T) first.item;
            first = first.next;
            N--;
            return item;

        }else  last = null;



        return null;


    }
}
