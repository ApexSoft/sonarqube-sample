/**
 * Created by Administrator on 2014-07-08.
 */
public class IntegerArray {

	/**
	 * integer array
	 */
	private int[] numbers;

	/**
	 * sort algorithm
	 */
	private SortAlgorithm algorithm;

	/**
	 * Construct
	 * @param values
	 */
	public IntegerArray(int...values) {
		this.numbers = new int[values.length];
		System.arraycopy(values, 0, numbers, 0, numbers.length);
	}

	/**
	 * @param algorithm
	 */
	public void setSortAlgorithm(SortAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * starting sort
	 */
	public void sort() {
		if (algorithm != null) {
			algorithm.sort(numbers);
		}
	}
	
	/**
	 * return result
	 * @return
	 */
	public int[] getNumbers() {
		return numbers;
	}
}
