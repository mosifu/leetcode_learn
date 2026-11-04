"""
给定一个二叉树 root ，返回其最大深度。
二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

示例 1：
      3
    /   \
   9     20
        /  \
      15    7

输入：root = [3,9,20,null,null,15,7]
输出：3

示例 2：
输入：root = [1,null,2]
输出：2

提示：
树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxDepth(self, root: TreeNode | None) -> int:
        # 递归遍历左右节点,取最长的返回上一级节点得到的是下一级节点+1,如果下一级节点为None,则当前节点返回给上一级的就是0+1
        if root is None:
            return 0
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        return max(left, right) + 1

if __name__ == '__main__':
    from buildTree import build_tree
    tree = build_tree([3,9,20,None,None,15,7])
    s=Solution()
    print(s.maxDepth(tree))