package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem 1652 - Defuse the Bomb
 * Topics: Array
 * Time Complexity: O(n*k), where n is the length of the code and k is the absolute value of k.
 * Space Complexity: O(n), for the result array.
 * <p>
 * You have a circular array code of length n and an integer k.
 * To decrypt the code, create a new array where for each index i:
 *   - If k > 0, sum the next k elements.
 *   - If k < 0, sum the previous k elements.
 *   - If k == 0, set to 0.
 * Return the resulting array.
 * <p>
 * Example:
 * Input: code = [5,7,1,4], k = 3
 * Output: [12,10,16,13]
 */
public class DefuseTheBomb {
	public static void main(String[] args) {
		int[] code = {5,7,1,4};
		int k = 3;
		int[] result = decrypt(code, k);
		System.out.println(Arrays.toString(result)); // Output: [12,10,16,13]
	}

	/**
	 * Function to decrypt the code based on the value of k.
	 *
	 * @param code The input array representing the code.
	 * @param k    The integer value used for decryption.
	 * @return The decrypted array.
	 */
	private static int[] decrypt(int[] code, int k) {
		int len = code.length;
		// Initialize the result array with the same length as code
		int[] result = new int[len];
		// If k is 0, return an array of zeros
		if(k==0){
			return result;
		}
		// Iterate through each index of the code array
		for(int i = 0; i<len; i++){
			if(k>0){
				// Sum the next k elements
				for(int j = 1; j<=k; j++){
					result[i] += code[(i+j)%len];
				}
			}else{
				// Sum the previous k elements
				for(int j = 1; j<=-k; j++){
					result[i] += code[(i-j+len)%len];
				}
			}
		}

		return result;
	}
}