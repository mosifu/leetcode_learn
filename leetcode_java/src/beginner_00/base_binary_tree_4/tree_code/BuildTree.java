package beginner_00.base_binary_tree_4.tree_code;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 将创建二叉树的方法抽出，这样该目录下，每个类都可以直接调用
 */
public class BuildTree {

    public static class TreeNode {
        int val;
        BinaryTreeTraversal_144_94_145.TreeNode left;
        BinaryTreeTraversal_144_94_145.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeTraversal_144_94_145.TreeNode left, BinaryTreeTraversal_144_94_145.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 由整形列表创建二叉树
    public BinaryTreeTraversal_144_94_145.TreeNode buildTree(List<Integer> list) {
        // 先判断是否为空(判断列表是否存在(null)，存在是否为空列表([]),以及存在列表但第一个元素是否为null([null,1,2]))
        if (list == null || list.isEmpty() || list.get(0) == null) {
            return null;
        }
        BinaryTreeTraversal_144_94_145.TreeNode treeRoot = new BinaryTreeTraversal_144_94_145.TreeNode(list.get(0));  // 创建根节点
        Queue<BinaryTreeTraversal_144_94_145.TreeNode> queue = new ArrayDeque<>();  // 定义变量队列类型,实现数组双端队列类
        queue.offer(treeRoot);  // 把当前根节点的信息添加到队列
        int i = 1;  // 下一步要遍历的数组下标
        while (!queue.isEmpty() && i < list.size()) {
            BinaryTreeTraversal_144_94_145.TreeNode node = queue.poll();   // 第一次循环时,node就已经指向的引用就是根节点指向的引用
            Integer leftVal = list.get(i++);
            if (leftVal!=null) {
                node.left = new BinaryTreeTraversal_144_94_145.TreeNode(leftVal);
                queue.offer(node.left);
            }
            if (i < list.size()) {
                Integer rightVal = list.get(i++);
                if (rightVal != null) {
                    node.right = new BinaryTreeTraversal_144_94_145.TreeNode(rightVal);
                    queue.offer(node.right);
                }
            }
        }
        return treeRoot;
    }
}
