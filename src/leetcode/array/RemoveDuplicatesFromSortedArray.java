package leetcode.array;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/12/23
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }

//    public int removeDuplicates(int[] nums) {
//        int index = 0;
//        int temp;
//        if (nums.length > 0) {
//            temp = nums[0];
//        } else {
//            return 0;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != temp) {
//                temp = nums[i];
//                nums[++index] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return index + 1;
//    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index + 1;
    }

}
