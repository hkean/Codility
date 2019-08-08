package com.codility.time.complexity;

public class FrogJmp {

	public static void main(String[] args) {

		new FrogJmp();
	}

	FrogJmp() {

		int x = 1;
		int y = 1;
		int z = 30;
		
		System.out.println(solution(x,y,z));
	}
	
	public int solution(int X, int Y, int D) {
		return (int) Math.ceil((Y - X) / (double) D);
	}
	
	public int solution2(int X, int Y, int D) {
		int count = 0;
		for (int i=X; i<Y; i+=D, count++) {
//			System.out.println("i: "+i);
//			if (i>=D) {
//				return count++;
//			}
		}
		return count;
	}
	
}
