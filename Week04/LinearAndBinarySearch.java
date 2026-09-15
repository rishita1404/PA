package Week04;
import java.util.Arrays;
public class LinearAndBinarySearch {
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearchIterative(int[] arr, int target) {
        if (arr == null) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, high);
        } else {
            return binarySearchRecursive(arr, target, low, mid - 1);
        }
    }
    public static void main(String[] args) {
        int[] unsorted = { 42, 12, 88, 7, 23, 65 };
        int target = 23;
        System.out.println("Linear Search on " + Arrays.toString(unsorted) + " for " + target +
                ": Index = " + linearSearch(unsorted, target));
        int[] sorted = { 3, 8, 14, 23, 37, 52, 68, 91 };
        System.out.println("\nSorted Array: " + Arrays.toString(sorted));
        System.out.println("Iterative Binary Search for 37: Index = " + binarySearchIterative(sorted, 37));
        System.out.println("Recursive Binary Search for 37: Index = " + binarySearchRecursive(sorted, 37, 0, sorted.length - 1));
        System.out.println("Binary Search for missing element 99: Index = " + binarySearchIterative(sorted, 99));
    }
}
