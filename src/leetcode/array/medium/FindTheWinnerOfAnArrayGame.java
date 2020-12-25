package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2020/12/25
 */
public class FindTheWinnerOfAnArrayGame {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 25, 68, 35, 42, 70};
        int k = 4;
        System.out.println(new FindTheWinnerOfAnArrayGame().getWinner(arr, k));
    }

//    public int getWinner(int[] arr, int k) {
//        int maxCount = Integer.MIN_VALUE;
//        int maxIndex = Integer.MIN_VALUE;
//        int forCount = 0;
//        HashMap<Integer, Integer> countMap = new HashMap<>();
//        while (maxCount < k && forCount <= arr.length << 1) {
//            forCount++;
//            if (arr[0] < arr[1]) {
//                Integer count = countMap.get(arr[1]);
//                countMap.put(arr[1], count == null ? 1 : count + 1);
//                count = countMap.get(arr[1]);
//                if (maxCount < count) {
//                    maxCount = count;
//                    maxIndex = arr[1];
//                }
//                int temp = arr[0];
//                System.arraycopy(arr, 1, arr, 0, arr.length - 1);
//                arr[arr.length - 1] = temp;
//            } else {
//                Integer count = countMap.get(arr[0]);
//                countMap.put(arr[0], count == null ? 1 : count + 1);
//                count = countMap.get(arr[0]);
//                if (maxCount < count) {
//                    maxCount = count;
//                    maxIndex = arr[0];
//                }
//                int temp = arr[1];
//                System.arraycopy(arr, 2, arr, 1, arr.length - 2);
//                arr[arr.length - 1] = temp;
//            }
//        }
//        return maxIndex;
//    }

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

}
