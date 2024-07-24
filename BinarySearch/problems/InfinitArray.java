package BinarySearch.problems;

public class InfinitArray {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 7, 9, 10, 12, 16, 21, 23, 24, 27, 29, 30, 35, 46, 48, 50 };
        int target = 30;
        System.out.println("The position of " + target + " is " + helper(nums, target));
    }

    private static int helper(int[] nums, int target) {
        // take a chunks
        // initially take a 2 sized chunks
        int start = 0;
        int end = 1;
        while (nums[end] < target) {
            int temp = end + 1;
            // new end=previous end+(sized of the box)*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return search(nums, target, start, end);
    }

    public static int search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid; // ans found
            }
        }
        return -1; // ans not found
    }
}
