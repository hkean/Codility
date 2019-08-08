package com.codility.prefix.sum;

public class PassingCars {

	public static void main(String[] args) {

		PassingCars pc = new PassingCars();
		
		int[] A = {0,1,0,1,1,
				1,1,0,0,0,1
				};
		
		System.out.println(pc.solution(A));
	}
    public int solution(int[] A) {
        int countOfZeros = 0, count = 0;

        for (int i = 0; i < A.length; i++){
            if (A[i] == 0) countOfZeros++;                    
            if (A[i] == 1) count += countOfZeros;    
            if (count > 1000000000) return -1;
            
            System.out.println(count);
        }
        return count;}
}
