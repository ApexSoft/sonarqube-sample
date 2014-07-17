/**
 * Created by Administrator on 2014-07-10.
 */
public class BubbleSort implements SortAlgorithm {

    /**
     * bubble sort
     * @param numbers
     */
    public void sort(int...numbers) {
        int size = numbers.length;
        int low = 0;
        int high = size - 1;

        while (low < high) {
            int lowest  = low;
            int highest = high;
            low = size;
            for (int i = lowest; i < highest; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    exchange(i, i + 1, numbers);
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

    /**
     * exchange numbers[i] and numbers[j]
     * @param numbers
     * @param first
     * @param second
     */
    private void exchange(int first, int second, int...numbers) {
        numbers[first] = numbers[first] ^ numbers[second];
        numbers[second] = numbers[first] ^ numbers[second];
        numbers[first] = numbers[first] ^ numbers[second];
    }
}
