/*
    Given an array of integers and k. Where k means length of subarray
    Like array={1, 1, 2, 3, 4, 5, 2, 2, 1},k=3
    
   
    output:[
        [1, 1, 2], 
        [1, 2, 3], 
        [2, 3, 4], 
        [3, 4, 5], 
        [4, 5, 2], 
        [5, 2, 2], 
        [2, 2, 1]
    ]

     output:[
        [1, 2, 3], 
        [2, 3, 4], 
        [3, 4, 5], 
        [4, 5, 2], 
    ]

    1. Print list view all subarray
    
    2. Print list view all unique subarray where subarray set will be unique

    3. Print out all subarray reverse order
    
    4. Print list view all palindrome subarray

    5. Find out max and min value from each subarray

*/
package SlidingWindow.basic;

import java.util.ArrayList;
import java.util.HashSet;

public class FollowUp {

    // FollowUp-1
    public static void AllSubarray(int myarray[], int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> eachVal = new ArrayList<>();
        if (k < 0 || k > myarray.length) {
            System.out.println("Invalid position");
            return;
        }

        for (int i = 0; i < k; i++) {
            eachVal.add(myarray[i]);
        }
        list.add(new ArrayList<>(eachVal));
        for (int i = k; i < myarray.length; i++) {
            eachVal.remove(0);
            eachVal.add(myarray[i]);
            list.add(new ArrayList<>(eachVal));
        }
        System.out.println(list);
    }

    // FollowUp-2
    public static void printUniqueSubarray(int myarray[], int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> eachList = new ArrayList<>();

        if (k < 0 || k > myarray.length) {
            System.out.println("Invalid position");
            return;
        }

        for (int i = 0; i < k; i++) {
            eachList.add(myarray[i]);
        }

        if (set.add(eachList)) {
            list.add(new ArrayList<>(eachList));
        }

        for (int i = k; i < myarray.length; i++) {
            eachList.remove(0);
            eachList.add(myarray[i]);
            if (set.add(eachList)) {
                list.add(new ArrayList<>(eachList));
            }
        }
        System.out.println(list);
    }

    // FollowUp-03
    public static void reverseAllSubarray(int myarray[], int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = k - 1; i >= 0; i--) {
            list.add(myarray[i]);
        }
        result.add(new ArrayList<>(list));
        for (int i = k; i < myarray.length; i++) {
            list.remove(k - 1);
            list.add(0, myarray[i]);
            result.add(new ArrayList<>(list));
        }
        System.out.println(result);
    }

    // FollowUp-04
    public static void checkPalindrome(int myarray[], int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= myarray.length - k; i++) {
            boolean isPalindrome = true;

            int left = 0;
            int right = k - 1;
            while (left < right) {
                if (myarray[i + left] != myarray[i + right]) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }

            if (isPalindrome) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    list.add(myarray[i + j]);
                }
                result.add(list);
            }
        }
        System.out.println(result);
    }
    
    // FollowUp-05
    public static void findMinAndMax(int myarray[], int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            min = Math.min(min, myarray[i]);
            max = Math.max(max, myarray[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(min);
        list.add(max);
        res.add(new ArrayList<>(list));

        for (int i = k; i < myarray.length; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            int j = i - k + 1;
            while (j <= i) {
                min = Math.min(min, myarray[j]);
                max = Math.max(max, myarray[j]);
                j++;
            }

            list.clear();
            list.add(min);
            list.add(max);
            res.add(new ArrayList<>(list));
        }

        System.out.println(res);
    }

   


    public static void main(String[] args) {
        int myarray[] = { 1, 2, 1, 1, 1, 2, 3, 1, 1, 1 };
        int k = 3;

        AllSubarray(myarray, k);
        findMinAndMax(myarray, k);
        checkPalindrome(myarray, k);
        printUniqueSubarray(myarray, k);
        reverseAllSubarray(myarray, k);
    }
}
