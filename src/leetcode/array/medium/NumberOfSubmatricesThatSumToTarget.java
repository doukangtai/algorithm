package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/01/04
 */
public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int[][] matrix = new int[][]{{1, -1}, {-1, 1}};
        int target = 0;
        System.out.println(new NumberOfSubmatricesThatSumToTarget().numSubmatrixSumTarget(matrix, target));
    }

//    public int numSubmatrixSumTarget(int[][] matrix, int target) {
//        int count = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                for (int k = i; k < matrix.length; k++) {
//                    for (int l = j; l < matrix[k].length; l++) {
//                        int sumTemp = 0;
//                        for (int m = i; m <= k; m++) {
//                            for (int n = j; n <= l; n++) {
//                                sumTemp += matrix[m][n];
//                            }
//                        }
//                        if (target == sumTemp) {
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                tempSum += matrix[i][j];
                sum[i + 1][j + 1] = sum[i][j + 1] + tempSum;
            }
        }
        int count = 0;
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[i].length; j++) {
                for (int k = i; k < sum.length; k++) {
                    for (int l = j; l < sum[k].length; l++) {
                        int s = sum[k][l] - sum[i - 1][l] - sum[k][j - 1] + sum[i - 1][j - 1];
                        if (target == s) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

}
