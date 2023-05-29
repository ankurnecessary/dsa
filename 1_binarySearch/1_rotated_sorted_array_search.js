// Rotated Sorted Array Search - https://www.scaler.com/academy/mentee-dashboard/class/30364/assignment/problems/203/?navref=cl_pb_nv_tb
/*

*** Problem Description

Given a sorted array of integers A of size N and an integer B, 
where array A is rotated at some pivot unknown beforehand.

For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.

You can assume that no duplicates exist in the array.

NOTE: You are expected to solve this problem with a time complexity of O(log(N)).

*** Problem Constraints

1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.

*** Input format

The First argument given is the integer array A.
The Second argument given is the integer B.

*** Output format

Return index of B in array A, otherwise return -1

*** Example Input

Input 1
A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4

Input 2
A : [ 9, 10, 3, 5, 6, 8 ]
B : 5

*** Example Output

Output 1
0

Output 2
3

*/

module.exports = {
    //param A : array of integers
    //param B : integer
    //return an integer
    search: function (A, B) {

        let n = A.length;
        let pivot = this.getPivotIndex(A);

        if (B >= A[0] && B <= A[pivot - 1]) {
            return this.binarySearch(A, B, 0, pivot - 1);
        }
        else {
            return this.binarySearch(A, B, pivot, n - 1);
        }

    },
    binarySearch(array, target, start, end) {

        while (start <= end) {

            let mid = Math.floor(start + ((end - start) / 2));

            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }

        }

        return -1;
    },
    getPivotIndex: function (A) {

        let n = A.length;
        let start = 0;
        let end = n - 1;

        while (start <= end) {

            let mid = Math.floor(start + ((end - start) / 2))

            if (A[mid] < A[mid - 1]) {
                return mid;
            }
            else if (A[mid] > A[mid + 1]) {
                return mid + 1;
            }
            else if (A[mid] > A[start]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }

        return -1;

    }
};
