package edu.msudenver;

import com.pearson.Queue;

import java.util.ArrayList;
import java.util.Random;

public class RadixSort {
    private ArrayList<Queue<Integer>> sortLists;

    public RadixSort() {
        // 10 queues, one for each base 10 value
        sortLists = new ArrayList<>(10);
        for(int i = 0; i < 10; i++) {
            sortLists.add(new Queue<>());
        }
    }

    public int getNumDigits(int number) {
        // This method should return the number of digits in a given number
        // For example, 1 has 1 digit, 10 has 2 digits..
        return (int) (Math.log10(number) + 1);



    }



    }

    public int getMaxNumDigits(int[] array) {
        // This method should return the maximum number of digits in the array
        int max = 0;
        for(int i = 0; i < array.length; i++) {
            if(getNumDigits(array[i]) > max) {
                max = getNumDigits(array[i]);
            }
        }

        return max;
    }

    }

    public int getSpecificDigit(int number, int position) {
        // This method should take a given number
        // and return the specified digit (0's, 10s, 100s, etc.)

        // If the position requested is a larger digit than the number contains,
        // return 0

        // TODO implement
        return -1;
    }

    public void sort(int[] arrayToSort) {
        // This method should sort the given array using Radix Sort



        // You will need to use all the helper methods above to implement the sort

        // TODO implement
    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] toSort = new int[100];
        for(int i = 0; i < 100; i++) toSort[i] = random.nextInt(Integer.MAX_VALUE);

        System.out.println("Before sort:");
        for(int current : toSort) {
            System.out.print(current + ", ");
        }

        RadixSort radixSort = new RadixSort();
        radixSort.sort(toSort);

        System.out.println("After sort:");
        for(int current : toSort) {
            System.out.print(current + ", ");
        }
    }
}
