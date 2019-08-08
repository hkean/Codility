package com.codility.counting.element;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxCounters {

	public static void main(String[] args) {
		new MaxCounters();

	}

	public MaxCounters() {
		int N = 5;
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		System.out.println(Arrays.toString(mySolution(N, A)));
		System.out.println(Arrays.toString(libSolution(N, A)));
		System.out.println(Arrays.toString(solution_4_MaxCounters(N, A)));
	}

	private int[] mySolution(int N, int[] A) {
		int[] B = new int[N];
		int max = 0;
//		System.out.println("length: " + A.length);
//		System.out.println("B: " + Arrays.toString(B));
		for (int i = 0; i < A.length; i++) {
			if (N + 1 == A[i])
				for (int j = 0; j < B.length; j++) {
					B[j] = max;
				}
			else {
				B[A[i] - 1]++;
				if (B[A[i] - 1] > max)
					max++;
			}
//			System.out.println("B: " + Arrays.toString(B));
		}

		return B;
	}

	private int[] libSolution(int N, int[] A) {

		List<Integer> Z = Arrays.stream(A).boxed().collect(Collectors.toList());
		Collections.max(Z);
		Arrays.fill(A, N);
		return A;
	}

	public static int[] solution_4_MaxCounters(int N, int[] A) {

		int[] counterArray = new int[N];
		final int[] zeroedArray = new int[N];
		int biggestCounter = 0;
		int maxCounter = 0;

		for (int i = 0; i < A.length; i++) {

			if (A[i] <= N) {

				counterArray[A[i] - 1]++;
				if (counterArray[A[i] - 1] + maxCounter > biggestCounter)
					biggestCounter = counterArray[A[i] - 1] + maxCounter;

			} else if (A[i] == N + 1) {
				maxCounter = biggestCounter;
				System.arraycopy(zeroedArray, 0, counterArray, 0, zeroedArray.length);
			}

		}
//	    System.out.println("counterArray: " + Arrays.toString(counterArray));
		for (int j = 0; j < counterArray.length; j++)
			counterArray[j] += maxCounter;
//	    System.out.println("counterArray: " + Arrays.toString(counterArray));

		return counterArray;
	}
}
