package difficulty.easy;

import common.TreeNode;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/24 13:27
 */
public class P235LowestCommonAncestorofaBinarySearchTree {
    public static void main(String[] args) {

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 递归
//        if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)) {
//            return root;
//        } else if ((root.val > p.val)) {    // < 符号反了！！！ 应该是：>
//            root = root.left;
//            return lowestCommonAncestor(root, p, q);
//        } else {
//            root = root.right;
//            return lowestCommonAncestor(root, p, q);
//        }

        // 循环
//        while (root != null) {
//            if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)) {
//                return root;
//            } else if ((root.val > p.val)) {
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//        }
//
//        return null;

        // 更简单写法的循环
        while ((p.val - root.val) * (q.val - root.val) > 0) {
            root = (p.val < root.val) ? root.left : root.right;
        }

        return root;
    }
}
