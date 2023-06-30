class Main {

  public static void main(String[] args) {
    //        int n = 2;
    //        int k = 10;

    //        System.out.println(getNthRoot_recursive(n, k));
    //        System.out.println(getNthRoot_simple(n, k));
    //        System.out.println(getNthRoot_positive_power(n, k));

    double n = 10;
    double k = -1;
    System.out.println(getNthRoot_positive_negative_power(n, k));
  }

  private static int getNthRoot_simple(int n, int k) {
    int answer = 1;

    while (k != 0) {
      answer *= n;
      k--;
    }

    return answer;
    // TC - O(n)
    // SC - O(1)
  }

  private static int getNthRoot_recursive(int n, int k) {
    if (k == 0) return n;

    int answer = 1;

    if (k % 2 == 0) {
      answer = getNthRoot_recursive(n * n, k / 2);
    } else {
      answer = n * getNthRoot_recursive(n, (k - 1) / 2);
    }

    return answer;
    // TC - O(log k)
    // SC - O(log k)
  }

  private static int getNthRoot_positive_power(int n, int k) {
    int answer = 1;

    while (k > 0) {
      if (k % 2 == 0) {
        n = n * n;
        k /= 2;
      } else {
        answer = answer * n;
        k -= 1;
      }
    }

    return answer;
    // TC - O(log k)
    // SC - O(1)
  }

  private static double getNthRoot_positive_negative_power(double n, double k) {
    double answer = 1;
    double pow = k < 0 ? (k * -1) : k;

    while (pow > 0) {
      if (pow % 2 == 0) {
        n = n * n;
        pow /= 2;
      } else {
        answer = answer * n;
        pow -= 1;
      }
    }

    if (k < 0) {
      answer = 1 / answer;
    }

    return answer;
    // TC - O(log(k))
    // SC - O(1)
  }
}
