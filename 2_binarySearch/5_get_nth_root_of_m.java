// Get nth root of m - https://practice.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m

/*
You are given 2 numbers (n , m); the task is to find n√m (nth root of m).

*** Example 1:
Input: n = 2, m = 9
Output: 3
Explanation: 32 = 9

*** Example 2:
Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not
integer.

*** Constraints:
1 <= n <= 30
1 <= m <= 109

*/

class Solution {

  public int NthRoot(int n, int m) {
    // code here
    int min = 1;
    int max = m;

    while (min <= max) {
      int mid = min + ((max - min) / 2);
      int root = getNthRoot(mid, n, m);

      if (root == 1) {
        return mid;
      } else if (root == 2) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    return -1;
  }

  private int getNthRoot(int mid, int n, int m) {
    // answer > m, return 2;
    // answer < m, return 0;
    // answer == m, return 1;

    long answer = 1;

    while (n != 0) {
      answer *= mid;
      n--;

      if (answer > m) {
        return 2;
      }
    }

    if (answer < m) return 0;

    return 1;
  }
}
