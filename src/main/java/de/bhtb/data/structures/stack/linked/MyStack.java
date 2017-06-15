package de.bhtb.data.structures.stack.linked;

/**
 * Created by visenger on 14.06.17.
 */
public class MyStack<E> implements IStack<E> {
    private Node<E> top;
    private int size;

    public MyStack() {
        this.top = null;
        this.size = 0;
    }


    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void push(E element) {
        Node<E> node = new Node<>(element, top);
        this.top = node;
        size++;
    }

    @Override
    public E pop() {
        E result = null;

        if (!isEmpty()) {
            result = top.getInfo();
            this.top = top.getNext();
            size--;
        }

        return result;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return top.getInfo();
    }

    @Override
    public int size() {
        return this.size;
    }
}
