package com.codility.sort;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public int solution(int[] A) {
		int result = 0;
		
		// use set and then it will never duplicate
		Set<Integer> tmp = new HashSet<>();
		
		for (int i = 0; i < A.length; i++) {
			tmp.add(A[i]);
		}
		
		result = tmp.size();
		
		return result;
	}
	
	public static void main(String[] args) {
		Distinct obj = new Distinct();
		
		int[] A = { 2, 1, 1, 2, 3, 1};
		System.out.println(obj.solution(A));
	}
}
