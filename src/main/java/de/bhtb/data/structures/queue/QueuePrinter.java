package de.bhtb.data.structures.queue;

/**
 * Created by visenger on 15.06.17.
 */
public class QueuePrinter {

    public static void main(String... args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("a - first");
        myQueue.enqueue("b - second");
        myQueue.enqueue("c - third");
        myQueue.enqueue("d - fourth");

        printQueue(myQueue);
    }

    private static void printQueue(MyQueue<String> myQueue) {
        if (myQueue.isEmpty()) {

        } else {
            String elementFromQueue = myQueue.dequeue();
            System.out.println("element = " + elementFromQueue);
            printQueue(myQueue);
        }
    }
}
