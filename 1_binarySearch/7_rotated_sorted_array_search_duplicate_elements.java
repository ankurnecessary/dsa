// Rotated sorted array search duplicate elements - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

/*

There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

*** Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

*** Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

*** Constraints:
1. 1 <= nums.length <= 5000
2. -104 <= nums[i] <= 104
3. nums is guaranteed to be rotated at some pivot.
4. -104 <= target <= 104

*** Follow up: 
This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?

*/

/*

Time Complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array.

Reason: In the best and average scenarios, the binary search algorithm is primarily utilized and hence the time complexity is O(logN). However, in the worst-case scenario, where all array elements are the same but not the target (e.g., given array = {3, 3, 3, 3, 3, 3, 3}), we continue to reduce the search space by adjusting the low and high pointers until they intersect. This worst-case situation incurs a time complexity of O(N/2).

Space Complexity: O(1)

Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

*/

class Solution {

  public boolean search(int[] nums, int target) {
    int min = 0;
    int max = nums.length - 1;

    while (min <= max) {
      int mid = min + ((max - min) / 2);

      if (nums[mid] == target) {
        return true;
      } else if (nums[min] == nums[mid] && nums[mid] == nums[max]) {
        min++;
        max--;
      } else if (nums[min] <= nums[mid]) {
        if (nums[min] <= target && target <= nums[mid]) {
          max = mid - 1;
        } else {
          min = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[max]) {
          min = mid + 1;
        } else {
          max = mid - 1;
        }
      }
    }

    return false;
  }
}
