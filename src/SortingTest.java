/*  Author:
    Jimmy Hoang
    I certify that the code below is of my own work.
 */
import java.util.*;
/*
TODO
Use the given code from book on the 8 algorithms
Compare the running time and test programs on
Exchange sorts (Insert, Selection, Bubble no need for )
 */


public class SortingTest {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]){



    }
//Exchange Sorts methods

    //Bubble Sort

    //Selection Sort

    //Insertion sort


//Quicksort
     /**
     Source code example for "A Practical Introduction to Data
     Structures and Algorithm Analysis, 3rd Edition (Java)"
     by Clifford A. Shaffer
     Copyright 2008-2011 by Clifford A. Shaffer
     */
    static <E extends Comparable<? super E>>
    void qsort(E[] A, int start, int end) {      // Quicksort
        int pivotindex = findpivot(A, start, end); // Pick a pivot
        DSutil.swap(A, pivotindex, end);       // Stick pivot at end
        // k will be the first position in the right subarray
        int k = partition(A, start-1, end, A[end]);
        DSutil.swap(A, k, end);              // Put pivot in place
        if ((k-start) > 1) qsort(A, start, k-1);   // Sort left partition
        if ((end-k) > 1) qsort(A, k+1, end);   // Sort right partition
    }
    static <E extends Comparable<? super E>>
    int partition(E[] A, int l, int r, E pivot) {
        do {                 // Move bounds inward until they meet
            while (A[++l].compareTo(pivot)<0);
            while ((r!=0) && (A[--r].compareTo(pivot)>0));
            DSutil.swap(A, l, r);       // Swap out-of-place values
        } while (l < r);              // Stop when they cross
        DSutil.swap(A, l, r);         // Reverse last, wasted swap
        return l;      // Return first position in right partition
    }
    static <E extends Comparable<? super E>>
        int findpivot(E[] A, int i, int j)
        { return (i+j)/2; }
//end quicksort

}
