package easy.done;

/* LeetCode Problem 938. Range Sum of BST
 * Time: O(m) m <= n where n is the number of nodes in the tree. We prune branches or might visit all nodes
 * Space: O(h) where h is the height of the tree due to recursion stack
 * Topics: Tree, Depth-First Search, Binary Search Tree
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 * Example:
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are within the range [7, 15]. Therefore, we return the sum 7 + 10 + 15 = 32.
 * Hint: Use the properties of the BST to skip branches that do not fall within the range.
 * http://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);

		int low = 7;
		int high = 15;

		System.out.println("Range Sum of BST: " + rangeSumBST(root, low, high)); // Output: 32
	}

	private static int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;

		// If current node is less than low, skip left subtree
		if (root.val < low)
			return rangeSumBST(root.right, low, high);

		// If current node is greater than high, skip right subtree
		if (root.val > high)
			return rangeSumBST(root.left, low, high);

		// Current node is within range, include it and recurse both sides
		return root.val
				+ rangeSumBST(root.right, low, high)
				+ rangeSumBST(root.left, low, high);
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