/**
 * Created by Administrator on 2014-07-08.
 */
public class IntegerArray {

	public final static int BUBBLE_SORT = 1;
	public final static int QUICK_SORT = 2;
	public final static int MERGE_SORT = 3;

	private int[] numbers;
	private int size;
	private int[] helper;

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
		case MERGE_SORT:
			helper = new int[size];
			mergeSort(0, size - 1);
		}
	}

	private void bubbleSort() {
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

	private void mergeSort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}

	private void exchange(int i, int j) {
		if (i == j) {
			return;
		}
		numbers[i] = numbers[i] ^ numbers[j];
		numbers[j] = numbers[i] ^ numbers[j];
		numbers[i] = numbers[i] ^ numbers[j];
	}
}
