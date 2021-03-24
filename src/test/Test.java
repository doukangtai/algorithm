package test;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {
    }
}

class Test2 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 4, 2, 3, 3, 2, 4, 1, 5};
        Test2 test = new Test2();
        show(test.countSort(nums));
        show(test.bucketSort(nums, 3));
        show(test.radixSort(nums));
        learn();
    }

    public static void learn() {
    }

    public int[] radixSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int maxLen = 0;
        while (max != 0) {
            max /= 10;
            maxLen++;
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        int mod = 10;
        int div = 1;
        for (int i = 0; i < maxLen; i++, mod *= 10, div *= 10) {
            for (int num : nums) {
                int index = (num % mod) / div;
                buckets.get(index).add(num);
            }
            int j = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer num : bucket) {
                    nums[j++] = num;
                }
                bucket.clear();
            }
        }
        return nums;
    }

    public int[] bucketSort(int[] nums, int bucketSize) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            buckets.get(index).add(num);
        }
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer num : bucket) {
                nums[i++] = num;
            }
        }
        return nums;
    }

    public int[] countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }
        int j = 0;
        int i = 0;
        while (j < nums.length) {
            if (count[i] != 0) {
                nums[j++] = i + min;
                count[i]--;
            } else {
                i++;
            }
        }
        return nums;
    }

    public int[] heapSort(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            sink(nums, i, nums.length - 1);
        }
        int lastIndex = nums.length - 1;
        while (lastIndex > 0) {
            swap(nums, 0, lastIndex);
            sink(nums, 0, --lastIndex);
        }
        return nums;
    }

    public void sink(int[] nums, int curIndex, int lastIndex) {
        while (curIndex < lastIndex) {
            int l = curIndex * 2;
            int r = curIndex * 2 + 1;
            int maxIndex = curIndex;
            if (l <= lastIndex && nums[maxIndex] < nums[l]) {
                maxIndex = l;
            }
            if (r <= lastIndex && nums[maxIndex] < nums[r]) {
                maxIndex = r;
            }
            if (nums[maxIndex] > nums[curIndex]) {
                swap(nums, maxIndex, curIndex);
                curIndex = maxIndex;
            } else {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] quickSort(int[] nums) {
        qs(nums, 0, nums.length - 1);
        return nums;
    }

    public void qs(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        int key = nums[left];
        while (left < right) {
            while (nums[right] >= key && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= key && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        qs(nums, l, left - 1);
        qs(nums, left + 1, r);
    }

    public int[] mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int temp = 0;
        while (p1 <= mid && p2 <= right) {
            tempArr[temp++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            tempArr[temp++] = nums[p1++];
        }
        while (p2 <= right) {
            tempArr[temp++] = nums[p2++];
        }
        temp = 0;
        for (int i = left; i <= right; i++) {
            nums[i] = tempArr[temp++];
        }
    }

    public int[] shell(int[] nums) {
        int gap = nums.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < nums.length; i++) {
                for (int j = i; j >= gap && nums[j] < nums[j - gap]; j -= gap) {
                    int temp = nums[j];
                    nums[j] = nums[j - gap];
                    nums[j - gap] = temp;
                }
            }
            gap /= 2;
        }
        return nums;
    }

    public int[] insertion(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    public int[] bubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public int[] selection(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                index = nums[index] > nums[j] ? j : index;
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }

    public static void show(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
