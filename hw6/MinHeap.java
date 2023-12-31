import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {throw new IllegalArgumentException();}
        if (size == backingArray.length - 1) {
            reSize(backingArray.length*2);
        }
        backingArray[size + 1] = data;
        size++;
        upHeap(size);
    }
    private void reSize(int newCapacity){
        T[] newBackArray = (T[]) new Comparable[newCapacity];
        for(int i= 1; i < backingArray.length; i++){
            newBackArray[i] = backingArray[i];
        }
        backingArray = newBackArray;
    }
    private void upHeap(int size) {
        for (int i = size; i > 1; i = i / 2) {
            if (backingArray[i].compareTo(backingArray[i / 2]) < 0) {
                swaP(i/2,i);
            }else {
                return;
            }
        }
    }


    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size ==0){ throw new NoSuchElementException();}
        T data = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] =null;
        size--;
        for(int i = 2; i <= size; i= i*2){
            if(i == size){
                if(backingArray[i].compareTo(backingArray[i/2])<0){
                    swaP(i/2,i);
                }
            }else {
                if (backingArray[i].compareTo(backingArray[i + 1]) < 0 && backingArray[i].compareTo(backingArray[i/2])<0) {
                    swaP(i/2,i);
                }else if(backingArray[i+1].compareTo(backingArray[i]) < 0 && backingArray[i+1].compareTo(backingArray[i/2])<0) {
                    swaP(i/2,i+1);
                    i = i + 1;
                }
            }
        }
        return data;
    }
    private void swaP(int parent, int children){
        T tmp = backingArray[parent];
        backingArray[parent] = backingArray[children];
        backingArray[children] = tmp;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}