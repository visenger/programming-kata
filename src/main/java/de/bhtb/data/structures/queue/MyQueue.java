package de.bhtb.data.structures.queue;

/**
 * Created by visenger on 15.06.17.
 */
public class MyQueue<T> implements IQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    @Override
    public void enqueue(T item) {
        QueueNode<T> oldLast = this.last; //the last node becomes oldLast
        this.last = new QueueNode<>(item); //the last node gets new item
        this.last.next = null; //the last node points to nowhere

        if (isEmpty()) this.first = this.last; //in case the queue is empty, the first becomes the first
        else oldLast.next = this.last; //the old last now points to the newly added node
    }

    @Override
    public T dequeue() {

        T data = this.first.data;
        QueueNode<T> newFirst = this.first.next;
        this.first = newFirst;

        if (isEmpty()) this.last = null;

        return data;
    }


    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
