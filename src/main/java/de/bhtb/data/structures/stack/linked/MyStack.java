package de.bhtb.data.structures.stack.linked;


public interface MyStack<E> {
    boolean isEmpty();

    void push(E element);

    E pop();

    E top();

    int size();
}

