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

