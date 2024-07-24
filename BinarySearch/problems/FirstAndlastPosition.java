package BinarySearch.problems;

import java.util.Arrays;

public class FirstAndlastPosition {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 7, 7, 8, 8, 10 };
        int target = 7;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        // brute force manner == o(n)
        int[] ans = { -1, -1 };
        // First loop check the first position.
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == target) {
        // ans[0] = i;
        // break;
        // }
        // }
        // // Second loop check the last positions.
        // for (int i = nums.length - 1; i >= 0; i--) {
        // if (nums[i] == target) {
        // ans[1] = i;
        // break;
        // }
        // }

        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }

        return ans;
    }

    // Optimized approach == Time Complexity = O(log n)

    public static int search(int[] arr, int target, boolean index) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                if (index) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
