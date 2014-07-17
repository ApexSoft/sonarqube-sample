/**
 * Created by Administrator on 2014-07-08.
 */
public class IntegerArray {

	public final static int BUBBLE_SORT = 1;
	public final static int QUICK_SORT = 2;
	public final static int MERGE_SORT = 3;

	private int[] numbers;

	private SortAlgorithm algorithm;

	public IntegerArray(int...values) {
		this.numbers = new int[values.length];
		System.arraycopy(values, 0, numbers, 0, numbers.length);
	}

	public void setSortAlgorithm(SortAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public void sort() {
		if (algorithm != null) {
			algorithm.sort(numbers);
		}
	}
	
	public int[] getNumbers() {
		return numbers;
	}
}
