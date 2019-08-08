package com.codility.array;

import java.util.ArrayList;
import java.util.HashSet;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		new OddOccurrencesInArray();
		HashSet<Integer> dups = new HashSet<Integer>();
		dups.add(9);
		dups.add(9);
	}

	public OddOccurrencesInArray() {
//		int max = 999999;
//		int[] A = new int[max];
//		for (int i=0;i<max;i+=2) {
//			if (i != max-1) {
//				A[i+1] = i;
//			}
//				A[i] = i;
//		}
		int[] A = {9, 3, 9, 3, 9, 7, 9};
//		 if 3 array of the same
//		int[] A = {9, 9, 9, 9};
//		 System.out.println(Arrays.toString(A));
//		System.out.println(solution(A));
//		System.out.println(solution0(A));
		System.out.println(solution2(A));
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		
		// non-empty but as precaution, put a logic for empty array
		// odd number of element, but as precaution, put a logic for even element
		if (A.length == 0 || A.length % 2 == 0) {
			return -1;
		}
		else {
			ArrayList<Integer> aL = new ArrayList<Integer>();
			for (int i=0; i<A.length; i++) {
				if (aL.contains(A[i])) {
					aL.remove(aL.indexOf(A[i]));
				}
				else {
					aL.add(A[i]);
				}
//				System.out.println(aL);
			}
//			System.out.println(aL.get(0));
			return aL.get(0);
		}
		
//		return 0;
	}
	
	public static int solution0(int[] A) {
		// write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
//			System.out.println(elem);
		}
		return elem;
	}
	
	public static int solution2(int[] A) {
		// write your code in Java SE 8
		HashSet<Integer> dups = new HashSet<Integer>();
		int elem = -1;

		for (int i = 0; i < A.length; i++) {
			if (dups.add(A[i])) {
				elem = A[i];
			}
			System.out.println(elem);
		}
		return elem;
	}
}
