/**
 * Created by Administrator on 2014-07-10.
 */
public class QuickSort implements SortAlgorithm {

    private int[] numbers;
    private int size;

    public QuickSort() {
    }

    @Override
    public void sort(int[] values) {
        this.numbers = values;

        quickSort(0, numbers.length - 1);
    }

    private void quickSort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }
    }

    private void exchange(int i, int j) {
        numbers[i] = numbers[i] ^ numbers[j];
        numbers[j] = numbers[i] ^ numbers[j];
        numbers[i] = numbers[i] ^ numbers[j];
    }

}
