/*  Author:
    Jimmy Hoang
    I certify that the code below is of my own work.
    with exceptions from code obtained by "A Practical Introduction to Data
     Structures and Algorithm Analysis, 3rd Edition (Java)"
     by Clifford A. Shaffer
 */
import java.util.*;
/*
TODO
Use the given code from book on the 8 algorithms
Compare the running time and test programs on
Exchange sorts (Insert, Selection, Bubble)
QuickSort
Quicksort improved
shellsort powers of 2 and 3
heapsort
mergesort
improved mergesort
radixsort
 */


public class SortingTest {
    static Scanner scan = new Scanner(System.in);
    static int MAXSTACKSIZE = 1000;
    public static void main(String args[]){



    }//endmain
//Exchange Sorts methods

    //Bubble Sort

    //Selection Sort

    //Insertion sort
    static <E extends Comparable<? super E>>
    void inssort(E[] A, int start, int len) {
        for (int i=start+1; i<start+len; i++)        // Insert i'th record
            for (int j=i; (j>start) &&
                    (A[j].compareTo(A[j-1])<0); j--)
                DSutil.swap(A, j, j-1);
    }

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
        if ((k-start) > 1) {
            qsort(A, start, k-1);   // Sort left partition
        }
        if ((end-k) > 1) {
            qsort(A, k+1, end);   // Sort right partition
        }
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

//Quicksort Improved
static int THRESHOLD = 0;
static <E extends Comparable<? super E>>
void qsort(E[] A, int oi, int oj) {
    int[] Stack = new int[MAXSTACKSIZE]; // Stack for array bounds
    int listsize = oj-oi+1;
    int top = -1;
    E pivot;
    int pivotindex, l, r;

    Stack[++top] = oi;  // Initialize stack
    Stack[++top] = oj;

    while (top > 0) {   // While there are unprocessed subarrays
        // Pop Stack
        int j = Stack[top--];
        int i = Stack[top--];

        // Findpivot
        pivotindex = (i+j)/2;
        pivot = A[pivotindex];
        DSutil.swap(A, pivotindex, j); // Stick pivot at end

        // Partition
        l = i-1;
        r = j;
        do {
            while (A[++l].compareTo(pivot)<0);
            while ((r!=0) && (A[--r].compareTo(pivot)>0));
            DSutil.swap(A, l, r);
        } while (l < r);
        DSutil.swap(A, l, r);  // Undo final swap
        DSutil.swap(A, l, j);  // Put pivot value in place

        // Put new subarrays onto Stack if they are small
        if ((l-i) > THRESHOLD) {   // Left partition
            Stack[++top] = i;
            Stack[++top] = l-1;
        }
        if ((j-l) > THRESHOLD) {   // Right partition
            Stack[++top] = l+1;
            Stack[++top] = j;
        }
    }
    inssort(A);             // Final Insertion Sort
}
//end quicksort Improved

//Shellsort
    //powers of 2
    //powers of 3
//end Shell

//Heapsort
static <E extends Comparable<? super E>>
void heapsort(E[] A) {
    // The heap constructor invokes the buildheap method
    MaxHeap<E> H = new MaxHeap<E>(A, A.length, A.length);
    for (int i=0; i<A.length; i++)  // Now sort
        H.removemax(); // Removemax places max at end of heap
}

//end heapsort

//MergeSort
static <E extends Comparable<? super E>>
void mergesort(E[] A, E[] temp, int l, int r) {
    int mid = (l+r)/2;                // Select midpoint
    if (l == r) return;               // List has one element
    mergesort(A, temp, l, mid);   // Mergesort first half
    mergesort(A, temp, mid+1, r); // Mergesort second half
    for (int i=l; i<=r; i++)          // Copy subarray to temp
        temp[i] = A[i];
    // Do the merge operation back to A
    int i1 = l; int i2 = mid + 1;
    for (int curr=l; curr<=r; curr++) {
        if (i1 == mid+1)              // Left sublist exhausted
            A[curr] = temp[i2++];
        else if (i2 > r)              // Right sublist exhausted
            A[curr] = temp[i1++];
        else if (temp[i1].compareTo(temp[i2])<0) // Get smaller
            A[curr] = temp[i1++];
        else A[curr] = temp[i2++];
    }
}
//end msort

//MergesortImproved
static <E extends Comparable<? super E>>
void mergesort(E[] A, E[] temp, int l, int r) {
    int i, j, k, mid = (l+r)/2;  // Select the midpoint
    if (l == r) return;          // List has one element
    if ((mid-l) >= THRESHOLD) mergesort(A, temp, l, mid);
    else inssort(A, l, mid-l+1);
    if ((r-mid) > THRESHOLD) mergesort(A, temp, mid+1, r);
    else inssort(A, mid+1, r-mid);
    // Do the merge operation.  First, copy 2 halves to temp.
    for (i=l; i<=mid; i++) temp[i] = A[i];
    for (j=1; j<=r-mid; j++) temp[r-j+1] = A[j+mid];
    // Merge sublists back to array
    for (i=l,j=r,k=l; k<=r; k++)
        if (temp[i].compareTo(temp[j])<0) A[k] = temp[i++];
        else A[k] = temp[j--];
}
//end msort Improved

//RadixSort
static void radix(Integer[] A, Integer[] B,
                  int k, int r, int[] count) {
    // Count[i] stores number of records in bin[i]
    int i, j, rtok;

    for (i=0, rtok=1; i<k; i++, rtok*=r) { // For k digits
        for (j=0; j<r; j++) count[j] = 0;    // Initialize count

        // Count the number of records for each bin on this pass
        for (j=0; j<A.length; j++) count[(A[j]/rtok)%r]++;

        // count[j] will be index in B for last slot of bin j.
        for (j=1; j<r; j++) count[j] = count[j-1] + count[j];

        // Put records into bins, working from bottom of bin
        // Since bins fill from bottom, j counts downwards
        for (j=A.length-1; j>=0; j--)
            B[--count[(A[j]/rtok)%r]] = A[j];

        for (j=0; j<A.length; j++) A[j] = B[j]; // Copy B back
    }
}
//end Radix


}
