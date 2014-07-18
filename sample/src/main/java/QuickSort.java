/**
 * Created by Administrator on 2014-07-10.
 */
public class QuickSort implements SortAlgorithm {

    /**
     *
     * @param numbers
     */
    public void sort(int...numbers) {
        quickSort(0, numbers.length - 1, numbers);
    }

    /**
     *
     * @param numbers
     * @param low
     * @param high
     */
    private void quickSort(int low, int high, int...numbers) {
        int low_temp= low, high_temp= high;
        int pivot = numbers[low + (high - low) / 2];

        while (low_temp <= high_temp) {
            while (numbers[low_temp] < pivot) {
                low_temp++;
            }
            while (numbers[high_temp] > pivot) {
                high_temp--;
            }
            if (low_temp <= high_temp) {
                exchange(numbers, low_temp, high_temp);
                low_temp++;
                high_temp--;
            }
        }

        if (low < high_temp) {
            quickSort(low, high_temp, numbers);
        }
        if (low_temp < high) {
            quickSort(low_temp, high, numbers);
        }
    }

    /**
     *
     * @param numbers
     * @param first
     * @param second
     */
    private void exchange(int[] numbers, int first, int second) {
    	if (first == second) {
    		return;
    	}
        numbers[first] = numbers[first] ^ numbers[second];
        numbers[second] = numbers[first] ^ numbers[second];
        numbers[first] = numbers[first] ^ numbers[second];
    }

}
