package BinarySearch.problems;

public class CilingNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };
        int target = 2;
        System.out.println("Ceiling Number of " + target + " is " + ceiling(arr, target));

    }
    // Ceiling number = smallest greater than or equal to target..

    private static int ceiling(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (target > arr[right]) {
            // No ceiling no is present in this array
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return arr[left];
    }
}
