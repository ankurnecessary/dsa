// Kth smallest element in an unsorted array - https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

/**
Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Note :-  l and r denotes the starting and ending index of the array.

*** Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.

*** Example 2:

Input:
N = 5
arr[] = 7 10 4 20 15
K = 4
Output : 15
Explanation :
4th smallest element in the given 
array is 15.

*** Your Task:
You don't have to read input or print anything. Your task is to complete the function kthSmallest() which takes the array arr[], integers l and r denoting the starting and ending index of the array and an integer K as input and returns the Kth smallest element.
 
 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(log(n))

*** Constraints:
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

 */

import java.io.*;
import java.util.*;

class Solution {

  public static int kthSmallest(int[] arr, int l, int r, int k) {
    int min = getMin(arr);
    int max = getMax(arr);

    while (min <= max) {
      int mid = min + ((max - min) / 2);
      int isKthSmallest = isMidKthSmallest(arr, k, mid);

      if (isKthSmallest == 1) {
        return mid;
      } else if (isKthSmallest == 0) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    return -1;
  }

  private static int isMidKthSmallest(int[] arr, int k, int mid) {
    // 0 - If mid < kth smallest element
    // 1 - If mid == kth smallest element
    // 2 - If mid > kth smallest element

    int count = 0;
    int max = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] <= mid) {
        count++;
        max = Math.max(max, arr[i]);
      }
    }

    if (count == k && max == mid) {
      return 1;
    } else if (count < k) {
      return 0;
    } else {
      return 2;
    }
  }

  private static int getMax(int[] arr) {
    int max = -1;

    for (int integer : arr) {
      max = Math.max(max, integer);
    }

    return max;
  }

  private static int getMin(int[] arr) {
    int min = Integer.MAX_VALUE;

    for (int integer : arr) {
      min = Math.min(min, integer);
    }

    return min;
  }
}
