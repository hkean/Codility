package com.codility.greedy.algorithm;

public class TieRopes {

	public static void main(String[] args) {

		new TieRopes();
	}

	public TieRopes() {
		int K = 4;
		int[] A = { 1, 2, 3, 4, 1, 1, 3 };

		System.out.println(solution(K, A));
	}

	public int solution(int K, int[] A) {

		int count = 0;
		int tmp = 0;

		for (int i = 0; i < A.length; i++) {
			tmp += A[i];
			if (tmp >= K) {
				tmp = 0;
				count++;
			}
		}

		return count;
	}
}
