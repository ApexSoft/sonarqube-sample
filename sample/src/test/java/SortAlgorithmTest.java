import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Administrator on 2014-07-10.
 */
public class SortAlgorithmTest {

    private int[] numbers;
    private final static int SIZE = 9;
    private final static int MAX = 100;

    @Before
    public void setup() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testBubbleSortStrategy() {
        SortAlgorithm algorithm = new BubbleSort();
        algorithm.sort(numbers);
    }

    @Test
    public void testQuickSortStrategy() {
        SortAlgorithm algorithm = new QuickSort();
        algorithm.sort(numbers);
    }

    @Test
    public void testMergeSortStrategy() {
        SortAlgorithm algorithm = new MergeSort();
        algorithm.sort(numbers);
    }
}
