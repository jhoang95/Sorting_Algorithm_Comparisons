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

//committing to origin/master
public class SortingTest {
    static Scanner scan = new Scanner(System.in);

    public static void main(String args[]){
        int n1 = 100,n2=10000,n3= 100000,n4=1000000,n5=10000000;
        //at least 3 different list sizes
        int[] staticArray = new int[n5];
        generateRandomArray(staticArray);
        int[] a1=new int[n1],a2=new int [n2],a3=new int [n3],a4=new int[n4],a5=new int[n5];
        copyArray(staticArray,a1,a2,a3,a4,a5);
        System.out.println("All algorithms sorting the same Array at different sizes");
       // printArray(staticArray);
        System.out.println("Using Sizes n1: "+n1+", n2: "+n2+", n3: "+n3+", n4: "+n4+", n5: "+n5);

//bubblesort
        System.out.println("=========================================");
        long startTime = System.nanoTime();
        System.out.print("Bubble sort \nsort on n1: ");
        bubblesort(a1);
        long endTime = System.nanoTime();
        double elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        bubblesort(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        bubblesort(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        //elapsed time in ms
        //reset array to original

//selectsort
        copyArray(staticArray,a1,a2,a3,a4,a5);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Selection sort \nsort on n1: ");
        selectsort(a1);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        selectsort(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        selectsort(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");


//insertSort
        copyArray(staticArray,a1,a2,a3,a4,a5);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Insertion sort \nsort on n1: ");
        insSort(a1);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        insSort(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        insSort(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

//quicksort
        copyArray(staticArray,a1,a2,a3,a4,a5);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Quick sort \nsort on n1: ");
        qsort(a1,0,(a1.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        qsort(a2,0,(a2.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        qsort(a3,0,(a3.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        qsort(a4,0,(a4.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n5: ");
        qsort(a5,0,(a5.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

//Quicksort Optimized
        copyArray(staticArray,a1,a2,a3,a4,a5);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Quick sort Optimized \nsort on n1: ");
        qsortOp(a1,0,(a1.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        qsortOp(a2,0,(a2.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        qsortOp(a3,0,(a3.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        qsortOp(a4,0,(a4.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        startTime = System.nanoTime();
        System.out.print("sort on n5: ");
        qsortOp(a5,0,(a5.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
//shellsort
        copyArray(staticArray,a1,a2,a3,a4,a5);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Shell Sort powers of 2 \nsort on n1: ");
        shellSort(a1);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        shellSort(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        shellSort(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        shellSort(a4);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n5: ");
        shellSort(a5);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
//Shellsort powers of 3
        copyArray(staticArray,a1,a2,a3,a4,a5);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Shell Sort powers of 3 \nsort on n1: ");
        shellSort3(a1);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        shellSort3(a2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        shellSort3(a3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        shellSort3(a4);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n5: ");
        shellSort3(a5);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

//heapsort
        copyArray(staticArray,a1,a2,a3,a4,a5);
        Integer[] b1=intToInteger(a1),b2=intToInteger(a2),b3=intToInteger(a3),b4=intToInteger(a4),b5=intToInteger(a5);
        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Heap Sort \nsort on n1: ");
        heapsort(b1);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        heapsort(b2);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        heapsort(b3);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        heapsort(b4);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n5: ");
        heapsort(b5);
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

//mergesort
        copyArray(staticArray,a1,a2,a3,a4,a5);
        b1=intToInteger(a1);b2=intToInteger(a2);b3=intToInteger(a3);b4=intToInteger(a4);b5=intToInteger(a5);
        Integer[] c1=intToInteger(a1),c2=intToInteger(a2),c3=intToInteger(a3),c4=intToInteger(a4),c5=intToInteger(a5);

        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Merge sort \nsort on n1: ");
        mergesort(b1,c1,0,(b1.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        mergesort(b2,c2,0,(b2.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        mergesort(b3,c3,0,(b3.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        mergesort(b4,c4,0,(b4.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        mergesort(b5,c5,0,(b5.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

//mergesort O
        copyArray(staticArray,a1,a2,a3,a4,a5);
        b1=intToInteger(a1);b2=intToInteger(a2);b3=intToInteger(a3);b4=intToInteger(a4);b5=intToInteger(a5);
        c1=intToInteger(a1);c2=intToInteger(a2);c3=intToInteger(a3);c4=intToInteger(a4);c5=intToInteger(a5);

        System.out.println("=========================================");
        startTime = System.nanoTime();
        System.out.print("Merge sort Optimized\nsort on n1: ");
        mergesortO(b1,c1,0,(b1.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n2: ");
        mergesortO(b2,c2,0,(b2.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n3: ");
        mergesortO(b3,c3,0,(b3.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        mergesortO(b4,c4,0,(b4.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");

        startTime = System.nanoTime();
        System.out.print("sort on n4: ");
        mergesortO(b5,c5,0,(b5.length-1));
        endTime = System.nanoTime();
        elapsedtime=(endTime-startTime)/Math.pow(10, 6);
        System.out.println(elapsedtime+" ms");
        System.out.println(b1+" ");

    }//endmain

//BASIC ARRAY METHODS
//generating random list
    static void generateRandomArray(int[] a){
        Random rand = new Random();
        for (int i= 0;i<a.length;i++){
            a[i] = rand.nextInt(200000)-100000;
        }
    }
//this is used so that all of the sorts sort the same array
    static void copyArray(int[] copy, int []a1, int a2[],int[]a3,int[]a4,int[] a5){
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
            if(i< a4.length){
                a4[i]=copy[i];
            }
            if(i< a5.length){
                a5[i]=copy[i];
            }
        }
    }
    static void printArray(int[] a){
        for(int i = 0; i < a.length;i++){
            System.out.print(" "+ a[i]);
        }
        System.out.println();
    }
    static void copyArray(int[] copy,int []a){
        for (int i = 0;i<a.length;i++){
            a[i]=copy[i];
        }
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
//modified slightly for int arrays

    static void qsort(int[] A, int start, int end) {      // Quicksort
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
    static int partition(int[] A, int l, int r, int pivot) {
        do {                 // Move bounds inward until they meet
            while (A[++l]<(pivot));
            while ((r!=0) && (A[--r]>(pivot)));
            DSutil.swap(A, l, r);       // Swap out-of-place values
        } while (l < r);              // Stop when they cross
        DSutil.swap(A, l, r);         // Reverse last, wasted swap
        return l;      // Return first position in right partition
    }
    static int findpivot(int[] A, int i, int j){return (i+j)/2; }
//end quicksort


//Optimized Quicksort
static int THRESHOLD = 0;
static int MAXSTACKSIZE = 1000;
static void qsortOp(int[] A, int oi, int oj) {
    int[] Stack = new int[MAXSTACKSIZE]; // Stack for array bounds
    int listsize = oj-oi+1;
    int top = -1;
    int pivot;
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
            while (A[++l]<(pivot));
            while ((r!=0) && (A[--r]>(pivot)));
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
    insSort(A);             // Final Insertion Sort
}
//end quicksort Improved


//Shellsort
    //powers of 2
    static void shellSort(int[] A) {
        for (int i=A.length/2; i>2; i/=2) // For each increment
            for (int j=0; j<i; j++)         // Sort each sublist
                inssort2(A, j, i);
        inssort2(A, 0, 1);     // Could call regular inssort here
    }

        //Modified Insertion Sort for varying increments
        static void inssort2(int[] A, int start, int incr) {
            for (int i=start+incr; i<A.length; i+=incr)
                for (int j=i; (j>=incr)&&(A[j]<(A[j-incr])); j-=incr)
                    DSutil.swap(A, j, j-incr);
        }

    //powers of 3
    static void shellSort3(int[] A) {
        for (int i=A.length/3; i>3; i/=3) // For each increment
            for (int j=0; j<i; j++)         // Sort each sublist
                inssort2(A, j, i);
        inssort2(A, 0, 1);     // Could call regular inssort here
    }
//end Shell


//Heapsort
static Integer[] intToInteger(int[] A){
        Integer[] temp = new Integer[A.length];
        for(int i=0; i <A.length;i++){
            temp[i]= A[i];
        }
        return temp;
    }
static void heapsort(Integer[] A) {
    // The heap constructor invokes the buildheap method
    MaxHeap<Integer> H = new MaxHeap<Integer>(A, A.length, A.length);
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
void inssort(E[] A, int start, int len) {
    for (int i=start+1; i<start+len; i++)        // Insert i'th record
        for (int j=i; (j>start) &&
                (A[j].compareTo(A[j-1])<0); j--)
            DSutil.swap(A, j, j-1);
}

static <E extends Comparable<? super E>>
void mergesortO(E[] A, E[] temp, int l, int r) {
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
/*
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
