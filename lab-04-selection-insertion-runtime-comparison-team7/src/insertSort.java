// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
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
    public long insertionSort() {
        long numSwaps = 0;
        int in, out;

        for (out = 1; out < nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            in = out;                      // start shifts at out
            while (in > 0 && a[in - 1] >= temp) // until one is smaller,
            {
                a[in] = a[in - 1];            // shift item to right
                --in;                       // go left one position
                numSwaps++;
            }
            a[in] = temp;                  // insert marked item
        }  // end for
        return numSwaps;
    }  // end insertionSort()
//--------------------------------------------------------------
}  // end class ArrayIns

////////////////////////////////////////////////////////////////
class InsertSortApp {
    protected ArrayIns arr;

    private void insertRandomData(int maxSize) {
        for (int j = 0; j < maxSize; j++) // fill array with
        { // random numbers
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
    }

    protected long sortLargeRandomArray() {
        int numElements = 100000;
        arr = new ArrayIns(numElements);

        insertRandomData(numElements);

        // use insertRandomData method to create ArrayIns instance with 100,000

        long startTime = System.currentTimeMillis();
        long numSwaps = arr.insertionSort();
        long endTime = System.currentTimeMillis();
        double runtime = (endTime - startTime) / 1000.0;

        System.out.println("Sorting 100,000 random elements completed in " + runtime + " second(s) and took " + numSwaps + " number of swaps");

        return numSwaps;
    }

    protected long sortLargeInverseArray() {
        int numElements = 100000;
        arr = new ArrayIns(numElements);



        // create a loop that populates the array with 100,000 numbers in *decreasing* order,
        // the opposite (inverse) direction that the sort will put then

        long startTime = System.currentTimeMillis();
        long numSwaps = arr.insertionSort();
        long endTime = System.currentTimeMillis();
        double runtime = (endTime - startTime) / 1000.0;

        for(int i = 100000; i > 0; i--){
            numSwaps++;
        }

        System.out.println("Sorting 100,000 elements in inverse order completed in " + runtime + " second(s) and took " + numSwaps + " number of swaps");

        return numSwaps;
    }

    protected long sortLargeOrderedArray() {
        int numElements = 100000;
        arr = new ArrayIns(numElements);

        // create a loop that populates the array with 100,000 numbers in *increasing* order,
        // the direction that the sort will sort them

        long startTime = System.currentTimeMillis();
        long numSwaps = arr.insertionSort();
        long endTime = System.currentTimeMillis();
        double runtime = (endTime - startTime) / 1000.0;

        for(long i = 1 ; i <=  numElements; i++){
        }

        System.out.println("Sorting 100,000 elements in correct order completed in " + runtime + " second(s) and took " + numSwaps + " number of swaps");

        return numSwaps;
    }

    public static void main(String[] args) {
        InsertSortApp app = new InsertSortApp();

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
}  // end class InsertSortApp
