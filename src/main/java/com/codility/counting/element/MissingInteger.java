package com.codility.counting.element;

//import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MissingInteger {

	public static void main(String[] args) {
		new MissingInteger();
	}

	MissingInteger() {
		int[] A = { 1, 3, 6, 4, 1, 2 };
		int[] B = { 1, 2, 3 };
		int[] C = { -1, -3, 0 };

		System.out.println("A: " + solution(A));
		System.out.println("B: " + solution(B));
		System.out.println("C: " + solution(C));
	}
//
//	public int solution(int[] A) {
//		return -1;
//	}

//	public int solution(int[] A) {
//
//		// sort
//		Arrays.sort(A);
//		System.out.println(Arrays.toString(A));
//		// check if max is < 1
//		if (A[A.length - 1] < 1) {
//			return -1;
//		}
//
//		// loop
//		int i;
//		for (i = 1; i < A.length; i++) {
////			System.out.println(i + " " + A[i]);
//			// if not the same, then return
//			if (i != A[i-1]) {
//				return i;
//			}
////			System.out.print(i + " ");
//		}
//
//		return i++;
//	}

	// 66%
	public int solution_66(int[] A) {
		List<Integer> list = new LinkedList<Integer>();
		int min = 1;

		// remove all negative
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0)
				list.add(A[i]);
		}

		// contains mean no need sort anymore
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!list.contains(i))
				return i;
		}

		return min;
	}

	// karimhamdanali
	public int solution(int[] A) {
		HashSet<Integer> list = new HashSet<Integer>();
		int min = 1;

		// remove all negative
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0)
				list.add(A[i]);
		}

		// contains mean no need sort anymore
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!list.contains(i))
				return i;
		}

		return min;
	}
}
/*
 * 1 1 2 1 3 2 4 3 5 4
 */
