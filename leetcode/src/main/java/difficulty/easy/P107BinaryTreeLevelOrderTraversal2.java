package difficulty.easy;

import common.TreeNode;

import java.util.*;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/1 10:02
 */
public class P107BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (levelSize > 0) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                levelList.add(queue.poll().val);
                levelSize--;
            }
            listList.add(0, levelList);
        }
        return listList;
    }
}
