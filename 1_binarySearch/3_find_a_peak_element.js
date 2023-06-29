// 3. Find a peak element - https://www.scaler.com/academy/mentee-dashboard/class/30364/assignment/problems/4132/?navref=cl_pb_nv_tb
/* 
*** Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

1. It is guaranteed that the array contains only a single peak element.
2. Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

*** Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 109

*** Input Format
The only argument given is the integer array A.

*** Output Format
Return the peak element.

*** Example Input

Input 1:
A = [1, 2, 3, 4, 5]

Input 2:
A = [5, 17, 100, 11]

*** Example Output
Output 1: 5
Output 2: 100

*** Example Explanation

Explanation 1: 
5 is the peak.

Explanation 2: 
100 is the peak.

*/

module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {

        let n = A.length;

        if (n === 1) {
            return A[0];
        }

        // It is a smart way of checking if the peak element lies at first or last index or not
        if (A[0] > A[1]) return A[0];
        if (A[n - 1] >= A[n - 2]) return A[n - 1];

        let start = 1;
        let end = n - 2;

        while (start <= end) {

            let mid = Math.floor(start + ((end - start) / 2));

            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return A[mid];
            }
            else if (mid - 1 >= 0 && A[mid] < A[mid - 1]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }

        }

        return -1;

    }
};
