package com.codility.greedy.algorithm;

public class MaxNonoverlappingSegments {

	public static void main(String[] args) {

		new MaxNonoverlappingSegments();
	}

	public MaxNonoverlappingSegments() {
		int[] A = { 1, 3, 7, 9, 9 };
		int[] B = { 5, 6, 8, 9, 10 };

		System.out.println(solution(A, B));
	}

	public int solution(int A[], int B[]) {
		// get the max segment
		int N = A.length;
		
		// when it will get 0
		if (N <= 1) {
			return N;
		}

		int cnt = 1;
		int prev_end = B[0]; // get the B value

		int curr;
		for (curr = 1; curr < N; curr++) {
			System.out.println(A[curr] +">"+ prev_end);
			if (A[curr] > prev_end) {
				cnt++;
				prev_end = B[curr];
			}
		}

		return cnt;
	}

}
