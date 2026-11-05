r"""
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

        3
      /   \
    5       1
   / \     / \
  6   2   0   8
     / \
    7   4
示例 1：
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

示例 2：
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。

示例 3：
输入：root = [1,2], p = 1, q = 2
输出：1

提示：
树中节点数目在范围 [2, 105] 内。
-109 <= Node.val <= 109
所有 Node.val 互不相同 。
p != q
p 和 q 均存在于给定的二叉树中。
"""

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # 返回三个信息：
        # 1. 当前节点的子树是否包含 p
        # 2. 当前节点的子树是否包含 q
        # 3. 当前节点的子树中是否已经找到最近公共祖先，以及该节点
        # 递归遍历,判断当前节点字数是否包含p,q
        def dfs(node:TreeNode) -> tuple[bool,bool,TreeNode|None] :
            if not node:
                return False, False, None

            # 递归获取左子树的信息
            left_has_p, left_has_q, left_x = dfs(node.left)
            right_has_p, right_has_q, right_x = dfs(node.right)

            # 当前节点是否含有p(左分支,右分支含有p或者自己就是p)
            cur_has_p = left_has_p or right_has_p or node is p
            cur_has_q = left_has_q or right_has_q or node is q

            cur_x = None    # 初始化祖先节点
            # 左右子树都没有找到最近公共祖先，
            # 但当前子树已经同时包含 p 和 q，
            # 因此当前节点就是最近公共祖先
            if right_x:
                cur_x = right_x
            elif left_x:
                cur_x = left_x
            elif cur_has_p and cur_has_q:
                cur_x = node
            return cur_has_p, cur_has_q, cur_x

        _,_,x = dfs(root)
        return x


if __name__ == '__main__':
    from buildTree import build_tree
    s = Solution()
    root = build_tree([3,5,1,6,2,0,8,None,None,7,4])
    print(s.lowestCommonAncestor(root,5,1))


