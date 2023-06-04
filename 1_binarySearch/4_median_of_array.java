// Median of Array - https://www.scaler.com/academy/mentee-dashboard/class/30364/homework/problems/198/?navref=cl_pb_nv_tb

/*
*** Problem Description
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

*** NOTE:
1. The overall run time complexity should be O(log(m+n)).
2. IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

*** Problem Constraints
1 <= N + M <= 2*106

*** Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.

*** Output Format
Return a decimal value denoting the median of two sorted arrays.

*** Example Input
Input 1:
 A = [1, 4, 5]
 B = [2, 3]

Input 2:
 A = [1, 2, 3]
 B = [4]

*** Example Output
Output 1:
 3.0

Output 2:
 2.5

***Example Explanation

Explanation 1:
 The median of both the sorted arrays will be 3.0.

Explanation 2:
 The median of both the sorted arrays will be (2+3)/2 = 2.5.

 */
public class Solution {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int n = a.size();
        int m = b.size();

        // CORNER CASE - If both a and b have 0 length
        if( m == 0 && n == 0 ) return 0.0;

        // CORNER CASE - If no element is there in array b
        if( m == 0) {
            if( n % 2 == 0 ) {
                int medianPos = n / 2;
                return (double) (a.get(medianPos - 1) + a.get(medianPos)) / 2;
            }
            else {
                int medianPos = (int) Math.floor((double) n /2);
                return a.get(medianPos);
            }
        }

        // CORNER CASE - If no element is there in array a
        if( n == 0 ) {
            if( m % 2 == 0 ) {
                int medianPos = m / 2;
                return (double) (b.get(medianPos - 1) + b.get(medianPos)) / 2;
            }
            else {
                int medianPos = (int) Math.floor((double) m /2);
                return b.get(medianPos);
            }
        }

        // If array a.length > b.length. This will decrease the search space
        if(n > m) {
            return findMedianSortedArrays(b,a);
        }

        int start = 0;
        int end = n;
        int medianPos = (int) (
                ( m + n ) % 2 == 0 ?
                        ( m + n ) / 2 : // even length
                        Math.floor( ( (double) (m + n) / 2 ) ) + 1  // odd length
        );

        while (start <= end) {

            int midA = (int) Math.floor( start + ( (double) (end - start) / 2 ) );
            int midB = medianPos - midA;

            int l1 = midA - 1 >= 0 ? a.get(midA - 1) : Integer.MIN_VALUE;
            int l2 = midB - 1 >= 0 ? b.get(midB - 1) : Integer.MIN_VALUE;
            int r1 = midA <= n - 1 ? a.get(midA) : Integer.MAX_VALUE;
            int r2 = midB <= m - 1 ? b.get(midB) : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) { // check
                if( (m + n) % 2 == 0 ) { // even length
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                else { // odd length
                    return Math.max(l1, l2);
                }
            }
            else if ( l1 > r2) {
                end = midA - 1;
            }
            else {
                start = midA + 1;
            }

        }

        return 0.0;

    }
}
