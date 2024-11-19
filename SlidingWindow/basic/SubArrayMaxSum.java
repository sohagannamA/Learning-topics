/*
 Given an array of integers and a positive integer `k`, 
 you are required to find the subarray of length `k` such that 
 the sum of the elements in the subarray is maximum.

    Input:
    - An array `arr` of integers.
    - A positive integer `k` representing the length of the subarray.

    Output:
    - The maximum sum of the subarray of length `k`.

    Example:

    **Input**:
    `arr = [1, 3, 2, 5, 7, 2]`, `k = 3`

    **Output**:
    `14` (because the subarray `[5, 7, 2]` has the maximum sum) 
 */
package SlidingWindow.basic;
public class SubArrayMaxSum {
    public static int getMaxSum(int nums[], int k) {
        int max = 0;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        max = sum;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[left]+nums[i];
            max = Math.max(max, sum);
            left++;
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 10, 3, 4, 5 };
        int k = 2;
        System.out.println(getMaxSum(nums,k));
    }
}
