package com.pearson;

public class Stack<T extends Comparable<T>> extends DoubleEndedLinkedList<T> {
    public void push(T data) {
        super.insertFirst(data);
    }

    public T pop() {
        return super.deleteFirst();
    }

    public T peek() {
        return super.peekFirst();
    }
}
