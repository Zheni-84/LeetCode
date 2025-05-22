# LeetCode Problems

This repository contains my solutions to LeetCode problems in Java.

---
<!-- TOC -->
* [LeetCode Problems](#leetcode-problems)
  * [📝 Problem List](#-problem-list)
    * [Easy Problems](#easy-problems)
    * [Medium Problems](#medium-problems)
    * [Hard Problems](#hard-problems)
  * [🚀 How I solve problems](#-how-i-solve-problems)
  * [✏️ Notes](#-notes)
  * [🛠 Git Workflow Reminder](#-git-workflow-reminder)
  * [📈 Goals](#-goals)
  * [📚 Useful Resources](#-useful-resources)
  * [📧 Contact](#-contact)
<!-- TOC -->

## 📝 Problem List

### Easy Problems

|    # |                           Problem                            |                  Topics                   |                                     Solution                                      |
|-----:|:------------------------------------------------------------:|:-----------------------------------------:|:---------------------------------------------------------------------------------:|
|   66 |                           Plus one                           |                Array, Math                |                 [Java Code](src/main/java/easy/done/PlusOne.java)                 |
|  125 |                       Valid Palindrome                       |           Two Pointers, String            |             [Java Code](src/main/java/easy/done/ValidPalindrome.java)             |
|  133 |                Reverse Words in a String III                 |              String, Streams              |             [Java Code](src/main/java/easy/done/ReverseWordsIII.java)             |
|  136 |                        Single Number                         |         Arrays, Bit Manipulation          |              [Java Code](src/main/java/easy/done/SingleNumber.java)               |
|  219 |                    Contains Duplicate II                     |              Array, HashMap               |           [Java Code](src/main/java/easy/done/ContainsDuplicate2.java)            |
|  392 |                        Is Subsequence                        |           Two Pointers, String            |              [Java Code](src/main/java/easy/done/IsSubsequence.java)              |
|  392 |                  Is Subsequence (Optimized)                  |           String, Binary Search           |         [Java Code](src/main/java/easy/done/IsSubsequenceOptimized.java)          |
|  414 |                     Third Maximum Number                     |         Arrays, Sorting, TreeSet          |           [Java Code](src/main/java/easy/done/ThirdMaximumNumber.java)            |
|  455 |                        Assign Cookies                        |          Array, Sorting, Greedy           |              [Java Code](src/main/java/easy/done/AssignCookies.java)              |
|  495 |                       Teemo Attacking                        |               Array, Greedy               |             [Java Code](src/main/java/easy/done/TeemoAttacking.java)              |
|  496 |                    Next Greater Element I                    | Array, Hash Table, Stack, Monotonic Stack |           [Java Code](src/main/java/easy/done/NextGreaterElement1.java)           |
|  506 |                        Relative Ranks                        |   Array, Sorting, Heap (Priority Queue)   |              [Java Code](src/main/java/easy/done/RelativeRanks.java)              |
|  541 |                      Reverse String II                       |                  String                   |             [Java Code](src/main/java/easy/done/ReverseStringII.java)             |
|  557 |                Reverse Words in a String III                 |           String, Two Pointers            |        [Java Code](src/main/java/easy/done/ReverseWordsInAStringIII.java)         |
|  557 |         Reverse Words in a String III (**Streams**)          |       String, Stream, StringBuilder       |     [Java Code](src/main/java/easy/done/ReverseWordsInAStringIIIStream.java)      |
|  594 |                Longest Harmonious Subsequence                |             Array, Hash Table             |      [Java Code](src/main/java/easy/done/LongestHarmoniousSubsequence.java)       |
|  661 |                        Image Smoother                        |               Array, Matrix               |              [Java Code](src/main/java/easy/done/ImageSmoother.java)              |
|  605 |                      Can Place Flowers                       |               Array, Greedy               |             [Java Code](src/main/java/easy/done/CanPlaceFlowers.java)             |
|  643 |                  Maximum Average Subarray I                  |           Array, Sliding Window           |         [Java Code](src/main/java/easy/done/MaximumAverageSubarrayI.java)         |
|  674 |          Longest Continuous Increasing Subsequence           |                   Array                   |      [Java Code](src/main/java/easy/done/LongestContinuousSubsequence.java)       |
|  680 |                     Valid Palindrome II                      |       Two Pointers, String, Greedy        |            [Java Code](src/main/java/easy/done/ValidPalindrome2.java)             |
|  680 |              Valid Palindrome II (**Streams**)               |   Two Pointers, String, Greedy, Streams   |         [Java Code](src/main/java/easy/done/ValidPalindrome2Streams.java)         |
|  804 |                   Unique Morse Code Words                    |         Array, Hash Table, String         |          [Java Code](src/main/java/easy/done/UniqueMorseCodeWords.java)           |
|  804 |            Unique Morse Code Words (**Streams**)             |    Array, Hash Table, String, Streams     |       [Java Code](src/main/java/easy/done/UniqueMorseCodeWordsStreams.java)       |
|  819 |                       Most Common Word                       |       String, Hash Table, Counting        |             [Java Code](src/main/java/easy/done/MostCommonWord.java)              |
|  941 |                     Valid Mountain Array                     |            Array, Two Pointers            |           [Java Code](src/main/java/easy/done/ValidMountainArray.java)            |
|  976 |                  Largest Perimeter Triangle                  |              Array, Sorting               |        [Java Code](src/main/java/easy/done/LargestPerimeterTriangle.java)         |
| 1050 |                        Height Checker                        |              Array, Sorting               |              [Java Code](src/main/java/easy/done/HeightChecker.java)              |
| 1295 |           Find Numbers with Even Number of Digits            |              String, Ponters              |         [Java Code](src/main/java/easy/done/MergeStringsAlternately.java)         |
| 1491 | Average Salary Excluding the Minimum <br/>and Maximum Salary |              Array, Sorting               |  [Java Code](src/main/java/easy/done/AverageSalaryExcludingMinimumMaximum.java)   |
| 1634 |                      Buy Two Chocolates                      |              Array, Sorting               |            [Java Code](src/main/java/easy/done/BuyTwoChocolates.java)             |
| 1652 |                       Defuse the Bomb                        |                   Array                   |              [Java Code](src/main/java/easy/done/DefuseTheBomb.java)              |
| 1768 |                  Merge Strings Alternately                   |              Array, Sorting               |            [Java Code](src/main/java/easy/done/BuyTwoChocolates.java)             |
| 1913 |         Maximum Product Difference Between Two Pairs         |              Array, Sorting               | [Java Code](src/main/java/easy/done/MaximumProductDifferenceBetweenTwoPairs.java) |
| 1920 |           Minimum Number of Moves to Seat Everyone           |              Array, Sorting               |     [Java Code](src/main/java/easy/done/MinimumNumberMovesSeatEveryone.java)      |
| 2395 |                  Find K-Beauty of a Number                   |               String, Math                |           [Java Code](src/main/java/easy/done/FindKBeautyOfNumber.java)           |

---

### Medium Problems

| # | Problem Title   | Topics |                       Solution                       |
|--:|:----------------|:------:|:----------------------------------------------------:|
| 2 | Add Two Numbers |        | [Java Code](src/main/java/medium/AddTwoNumbers.java) |

---

### Hard Problems

|    # | Problem Title            |                                  Topics                                   |                    Solution                     |
|-----:|:-------------------------|:-------------------------------------------------------------------------:|:-----------------------------------------------:|
|   41 | First Missing Positive   |                                                                           | [Java Code](src/main/java/hard/FirstMissingPositive.java) |
| 1499 | Max Value of Equation    | Array, Queue, Sliding Window, <br/>Heap (Priority Queue), Monotonic Queue | [Java Code](src/main/java/hard/MaxValueOfEquation.java) |

---

---

## 🚀 How I solve problems

- **Understand** the problem requirements
- **Break down** edge cases
- **Write** clean and efficient code
- **Refactor** if I find better approaches
- **Add** short explanations when needed

---

## ✏️ Notes

- Each solution has proper JavaDoc on top linking to the original problem.
- Clean, readable code using Java best practices (Streams, Optionals, Lambdas when appropriate).
- Commits follow a clean, descriptive template.

---

## 🛠 Git Workflow Reminder

Refer to [GIT_WORKFLOW.md](GIT_WORKFLOW.md) for a full guide on how to contribute and push new problems.

---

## 📈 Goals

- Solve 500+ LeetCode problems
- Focus on mastering Data Structures and Algorithms
- Improve Java coding standards for interviews and real-world applications

## 📚 Useful Resources

- [LeetCode](https://leetcode.com/)
- [Java 8+ Documentation](https://docs.oracle.com/javase/8/docs/api/)
- [Big-O Cheat Sheet](https://www.bigocheatsheet.com/)

---

## 📧 Contact

If you want to connect, discuss, or collaborate, feel free to reach out!