package easy.done;

/**
 * LeetCode 28. Find the Index of the First Occurrence in a String
 * Time Complexity: O(n * m), where n is the length of `haystack` and m is the length of `needle`.
 * Space Complexity: O(1), since we are using a constant amount of space for the index variable.
 * Topics: String, String Matching, Two Pointers
 * <p>
 * Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`,
 * or -1 if `needle` is not part of `haystack`.
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class FindIndexOfFirstOccurrenceInString {

	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		int index = strStr(haystack, needle);
		System.out.println("Index of first occurrence: " + index); // Output: 2

		haystack = "aaaaa";
		needle = "bba";
		index = strStr(haystack, needle);
		System.out.println("Index of first occurrence: " + index); // Output: -1
	}
	private static int strStr(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();

		if(m > n){
			return -1;
		}

		// Iterate through the haystack string
		for(int i = 0; i <= n-m; i++){
			// Check if the substring from i to i+m matches the needle
			int j = 0;
			// Compare characters of needle with haystack
			while(j < m && haystack.charAt(i+j) == needle.charAt(j)){
				j++;
			}
			// If we have matched all characters of needle
			// then return the starting index i
			if(j==m){
				return i;
			}
		}
		// If no match found, return -1
		return -1;
	}
}