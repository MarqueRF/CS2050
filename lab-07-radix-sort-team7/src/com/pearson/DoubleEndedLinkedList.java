package com.pearson;

public class DoubleEndedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    private Link<T> last;

    @Override
    public void insertFirst(T data)
    {
        super.insertFirst(data);
        if(last == null) {
            last = first;
        }
    }

    @Override
    public T deleteFirst()
    {
        T retVal = super.deleteFirst();
        if(first == null) {
            last = null;
        }
        return retVal;
    }

    public void insertLast(T data) {
        if(last == null) {
            insertFirst(data);
        } else {
            Link newLink = new Link(data);
            last.setNext(newLink);
            last = newLink;
        }
    }

    public T peekLast() {
        return last == null ? null : last.getData();
    }
}
