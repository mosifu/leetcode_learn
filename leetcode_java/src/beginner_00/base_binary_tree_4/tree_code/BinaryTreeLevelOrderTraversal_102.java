package beginner_00.base_binary_tree_4.tree_code;

import java.util.*;

/**102.二叉树的层序遍历
 *给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 *       3
 *     /   \
 *    9     20
 *         /  \
 *       15    7
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 广度优先遍历，先把当前节点存进队列里，记录当前节点的数量，然后根据节点数弹出队列前n个
        // 同时看弹出的节点有没有左右节点,有的话再加入队列
        if (Objects.isNull(root)) {
            // root为空,则返回空列表
            return new ArrayList<>(){};
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>(); // 创建队列
        nodeDeque.offerLast(root);  // 从队尾插入
        List<List<Integer>> res = new ArrayList<>();
        while (!nodeDeque.isEmpty()) {
            int n = nodeDeque.size();   // 当前队列中的节点数
            List<Integer> curr = new ArrayList<>(); // 当前层取出的节点
            for (int i = 0; i < n; i++) {
                TreeNode curNode = nodeDeque.pop();
                curr.add(curNode.val);
                if (Objects.nonNull(curNode.left)) {
                    nodeDeque.offerLast(curNode.left);
                }
                if (Objects.nonNull(curNode.right)) {
                    nodeDeque.offerLast(curNode.right);
                }
            }
            res.add(curr);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = new BuildTree().buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(levelOrder(tree));
    }
}
