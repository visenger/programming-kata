package de.bhtb.data.structures.queue;

/**
 * Created by visenger on 15.06.17.
 */
public interface IQueue<T> {

    void enqueue(T item);

    T dequeue();

    boolean isEmpty();
}
