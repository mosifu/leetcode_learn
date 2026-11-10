r"""
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

示例 1：
      3
    /   \
   9     20
        /  \
      15    7
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

示例 2：
输入：root = [1]
输出：[[1]]

示例 3：
输入：root = []
输出：[]

提示：
树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000
"""
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: TreeNode | None) -> list[list[int]]:
        if root is None:
            return []

        queue = deque() # 定义队列
        queue.append(root)  # 从队尾添加进去(先进先出)
        res = []    # 结果列表

        while queue:
            curr_level = []     # 每一层弹出的节点
            n = len(queue)  # 当层节点的数量
            for i in range(n):
                node = queue.popleft() # 队列头部
                curr_level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            res.append(curr_level)

        return res

if __name__ == '__main__':
    from buildTree import build_tree
    tree = build_tree([3,9,20,None,None,15,7])
    s = Solution()
    print(s.levelOrder(tree))

