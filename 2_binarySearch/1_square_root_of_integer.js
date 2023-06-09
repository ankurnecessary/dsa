// Square root of Integer - https://www.scaler.com/academy/mentee-dashboard/class/30365/assignment/problems/200/?navref=cl_pb_nv_tb

/*

*** Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

The value of A can cross the range of Integer.

NOTE: 
   Do not use the sqrt function from the standard library. 
   Users are expected to solve this in O(log(A)) time.


*** Problem Constraints
0 <= A <= 10^10


*** Input Format
The first and only argument given is the integer A.


*** Output Format
Return floor(sqrt(A))


*** Example Input
Input 1:
 11

Input 2:
 9


Example Output
Output 1:
 3
Output 2:
 3
 
*/

module.exports = {
    //param A : an integer
    //return an integer
    sqrt: function (A) {

        let start = 0;
        let end = A;
        let answer = -1;

        while (start <= end) {

            let mid = Math.floor(start + ((end - start) / 2));

            if (mid * mid <= A) {
                start = mid + 1;
                answer = mid;
            }
            else {
                end = mid - 1;
            }

        }

        return answer;

    }
};
