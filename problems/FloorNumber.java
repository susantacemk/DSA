package problems;

public class FloorNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };
        int target = 15;
        System.out.println("Ceiling Number of " + target + " is " + floor(arr, target));
    }

    // Floor = Greatest smaller than or equal to the target..
    private static int floor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
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
        return arr[right];
    }
}
