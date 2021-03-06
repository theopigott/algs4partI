# Overview
* Want to sort *any* type of data.

## Comparable
* Callback = reference to executable code.
* `sort()` function *calls back* an object's `compareTo()` method.
* `Comparable` interface implements `compareTo()` method.

### `compareTo()`
Returns

* negative integer if v < w
* zero if v = w
* positive integer if v > w

Throws exception if types are incompatible or either is `null`.

Total ordering: relation v ~ w = `v.compareTo(w)` satisfies

* Antisymmetry: if v &le; w and w &le; v then v = w.
* Transitivity: if v &le; w and w &le; x then v &le; x.
* Totality: either v &le; w or w &le; v or both.

## Sorting abstractions
Will use helper functions 

* Less: returns `true` if v is less than w.
* Exchange: swaps items at indices i and j in array.

# Selection Sort
* In iteration *i*, find index *min* of smallest remaining entry, then swap `a[i]` and `a[min]`.

Invariants

* Entries to left of *i* fixed, in ascending order.
* No entry to right of *i* smaller than any entry to left of *i*.

## Performance
* (N - 1) + (N - 2) + ... + 1 + 0 ~ N^2 / 2 compares and N exchanges, independent of input.

# Insertion Sort
* In iteration *i*, swap `a[i]` with each larger entry to its left.

Invariants

* Entries to left of *i* in ascending order.
* Entries to right of *i* not yet seen.

## Performance
* For randomly sorted array uses on average ~ 1/4 N^2 compares and ~ 1/4 N^2 exchanges. (Proof: expect each entry to move halfway back.)
* Best case: if array in ascending order, uses N-1 compares and 0 exchanges.
* Worst case: if array in descending order (no duplicates), uses ~ 1/2 N^2 compares and exchanges.

## Partially sorted arrays
* Inversion: pair of keys that are out of order.
* Partially sorted: number of inversions of array is &le; cN.
* e.g. subarray of size 10 appended to sorted subarray; array of size N with 10 entries out of place.

For *partially-sorted* arrays, insertion sort runs in linear time. 

Proof: # exchanges = # inversions, and # compares = # exchanges + (N - 1).

# Shellsort
* *h-sort* array for decreasing sequence of values of *h*.

## h-sorting
* Insertion sort with stride length *h*.

## Increment sequence
* Optimal sequence unknown.
* 3x + 1: 1, 4, 13, 40, 121, 364, ...  
(Easy to compute.)
* Sedgewick: 1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905  
(Merging of (9 &times; 4^i) - (9 &times; 2^i) + 1 and 4^i - (3 &times; 2^i) + 1)  
(Good in empirical studies.)

## Performance
* Worst-case compares used with 3x + 1 increments is O(N^(3/2)).
* For sorted array, 3x + 1 increments uses linearithmic number of compares (~ N compares used for each of log_3(N) h values).

## Benefits
* Fast unless array size huge.
* Small code footprint - used in embedded systems / hardware.

# Applications of sorting
## Shuffling
* Aim: rearrange array so result is uniformly random permutation.

### Sorting solution
* Generate uniformly random real (between 0 and 1) for each array entry.
* Sort array by this key.

### Knuth shuffle
* In iteration *i*, pick integer *r* between 0 and *i* uniformly at random.
* Swap `a[i]` and `a[r]`.
* (Fisher-Yates 1938) Produces uniformly random permutation of array in linear time.

## Convex hull
* Smallest perimeter fence enclosing a set of N points.
* Specify as sequence of vertices in counterclockwise order.

### Properties
* Can traverse convex hull making only counterclockwise (ccw) turns.
* Vertices of convex hull appear in increasing order of polar angle with respect to point p with lowest y-coordinate.

### Graham scan
* Choose point p with smallest y-coordinate.
* Sort points by polar angle with p.
* Consider points in order, discard unless creates ccw turn.

### CCW
* Is a &rarr; b &rarr; c a counterclockwise turn?
* Determinant (or cross product) gives 2&times; signed area of planar triangle:  
2 &times; Area(a, b, c) = (b.x - a.x)(c.y - a.y) - (b.y - a.y)(c.x - a.x)
* If signed area > 0, counterclockwise.
* If signed area < 0, clockwise.
* If signed area = 0, collinear.