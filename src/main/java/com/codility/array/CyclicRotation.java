package com.codility.array;

import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		new CyclicRotation();
	}

	public CyclicRotation() {
		// int[] A = {3, 8, 9, 7, 6};
		// int[] A = {0, 0, 0};
		// int[] A = {1, 2, 3, 4};
		// int[] A = {1};
		// int[] A = new int[100];
		// for (int i=0;i<100;i++) {
		// A[i]=i;
		// }
		int[] A = new int[0];
		System.out.println(Arrays.toString(solution(A, 100)));
	}

	public int[] solution(int[] A, int K) {
		// write your code in Java SE 8

		int len = A.length;
		int[] tmp = new int[len];
		// return the same if K is the same size as the array
		if (K == A.length || len == 0)
			return A;
		else {
			int countM = K % len;
			int countA = 0;
			for (int i = 0; i < len; i++) {
				if (countM > 0) {
					tmp[i] = A[len - countM];
					countM--;
				} else {
					tmp[i] = A[countA];
					countA++;
				}
				// System.out.println(Arrays.toString(tmp));
			}
		}

		return tmp;
	}
}
