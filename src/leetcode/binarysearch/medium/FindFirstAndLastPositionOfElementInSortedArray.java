package leetcode.binarysearch.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/24
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(Arrays.toString(new Method2().searchRange(new int[]{}, 0)));
        }

        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums, target);
            int right = searchRight(nums, target);
            int[] res = {-1, -1};
            if (left >= 0 && left < nums.length && nums[left] == target) {
                res[0] = left;
            }
            if (right >= 0 && right < nums.length && nums[right] == target) {
                res[1] = right;
            }
            return res;
        }

        public int searchLeft(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return left;
        }

        public int searchRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return right;
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray searchRange = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] range = searchRange.searchRange(new int[]{1, 2, 2, 2, 3}, 12);
        System.out.println(Arrays.toString(range));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeftBound(nums, target), searchRightBound(nums, target)};
    }

    public int searchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public int searchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
}
