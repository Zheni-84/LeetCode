package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 965: Univalued Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(n) in the worst case (for the queue).
 * Topic: Tree, Breadth-First Search (BFS)
 *
 * This class provides a method to determine if a binary tree is univalued,
 * meaning all its nodes have the same value. The main method demonstrates
 * the usage of the isUniValTree method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: Use BFS to traverse the tree and check if all values are the same.
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class UniValuedBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);

		boolean result = isUniValTree(root);
		System.out.println("Is the binary tree univalued? " + result); // Output: true
	}

	private static boolean isUniValTree(TreeNode root) {
		if (root == null)
			return false;
		int val = root.val;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.val != val)
				return false;
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

		return true;
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}