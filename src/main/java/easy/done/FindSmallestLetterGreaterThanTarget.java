package easy.done;

/* LeetCode Problem 744: Find Smallest Letter Greater Than Target
 * Time Complexity: O(log n), where n is the number of letters in the array.
 * Space Complexity: O(1)
 * Topic: Binary Search, Array
 *
 * This class provides a method to find the smallest letter in a sorted array that is greater than a given target letter.
 * The main method demonstrates the usage of the nextGreatestLetter method.
 *
 * Hint: Use binary search to efficiently find the target letter.
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'a';
		char result = nextGreatestLetter(letters, target);
		System.out.println(result); // Output: 'c'

		letters = new char[] { 'a', 'z' };
		target = 'm';
		result = nextGreatestLetter(letters, target);
		System.out.println(result); // Output: 'z'

		//letters from a to z
		letters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };
		target = 'z';
		result = nextGreatestLetter(letters, target);
		System.out.println(result); // Output: 'a', no greate than z
	}

	private static char nextGreatestLetter(char[] letters, char target) {
		int len = letters.length - 1;
		if (letters[0] > target || letters[len] <= target)
			return letters[0];
		int l = 0;
		int r = len;
		while (r - l > 1) {
			int mid = (r + l) / 2;
			if (letters[mid] <= target)
				l = mid;
			else
				r = mid;
		}

		return letters[r % letters.length];
	}
}