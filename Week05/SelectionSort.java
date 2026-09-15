package Week05;
import java.util.Arrays;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = { 29, 10, 14, 37, 13 };
        System.out.println("Original: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Selection Sorted: " + Arrays.toString(arr));
    }
}
