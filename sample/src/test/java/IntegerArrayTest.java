import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Administrator on 2014-07-08.
 */
public class IntegerArrayTest {

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
		IntegerArray array = new IntegerArray(numbers);
		System.out.println("**Bubble Sort**");
		System.out.print("before: ");
		printResult(array.getNumbers());
        array.setSortAlgorithm(new BubbleSort());
        array.sort();
		if (validate(numbers)) {
			System.out.print("sorted: ");
			printResult(array.getNumbers());
		} else {
			System.out.println("sort failed");
		}
    }

    @Test
    public void testQuickSort() {
		IntegerArray array = new IntegerArray(numbers);
		System.out.println("**Quick Sort**");
		System.out.print("before: ");
		printResult(array.getNumbers());
        array.setSortAlgorithm(new QuickSort());
        array.sort();
		if (validate(numbers)) {
			System.out.print("sorted: ");
			printResult(array.getNumbers());
		} else {
			System.out.println("sort failed");
		}
    }
    
    @Test
    public void testMergeSort() {
		IntegerArray array = new IntegerArray(numbers);
		System.out.println("**Merge Sort**");
		System.out.print("before: ");
		printResult(array.getNumbers());
        array.setSortAlgorithm(new MergeSort());
        array.sort();
		if (validate(numbers)) {
			System.out.print("sorted: ");
			printResult(array.getNumbers());
		} else {
			System.out.println("sort failed");
		}
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
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
