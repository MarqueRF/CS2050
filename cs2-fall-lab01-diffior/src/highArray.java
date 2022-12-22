// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
    protected long[] a;                 // ref to array a
    protected int nElems;               // number of data items

    //-----------------------------------------------------------
    public HighArray(int max)           // constructor
    {
        a = new long[max];              // create the array
        nElems = 0;                     // no items yet
    }

    //-----------------------------------------------------------
    public int find(long searchKey) {   // find specified value
        int counter = 0;
        int j;

        for (j = 0; j < nElems; j++)    // for each element,
            if (a[j] == searchKey)
                counter++;    // found item?// exit loop before end
        System.out.println ("Number of Duplicates is : " +counter);                // gone to end?
            return counter;                  // yes, can't find it
        //else
            //return 1;                   // no, found it

         //return -1;


    }  // end find()

    //-----------------------------------------------------------
    public void insert(long value)      // put element into array
    {
        a[nElems] = value;              // insert it
        nElems++;                       // increment size
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)    // look for it
            if (value == a[j])
                break;
        if (j == nElems)                // can't find it
            return false;
        else                            // found it
        {
            for (int k = j; k < nElems; k++) // move higher ones down
                a[k] = a[k + 1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()

    //-----------------------------------------------------------
    public void display()               // displays array contents
    {
        for (int j = 0; j < nElems; j++)   // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------
}  // end class HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        arr.insert(35);          // insert 10 items
        arr.insert(35);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        int searchKey = 35;           // search for item
        if (arr.find(searchKey) == 1)
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(00);          // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                // display items again
    }  // end main()
}  // end class HighArrayApp
