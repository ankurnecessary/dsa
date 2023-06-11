// Square root of N upto 3 decimal places
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

class Main {

  public static void main(String[] args) {
    System.out.println(getSquareRoot(10, 3));
  }

  private static BigDecimal getSquareRoot(int num, int decimalPlaces) {

    // To calculate the integer part of the 
    float sqrt = (float) getSquareRootInt(num);

    // Start: For getting decimal place of the square root
    // Very Easy but not able to predict the decimalPlace variable approach below.
    BigDecimal num_bd = new BigDecimal(String.valueOf(num));
    BigDecimal decimalPlace = new BigDecimal("0.1");
    BigDecimal sqrt_bd = new BigDecimal(String.valueOf(sqrt));

    for (int i = 1; i <= decimalPlaces; i++) {
      while (sqrt_bd.multiply(sqrt_bd).compareTo(num_bd) < 0) {
        sqrt_bd = sqrt_bd.add(decimalPlace);
      }

      sqrt_bd = sqrt_bd.subtract(decimalPlace);
      BigDecimal divisor = new BigDecimal("10");
      decimalPlace = decimalPlace.divide(divisor);
    }
    // End: For getting decimal place of the square root

    return sqrt_bd;
  }

  private static int getSquareRootInt(int num) {
    int start = 0;
    int end = num;
    int answer = 0;

    while (start <= end) {
      int mid = start + ((end - start) / 2);

      if (mid * mid <= num) {
        answer = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return answer;
  }
}
