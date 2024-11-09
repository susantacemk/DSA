package problems;

// Problem Links -https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakElementMountainArr {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        System.out.println(peakIndexInMountainArray(arr));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 2, 3, 2, 1 }));
    }

    // Time Complexity = O(log n)
    // Space complexity = O(1)
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // we are in left hand side ..
                // We are in asc part.
                start = mid + 1;
            } else {
                // we are in right hand side..
                // We are in desc part
                end = mid;
            }
        }
        return start;
    }
}
