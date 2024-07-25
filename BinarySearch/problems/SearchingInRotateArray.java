package BinarySearch.problems;

public class SearchingInRotateArray {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    /*
     * [0,1,2,3,4,5,6,7] => rotated array = [4,5,6,7,0,1,2]
     * We can see the rotaed array upto peak element the array is sorted in
     * ascending order
     * and after the peak element teh array is sorted in ascending order..
     * 
     * To search in rotated array , You will the following the steps-
     * i. first of all find the peak element index {3}
     * ii. upto 0 index to 3 index the array is sorted in ascending order.
     * iii. And index 3 to till last index the array is sorted in ascending order.
     */
    public static int search(int[] nums, int target) {
        int peakIndex = peakIndexInMountainArray(nums);
        int firstAnswer = searchAsc(nums, target, 0, peakIndex);
        if (firstAnswer == -1) {
            return searchAsc(nums, target, peakIndex, nums.length - 1);
        } else {
            return firstAnswer;
        }
    }

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
}
