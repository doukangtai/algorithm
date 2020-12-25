package leetcode.array.easy;

/**
 * @author 窦康泰
 * @date 2020/12/23
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6, 8, 9};
        int target = 17;
        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
    }

//    public int searchInsert(int[] nums, int target) {
//        int index = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (index == -1 && nums[i] > target) {
//                index = i;
//            }
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        if (nums[nums.length - 1] < target) {
//            return nums.length;
//        }
//        return index;
//    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                pos = mid;
                right = mid - 1;
            }
        }
        return pos;
    }

}
