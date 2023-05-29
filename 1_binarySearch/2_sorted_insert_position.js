// Sorted Insert Position - https://www.scaler.com/academy/mentee-dashboard/class/30364/assignment/problems/204/?navref=cl_pb_nv_tb
/*

*** Problem Description

You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index where it would be inserted to maintain the sorted order.
Your solution should have a time complexity of O(log(N)).

*** Problem Constraint

1 <= N <= 106

*** Input Format

The first argument is an integer array A of size N.
The second argument is an integer B.

*** Output Format

Return an integer denoting the index of target value.

*** Example Input

Input 1:
A = [1, 3, 5, 6]
B = 5 

Input 2:
A = [1, 4, 9]
B = 3

*** Example Output

Output 1:
2 

Output 2:
1

*** Example Explanation

Explanation 1:
The target value is present at index 2. 

Explanation 2:
The target value should be inserted at index 1.

*/

module.exports = {
    //param A : array of integers
    //param B : integer
    //return an integer
    searchInsert: function (A, B) {

        let n = A.length;
        let start = 0;
        let end = n - 1;
        let answer = -1;

        while (start <= end) {

            let mid = Math.floor(start + ((end - start) / 2));

            if (A[mid] == B) {
                return mid;
            }
            else if (A[mid] < B) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }

        return start;

    }
};
