package learn.sort;

/**
 * @author 窦康泰
 * @date 2020/09/29
 */
public class SpeedTest {

    public static void main(String[] args) {
        int[] array = getArray();
//        int[] temp = new int[array.length];
        long beforeTimeMillis = getBeforeTimeMillis();
        // bubbleSort-----11662
//        BubbleSort.bubbleSort(array);
        // selectSort-----2396
//        SelectSort.selectSort(array);
        // insertSort-----690
//        InsertSort.insertSort(array);
        // shellSort-----7857
//        ShellSort.shellSort(array);
        // shellSort2-----52-----900W-----1948
//        ShellSort.shellSort2(array);
        // quickSort-----40-----900W-----1032
//        QuickSort.quickSort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));
        // mergeSort-----14-----900w-----1197
//        MergeSort.mergeSort(array, 0, array.length - 1, temp);
//        System.out.println(Arrays.toString(array));
        // radixSort-----30-----900w-----1410
        RadixSort.radixSort(array);
        long afterTimeMillis = getAfterTimeMillis();
        System.out.println(afterTimeMillis - beforeTimeMillis);
    }

    public static int[] getArray() {
        int[] array = new int[9000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        return array;
    }

    public static long getBeforeTimeMillis() {
        long l1 = System.currentTimeMillis();
        return l1;
    }

    public static long getAfterTimeMillis() {
        long l2 = System.currentTimeMillis();
        return l2;
    }

}
