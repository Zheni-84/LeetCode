package easy.done;

/**
 * LeetCode Problem 1022: Sum of Root To Leaf Binary Numbers
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
 * Topic: Tree, Depth-First Search (DFS)
 * <p>
 * This class provides a method to calculate the sum of all root-to-leaf paths in a binary tree,
 * where each path represents a binary number. The main method demonstrates the usage of the
 * sumRootToLeaf method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: Use DFS to build the binary number as you traverse the tree.
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumOfRootToLeafBinaryNumbers {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);

		SumOfRootToLeafBinaryNumbers solution = new SumOfRootToLeafBinaryNumbers();
		int result = solution.sumRootToLeaf(root);
		System.out.println("Sum of Root to Leaf Binary Numbers: " + result); // Output: 22
	}

	public int sumRootToLeaf(TreeNode root) {
		return dfs(root, 0);
	}

	private int dfs(TreeNode node, int currentSum) {
		if (node == null) {
			return 0;
		}

		// shift left(= multiply by 2) and add val as most insignificant bit
		currentSum = (currentSum << 1) | node.val;

		// If it's a leaf node, return the current sum
		if (node.left == null && node.right == null) {
			return currentSum;
		}

		// Recurse for left and right subtrees
		return dfs(node.left, currentSum) + dfs(node.right, currentSum);
	}

	// Definition for a binary tree node.
	public static class TreeNode {

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