package easy.done;

/**
 * LeetCode Problem 993: Cousins in Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
 * Topic: Tree, Depth-First Search (DFS)
 *
 * This class provides a method to determine if two nodes in a binary tree are cousins,
 * meaning they are at the same depth but have different parents. The main method demonstrates
 * the usage of the isCousins method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: Use DFS to track the depth and parent of each target node.
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class CousinsInBinaryTree {

	private TreeNode parentX = null;
	private TreeNode parentY = null;
	private int depthX = -1;
	private int depthY = -1;
	private boolean foundX = false;
	private boolean foundY = false;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);

		CousinsInBinaryTree solution = new CousinsInBinaryTree();
		boolean result = solution.isCousins(root, 5, 4);
		System.out.println("Are nodes 5 and 4 cousins? " + result); // Output: true
	}

	private boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, null, 0, x, y);
		return depthX == depthY && parentX != parentY;
	}

	private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
		// stop when both found
		if (node == null || (foundX && foundY))
			return;

		if (node.val == x) {
			foundX = true;
			parentX = parent;
			depthX = depth;
		} else if (node.val == y) {
			foundY = true;
			parentY = parent;
			depthY = depth;
		}

		dfs(node.left, node, depth + 1, x, y);
		dfs(node.right, node, depth + 1, x, y);
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}