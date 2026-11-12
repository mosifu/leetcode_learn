r"""
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

示例 1:
      3
    /   \
   9     20
        /  \
      15    7
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]

示例 2:
输入: preorder = [-1], inorder = [-1]
输出: [-1]

提示:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]) -> TreeNode | None:
        # 先序遍历第一个元素为根节点，根据这个元素在中序遍历中找到对应位置，该位置之前为根节点左子树，位置之后为节点右子树
        if not preorder or not inorder:
            return None

        root_val = preorder[0]  # 根节点
        root = TreeNode(root_val)

        inorder_root_idx = inorder.index(root_val)  # 中序遍历中根节点下标索引

        # 构建左子树
        root.left = self.buildTree(preorder[1:inorder_root_idx+1], inorder[:inorder_root_idx])
        root.right = self.buildTree(preorder[inorder_root_idx+1:], inorder[inorder_root_idx+1:])

        return root

    def buildTree2(self, preorder: list[int], inorder: list[int]) -> TreeNode | None:
        # 上面的方法每次递归传入的数组都是新数组，每次创建都会耗时
        # 现采用哈希表先存储中序遍历的索引
        inorder_map = {val: index for index,val in enumerate(inorder)}  # 值为键，索引为值

        # 传入的是前序遍历左右指针和中序遍历左右指针
        def solver(pre_left, pre_right, in_left, in_right) -> TreeNode | None:
            if pre_left > pre_right:
                return None
            root_val = preorder[pre_left]   # 根节点的值
            root = TreeNode(root_val)
            root_idx = inorder_map[root_val] # 对应的中序遍历的索引
            left_size = root_idx - in_left

            root.left = solver(pre_left+1, pre_left+left_size, in_left, root_idx-1)
            root.right = solver(pre_left+left_size+1, pre_right, root_idx+1, in_right)
            return root

        return solver(0, len(preorder)-1, 0, len(inorder)-1)
