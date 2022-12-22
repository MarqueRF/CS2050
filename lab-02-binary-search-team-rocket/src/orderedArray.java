import org.junit.jupiter.api.Assertions;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {
   protected long[] a;                 // ref to array a
   protected int nElems;               // number of data items

   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
   {
      a = new long[max];             // create array
      nElems = 0;
   }

   //-----------------------------------------------------------
   public int size() {
      return nElems;
   }

   //-----------------------------------------------------------
//   public long[] merge(long[] array1, long[] array2) {
//      int a1 = array1.length;
//      int a2 = array2.length;
//
//   long array3 [] =  new long [a1 + a2];
//      for (int i = 0; i < a1; i++){
//         array3[i] =  array1[i];
//      }
//      for (int i = 0; i < a2; i++){
//         array3[i + a1] =  array2[i];
//      }
//      return array3;
//   }
   public long[] merge(long[] array1, long[] array2){
      int n1 = array1.length;
      int n2 = array2.length;
      long[] array3 = new long [(int) (n1 +n2)];
      int i = 0, j = 0, k = 0, x;

         for (x = 0; x < n2; x++)
            while(i < n1 && j < n2){
               if (array1[i] < array2[j])
                   array3[k++] = array1[i++];
               else  array3[k++] = array2[j++];
            }
         while (i < n1){
            array3[k++] = array1[i++];
         }
         while (j < n2){
            array3[k++] = array2[j++];
         }
         return array3;
   }

      // This method needs to combine array1 and array2, preserving order of the arrays
      // The return value will be a new array with values merged from array1 and array2
      // You have to be able to handle arrays of different sizes! array1 and array2 may not be the same length
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()

   public int findInsertPoint(long searchKey)
   {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn = 0;

      while(true)
      {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound) {
            return lowerBound;
         } else                          // divide range
         {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
         }  // end else divide range
      }  // end while
   }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int curln = findInsertPoint(value);
      for(int k=nElems; k>curln; k--)
                        // move bigger ones up
         a[k] = a[k-1];
      a[curln] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   }  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again
      }  // end main()
   }  // end class OrderedApp
