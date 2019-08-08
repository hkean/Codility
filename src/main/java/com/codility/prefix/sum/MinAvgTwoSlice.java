package com.codility.prefix.sum;

public class MinAvgTwoSlice {

	public int solution(int[] A) {
		int result = 0;
		// min a random number based on the first two element
		int currMin = 0, min = (A[0] + A[1]) / 2;
		
		
		// A.length - 1, since min need to be two elements
		for (int i = 0; i < A.length - 1; i++) {
			int numerator = 0;
			
			// i + 1, since need to start with two elements 
			for (int j = i + 1; j < A.length; j++) {
//				System.out.println(i + " " + j);
				numerator += A[i] + A[j];
			}
			// 
		}
		
		return result;
	}

	public MinAvgTwoSlice() {
		int[] A = { 5, 5, 2, 2, 2, 1, 8 }; // 4
		int[] A11 = { 5, 5, 2, 1, 2, 1, 8 }; // 3
		int[] A1 = { 4, 2, 2, 5, 1, 5, 8 }; // 1
		System.out.println(solution(A1));
	}

	public static void main(String[] args) {
		new MinAvgTwoSlice();

	}

}
