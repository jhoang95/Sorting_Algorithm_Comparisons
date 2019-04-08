# Sorting_Algorithm_Comparisons
Comparing Sorting Algorithms time based off of number in array\n
The goal of this project is to be able to observe and compare the sorting Algorithms given by our textbook.

The objective is to use these sorting algorithms: 

- [x] Exchange Sorts (bubble, Selection, Insertion)

- [x] Quick Sort (Recursive and Optimized versions)

- [x] Shellsort

- [x] Heapsort

- [x] Mergesort(Recursive vs Optimized)

- [x] RadixSort

and compared them based off of a random list filled with n= 100 1000 10,000 100,000 etc. for up to 5 sizes

the sizes I chose were n = 100 10,000 100,000 1,000,000 10,000,000

# Notes of improvement:
* clean up code 
 * separate sort analysis by either different classes or functions rather than constant copy/paste
  


# Sample Output

All algorithms sorting the same Array at different sizes
Using Sizes n1: 100, n2: 10000, n3: 100000, n4: 1000000, n5: 10000000

Bubble sort 
sort on n1: 0.833049 ms
sort on n2: 106.761685 ms
sort on n3: 14190.755493 ms

Selection sort 
sort on n1: 0.14275 ms
sort on n2: 41.217496 ms
sort on n3: 3877.686783 ms
sort on n4: 178037.785049 ms

Insertion sort 
sort on n1: 0.103765 ms
sort on n2: 11.079093 ms
sort on n3: 800.363822 ms
sort on n4: 96089.813138 ms

Quick sort 
sort on n1: 0.063607 ms
sort on n2: 1.450656 ms
sort on n3: 5.513899 ms
sort on n4: 54.544532 ms
sort on n5: 565.834233 ms

Quick sort Optimized 
sort on n1: 0.074746 ms
sort on n2: 3.433618 ms
sort on n3: 7.65925 ms
sort on n4: 58.319344 ms
sort on n5: 659.69713 ms

Shell Sort powers of 2 
sort on n1: 0.08178 ms
sort on n2: 1.704792 ms
sort on n3: 11.364593 ms
sort on n4: 125.554255 ms
sort on n5: 1610.733621 ms

Shell Sort powers of 3 
sort on n1: 0.023743 ms
sort on n2: 0.928021 ms
sort on n3: 11.236499 ms
sort on n4: 120.143536 ms
sort on n5: 1829.345276 ms

Heap Sort 
sort on n1: 1.445966 ms
sort on n2: 4.80865 ms
sort on n3: 38.942291 ms
sort on n4: 418.788642 ms
sort on n5: 6562.268416 ms

Merge sort 
sort on n1: 0.119886 ms
sort on n2: 4.284549 ms
sort on n3: 75.517043 ms
sort on n4: 275.094304 ms
sort on n4: 3510.900436 ms

Merge sort Optimized
sort on n1: 0.043382 ms
sort on n2: 2.04745 ms
sort on n3: 19.117935 ms
sort on n4: 267.985242 ms
sort on n5: 3689.944281 ms

Radix Sort 
sort on n1: 0.099075 ms
sort on n2: 3.397272 ms
sort on n3: 6.485008 ms
sort on n4: 97.673469 ms
sort on n5: 1055.992256 ms

Process finished with exit code 0
