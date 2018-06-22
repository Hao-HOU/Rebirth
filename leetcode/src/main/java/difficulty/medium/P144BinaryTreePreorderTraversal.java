package difficulty.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/22 11:25
 */
public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    // 递归
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return traverseNode(root, ans);
    }

    private static List<Integer> traverseNode(TreeNode node, List<Integer> ans) {
        if (node != null) {
            ans.add(node.val);
            traverseNode(node.left, ans);
            traverseNode(node.right, ans);
        }
        return ans;
    }


    // 不使用递归
    private static List<Integer> preorderTraversalWithStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            ans.add(current.val);
            if (current.left == null && current.right == null) {
                continue;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return ans;
    }
}
