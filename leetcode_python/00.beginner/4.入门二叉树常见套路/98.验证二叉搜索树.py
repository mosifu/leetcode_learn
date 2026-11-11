"""
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例 1：
输入：root = [2,1,3]
输出：true

示例 2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。

提示：
树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: TreeNode | None) -> bool:
        # 设置一个函数进行递归，传递的是当前节点和左右子树需要满足的最小值和最大值
        def dfs(node: TreeNode, min_limit, max_limit):  # 按左右中后序遍历
            if not node:
                return True
            # 对于节点的左子节点,传递的是限制最大值,即左子节点的值,不能大于传递的值
            left_is_bst = dfs(node.left, min_limit, node.val)
            right_is_bst = dfs(node.right, node.val, max_limit)
            # 如果左子树为真,右子树也为真,且当前节点满足大于最小限制,小于最大限制,则说明满足BST
            if left_is_bst and right_is_bst and min_limit < node.val < max_limit:
                return True
            return False
        return dfs(root, -float('inf'), float('inf'))   # 初始化调用,传入根节点与无穷小和无穷大

    def isValidBST2(self, root: TreeNode) -> bool:
        # 条件足够可以先判断当前节点 (中左右)
        def dfs(node: TreeNode, min_limit, max_limit):
            if not node:
                return True
            if node.val <= min_limit or node.val >= max_limit:
                return False
            left_is_bst = dfs(node.left, min_limit, node.val)
            if not left_is_bst:
                return False
            right_is_bst = dfs(node.right, node.val, max_limit)
            if not right_is_bst:
                return False
            return True
        return dfs(root, -float('inf'), float('inf'))

    def isValidBST3(self, root: TreeNode) -> bool:
        # 二叉搜索树按照中序遍历之后得到的是递增的序列,那么也可以在遍历的时候进行比较
        pre = -float('inf') # 定义为负无穷小
        def dfs(node: TreeNode, min_limit, max_limit):
            if not node:
                return True
            left_is_bst = dfs(node.left, min_limit, node.val)
            if not left_is_bst:
                return False
            nonlocal pre
            if node.val <= pre:
                # 当前节点与遍历的前一个节点进行比较
                return False
            pre = node.val
            right_is_bst = dfs(node.right, node.val, max_limit)
            if not right_is_bst:
                return False
            return True
        return dfs(root, -float('inf'), float('inf'))

if __name__ == '__main__':
    from buildTree import build_tree
    tree = build_tree([5,1,4,None,None,3,6])
    s = Solution()
    print(s.isValidBST(tree))

