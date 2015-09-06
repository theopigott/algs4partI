# Union-Find (UF)
Set of N points, with links between them. Can join two points (`union`) or check if there is a path joining two points (`conncted`).

## Quick-Find
Store IDs in an array id[N]. Points conncted if they have the same id.

## Quick-Union
Store IDs in an array. id[i] = j means that parent of i is j. If id[i] = i then i is a root. i and j are connected if they have the same root.

### Weighted
Store size (number of nodes or height of tree) of each root's tree in separate array. When joining two nodes, make the larger one the parent. This reduces the tree heights, increasing efficiency. Maximum tree height is log_2(N).

### Path compression
When finding root, update all nodes passed through to point to the root, flattening out tree.
Or, more simply, update every other node to point to its grandparent, havling tree size.

## Applications
* Percolation
* Dynamic connectivity

# Analysis of Algorithms

## Scientific method
* Observe
* Hypothesize
* Predict
* Verify
* Validate

Experiments should be *reproducible* and hypotheses should be *falsifiable*.

## Empirical analysis
Time manually, or use Java `Stopwatch` class.
Double input size, measure running time. Plot log-log graph. Use regression to fit straight line, log(T) = log(a) + b log(N), gives T = a N^b.
Or, find log-ratio of time for doubling input size. Log-ratio tends to constant b, running time is roughly a N^b. To find a, run program with large input and solve.
N.B. cannot identify logarithmic factors with this method.

## Mathematical models
### Cost model
Total running time = sum of cost x freq for all operations
Only count most expensive operations.

### Tilde notation
$f(N) \sim g(N)$ if $\lim_{N \to \infty} \frac{f(N)}{g(N)} = 1$.

### Estimating discrete sum
Use integrals, e.g.

* $\sum_{i = 1}^{N} i \sim \int_{x=1}^{N} x dx \sim \frac{1}{2} N^2$
* $\sum_{i = 1}^{N} \frac{1}{i} \sim \int_{x=1}^{N} \frac{1}{x} dx = \ln{N}$

## Order-of-growth
Discard leading coefficient
Functions usually 1, log N, N, N log N, N^2, N^3, 2^N

e.g. 3 sum problem (find number of triples summing to zero)
Naive approach has order N^3. Improved algorithm has order N^2 log(N):
* Sort (e.g. insertion sort, order N^2)
* For each pair (i, j) do binary search (order log(N)) for (-i - j).

## Types of analyses
* Best case (easiest input) - provides goal
* Worst case (most difficult input) - provides guarantee
* Average case (random input) - provides prediction

## Notation
* Big Theta - asymptotic order of growth
* Big Oh - upper bounds
* Big Omega - lower bounds

## Memory
### Space
* Bit. 0 or 1.
* Byte. 8 bits.
* Megabyte (MB). 2^20 bytes (~ 1 million bytes).
* Gigabyte (GB). 2^30 bytes (~ 1 billion bytes).

Modern machine - 64-bit memory, 8-bit pointers.

#### Primitives
* boolean - 1 byte
* byte - 1 byte
* char - 2 bytes
* int - 4 bytes
* float - 4 bytes
* long - 8 bytes
* double - 8 bytes

1D primitive array - 24 + N*(memory usage of primitive)

#### Objects
* Overhead - 16 bytes
* Reference (to another object) - 8 bytes
* Padding - round up to multiple of 8 bytes
