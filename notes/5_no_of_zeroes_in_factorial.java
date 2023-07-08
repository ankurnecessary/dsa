/*
Find the no. of trailing 0s in N![N factorial]
 */
class Main {

  public static void main(String[] args) {
    System.out.println(getNoOfZeroes(28));
  }

  private static int getNoOfZeroes(int n) {
    int divisor = 5;
    int answer = 0;

    while (n / divisor != 0) {
      answer += (n / divisor);
      divisor *= 5;
    }

    return answer;
  }
}
// TC - O(log (n)) to the base 5
// SC - O(1)
