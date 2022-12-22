import java.util.Arrays;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayOddEven {
    protected long[] a;                 // ref to array a
    protected int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayOddEven(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public long bubbleSort() {
        long numSwaps = 0;
        int out, in;

        for (out = nElems - 1; out > 1; out--)   // outer loop (backward)
            for (in = 0; in < out; in++)        // inner loop (forward)
                if (a[in] > a[in + 1]) {       // out of order?
                    swap(in, in + 1);          // swap them
                    numSwaps++;
                }

        return numSwaps;
    }  // end bubbleSort()

    public void oddEvenSort() {
        long numSwaps = 0;
        int out, in;

        //int odd = 0;
        //int even = nElems - 1;

        //while (true) {
           // while (a[odd] % 2 != 0 && odd < even) odd++;
            //while (a[even] % 2 == 0 && odd < even) even--;

            //if (odd < even); //swap(odd, even)
            //else break;




        for (out = nElems - 1; out > 1; out--)   // outer loop (backward)
            for (in = 1; in < out; in = in+2)
               for(in = 0; in < out; in++)                               // inner loop (forward)
                if (a[in] > a[in + 1]) {       // out of order?
                    swap(in, in + 1);

                }

    }
                    // TODO implement odd-even sort
      // end oddEvenSort()

    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArrayBub

////////////////////////////////////////////////////////////////
class OddEvenSortApp {
    protected ArrayOddEven arr;

    private void insertRandomData(int maxSize) {
        arr = new ArrayOddEven(maxSize);
        for (int j = 0; j < maxSize; j++) // fill array with
        { // random numbers
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
    }

    public static void main(String[] args) {
        OddEvenSortApp app = new OddEvenSortApp();

        app.insertRandomData(15);
        long[] randomData = Arrays.copyOf(app.arr.a, app.arr.a.length);

        System.out.println("Bubble sort:");
        app.arr.display();
        app.arr.bubbleSort();
        app.arr.display();

        System.out.println("Odd-Even sort:");
        app.arr.a = randomData;
        app.arr.display();
        app.arr.oddEvenSort();
        app.arr.display();
    }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
