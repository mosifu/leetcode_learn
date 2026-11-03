"""
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

示例 1：
输入：root = [1,null,2,3]
输出：[1,2,3]
解释：
  1
   \
    2
   /
  3

示例 2：
输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
输出：[1,2,4,5,6,7,3,8,9]
解释：
        1
      /   \
    2       3
  /   \      \
 4     5      8
      / \    /
     6   7  9


示例 3：
输入：root = []
输出：[]

示例 4：
输入：root = [1]
输出：[1]



提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # 前序遍历:中左右
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = list()
        def f(root):
            if root is None:
                return
            res.append(root.val)
            f(root.left)
            f(root.right)
            return
        f(root)
        return res

    # 中序遍历:左中右
    def inorderTraversal(self, root: TreeNode | None) -> list[int]:
        res = list()
        def f(root):
            if root is None:
                return
            f(root.left)
            res.append(root.val)
            f(root.right)
            return
        f(root)
        return res

    #后序遍历:左右中
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = list()
        def f(root):
            if root is None:
                return
            f(root.left)
            f(root.right)
            res.append(root.val)
            return
        f(root)
        return res