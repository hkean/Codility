package com.codility.time.complexity;

import java.util.Arrays;

public class PermMissingElem {

	public static void main(String[] args) {
		new PermMissingElem();
	}

	public PermMissingElem() {
		int[] A = { 2, 3, 1, 5, 7, 8 };
		System.out.println(solution(A));
		System.out.println(mySolution(A));
	}

	public int mySolution(int[] A) {
		Arrays.sort(A);
		int count = 1;
//		System.out.println(Arrays.toString(A));

		for (int i = 0; i < A.length; i++) {
			if (A[i] != count) {
				return count;
			}
			count++;
		}

		return 0;
	}
	
	public int solution(int[] A) {

	    long N = A.length + 1;
	    long total = (N * (N + 1)) / 2;

	    long sum = 0L;

	    for (int i : A) {

	        sum += i;
	    }

	    return (int)(total - sum);
	}
}
