package easy.done;

/**
 * LeetCode Problem 35: Search Insert Position
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Topics: Array, Binary Search
 *
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 *
 * Example:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Hint: Use binary search to find the correct insertion point efficiently.
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums1 = {1, 3, 5, 6};
		int target1 = 5;
		System.out.println("Insert position: " + searchInsert(nums1, target1)); // Output: 2

		int[] nums2 = {1, 3, 5, 6};
		int target2 = 2;
		System.out.println("Insert position: " + searchInsert(nums2, target2)); // Output: 1

		int[] nums3 = {1, 3, 5, 6};
		int target3 = 7;
		System.out.println("Insert position: " + searchInsert(nums3, target3)); // Output: 4

		int[] nums4 = {1, 3, 5, 6};
		int target4 = 0;
		System.out.println("Insert position: " + searchInsert(nums4, target4)); // Output: 0
	}

	private static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int l = -1; // last index where nums[i] < target (before)
		int r = n;  // first index where nums[i] >= target (after)

		while (r - l > 1) {
			//int mid = l + (r - l) / 2;
			int mid = (l + r ) / 2;
			if (nums[mid] < target) { // is_before(mid)
				l = mid;
			} else {
				r = mid;
			}
		}

		return r; // first index where nums[r] >= target, or n if all are smaller
	}
}