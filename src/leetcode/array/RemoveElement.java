package leetcode.array;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/12/23
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(new RemoveElement().removeElement(nums, val));
    }

//    public int removeElement(int[] nums, int val) {
//        int rear = nums.length;
//        for (int i = 0; i < rear;) {
//            if (nums[i] == val) {
//                for (int j = i; j < rear - 1; j++) {
//                    nums[j] = nums[j + 1];
//                }
//                rear--;
//            } else {
//                i++;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return rear;
//    }

//    public int removeElement(int[] nums, int val) {
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != val) {
//                nums[index++] = nums[i];
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return index;
//    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }

}
