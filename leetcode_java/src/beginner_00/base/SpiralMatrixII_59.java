package beginner_00.base;

import java.util.Arrays;

/**59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 */
public class SpiralMatrixII_59 {
    public static int[][] generateMatrix(int n) {
        // 设置起始点与移动计数
        int index = 0, count = 1;
        // 设置n*n矩阵
        int[][] matrix = new int[n][n];
        while (count < (n*n)) {
            for (int j = index; j < n-1-index; j++) {
                // 上面的一行,从左往右
                matrix[index][j] = count;
                count += 1;
            }
            for (int i = index; i < n-1-index; i++) {
                // 右面的一列,从上往下
                matrix[i][n-1-index] = count;
                count += 1;
            }
            for (int j = n-1-index; j > index ; j--) {
                // 下面那一行,从右往左,索引递减
                matrix[n-1-index][j] = count;
                count += 1;
            }
            for (int i = n-1-index; i > index; i--) {
                // 左面那一列,从下往上,行索引递减
                matrix[i][index] = count;
                count += 1;
            }
            index++;
        }
        // 当n为奇数时,矩阵中心的位置无法赋值,就结束循环了
        if (n % 2 == 1) {
            // 奇数,需要补充矩阵中心的数
            matrix[n/2][n/2] = count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
}
