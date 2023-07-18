import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     * <p>
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     * <p>
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     * <p>
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     * <p>
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        //partitioning
        if (arr.length <= 1) {
            return;
        }
        int length = arr.length;
        int midIndex = length / 2;
        T[] arrLeft = arraySplit(arr, 0, midIndex - 1);
        T[] arrRight = arraySplit(arr, midIndex, length - 1);
        mergeSort(arrLeft, comparator);
        mergeSort(arrRight, comparator);
        mergeHelper(arrLeft, arrRight, arr, comparator);
    }

    private static <T> void mergeHelper(T[] arrayLeft, T[] arrayRight, T[] array, Comparator<T> comparator) {
        int i = 0;
        int j = 0;
        while (i < arrayLeft.length && j < arrayRight.length) {
            if (comparator.compare(arrayLeft[i], arrayRight[j]) <= 0) {
                array[i + j] = arrayLeft[i];
                i++;
            } else {
                array[i + j] = arrayRight[j];
                j++;
            }
        }
        while (i < arrayLeft.length) {
            array[i + j] = arrayLeft[i];
            i++;
        }
        while (j < arrayRight.length) {
            array[i + j] = arrayRight[j];
            j++;
        }
    }

    private static <T> T[] arraySplit(T[] array, int startIndex, int endIndex) {
        T[] newArray = (T[]) new Object[endIndex - startIndex + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[startIndex + i];
        }
        return newArray;
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     * <p>
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     * <p>
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     * <p>
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     * <p>
     * Do NOT use anything from the Math class except Math.abs().
     * <p>
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Queue<Integer>[] buckets = new LinkedList[19];
        for (int i = 0; i < 19; i++) {
            buckets[i] = new LinkedList<>();
        }
        int k = calculateK(arr);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length; j++) {
                int index = currentIndex(arr[j],i) % 10;
                buckets[index+9].add(arr[j]);
            }
            int idx = 0;
            for(Queue<Integer> bucket: buckets){
                while(!bucket.isEmpty()){
                    arr[idx++]=bucket.poll();
                }
            }
        }


    }
    private static int currentIndex(int value, int iteration){
        if(value == -2147483648){
            return -8;
        }
        int di = 1;
        while(iteration != 0){
                di = di * 10;
                iteration--;
            }
        return value/di;
    }

    private static int calculateK(int[] arr) {
        int k = 0;
        int numMax = Math.abs(arr[0]);
        if(numMax == -2147483648){
            return 10;
        }
        for (int num = 1; num < arr.length; num++) {
            if(arr[num]==-2147483648){
                return 10;
            }
            if (Math.abs(arr[num]) > numMax) {
                numMax = Math.abs(arr[num]);
            }
        }

        while (numMax > 0) {
            numMax = numMax / 10;
            k++;
        }
        return k;
    }


}






