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
        int n1 = 100,n2=10000,n3= 100000;
        //at least 3 different list sizes
        int[] staticArray = new int[n3];
        generateRandomArray(staticArray);
        int[] a1=new int[n1],a2=new int [n2],a3=new int [n3];
        copyArray(staticArray,a1,a2,a3);
        System.out.println("All algorithms sorting this Array");
        printArray(staticArray);
        System.out.println("Using Sizes n1: "+n1+", n2: "+n2+", n3: "+n3);
//bubblesort
        long startTime = System.nanoTime();
        System.out.println("starting bubble sort \nsort on n1");
        bubblesort(a1);
        long endTime = System.nanoTime();
        double elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.println("sort on n2");
        bubblesort(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.println("sort on n3");
        bubblesort(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        //elapsed time in ms
        //reset array to original

//selectsort
        copyArray(staticArray,a1,a2,a3);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.println("Selection sort \nsort on n1");
        selectsort(a1);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.println("sort on n2");
        selectsort(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.println("sort on n3");
        selectsort(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");


//insertSort
        copyArray(staticArray,a1,a2,a3);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.println("Insertion sort \nsort on n1");
        insSort(a1);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.println("sort on n2");
        insSort(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.println("sort on n3");
        insSort(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

    }//endmain
//generating random list
    static void generateRandomArray(int[] a){
        Random rand = new Random();
        for (int i= 0;i<a.length;i++){
            a[i] = rand.nextInt(10000);
        }
    }
//this is used so that all of the sorts sort the same array
    static void copyArray(int[] copy, int []a1, int a2[],int[]a3){
        for(int i=0; i< copy.length;i++){
            if(i< a1.length){
                a1[i]=copy[i];
            }
            if(i< a2.length){
                a2[i]=copy[i];
            }
            if(i< a3.length){
                a3[i]=copy[i];
            }
        }
    }
    static void printArray(int[] a){
        for(int i = 0; i < a.length;i++){
            System.out.print(" "+ a[i]);
        }
        System.out.println();
    }
//Exchange Sorts methods

    //Bubble Sort
    static void bubblesort(int[] A) {
        for (int i=A.length-1; i>0; i--) // Bubble up i’th record
            for (int j=0; j<i; j++)
                if (A[j]>(A[j+1])){
                    DSutil.swap(A, j, j + 1);
                 }
    }

    //Selection Sort
    static void selectsort(int[] A) {
        for (int i=0; i<A.length-1; i++) { // Select i’th record
            int lowindex = i; // Remember its index
            for (int j=A.length-1; j>i; j--) // Find the least value
                if (A[j]<(A[lowindex]))
                    lowindex = j; // Put it in place
            DSutil.swap(A, i, lowindex);
        }
    }

    //Insertion sort
    static void insSort(int[] array) {
        int i;
        int key;

        for (int j = 1; j < array.length; j++) {
            key = array[ j ];
            i = j - 1;

            while ((i >= 0) && (array[ i ] > key)) {
                array[ i + 1 ] = array[ i ];
                i--;
            }

            array[ i + 1 ] = key;
        }
    }
/*
//Quicksort
     /**
     Source code example for "A Practical Introduction to Data
     Structures and Algorithm Analysis, 3rd Edition (Java)"
     by Clifford A. Shaffer
     Copyright 2008-2011 by Clifford A. Shaffer
     */

    /*
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
    void Sort(E[] A) {
        for (int i=A.length/2; i>2; i/=2) // For each increment
            for (int j=0; j<i; j++)         // Sort each sublist
                inssort2(A, j, i);
        inssort2(A, 0, 1);     // Could call regular inssort here
    }

        //Modified Insertion Sort for varying increments
        static <E extends Comparable<? super E>>
        void inssort2(E[] A, int start, int incr) {
            for (int i=start+incr; i<A.length; i+=incr)
                for (int j=i; (j>=incr)&&
                        (A[j].compareTo(A[j-incr])<0); j-=incr)
                    DSutil.swap(A, j, j-incr);
        }

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
}*/
//end Radix


}
