package beginner_00.base_binary_tree_4.tree_code;

import java.util.Arrays;
import java.util.Objects;

/**104.二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 示例 1：
 *       3
 *     /   \
 *    9     20
 *         /  \
 *       15    7
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 *
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 *
 * 提示：
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree_104 {

    public static int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(right,left)+1;
    }

    public static void main(String[] args) {
        BuildTree bt = new BuildTree();
        TreeNode tree = bt.buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(maxDepth(tree));
    }
}
