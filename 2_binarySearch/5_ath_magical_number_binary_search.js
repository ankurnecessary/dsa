// Ath magical number - https://www.scaler.com/academy/mentee-dashboard/class/30365/assignment/problems/5697?navref=cl_tt_lst_nm

/*

*** Problem Description
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.

Note: Ensure to prevent integer overflow while calculating.


*** Problem Constraints
1 <= A <= 109
2 <= B, C <= 40000


*** Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.


*** Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.


*** Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


*** Example Output
Output 1:

 2
Output 2:

 6


*** Example Explanation

Explanation 1:
1st magical number is 2.

Explanation 2:
First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

*/
module.exports = {
    //param A : integer
    //param B : integer
    //param C : integer
    //return an integer
    solve: function (A, B, C) {

        let start = 1;
        let end = Math.min(B, C) * A;
        let answer = -1;

        while (start <= end) {

            let mid = Math.floor(start + ((end - start) / 2));
            let totalDivisibleNumbers = Math.floor(mid / B) + Math.floor(mid / C) - Math.floor(mid / this.lcm(B, C));
            if (totalDivisibleNumbers < A) {
                start = mid + 1;
            }
            else {
                if (totalDivisibleNumbers === A) {
                    answer = mid;
                }
                end = mid - 1;
            }

        }

        return answer % (10 ** 9 + 7); // ** - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Exponentiation

    },
    lcm(B, C) {
        return (B * C) / this.hcf(B, C);
    },
    hcf(B, C) {

        while (B !== 0 && C !== 0) { // B * C !== 0

            if (B > C) {
                B = B % C;
            }
            else {
                C = C % B;
            }

        }

        return Math.max(B, C); // B + C because one of them will be 0

    }

};

