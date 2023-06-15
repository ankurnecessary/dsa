// Aggressive cows

/*

Farmer John has built a new long farm, with N stalls. The stalls are located along a straight line at positions X1,...,XN.

His C(2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, farmer wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

*/

import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    int[] stalls = { 1, 8, 2, 3, 5 };
    int noOfCows = 3;
    System.out.println(minDistanceBetweenCows(stalls, noOfCows));
  }

  private static int minDistanceBetweenCows(int[] stalls, int noOfCows) {
    Arrays.sort(stalls);

    int minDistance = 1;
    int maxDistance = stalls[stalls.length - 1] - stalls[0];
    int answer = 0;

    while (minDistance <= maxDistance) {
      if (isMinDistancePossible(minDistance, stalls, noOfCows)) {
        answer = minDistance;
      }

      minDistance++;
    }

    return answer;
  }

  // Calculating cow distance
  private static boolean isMinDistancePossible(
    int minDistance,
    int[] stalls,
    int noOfCows
  ) {
    int currentCow = stalls[0];
    int currentCowNo = 1;

    for (int i = 1; i < stalls.length; i++) {
      if (stalls[i] - currentCow >= minDistance) {
        currentCow = stalls[i];
        currentCowNo++;
      }

      if (currentCowNo == noOfCows) {
        return true;
      }
    }

    return false;
  }
}
// TC - O(maxDistance * noOfStalls)
// SC - O(1)
