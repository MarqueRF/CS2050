class StackX {
    private Deque deque;
    private int nItems;
    private int maxSize;
    private long[] stackXArray;
    private int top;




    public StackX(int s)         // constructor
    {
        deque = new Deque(s);
        maxSize = s;
        stackXArray = new long[maxSize];
        top = -1;
    }

    public void push(long j)    // put item on top of stack
    {
        stackXArray[++top] =j;


        // TODO implement
    }

    public long pop()           // take item from top of stack
    {
        return stackXArray[top--];


    }

    public boolean isEmpty()    // true if stack is empty
    {
        {
            return (top == -1);
        }
        // TODO implement
    }

    public boolean isFull()     // true if stack is full
    {
        return (top == maxSize-1);
    }
}

