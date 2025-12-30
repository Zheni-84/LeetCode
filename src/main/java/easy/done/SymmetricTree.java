package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem: 101. Symmetric Tree
 * Space: O(n)
 * Time: O(n)
 * Topics: Tree, Depth-First Search, Breadth-First Search
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Example:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Hint: Use recursion or iteration to compare the left and right subtrees.
 * http://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,
				new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));

		System.out.println("Is the tree symmetric? " + isSymmetric(root)); // Output: true
		System.out.println("Is the tree symmetric (BFS)? " + isSymmetricBFS(root)); // Output: true

		TreeNode asymmetricRoot = new TreeNode(1,
				new TreeNode(2, null, new TreeNode(3)),
				new TreeNode(2, null, new TreeNode(3)));

		System.out.println("Is the tree symmetric? " + isSymmetric(asymmetricRoot)); // Output: false
		System.out.println("Is the tree symmetric (BFS)? " + isSymmetricBFS(asymmetricRoot)); // Output: false
	}

	// Recursive approach by DFS
	// Time Complexity: O(n), where n is the number of nodes in the tree.
	// Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
	private static boolean isSymmetric(TreeNode root) {
		return isMirrorRecursive(root.left, root.right);
	}

	private static boolean isMirrorRecursive(TreeNode t1, TreeNode t2) {
		// If both nodes are null, they are symmetric
		// This is the base case for recursion
		// It means we have reached the end of both subtrees
		// and they are structurally identical up to this point
		if (t1 == null && t2 == null)
			return true;
		// If one is null and the other is not, trees are not symmetric
		if (t1 == null || t2 == null)
			return false;

		// Check if the current nodes are equal
		// and recursively check the left subtree of t1 with the right subtree of t2
		// and the right subtree of t1 with the left subtree of t2
		return t1.val == t2.val
				&& isMirrorRecursive(t1.left, t2.right)
				&& isMirrorRecursive(t1.right, t2.left);
	}

	// Iterative approach by BFS
	// Time Complexity: O(n), where n is the number of nodes in the tree.
	// Space Complexity: O(w), where w is the maximum width of the tree (due to the queue).
	private static boolean isSymmetricBFS(TreeNode root) {
		if (root == null) return true;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);

		while (!queue.isEmpty()) {
			TreeNode t1 = queue.poll();
			TreeNode t2 = queue.poll();

			if (t1 == null && t2 == null) continue;
			if (t1 == null || t2 == null || t1.val != t2.val) return false;

			queue.add(t1.left);
			queue.add(t2.right);
			queue.add(t1.right);
			queue.add(t2.left);
		}

		return true;
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

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