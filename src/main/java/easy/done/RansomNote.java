package easy.done;

/*
 * LeetCode Problem 383: Ransom Note
 * Time Complexity: O(n + m), where n is the length of the ransom note and m is the length of the magazine.
 * Space Complexity: O(1), since we are using a fixed-size array for character counts.
 * Topics: String, Hash Table
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

	public static void main(String[] args) {
		String ransomNote = "a";
		String magazine = "b";
		boolean result = canConstructBrute(ransomNote, magazine);
		System.out.println("Can construct ransom note: " + result); // Output: false

		ransomNote = "aa";
		magazine = "ab";
		result = canConstructOptimal(ransomNote, magazine);
		System.out.println("Can construct ransom note: " + result); // Output: false

		ransomNote = "aa";
		magazine = "aab";
		result = canConstructOptimal(ransomNote, magazine);
		System.out.println("Can construct ransom note: " + result); // Output: true
	}

	private static boolean canConstructOptimal(String ransomNote, String magazine) {
		int[] letters = new int[26];

		for(char c : magazine.toCharArray()){
			letters[c - 'a']++;
		}

		for(char c : ransomNote.toCharArray()){
			letters[c - 'a']--;
			if( letters[c - 'a'] < 0){
				return false;
			}
		}

		return true;
	}

	private static boolean canConstructBrute(String ransomNote, String magazine) {
		StringBuilder sb = new StringBuilder(magazine);

		for (char c : ransomNote.toCharArray()) {
			// Find the index of the character in the magazine
			int index = sb.indexOf(String.valueOf(c));
			// If the character is not found, return false
			if (index == -1) {
				return false;
			}
			// Remove the character from the magazine
			sb.deleteCharAt(index);
		}

		return true;
	}
}
