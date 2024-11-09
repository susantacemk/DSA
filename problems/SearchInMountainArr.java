package problems;

public class SearchInMountainArr {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        int target = 3;
        System.out.println(findInMountainArray(arr, target));
    }

    /*
     * To solve this problem we simply follow 3 steps
     * i. Find the peak element in the mountain array.
     * ii. Search in first index to till peak element index.
     * iii. If the element is not found in first half then check to peak index to
     * last index.
     */
    public static int findInMountainArray(int[] arr, int target) {
        int peakIndex = peakIndexInMountainArray(arr);
        int firstAnswer = searchAsc(arr, target, 0, peakIndex);
        if (firstAnswer == -1) {
            return searchDESC(arr, target, peakIndex, arr.length - 1);
        } else {
            return firstAnswer;
        }

    }

    // i. Find the peak index in the array
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

    // ii. search the target in o index to till peak index (Ascending order Binary
    // Search)
    static int searchAsc(int[] arr, int target, int left, int right) {

        // condition
        while (left <= right) {
            // find the middle element
            int mid = left + (right - left) / 2;

            // 3 condition
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // target element is present in left side..
                right = mid - 1;
            } else {
                // target element is present in right side..
                left = mid + 1;
            }
        }

        // if , target element is not found then return -1;
        return -1;
    }

    // ii. search the target in peak index to till last index (Descending order
    // Binary
    // Search)
    static int searchDESC(int[] arr, int target, int left, int right) {
        // condition
        while (left <= right) {
            // find the middle element
            int mid = left + (right - left) / 2;

            // 3 condition
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // target element is present in left side..
                right = mid - 1;
            } else {
                // target element is present in right side..
                left = mid + 1;
            }
        }

        // if , target element is not found then return -1;
        return -1;
    }
}
