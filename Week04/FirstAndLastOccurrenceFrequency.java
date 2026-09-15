package Week04;
import java.util.Arrays;
public class FirstAndLastOccurrenceFrequency {
    public static int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int firstIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                firstIndex = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstIndex;
    }
    public static int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int lastIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                lastIndex = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastIndex;
    }
    public static int countFrequency(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) return 0;
        int last = findLastOccurrence(arr, target);
        return (last - first + 1);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6 };
        int target = 5;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        int freq = countFrequency(arr, target);
        System.out.printf("First Occurrence: %d | Last Occurrence: %d | Total Frequency: %d%n",
                first, last, freq);
    }
}
