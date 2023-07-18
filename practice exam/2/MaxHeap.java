/**
 * Your implementation of a MaxHeap.
 */
public class MaxHeap<T extends Comparable<? super T>> {

    /*
     * The initial capacity of the MaxHeap when created with the default
     * constructor.
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
     * This is the constructor that constructs a new MaxHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MaxHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Removes and returns the max item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * You may assume that the heap is not empty.
     *
     * @return The data that was removed.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T data = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        for(int i = 2; i <= size; i = i*2){
            if(backingArray[i+1] != null){
                if(backingArray[i].compareTo(backingArray[i+1])>0){
                    if(backingArray[i].compareTo(backingArray[i/2])>0){
                        T tmp = backingArray[i/2];
                        backingArray[i/2] =backingArray[i];
                        backingArray[i] = tmp;
                    }else{
                        break;
                    }
                }else{
                    if(backingArray[i+1].compareTo(backingArray[i/2])>0){
                        T tmp = backingArray[i/2];
                        backingArray[i/2] =backingArray[i+1];
                        backingArray[i+1] = tmp;
                        i = i +1;
                    }
                    else{
                        break;
                    }
                }
            }else{
                if(backingArray[i].compareTo(backingArray[i/2])>0){
                    T tmp = backingArray[i/2];
                    backingArray[i/2] =backingArray[i];
                    backingArray[i] = tmp;
                }
            }


        }
        return data;
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