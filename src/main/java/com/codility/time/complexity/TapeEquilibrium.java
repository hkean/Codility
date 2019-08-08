package com.codility.time.complexity;

public class TapeEquilibrium {

	public static void main(String[] args) {

		new TapeEquilibrium();
	}

	public TapeEquilibrium() {
		int[] A = { -3, -1, -2, -4, -3 };

		System.out.println(solution(A));
	}

	public int solution(int A[]) {
		int N = A.length;
		int max = 0;
		int min = 1000;
		int curr = 0;

		for (int i = 0; i < N; i++) {
			max += A[i];
		}

		int tmp = 0;

		for (int j = 0; j < N - 1; j++) {
			max -= A[j];
			curr = Math.abs((A[j] + tmp) - (max));
//System.out.println(curr + " " + A[j] + " " + tmp + " " + max);
			if (curr < min)
				min = curr;

			tmp += A[j];
//			tmp += Math.abs(A[j]);
		}

		return min;
	}
}
