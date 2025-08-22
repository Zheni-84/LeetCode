package easy.done;

/* LeetCode Problem 572: Subtree of Another Tree
 * Time Complexity: O(n * m), where n is the number of nodes in the main tree and m is the number of nodes in the subtree.
 * Space Complexity: O(h), where h is the height of the main tree (for recursion stack).
 * Topic: Binary Tree, Depth-First Search (DFS)
 *
 * This class provides a method to check if one binary tree is a subtree of another.
 * The main method demonstrates the usage of the isSubtree method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: A subtree is a tree consisting of a node and all its descendants.
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(0);

		TreeNode subRoot = new TreeNode(4);
		subRoot.left = new TreeNode(1);
		subRoot.right = new TreeNode(2);

		SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
		boolean result = solution.isSubtree(root, subRoot);
		System.out.println("Is subRoot a subtree of root? " + result); // Output: true
	}
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;
		if (isSame(root, subRoot))
			return true;

		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean isSame(TreeNode a, TreeNode b) {
		// If both nodes are null, they are the same
		if (a == null && b == null)
			return true;
		// If one is null and the other is not, they are not the same
		if (a == null || b == null)
			return false;
		// If values are different, they are not the same
		if (a.val != b.val)
			return false;
		// Recursively check left and right subtrees
		// If both left and right subtrees are the same, then the trees are the same
		return isSame(a.left, b.left) && isSame(a.right, b.right);
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