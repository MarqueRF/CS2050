package com.pearson;

public class Queue<T extends Comparable<T>> extends DoubleEndedLinkedList<T> {
    public void insert(T data) {
        super.insertLast(data);
    }

    public T remove() {
        return super.deleteFirst();
    }

    public T peek() {
        return super.peekFirst();
    }
}
