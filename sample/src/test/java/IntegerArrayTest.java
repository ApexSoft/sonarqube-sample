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
		System.out.println("**Bubble Sort**");
		System.out.print("before: ");
		printResult(numbers);
		IntegerArray sorter = new IntegerArray(numbers);
		sorter.sort(IntegerArray.BUBBLE_SORT);
		if (validate(numbers)) {
			System.out.print("sorted: ");
			printResult(numbers);
		}
	}

	@Test
	public void testQuickSort() {
		System.out.println("**Quick Sort**");
		System.out.print("before: ");
		printResult(numbers);
		IntegerArray sorter = new IntegerArray(numbers);
		sorter.sort(IntegerArray.QUICK_SORT);
		if (validate(numbers)) {
			System.out.print("sorted: ");
			printResult(numbers);
		}
	}

	@Test
	public void testMergeSort() {
		System.out.println("**Merge Sort**");
		System.out.print("before: ");
		printResult(numbers);
		IntegerArray sorter = new IntegerArray(numbers);
		sorter.sort(IntegerArray.MERGE_SORT);
		if (validate(numbers)) {
			System.out.print("sorted: ");
			printResult(numbers);
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
