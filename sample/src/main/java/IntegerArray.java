/**
 * Created by Administrator on 2014-07-08.
 */
public class IntegerArray {

    public final static int BUBBLE_SORT = 1;

    public final static int QUICK_SORT = 2;

    private int[] numbers;
    private int size;

    public IntegerArray(int[] values) {
        this.numbers = values;
        this.size = numbers.length;
    }

    public void sort(int algorithmType) {
        switch (algorithmType) {
            case BUBBLE_SORT:
                bubbleSort();
                break;
            case QUICK_SORT:
                quickSort(0, size - 1);
                break;
        }
    }

    private void bubbleSort() {
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    exchange(j, j + 1);
                }
            }
        }
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
