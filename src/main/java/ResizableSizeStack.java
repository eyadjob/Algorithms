import lombok.ToString;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

@ToString
public class ResizableSizeStack<T> implements Iterable<T> {

    private String c;
    private T[] stack =(T[]) new Object[1];
    private int N = 0;

    public ResizableSizeStack(int cap) {
        N = 0;
        stack = (T[]) new Object[cap];
    }

    public long getSize() {
        return N;
    }

    public void push(T s) {
        if (N == stack.length) {
            resize(stack.length * 2);
        }
        stack[N++] = s;

    }

    public T pop() {

        T item = stack[--N];
        stack[N] = null;
        if (N > 0 && N == stack.length / 4)
            resize(stack.length / 2);
        return item;
    }

    private void resize(int max) {

        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = stack[i];
        stack = temp;
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<T>   {

         private int i = N;
         public boolean hasNext()
         {  return i > 0;   }
         public    T next()
         {  return stack[--i];  }
         public    void remove()  {
         }   }

}
