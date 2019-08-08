package com.codility.counting.element;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {

		int[] A = { 4, 1, 3, 2 };
		int[] B = { 4, 1, 3 };
		int[] C = { 1 };
		int[] D = { 100 };

		PermCheck pc = new PermCheck();
		System.out.println(pc.solution(A));
		System.out.println(pc.solution(B));
		System.out.println(pc.solution(C));
		System.out.println(pc.solution(D));

	}

	public int solution(int[] A) {
		// write your code in Java SE 8

		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (i + 1 != A[i]) {
				return 0;
			}
		}

		return 1;
	}
}
