"""
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

示例 1：
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]

示例 2：
输入：n = 1
输出：[[1]]
"""

class Solution:
    def generateMatrix(self, n: int) -> list[list[int]]:
        # 先定义起始点索引(0,0)和移动计数
        index, count = 0, 1
        # 定义 n*n矩阵
        matrix = [[0] * n for _ in range(n)]    # 列表推导式构建矩阵
        while not count >= n*n:     # 移动计数必需小于n
            # n代表列数从1开始,但是索引下标是从0开始的,range也是左闭右开
            for j in range(index,n-1-index):    # 先从最上面开始,从左往右(i-行不变,j-列+1)
                matrix[index][j] = count
                count += 1
            for i in range(index,n-1-index):    # 从最右边开始,从上到下(i-行+1,j-列不变)
                matrix[i][n-1-index] = count
                count += 1
            for j in range(n-1-index,index,-1):    # 最下面,从右到左(i-行不变,j-减一)
                matrix[n-1-index][j] = count
                count += 1
            for i in range(n-1-index,index,-1):    # 最右面,从下往上(i-行减一,j-列不变)
                matrix[i][index] = count
                count += 1
            index += 1  # 每次外层循环完一圈,起始点位置+1(1,1)->(2,2)->(3,3)

        # 当n为奇数时,最后一圈转完,count>n导致结束循环,但是矩阵中心的位置还没有填上数字,所以需要单独处理
        if n % 2 == 1:
            matrix[n//2][n//2] = count
        return matrix

    def generateMatrix1(self, n: int) -> list[list[int]]:
        # 使用边界收缩法,设置上下左右四个边界
        top, bottom = 0, n-1
        left, right = 0, n-1
        count = 1
        matrix = [[0] * n for _ in range(n)]
        while count <= n**2:
            for j in range(left, right+1):
                # 针对上边界,从左到右跑完之后,上边界往下收缩
                matrix[top][j] = count
                count += 1
            top += 1
            for i in range(top, bottom+1):
                # 对于右边界,从上到下跑完,右边界往左收缩
                matrix[i][right] = count
                count += 1
            right -= 1
            for j in range(right, left-1, -1):
                # 对于下边界,从右往左跑完,下边界往上收缩
                matrix[bottom][j] = count
                count += 1
            bottom -= 1
            for i in range(bottom, top-1, -1):
                # 对于左边界,从下往上跑完,左边界往右收缩
                matrix[i][left] = count
                count += 1
            left += 1
        return matrix


if __name__ == '__main__':
    print(Solution().generateMatrix(4))

