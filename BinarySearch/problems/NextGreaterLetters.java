package BinarySearch.problems;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
// same as ceiling of a number problem
public class NextGreaterLetters {
    public static void main(String[] args) {
        // Edge cases
        System.out.println(nextGreatestLetter(new char[] { 'x', 'x', 'y', 'y' }, 'z'));
        System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'j'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        // base case
        if (letters[end] <= target) {
            return letters[0];
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start];

    }
}
