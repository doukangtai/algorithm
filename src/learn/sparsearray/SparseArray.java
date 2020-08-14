package learn.sparsearray;

/**
 * @Author 窦康泰
 * @Date 2020-08-12 17:47
 *
 * 将二维数组转成稀疏数组
 * 1. 遍历二维数组，获取非0数据的个数count
 * 2. 创建稀疏数组spareArray，count+1行，3列，三列分别代表，row---column---value，二维数组的坐标和值
 * 3. 稀疏数组第一行为总行数、总列数、count值
 * 4. 从稀疏数组第二行开始为二维数组行、列坐标和值
 *
 * 将稀疏数组还原二维数组
 * 1. 根据稀疏数组第一行，第一、二列创建二维数组
 * 2. 遍历稀疏数组（从第二行开始），将value赋值给二维数组
 */
public class SparseArray {

    public static void main(String[] args) {
        int row = 10;
        int column = 12;
        int[][] array = new int[row][column];
        array[0][1] = 1;
        array[1][2] = 2;
        array[2][3] = 1;
        array[3][4] = 2;
        array[4][5] = 1;
        System.out.println("原始二维数组");
        int count = 0;
        for (int[] ints : array) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
                if (i != 0) {
                    count++;
                }
            }
            System.out.println();
        }
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = count;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    sparseArray[i + 1][0] = i;
                    sparseArray[i + 1][1] = j;
                    sparseArray[i + 1][2] = array[i][j];
                }
            }
        }
        System.out.println("稀疏数组");
        System.out.println("row column value");
        for (int[] ints : sparseArray) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        int[][] newArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            newArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("恢复后的新数组");
        for (int[] ints : newArray) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

}
