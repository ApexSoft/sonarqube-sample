import java.util.Arrays;

/**
 * Created by Administrator on 2014-07-10.
 */
public class BubbleSort implements SortAlgorithm {

    private int[] numbers;

    public BubbleSort() {
    }

    @Override
    public void sort(int[] values) {
        this.numbers = values;

        int size = numbers.length;
        int low = 0;
        int high = size - 1;

        while (low < high) {
            int lowest  = low;
            int highest = high;
            low = size;
            for (int i = lowest; i < highest; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    exchange(i, i + 1);
                    if (i < low) {
                        low = i-1;
                        if (low < 0) {
                            low = 0;
                        }
                    } else if (i > high) {
                        high = i + 1;
                    }
                }
            }
        }
    }

    private void exchange(int i, int j) {
        numbers[i] = numbers[i] ^ numbers[j];
        numbers[j] = numbers[i] ^ numbers[j];
        numbers[i] = numbers[i] ^ numbers[j];
    }
}
