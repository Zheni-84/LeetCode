package easy;

/**
 * LeetCode Problem: 1629. Slowest Key
 * Time: O(n) where n is the number of keys pressed.
 * Space: O(1) since we are only using a few variables to store the maximum duration and the corresponding key.
 * Topics: String, Array
 * You are given a string keysPressed, where keysPressed[i] was pressed at the ith second, and an array releaseTimes,
 * where releaseTimes[i] is the time when the ith key was released.
 * Return the key that was pressed for the longest time. If there are multiple keys with the same maximum duration,
 * return the lexicographically largest key.
 * <p>
 * Example:
 * Input: releaseTimes = [9, 29, 49, 50], keysPressed = "cbcd"
 * Output: "c"
 * Hint: Use a loop to calculate the duration for each key and keep track of the maximum duration and corresponding key.
 * http://leetcode.com/problems/slowest-key/
 */
public class SlowestKey {

	public static void main(String[] args) {
		int[] releaseTimes1 = {9, 29, 49, 50};
		String keysPressed1 = "cbcd";
		char result1 = slowestKey(releaseTimes1, keysPressed1);
		System.out.println("The slowest key pressed is: " + result1);
		int[] releaseTimes2 = {12, 23, 36, 46, 62};
		String keysPressed2 = "spuda";
		char result2 = slowestKey(releaseTimes2, keysPressed2);
		System.out.println("The slowest key pressed is: " + result2);
		int[] releaseTimes3 = {1, 2, 3, 4, 5};
		String keysPressed3 = "abcde";
		char result3 = slowestKey(releaseTimes3, keysPressed3);
		System.out.println("The slowest key pressed is: " + result3);

	}
	private static char slowestKey(int[] releaseTimes, String keysPressed) {
		int maxDuration = releaseTimes[0];
		char resultKey = keysPressed.charAt(0);

		for(int i = 1; i < releaseTimes.length; i++){
			int duration = releaseTimes[i] - releaseTimes[i-1];
			char key = keysPressed.charAt(i);

			if(duration > maxDuration || (duration == maxDuration && resultKey < key)){
				maxDuration = duration;
				resultKey = key;
			}
		}

		return resultKey;
	}
}