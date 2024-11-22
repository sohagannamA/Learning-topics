/*
    Find the minimum sum of a subarray.
    You are given an array and an integer k. Find a contiguous subarray of length k whose sum is the minimum.

    Example: Input: [2, 1, 5, 1, 3, 2], k = 3
    Output: 6 (because the sum of the subarray [1, 3, 2] is the minimum) 
 
 */

package SlidingWindow.basic;

public class SubArrayMinSum {
    public static int helper(int myarray[], int k) {
        int min = 0;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += myarray[i];
        }
        min = sum;
        for (int i = k; i < myarray.length; i++) {
            sum = sum - myarray[left] + myarray[i];
            min = Math.min(sum, min);
            left++;
        }
        return min;
    }

    public static void main(String[] args) {
        int myarray[] = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        System.out.println(helper(myarray, k));
    }
}
