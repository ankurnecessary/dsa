// Binary Search won't give an optimized answer to this problem but we have various ways of reaching to the solution. So, it is a good problem.
// Kth smallest price - https://www.scaler.com/academy/mentee-dashboard/class/30365/homework/problems/872?navref=cl_tt_nv
// IMPORTANT - https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/

/*
Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

NOTE: You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.

*** Example:
A : [2 1 4 3 2]
k : 3

Answer : 2

*** Constraints :
1 <= number of elements in the price list <= 1000000
1 <= k <= number of elements in the price list

*/

import java.util.*;

class Main {

  public static void main(String[] args) {
    // List<Integer> A = Arrays.asList(94,87,100,11,23,98,17,35,43,66,34,53,72,80,5,34,64,71,9,16,41,66,96); // 87
    // int k = 19;

    List<Integer> A = Arrays.asList(2, 1, 4, 3, 2);
    int k = 3;
    System.out.println(solve(A, k));
  }

  public static int solve(final List<Integer> A, int B) {
    // Fetching minimum and maximum values in array to run binary search on
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int a : A) { // TC - O(n)
      if (a < min) {
        min = a;
      }
      if (a > max) {
        max = a;
      }
    }

    // Binary search
    while (min < max) {
      int mid = min + ((max - min) / 2);
      int eleCount = smallerOrEqualCount(A, mid); // TC - O(n)
      if (eleCount <= B - 1) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }

    return min;
  }

  private static int smallerOrEqualCount(List<Integer> A, int num) {
    int count = 0;

    for (Integer integer : A) {
      if (integer <= num) {
        count++;
      }
    }

    return count;
  }
}
