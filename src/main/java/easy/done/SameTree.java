package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem: 100. Same Tree
 * Space: O(h) where h is the height of the tree (due to recursion stack)
 * Time: O(n) where n is the number of nodes in the tree
 * Topics: Tree, Recursion
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * <p>
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Hint: Use recursion to compare the nodes of both trees.
 * http://leetcode.com/problems/same-tree/
 */
public class SameTree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		System.out.println("Are the trees same? " + isSameTree(p, q)); // Output: true

		TreeNode r = new TreeNode(1, new TreeNode(2), null);
		System.out.println("Are the trees same? " + isSameTree(p, r)); // Output: false

		System.out.println("Are the trees same (BFS)? " + isSameTreeBFS(p, q)); // Output: true
		System.out.println("Are the trees same (BFS)? " + isSameTreeBFS(p, r)); // Output: false

	}

	public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(p);
		queue.add(q);
		while (!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();

			// If both nodes are null, continue to the next pair
			if (node1 == null && node2 == null) {
				continue;
			}

			// If one is null and the other is not, trees are not the same
			if (node1 == null || node2 == null) {
				return false;
			}

			// If values are different, trees are not the same
			if (node1.val != node2.val) {
				return false;
			}

			// Add left and right children to the queue for further comparison
			queue.add(node1.left);
			queue.add(node2.left);
			queue.add(node1.right);
			queue.add(node2.right);
		}

		return true;
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;

		// Recursively check the left and right subtrees
		// This ensures that both the structure and values of the trees are the same.
		// If both left and right subtrees are the same, then the trees are identical
		// This is a depth-first traversal approach.
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	// Definition for a binary tree node.
	static class TreeNode {

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