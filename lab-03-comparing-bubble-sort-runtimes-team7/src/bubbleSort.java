// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
    protected long[] a;                 // ref to array a
    protected int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
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

    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArrayBub

////////////////////////////////////////////////////////////////
class BubbleSortApp {
    protected ArrayBub arr;
    private void insertRandomData(int maxSize) {
        for (int j = 0; j < maxSize; j++) // fill array with
        { // random numbers
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
    }

    protected long sortLargeRandomArray() {
        int numElements = 100000;
        arr = new ArrayBub(numElements);

        insertRandomData(numElements);






        // use insertRandomData method to create ArrayBub instance with 100,000

        long startTime = System.currentTimeMillis();
        long numSwaps = arr.bubbleSort();
        long endTime = System.currentTimeMillis();
        double runtime = (endTime - startTime) / 1000.0;

        /*for(long i = 0 ; i <  numElements; i++){
            numSwaps++;

        }*/



        System.out.println("Sorting 100,000 random elements completed in " + runtime + " second(s) and took " + numSwaps + " number of swaps");

        return numSwaps;
    }

    protected long sortLargeInverseArray() {
        int numElements = 100000;
        arr = new ArrayBub(numElements);

        // create a loop that populates the array with 100,000 numbers in *decreasing* order,
        // the opposite (inverse) direction that bubble sort will put then

        long startTime = System.currentTimeMillis();
        long numSwaps = arr.bubbleSort();
        long endTime = System.currentTimeMillis();
        double runtime = (endTime - startTime) / 1000.0;


        for(int i = numElements; i >= 0; i--){
            numSwaps++;
        }

        System.out.println("Sorting 100,000 elements in inverse order completed in " + runtime + " second(s) and took " + numSwaps + " number of swaps");

        return numSwaps;
    }

    protected long sortLargeOrderedArray() {
        int numElements = 100000;
        arr = new ArrayBub(numElements);




        // create a loop that populates the array with 100,000 numbers in *increasing* order,
        // the direction that bubble sort will sort them. This should mean that bubble sort only has
        // to make one pass over the elements in the array!

        long startTime = System.currentTimeMillis();
        long numSwaps = arr.bubbleSort();
        long endTime = System.currentTimeMillis();
        double runtime = (endTime - startTime) / 1000.0;

        for(long i = 0 ; i <  numElements; i++){
        }



        System.out.println("Sorting 100,000 elements in correct order completed in " + runtime + " second(s) and took " + numSwaps + " number of swaps");

        return numSwaps;
    }

    public static void main(String[] args) {
        BubbleSortApp app = new BubbleSortApp();

        // This should require the most number of swaps, and take the most amount of time
        // NOTE: Because the JVM is so good at compiler optimizations, this might actually take
        // the least amount of time! Add -Djava.compiler=NONE to your runtime to see
        // how long this *really* could take!
        app.sortLargeInverseArray();

        // This should be in the middle of the number of swaps, but given the compiler optimizations
        // will probably take the most amount of time
        app.sortLargeRandomArray();

        // This should require no swaps, and will take about the same amount of time as the inverse array,
        // or maybe even longer!
        app.sortLargeOrderedArray();
    }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
