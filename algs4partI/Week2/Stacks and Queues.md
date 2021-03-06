# Overview
* Collection of objects
* Operations: insert, remove, iterate, test if empty

## Terminology
* __Client__: program using operations defined in interface
* __Implementation__: code implementing operations
* __Interface__: description of data type & operations

## Encapsulation
Separate interface and implementation

* __Design__: modular, reusable libraries
* __Performance__: optimised implementation

# Stack
__LIFO__ = "last in first out"

`public class Stack<Item> implements Iterable <Item>`

<table>
    <tr>
        <td></td>
        <td><code>Stack()</code></td>
        <td>create empty stack</td>
    </tr>
    <tr>
        <td><code>void</code></td>
        <td><code>push(Item item)</code></td>
        <td>add item</td>
    </tr>
    <tr>
        <td><code>Item</code></td>
        <td><code>pop()</code></td>
        <td>remove most recently added item</td>
    </tr>
    <tr>
        <td><code>boolean</code></td>
        <td><code>isEmpty()</code></td>
        <td>is stack empty?</td>
    </tr>
    <tr>
        <td><code>int</code></td>
        <td><code>size()</code></td>
        <td>number of items in stack</td>
    </tr>
</table>

## Linked-List implementation
* Define `Node` inner class with 2 attributes: `Item` and pointer to next `Node`
* Stack maintains pointer to first node in linked list and inserts & removes from front.

### Performance
* Every operation takes constant time in worst case.
* A stack with *N* items uses ~ 40 *N* bytes (excluding memory for Items, which client owns).

## Array implementation
* Use array `a[]` to store *N* items on stack.
* `push()` adds new item as `a[N]`
* `pop()` removes item from `s[N-1]`

### Resizing
* __Repeated doubling__: If array full, create new array of twice the size and copy items.
* If array 1/4 empty, create new array of half the size and copy items.

### Performance
* Cost of inserting first *N* items N + (2 + 4 + 6 + ... + N) ~ 3N since there is 1 array access per *push* and *k* array accesses to double to size *k*. Hence *amortised* (averaged) cost is 3.
* Thus amortised cost of push and pop operations is constant time.
* Memory usage: ~ 8 N when full, ~ 32 N when one-quarter full. 

## Comparison
__Linked-list__

* Every operation takes constant time in *worst case*.
* Uses extra time and space to deal with the links.

__Resizing-array implementation__

* Every operation takes constant *amortised* time.
* Less wasted space.

# Queue
__FIFO__ = "first in first out"

`public class Queue<Item> implements Iterable <Item>`

<table>
    <tr>
        <td></td>
        <td><code>Queue()</code></td>
        <td>create empty queue</td>
    </tr>
    <tr>
        <td><code>void</code></td>
        <td><code>enqueue(Item item)</code></td>
        <td>add item</td>
    </tr>
    <tr>
        <td><code>Item</code></td>
        <td><code>dequeue()</code></td>
        <td>remove least recently added item</td>
    </tr>
    <tr>
        <td><code>boolean</code></td>
        <td><code>isEmpty()</code></td>
        <td>is queue empty?</td>
    </tr>
    <tr>
        <td><code>int</code></td>
        <td><code>size()</code></td>
        <td>number of items in queue</td>
    </tr>
</table>

## Linked-List implementation
* Maintain pointer to first and last `Node` in linked list.
* Insert at end, remove from front.

## Array implementation
* Use array `a[]` to store *N* items in queue.
* `enqueue()` adds new item at `a[tail]`.
* `dequeue()` removes item from `a[head]`.
* `head` and `tail` updated modulo *N*.

# Bag
Implement a stack or queue without `pop()` or `dequeue()`!

# Generics
* Avoid implementing separate stack / queue class for each type.
* Avoid casting in client (i.e. don't just implement an array of objects and expect client to cast since this can cause errors at run-time).
* Java doesn't allow generic arrays, so have to cast `(Item[]) new Object[N]`, which will give an *unchecked cast* warning.
* Primitive types have *wrapper* types, and *autoboxing* allows automatic cast between primitive type and its wrapper.

# Iteration
* Need to support iteration over items in stack (or queue) without revealing internal representation of stack.
* In Java, implement `java.lang.Iterable` interface.
* `Iterable` has a method that returns an `Iterator`.
* `Iterator` has methods `hasNext()` and `next()`.
* Allows elegant iteration with *foreach* statement, `for (String s : stack)`.

# Applications
* Java comes with `Collection` implementations but APIs are bloated - e.g. `java.util.Stack` has methods for `get()` and `set()` at arbitrary indices.

## Stack applications
* Function calls in compiler
* Back button in Web browser
* Evaluating infix expressions (e.g. Dijkstra's two-stack algorithm)