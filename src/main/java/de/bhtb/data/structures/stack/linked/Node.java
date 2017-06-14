package de.bhtb.data.structures.stack.linked;

public class Node<E> {
    private E info;
    private Node<E> next;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(E info) {
        setInfo(info);
    }

    public Node(E info, Node<E> next) {
        this.info = info;
        this.next = next;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
