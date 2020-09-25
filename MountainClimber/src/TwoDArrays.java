import java.util.Arrays;

public class TwoDArrays {
	private int nums[][];

	public TwoDArrays(int TwoD[][]) {
		nums = TwoD;
		
	}

	public void print() {
		String w = "";
		for (int r = 0; r < nums.length; r++) {
			w += (Arrays.toString(nums[r]));
		}
		System.out.println(w);
	}

	public int Sum() {
		int a = 0;
		for (int r = 0; r < nums.length; r++) {
			for (int i = 0; i < nums[r].length; i++) {
				a += nums[r][i];
			}
		}
		return a;
	}

	public boolean isSquare() {
		if (nums.length == nums[0].length) {
			return true;
		} else {
			return false;
		}
	}

	public boolean inSequence() {
		boolean b = isSquare();
		int a = 1;
		if (b == true) {
			for (int i = 0; i < nums.length; i++) {
				for (int t = 0; t < nums[i].length; t++) {
					if (nums[i][t] == a) {
						a++;
					} else {
						return false;
					}
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public int[] closestToZero() {
		int closestZ = 100000;
		int[] closestZero = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int t = 0; t < nums[i].length; t++) {
				if (Math.abs(nums[i][t] - closestZ) <= closestZ) {
					closestZ = nums[i][t];
					closestZero[0] = i;
					closestZero[1] = t;
				}
			}
		}
		return closestZero;
	}

	public void addMatrix(int[][] other) {
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				nums[r][c] += other[r][c];
			}
		}
	}

	public int[] twoMin() {
		int min = 10000;
		int min2 = 10000;
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				if (nums[r][c] < min) {
					min = nums[r][c];
					System.out.println(min);
				}
				if ((nums[r][c] > min) && (nums[r][c] < min2)) {
					min2 = nums[r][c];
					System.out.println(min2);
				}

			}
		}
		return new int[] { min, min2 };
	}

	public int columnSum(int col) {
		int sum = 0;
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				if (c == col) {
					sum += nums[r][c];
				}
			}
		}
		return sum;
	}

	public boolean isColumnMagic() {
		boolean b = false;
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				if (columnSum(c) == columnSum(c + 1)) {
					b = true;
				}
			}
		}
		if (b == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean sameDiagonalSums() {
		int sum1 = 0;
		int sum2 = 0;
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				if (r == c)
					sum1 += nums[r][c];
			}
		}

		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				if ((r + c) == (nums[r].length - 1)) {
					sum2 += nums[r][c];

				}

			}
		}

		if (sum1 == sum2) {
			return true;
		} else
			return false;
	}
}
