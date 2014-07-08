import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by Administrator on 2014-07-08.
 */
public class IntegerArrayTest {

    private final static Logger log = LoggerFactory.getLogger(IntegerArrayTest.class);

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
    public void testBubbleSort() {
        IntegerArray sorter = new IntegerArray(numbers);
        sorter.sort(IntegerArray.BUBBLE_SORT);
        if (!validate(numbers)) {
            log.error("Should not happen");
        }
    }

    @Test
    public void testQuickSort() {
        IntegerArray sorter = new IntegerArray(numbers);
        sorter.sort(IntegerArray.QUICK_SORT);
    }

    private boolean validate(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
