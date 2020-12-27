## [1476. 子矩形查询](https://leetcode-cn.com/problems/subrectangle-queries/)

**题目描述**

请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：

1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)

用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
2. getValue(int row, int col)

返回矩形中坐标 (row,col) 的当前值。


示例 1：

输入：
["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
输出：
[null,1,null,5,5,null,10,5]
解释：
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);  
// 初始的 (4x3) 矩形如下：
// 1 2 1
// 4 3 4
// 3 2 1
// 1 1 1
subrectangleQueries.getValue(0, 2); // 返回 1
subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// 此次更新后矩形变为：
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5 
subrectangleQueries.getValue(0, 2); // 返回 5
subrectangleQueries.getValue(3, 1); // 返回 5
subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// 此次更新后矩形变为：
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10 
subrectangleQueries.getValue(3, 1); // 返回 10
subrectangleQueries.getValue(0, 2); // 返回 5
示例 2：

输入：
["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
[[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
输出：
[null,1,null,100,100,null,20]
解释：
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
subrectangleQueries.getValue(0, 0); // 返回 1
subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
subrectangleQueries.getValue(0, 0); // 返回 100
subrectangleQueries.getValue(2, 2); // 返回 100
subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
subrectangleQueries.getValue(2, 2); // 返回 20


提示：

最多有 500 次updateSubrectangle 和 getValue 操作。
1 <= rows, cols <= 100
rows == rectangle.length
cols == rectangle[i].length
0 <= row1 <= row2 < rows
0 <= col1 <= col2 < cols
1 <= newValue, rectangle[i][j] <= 10^9
0 <= row < rows
0 <= col < cols

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subrectangle-queries
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**手写**

```java
int[][] rectangle;

public SubrectangleQueries(int[][] rectangle) {
    this.rectangle = rectangle;
}

public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    for (int i = row1; i <= row2; i++) {
        for (int j = col1; j <= col2; j++) {
            rectangle[i][j] = newValue;
        }
    }
}

public int getValue(int row, int col) {
    return rectangle[row][col];
}
```

**题解**

- 有手就行

## [1535. 找出数组游戏的赢家](https://leetcode-cn.com/problems/find-the-winner-of-an-array-game/)

**题目描述**

给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。

每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。

返回赢得比赛的整数。

题目数据 保证 游戏存在赢家。

 

示例 1：

输入：arr = [2,1,3,5,4,6,7], k = 2
输出：5
解释：一起看一下本场游戏每回合的情况：

因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
示例 2：

输入：arr = [3,2,1], k = 10
输出：3
解释：3 将会在前 10 个回合中连续获胜。
示例 3：

输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
输出：9
示例 4：

输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
输出：99


提示：

2 <= arr.length <= 10^5
1 <= arr[i] <= 10^6
arr 所含的整数 各不相同 。
1 <= k <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**手写**

```java
public int getWinner(int[] arr, int k) {
    int maxCount = Integer.MIN_VALUE;
    int maxIndex = Integer.MIN_VALUE;
    int forCount = 0;
    HashMap<Integer, Integer> countMap = new HashMap<>();
    while (maxCount < k && forCount <= arr.length << 1) {
        forCount++;
        if (arr[0] < arr[1]) {
            Integer count = countMap.get(arr[1]);
            countMap.put(arr[1], count == null ? 1 : count + 1);
            count = countMap.get(arr[1]);
            if (maxCount < count) {
                maxCount = count;
                maxIndex = arr[1];
            }
            int temp = arr[0];
            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
            arr[arr.length - 1] = temp;
        } else {
            Integer count = countMap.get(arr[0]);
            countMap.put(arr[0], count == null ? 1 : count + 1);
            count = countMap.get(arr[0]);
            if (maxCount < count) {
                maxCount = count;
                maxIndex = arr[0];
            }
            int temp = arr[1];
            System.arraycopy(arr, 2, arr, 1, arr.length - 2);
            arr[arr.length - 1] = temp;
        }
    }
    return maxIndex;
}
```

**题解**

- HashMap<Integer, Integer> countMap = new HashMap<>();记录每个数获胜的次数
- 用while判断maxCount < k && forCount <= arr.length << 1，找到需要**返回的数**，同时，控制过大的k导致的超时问题，需要左移一位是因为可能存在某个数获胜次数过多，arr.length << 1确保获取的数是获胜的数
- 时间复杂度：O(n)
- 空间复杂度：O(n)

**非官方**

```java
public int getWinner(int[] arr, int k) {
    int index = 0;
    int count = 0;
    while (count < k && index < arr.length - 1) {
        if (arr[index] > arr[index + 1]) {
            arr[index + 1] = arr[index];
            count++;
        } else {
            count = 1;
        }
        index++;
    }
    return arr[index];
}
```

**题解**

- 两两比较，保证后面的最大，不用移动

## [1552. 两球之间的磁力](https://leetcode-cn.com/problems/magnetic-force-between-two-balls/)

**题目描述**

在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。

已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。

给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。

 

示例 1：

![MagneticForceBetweenTwoBalls](E:\project\idea-project\algorithm\src\leetcode\array\medium\images\MagneticForceBetweenTwoBalls.jpg)

输入：position = [1,2,3,4,7], m = 3
输出：3
解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
示例 2：

输入：position = [5,4,3,2,1,1000000000], m = 2
输出：999999999
解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。


提示：

n == position.length
2 <= n <= 10^5
1 <= position[i] <= 10^9
所有 position 中的整数 互不相同 。
2 <= m <= position.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/magnetic-force-between-two-balls
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**手写**

```java
public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int left = 1;
    int right = position[position.length - 1] - position[0];
    int value = 0;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (check(mid, position, m)) {
            value = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return value;
}

public boolean check(int key, int[] position, int m) {
    int count = 1;
    int pre = position[0];
    for (int i = 1; i < position.length; i++) {
        if (position[i] - pre >= key) {
            count++;
            pre = position[i];
        }
    }
    return count >= m;
}
```

**题解**

- 没思路，看的答案
- 合法的答案出现在**[1, position[position.length - 1] - position[0]]**中，因此采用**二分查找**的思想，依次尝试，符合条件的，则记录下当前尝试的值**value = mid;**尝试更大的值**left = mid + 1;**，不符合条件，则从更小的答案中尝试**right = mid - 1;**
- check方法用于检查大小为key的间隔是否可以放下m个元素
- 时间复杂度：O*(*n*log(*n**S*))，其中 n 为篮子的个数，S 为篮子位置的上限。对篮子位置排序需要 O(nlogn) 的时间复杂度，二分查找对篮子位置间隔进行二分，需要 O(logS) 的时间复杂度。每次统计答案是否符合要求需要 O(n) 的时间复杂度，因此总时间复杂度为 O(nlog n+nlog S) = O(nlog(nS))。
- 空间复杂度：O(logn)，即为排序需要的栈空间，Arrays.sort空间复杂度log n，check递归空间复杂度log n。