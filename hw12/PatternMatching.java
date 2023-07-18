import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class PatternMatching {
    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     *
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     *
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     *
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return           List containing the starting index for each match found.
     */
    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int m = pattern.length();
        int n = text.length();
        if(m > n){ return new ArrayList<>();}
        Map<Character,Integer> last = buildLastTable(pattern);
        List<Integer> iList = new ArrayList<>();
        int i = 0;
        while(i <= (n-m)){
            int j = m-1;
            while(j>=0 && comparator.compare(text.charAt(i+j),pattern.charAt(j))==0){
                j = j-1;
            }
            if(j == -1){
                    iList.add(i);
                    i = i +1;
            }else{
                    int shift = last.getOrDefault(text.charAt(i+j),-1);
                    if(shift<j){
                        i = i+j-shift;
                    }else{
                        i = i+ 1;
                    }
                }
        }
        return iList;
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. pattern = octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int m = pattern.length();
        Map<Character,Integer> last = new HashMap<>();
        for(int i = 0; i < m;i++){
            last.put(pattern.charAt(i),i);
        }
        return last;
    }

    //KMP failure table
//    private static List<Integer> KMPFailureTable(CharSequence pattern, CharacterComparator comparator) {
//        int m = pattern.length();
//        List<Integer> failureTable = new ArrayList<>();
//        int i = 0;
//        int j = 1;
//        failureTable.add(0,0);
//        while(j< m){
//            if(comparator.compare(pattern.charAt(i),pattern.charAt(j))==0){
//                failureTable.add(j,i+1);
//                i++;
//                j++;
//            }else if(comparator.compare(pattern.charAt(i),pattern.charAt(j))!=0 && i==0){
//                failureTable.add(j,0);
//                j++;
//            }else{
//                i = failureTable.get(i - 1);
//            }
//        }
//        return failureTable;
//
//    }
//    public static List<Integer> kMp(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
//        int m = pattern.length();
//        int n = text.length();
//        if(m > n){ return new ArrayList<>();}
//        List<Integer> failureT = KMPFailureTable(pattern,comparator);
//        List<Integer> kList = new ArrayList<>();
//        int j = 0;
//        int k = 0;
//        while(k<n){
//            if(comparator.compare(pattern.charAt(j),text.charAt(k))==0){
//                if(j == m-1){
//                    kList.add(k);
//                }else{
//                    j++;
//                }
//                k++;
//            }else if(comparator.compare(pattern.charAt(j),text.charAt(k))!=0 && j==0){
//                k++;
//            }else{
//                j = failureT.get(j-1);
//            }
//        }
//        return kList;
//    }

//        private static int powerBase(int base, int num){
//        int i = 1;
//        while(num>0){
//            i = i * base;
//            num--;
//        }
//        return i;
//        }
}