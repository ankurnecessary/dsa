// Single Element in a Sorted Array - https://leetcode.com/problems/single-element-in-a-sorted-array/description/

/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

*** Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

*** Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

*** Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 105

*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function (nums) {

    let min = 0;
    let max = nums.length - 1;

    while (min <= max) {

        let mid = Math.floor(min + ((max - min) / 2));

        if (nums[mid] !== nums[mid - 1] && nums[mid] !== nums[mid + 1]) {
            return nums[mid];
        }
        else if (
            (nums[mid] === nums[mid - 1] && (mid - 1) % 2 === 0) ||
            (nums[mid] === nums[mid + 1] && (mid + 1) % 2 !== 0)
        ) {
            min = mid + 1;
        }
        else {
            max = mid - 1;
        }

    }

};