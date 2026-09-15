package Week06;
import java.util.Arrays;
import java.util.Random;
public class QuickSort {
    private static final Random random = new Random();
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        sort(arr, 0, arr.length - 1);
    }
    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int randPivot = low + random.nextInt(high - low + 1);
        swap(arr, randPivot, high);
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5, 23, 14 };
        System.out.println("Original: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("Quick Sorted: " + Arrays.toString(arr));
    }
}
