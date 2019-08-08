package com.codility.euclidean.algorithm;

public class ChocolatesByNumbers {

	public static void main(String[] args) {
		new ChocolatesByNumbers();
	}

	public ChocolatesByNumbers() {
		System.out.println("answer: " + solution(10, 4));
	}

	public int solution(int N, int M) {
		// write your code in Java SE 8

		int X = 0;
		int result = 0;
		int tmp = -1;
//		for (int i=0; tmp == 0; i=(X+M)%N, X+=M) {
////			i = X+M;
//		tmp = i;
//		System.out.println(i + " " + X);
//			result++;
//		
//		}

		while (tmp != 0) {
			tmp = (X + M) % N;

//			System.out.println(tmp);

			result++;

			X += M;
		}

		return result;
	}
}
