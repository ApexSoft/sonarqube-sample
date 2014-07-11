import java.util.Arrays;

/**
 * Created by Administrator on 2014-07-10.
 */
public class MergeSort implements SortAlgorithm {

    /**
     *
     * @param numbers
     */
    @Override
    public void sort(int...numbers) {
        mergesort(0, numbers.length - 1, numbers);
    }

    private void mergesort(int low, int high, int...numbers) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle, numbers);
            // Sort the right side of the array
            mergesort(middle + 1, high, numbers);
            // Combine them both
            merge(numbers, low, middle, high);
        }
    }

    /**
     *
     * @param numbers
     * @param low
     * @param middle
     * @param high
     */
    private void merge(int[] numbers, int low, int middle, int high) {
        // Copy both parts into the helper array
        int[] helper = new int[numbers.length];
        System.arraycopy(numbers, 0, helper, 0, numbers.length);

        int left_side = low;
        int right_side= middle + 1;
        int pivot = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (left_side <= middle && right_side <= high) {
            if (helper[left_side] <= helper[right_side]) {
                numbers[pivot] = helper[left_side];
                left_side++;
            } else {
                numbers[pivot] = helper[right_side];
                right_side++;
            }
            pivot++;
        }
        // Copy the rest of the left side of the array into the target array
        System.arraycopy(numbers, pivot, helper, left_side, middle + 1 - left_side);
    }
}
