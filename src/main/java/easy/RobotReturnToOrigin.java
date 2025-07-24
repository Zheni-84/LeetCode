package easy;

/*
 * LeetCode Problem 657 - Robot Return to Origin
 * Topics: String, Simulation
 * Time Complexity: O(n), where n is the length of the moves string.
 * Space Complexity: O(1) - only a few integer variables are used.
 *
 * Description:
 * A robot is initially at the origin (0, 0) and can move in four directions: up (U), down (D), left (L), and right (R).
 * The robot returns to the origin if it ends up at (0, 0) after executing a sequence of moves.
 * This problem checks if the robot returns to the origin after a series of moves.
 * LeetCode Link: https://leetcode.com/problems/robot-return-to-origin/
 */
public class RobotReturnToOrigin {

	public static void main(String[] args) {
		RobotReturnToOrigin robot = new RobotReturnToOrigin();
		System.out.println(robot.judgeCircle("UDLR")); // true
		System.out.println(robot.judgeCircle("UUDDLLRR")); // true
		System.out.println(robot.judgeCircle("UUDD")); // true
		System.out.println(robot.judgeCircle("UUU")); // false
		System.out.println(robot.judgeCircleStreams("UDLR")); // true
	}

	public boolean judgeCircle(String moves) {
		int horizontal = 0;
		int vertical = 0;

		for (char move : moves.toCharArray()) {
			switch (move) {
				case 'U' -> vertical++;
				case 'D' -> vertical--;
				case 'L' -> horizontal--;
				case 'R' -> horizontal++;
			}
		}

		return horizontal == 0 && vertical == 0;
	}

	public boolean judgeCircleStreams(String moves) {
		long vertical = moves.chars()
				.filter(c -> c == 'U' || c == 'D')
				.map(c -> c == 'U' ? 1 : -1)
				.sum();

		long horizontal = moves.chars()
				.filter(c -> c == 'L' || c == 'R')
				.map(c -> c == 'R' ? 1 : -1)
				.sum();

		return vertical == 0 && horizontal == 0;
	}
}