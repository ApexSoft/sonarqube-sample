/**
 * Created by Administrator on 2014-07-10.
 */
public class MergeSort implements SortAlgorithm {

	private int[] helper;
	
    /**
     *
     * @param numbers
     */
    public void sort(int...numbers) {
        helper = new int[numbers.length];
        mergesort(0, numbers.length - 1, numbers);
    }

    private void mergesort(int low, int high, int...numbers) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle, numbers);
            mergesort(middle + 1, high, numbers);
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
        System.arraycopy(numbers, low, helper, low, high - low + 1);

        int left_side = low;
        int right_side= middle + 1;
        int pivot = low;
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
        System.arraycopy(helper, pivot, numbers, left_side, middle + 1 - left_side);
    }
}
