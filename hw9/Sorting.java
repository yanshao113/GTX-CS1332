import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int stopIndex = arr.length-1;
        while(stopIndex != 0){
            int idx = 0;
            int lastSwap = 0;
            while(idx < stopIndex){
                if(comparator.compare(arr[idx],arr[idx+1])>0){
                    swaP(arr,idx,idx+1);
                    lastSwap = idx;
                }
                idx++;
            }
            stopIndex = lastSwap;
        }
    }
    private static <T> void swaP(T[] arr,int a, int b){
        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b]=tmp;
    }
//    optimization1
//    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
//        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
//        int stopIndex = arr.length-1;
//        boolean swapsMade = true;
//        while(stopIndex != 0 && swapsMade){
//            swapsMade = false;
//            int idx = 0;
//            while(idx < stopIndex){
//                if(comparator.compare(arr[idx],arr[idx+1])>0){
//                    swaP(arr,idx,idx+1);
//                    swapsMade = true;
//                }
//                idx++;
//            }
//            stopIndex--;
//        }
//    }


    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for(int stopIndex = arr.length-1; stopIndex > 0; stopIndex--){
            int idxMax = 0;
            for(int i =1; i<= stopIndex;i++){
                if(comparator.compare(arr[i],arr[idxMax])>0){
                    idxMax = i;
                }
            }
            swaP(arr,idxMax,stopIndex);
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for(int i = 1; i < arr.length;i++){
            int presortedIdx = i;
            while(presortedIdx>0 && comparator.compare(arr[presortedIdx],arr[presortedIdx-1])<0){
                swaP(arr,presortedIdx,presortedIdx-1);
                presortedIdx--;
            }
        }
    }
//    public static <T> void cocktail(T[] arr, Comparator<T> comparator){
//        boolean swapsMade = true;
//        int startInd = 0;
//        int endInd = arr.length-1;
//        while(swapsMade){
//            swapsMade = false;
//            for(int i = startInd; i <= endInd; i++){
//                if(comparator.compare(arr[i],arr[i+1])>0){
//                    swaP(arr,i,i+1);
//                    swapsMade = true;
//                    endInd = i;
//                }
//            }
//            if (swapsMade){
//                swapsMade = false;
//                for(int j = endInd; j >= startInd; j--){
//                    if(comparator.compare(arr[j-1],arr[j])>0){
//                        swaP(arr,j-1,j);
//                        swapsMade = true;
//                        startInd = j;
//                    }
//                }
//            }
//        }
//    }
}
