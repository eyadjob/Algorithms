package linkedList;

import java.util.Iterator;

public class TestingClass {


    public static void main(String[] args) {
        StackUsingLinkedList<String> test = new StackUsingLinkedList<>();

        System.out.println(test.getSize());
        test.push("Ward");
        System.out.println(test.getSize());
        test.push("Otoum");
        System.out.println(test.getSize());
        System.out.println(test.popup());
        System.out.println(test.getSize());
        System.out.println(test.popup());
        System.out.println(test.popup());


        System.out.println();
        System.out.println();
        System.out.println("Queue");

        QueuLinkedListTwo<String> queueLinkedList = new QueuLinkedListTwo();
        System.out.println(queueLinkedList.getSize());
        queueLinkedList.enqueue("first");
        System.out.println(queueLinkedList.getSize());
        queueLinkedList.enqueue("second");
        System.out.println(queueLinkedList.getSize());
        System.out.println(queueLinkedList.dequeue());
        System.out.println(queueLinkedList.getSize());
        System.out.println(queueLinkedList.dequeue());
        System.out.println(queueLinkedList.getSize());
        System.out.println(queueLinkedList.dequeue());
        System.out.println(queueLinkedList.getSize());

        System.out.println();
        System.out.println();
        Bag<String> bag = new Bag();
        bag.add("first");
        bag.add("second");
        Iterator<String> bagiterator = bag.iterator();
        while ( bagiterator.hasNext()) {
            System.out.println(bagiterator.next());
        }

    }
}
