## [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

**题目描述**

给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 

示例 1:

给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。


说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**手写**

```java
public int removeDuplicates(int[] nums) {
    int index = 0;
    int temp;
    if (nums.length > 0) {
        temp = nums[0];
    } else {
        return 0;
    }
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != temp) {
            temp = nums[i];
            nums[++index] = temp;
        }
    }
    System.out.println(Arrays.toString(nums));
    return index + 1;
}
```

**题解**

- 与官方题解基本一样，多了temp辅助变量
- 时间复杂度：O(n)
- 空间复杂度：O(1)

**官方方法：双指针法**

```java
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
```

**题解**

- 用两个指针index和i，当nums[index] == nums[i]时，说明当前index处与后面的值重复，直接i++
- 当nums[index] != nums[i]时，说明遇到新值，nums[++index] = nums[i];将新值赋值到index + 1处，继续前面的过程
- 时间复杂度：O(n)
- 空间复杂度：O(1)

## [27. 移除元素](https://leetcode-cn.com/problems/remove-element/)

**题目描述**

给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 

示例 1:

给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。


说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**手写**

```java
public int removeElement(int[] nums, int val) {
    int rear = nums.length;
    for (int i = 0; i < rear;) {
        if (nums[i] == val) {
            for (int j = i; j < rear - 1; j++) {
                nums[j] = nums[j + 1];
            }
            rear--;
        } else {
            i++;
        }
    }
    System.out.println(Arrays.toString(nums));
    return rear;
}
```

**题解**

- 遇到相等的元素，将后面的所有元素整体前移
- 优缺点：频繁的赋值操作
- 时间复杂度：O(n)
- 空间复杂度：O(1)

**官方方法一：双指针**

```java
public int removeElement(int[] nums, int val) {
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[index++] = nums[i];
        }
    }
    System.out.println(Arrays.toString(nums));
    return index;
}
```

**题解**

- nums[i] != val，将nums[i]值赋值给nums[index]处
- nums[i] == val，i++跳过当前相等的数
- 优缺点：频繁的赋值操作
- 时间复杂度：O(n)
- 空间复杂度：O(1)

**官方方法二：双指针 —— 当要删除的元素很少时**

```java
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
```

**题解**

- 遇到nums[i] == val时，将数组最后一个元素换到nums[i]的位置，循环重复比较
- 优缺点：减少了不必要的赋值操作
- 时间复杂度：O(n)
- 空间复杂度：O(1)

## [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)

**题目描述**

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**手写**

```java
public int searchInsert(int[] nums, int target) {
    int index = -1;
    for (int i = 0; i < nums.length; i++) {
        if (index == -1 && nums[i] > target) {
            index = i;
        }
        if (nums[i] == target) {
            return i;
        }
    }
    if (nums[nums.length - 1] < target) {
        return nums.length;
    }
    return index;
}
```

**题解**

- 一次遍历nums，记录比targe第一个大的数的index，用于在nums中找不到target时，返回插入位置的index
- 同时判断nums[i] == target，即找到相等的值，返回i
- 或者在nums中找不到目标值，并且targe比数组中任何值都大，则插入最后，应该返回nums.length
- 时间复杂度：O(n)
- 空间复杂度：O(1)

**官方方法一：二分查找**

```java
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
```

**题解**

- 利用二分查找，逐渐趋近第一个大于等于target的值的index
- 用pos记录下可能大于等于target的index
- 初始用int pos = nums.length;避免出现target比nums中的所有值都大的情况
- 时间复杂度：O(log n)
- 空间复杂度：O(1)