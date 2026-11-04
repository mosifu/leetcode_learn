"""
为方便测试,现定义函数来实现二叉树的构建,在当前文件下供其他解题测试用
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def build_tree(list_tree_node:list) -> TreeNode | None:
    # 先判 None，再判空列表 / 首元素为 None（否则 None 上调 len() 会抛 TypeError）
    if list_tree_node is None or len(list_tree_node) == 0 or list_tree_node[0] is None:
        return None
    # 定义根节点
    root = TreeNode(list_tree_node[0])
    # 定义队列来接收"待挂载子节点"的父节点
    node_list: list[TreeNode] = [root]
    i = 1   # 数组下标索引，指向下一个待读取的元素
    # 队列非空且数组未读完；空列表是 False，不能写成 is not None
    while node_list and i < len(list_tree_node):
        node = node_list.pop(0)
        # 左孩子：先判边界，再取值，取完才自增
        if i < len(list_tree_node):
            left_val = list_tree_node[i]
            i += 1
            if left_val is not None:
                node.left = TreeNode(left_val)
                node_list.append(node.left)
        # 右孩子：同样先判边界，再取值，取完才自增
        if i < len(list_tree_node):
            right_val = list_tree_node[i]
            i += 1
            if right_val is not None:
                node.right = TreeNode(right_val)
                node_list.append(node.right)
    return root