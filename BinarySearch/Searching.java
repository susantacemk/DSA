package BinarySearch;

class Searching {
    // Binary Search in ascending Order
    public static void main(String[] args) {
        int[] arr = { 10, 12, 23, 34, 54, 65, 76, 87 };
        int target = 54;
        System.out.println(searchAsc(arr, target));

        int[] arr2 = { 87, 76, 65, 54, 34, 23, 12, 10 };
        System.out.println(searchDESC(arr2, 34));
    }

    static int searchAsc(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

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

    static int searchDESC(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

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