// Just greater number
import java.util.*;

class Main {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(
      Arrays.asList(1, 3, 5, 5, 6, 7, 8)
    );
    int answer = getJustGreater(arr, 5);
    System.out.println(answer);
  }

  public static int getJustGreater(final List<Integer> arr, int num) {
    int n = arr.size();
    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr.get(mid) <= num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return arr.get(start);
  }
}
