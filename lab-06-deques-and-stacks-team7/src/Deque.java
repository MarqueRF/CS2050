class Deque {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0; //right -1;
        rear = -1; //left = maxSize;
        nItems = 0;
    }

    public void insertLeft(long j) {
        if(nItems < maxSize){
            front = front+1 % maxSize;
            queArray[front] = j;
            nItems++;
        }/* tried my hand on using modulus
        queArray[--left] = j;
        if(left==0) leftt - maxsize -1;
        nItems++
         */

        // TODO implement
    }

    public void insertRight(long j) {
        if(rear ==maxSize -1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;/*
        right = (right + 1) % maxSize;
        queArray[Right] = j;
        nItems++
          */

        // TODO implement
    }

    public long removeLeft() {
        if (nItems == 0) {
            return 0;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = maxSize - 1;
        } else {
            rear = rear - 1;
        }
        return nItems--;

        /*
        long retVal = queArray[left % maxSize];
         left = (left + 1) % maxSize;
         nItems--;
         return retVal;*/


    }

    public long removeRight() {
        if (nItems == 0) {
            return 0;
        }
        if (front == rear) {
            front = 0;
            rear = 0;
        } else if (rear == 0) {
            front = maxSize - 1;
        } else {
            front = front +1;
        }
        return nItems--;
        /*
        if(right < 0) right = maxSize -1;
        long retVal = queArray[right--]'
        nItems--;
        return retVal;


       */


        // TODO implement

    }

    public boolean isEmpty() {

        return nItems == 0;
    }

    public boolean isFull() {

        return nItems == maxSize;
    }

    public int size() {

        return nItems;
    }

}

//pretty sure I broke something
