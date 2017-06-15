package de.bhtb.data.structures.stack.linked;


public interface IStack<E> {
    boolean isEmpty();

    void push(E element);

    E pop();

    E top();

    int size();
}

