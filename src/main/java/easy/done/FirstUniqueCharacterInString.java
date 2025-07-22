package easy.done;

/**
 * LeetCode Problem 387: First Unique Character in a String
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Topics: Index array, String, Counting
 * <p>
 * Given a string, find the index of the first non-repeating character in it.
 * If it doesn't exist, return -1.
 * <p>
 * Example:
 * Input: "leetcode"
 * Output: 0 (the first unique character is 'l')
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		String s = "leetcode";
		int index = firstUniqChar(s);
		if (index != -1) {
			System.out.println("The first unique character is at index: " + index);
		} else {
			System.out.println("No unique character found.");
		}
	}

	private static int firstUniqChar(String s) {
		// Assuming the string contains only lowercase letters a-z
		int[] count = new int[26];

		// Count the occurrences of each character
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		// Iterate through the string again to find the first unique character
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// Check if the character count is 1
			if (count[c - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}

	private static int firstUniqCharHashMap(String s) {
		// Using a HashMap to count occurrences
		java.util.Map<Character, Integer> charCount = new java.util.HashMap<>();

		// Count the occurrences of each character
		for (char c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		// Iterate through the string again to find the first unique character
		for (int i = 0; i < s.length(); i++) {
			if (charCount.get(s.charAt(i)) == 1) {
				return i;
			}
		}

		return -1;

	}
}