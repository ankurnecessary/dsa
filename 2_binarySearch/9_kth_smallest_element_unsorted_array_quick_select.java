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
    // We can solve this problem via quick select algorithm which uses quick sort algorithm partially
    if (k - 1 > arr.length - 1) return -1;

    int pivotIdx = partition(arr, l, r);

    if (pivotIdx == k - 1) {
      return arr[pivotIdx];
    }

    if (pivotIdx < k - 1) {
      return kthSmallest(arr, pivotIdx + 1, r, k);
    }

    return kthSmallest(arr, l, pivotIdx - 1, k);
  }

  private static int partition(int[] arr, int l, int r) {
    int pivotIdx = r, i = l;

    for (int j = l; j < r; j++) {
      if (arr[j] <= arr[pivotIdx]) {
        swap(arr, i, j);
        i++;
      }
    }

    swap(arr, i, pivotIdx);
    return i;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
