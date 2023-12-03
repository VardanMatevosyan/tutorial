package com.practice.binary_search;

public class MinValueInRotatedArray {
  /**
   * 153. Find Minimum in Rotated Sorted Array
   *     // 1, 2, 5 -> 0 -> 1 - n
   *     // 5, 1, 2 -> 1 -> n-1, 1, n-2
   *     // 2, 5, 1 -> 2 -> n-2, n-1, 1
   * @param nums rotated array
   * @return minimum
   */

  public static int findMin(int[] nums) {
    int len = nums.length;
    if (len == 1 || nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }
    if (nums[nums.length - 1] < nums[nums.length - 2]) {
      return nums[nums.length - 1];
    }

    if (len == 2 && nums[0] >= nums[1]) {
      return nums[1];
    } else if (len == 2 && nums[0] <= nums[1]) {
      return nums[0];
    }

    return searchMin(nums, Integer.MAX_VALUE, 0, len - 1);
  }

  private static int searchMin(int[] nums, int min, int left, int right) {
    if (left > right) {
      return min;
    }

    int minIndex = (left + right) / 2;
    min = Math.min(nums[minIndex], min);

    if (nums[left] < nums[right] && nums[left] < nums[minIndex]) {
      return searchMin(nums, min, left, minIndex - 1);
    } else {
      return searchMin(nums, min, left + 1, right);
    }

  }
}
