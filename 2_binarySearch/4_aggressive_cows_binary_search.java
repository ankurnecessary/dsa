// Aggressive cows

/*

Farmer John has built a new long farm, with N stalls. The stalls are located along a straight line at positions X1,...,XN.

His C(2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, farmer wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

*/

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] stalls = {1, 8, 2, 3, 5};
        int noOfCows = 3;
        System.out.println(minDistanceBetweenCows(stalls, noOfCows));
    }

    private static int minDistanceBetweenCows(int[] stalls, int noOfCows) {

        int start = 0;
        int end = stalls[stalls.length - 1];
        int answer = 0;

        // Sorting stalls
        Arrays.sort(stalls);

        // Binary search
        while(start <= end) {

            int mid = start + ( (end - start) / 2 );

            if(cowsDistancePossible(stalls, noOfCows, mid)) {
                answer = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }

        return answer;
    }

    // Calculating cow distance
    private static boolean cowsDistancePossible(int[] stalls, int noOfCows, int distance) {

        int currentCowLocation = stalls[0];
        int count = 1;

        for(int i = 1; i <= stalls.length - 1; i++) {

            if(stalls[i] - currentCowLocation >= distance) {
                count++;
                currentCowLocation = stalls[i];
            }

            if(count == noOfCows) {
                return true;
            }

        }

        return false;
    }

}