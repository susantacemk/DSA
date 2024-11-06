package Problem;
// https://leetcode.com/problems/find-if-array-can-be-sorted/description/?envType=daily-question&envId=2024-11-06
public class CheckArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{3,16,8,4,2}));
    }

    public static boolean canSortArray(int[] nums) {  // O(n^2 log n)
        // using Bubble sort
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] <= nums[j + 1]) {
                    continue; // it is correct order..
                } else { // its able swap
                    if (countSetBits(nums[j]) != countSetBits(nums[j + 1])) {
                        return false;
                    } else {
                        // swap
                        int val = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = val;
                    }
                }
            }
        }
        return true;
    }

    private static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count += 1;
            num = num & (num - 1);
        }
        return count;
    }
}
