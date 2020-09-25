import java.util.Arrays;
import java.util.Random;

public class SearchSort {
	private int[] nums;

	public SearchSort(int[] nums) {
		this.nums = nums;
	}

	public SearchSort(int size) {
		nums = new int[size];
		initArray();
		// Arrays.sort(nums);
	}

	public void initArray() {
		for (int i = 0; i < nums.length; i++) {
			Random rand = new Random();
			nums[i] = rand.nextInt(15) + 1;
		}
	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public int linearSearch(int key) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public int binarySearch(int key) {
		int high = nums.length - 1;
		int low = 0;
		while (low <= high) {
			int mid = (low + (high - low)) / 2;
			if (key < nums[mid]) {
				high = mid - 1;
			} else if (key > nums[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public int binarySearchRecursive(int key) {
		int low = 0;
		int high = nums.length;
		int index = helper(low, high, key);
		return index;
	}

	private int helper(int low, int high, int key) {
		int mid = (low + (high - low)) / 2;
		if (low <= high) {
			if (key == nums[mid]) {
				return mid;
			} else if (key < nums[mid]) {
				helper(low, mid - 1, key);
			} else if (key > nums[mid]) {
				helper(mid + 1, high, key);
			}
		}
		return -1;
	}

	public void bubbleSort(boolean print) {
		if (print) {
			for (int i = 0; i < nums.length - 1; i++) {
				for (int x = 0; x < nums.length - 1; x++) {
					if (nums[x + 1] < nums[x]) {
						swap(x + 1, x);
					}
				}
				System.out.println(Arrays.toString(nums));
			}
		} else {
			for (int i = 0; i < nums.length - 1; i++) {
				for (int x = 0; x < nums.length - 1; x++) {
					if (nums[x + 1] < nums[x]) {
						swap(x + 1, x);
					}
				}
			}
		}
	}

	public void selectionSort(boolean print) {
		int minValIndex = 0;
		int minVal = 100000000;
		for (int x = 0; x < nums.length; x++) {
			if (nums[x] < minVal) {
				minVal = nums[x];
				minValIndex = x;
			}
		}
		swap(0, minValIndex);
		minValIndex = 0;
		minVal = 100000000;
		if (print) {
			for (int i = 0; i < nums.length - 1; i++) {
				minValIndex = 0;
				minVal = 100000000;
				for (int x = i + 1; x < nums.length; x++) {
					if (nums[x] < minVal) {
						minVal = nums[x];
						minValIndex = x;
					}
				}
				swap(i + 1, minValIndex);
				System.out.println(toString());
			}
		}
	}

	public void insertionSort(boolean print) {
		if (print) {
			for (int i = 1; i < nums.length; i++) {
				int key = nums[i];
				int j = i - 1;

				while (j >= 0 && nums[j] > key) {
					nums[j + 1] = nums[j];
					j = j - 1;
				}
				nums[j + 1] = key;
				System.out.println(toString());
			}
		}
	}

	public void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(array, low, middle);
			mergeSort(array, middle + 1, high);
			merge(array, low, middle, high);
		}
	}

	private void merge(int[] array, int low, int middle, int high) {
		int[] helper = new int[array.length];
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;

			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
	public int[] getArray()
	{
		return nums;
	}

	@Override
	public String toString() {
		String output = Arrays.toString(nums);
		return output;
	}
}
