# Overview
**Divide and Conquer**

* Divide array into two halves.
* Recursively sort each half.
* Merge two halves.

i.e. Given sorted subarrays `a[lo]` to `a[mid]` and `a[mid+1]` to `a[hi]`, replace with sorted subarray `a[lo]` to `a[hi]`.

## Assertions
Statements to test assumptions about program: help to detect logic bugs and document code.

Can enable / disable at runtime (-ea or -da).

# Performance
Uses at most N lg(N) compares and 6 N lg(N) array accesses.

Recurrence relations for compares C(N) and array accesses A(N) are

C(N) &le; C(&lceil;N/2&rceil;) + C(&lfloor;N/2&rfloor;) + N

A(N) &le; A(&lceil;N/2&rceil;) + A(&lfloor;N/2&rfloor;) + 6N

for N > 1, with C(1) = A(1) = 0.

# Memory
Uses extra space proportional to N, as `aux[]` must be of size N for the last merge.

## In-place
A sortion algorithm is **in-place** if it uses &le; log(N) extra memory, e.g. insertion sort, selection sort, shellsort. Possible to implement in-place merge (Kronrod, 1969).

# Improvements
* Use insertion sort for small subarrays (mergesort has too much overhead for small arrays), e.g. cutoff to insertion sort for &asymp; 7 items.
* No need to merge if already sorted: if biggest item in 1st half &le; smallest item in second half.
* Eliminate copy to auxiliary array by switching input and auxiliary array in each recursive call.