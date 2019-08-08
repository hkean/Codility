package com.codility.binary.search.algorithm;

public class NailingPlanks {

	public static void main(String[] args) {
		new NailingPlanks();
	}

	public NailingPlanks() {

		int[] A = { 1, 4, 5, 8 };
		int[] B = { 4, 5, 9, 10 };
		int[] C = { 4, 6, 7, 10, 2 };

		System.out.println(solution(A, B, C));
	}

	public int solution(int[] A, int[] B, int[] C) {
		int count = 0;
		int result = -1;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[j] <= C[i] && B[j] >= C[i]) {
					count++;
				}
			}
			if (count == A.length)
				return count;
		}

		return result;
	}
}
