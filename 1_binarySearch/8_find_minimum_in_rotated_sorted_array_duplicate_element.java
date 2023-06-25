// find minimum in rotated sorted array with duplicate elements - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/?envType=list&envId=raau48es

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

1. [4,5,6,7,0,1,4] if it was rotated 4 times.
2. [0,1,4,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

*** Example 1:
Input: nums = [1,3,5]
Output: 1

*** Example 2:
Input: nums = [2,2,2,0,1]
Output: 0
 
*** Constraints:
1. n == nums.length
2. 1 <= n <= 5000
3. -5000 <= nums[i] <= 5000
4. nums is sorted and rotated between 1 and n times.

***Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?

*/

class Solution {

  public int findMin(int[] nums) {
    if (nums.length == 1) return nums[0]; // corner case

    int min = 0;
    int max = nums.length - 1;
    int answer = Integer.MAX_VALUE;

    while (min <= max) {
      int mid = min + ((max - min) / 2);

      if (nums[min] < nums[max]) {
        answer = Math.min(answer, nums[min]);
        break;
      }

      if (nums[min] == nums[mid] && nums[mid] == nums[max]) {
        answer = Math.min(answer, nums[min]);
        min++;
        max--;
      } else if (nums[min] <= nums[mid]) {
        answer = Math.min(answer, nums[min]);
        min = mid + 1;
      } else {
        answer = Math.min(answer, nums[mid]);
        max = mid - 1;
      }
    }

    return answer;
  }
}
// Best and Average case - TC - O(log n)
// Worst case - TC - O(n/2) - [3,3,1,3,3,3,3,3]
