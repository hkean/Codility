package com.codility.prefix.sum;

public class CountDiv {

	public int solution(int A, int B, int K) {
		System.out.println("B: " +B + " / K: " + K + " A: " + A + " / K: " + K + " % " + (A % K == 0 ? 1 : 0));
		return (B / K) - (A / K) + (A % K == 0 ? 1 : 0);
	}

	public int solution1(int A, int B, int K) {

		int result = 0;

		// loop
		for (int i = A; i <= B; i++) {

			// check mod = 0
			if (i % K == 0)
				// increment result
				result++;
		}

		return result;
	}

	CountDiv() {
		int A = 6, B = 11, K = 2;
		System.out.println(solution(A, B, K));
		int A1 = 11, B1 = 345, K1 = 17; // simple
		System.out.println(solution(A1, B1, K1));
		int A2 = 0, B2 = A2, K2 = 11; // min1
		System.out.println(solution(A2, B2, K2));
		int A3 = 1, B3 = A3, K3 = 11; // min2
		System.out.println(solution(A3, B3, K3));
		int A4 = 10, B4 = 10, K4 = 20; // extreme if empty, K4 = {5, 7, 20}
		System.out.println(solution(A4, B4, K4));
		int A5 = 0, B5 = 2000000000, K5 = 20; // extreme endpoint
		System.out.println(solution(A5, B5, K5));
		int A6 = 0, B6 = 2000000000, K6 = 1000; // extreme endpoint
		System.out.println(solution(A6, B6, K6));
		int A7 = 0, B7 = Integer.MAX_VALUE, K7 = 100000; // extreme endpoint
		System.out.println(solution(A7, B7, K7));
	}

	public static void main(String[] args) {
		new CountDiv();
	}

}
