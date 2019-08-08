package com.codility.counting.element;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class FrogRiverOne {

	public static void main(String[] args) {
		new FrogRiverOne();
	}

	public FrogRiverOne() {
		int X = 5;
		int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
//		int[] A = { 1, 3, 1, 4, 2, 3, 6, 4 };

		System.out.println(mySolution(X, A));
		System.out.println(solution(X, A));
		System.out.println(solution_4_FrogRiverOne(X, A));
	}

	public int mySolution(int X, int[] A) {
		List<Integer> l = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
//			System.out.println(Arrays.toString(l.toArray()));
			if (A[i] <= X && !l.contains(A[i])) {
				l.add(A[i]);

				if (X == l.size())
					return i;
			}
		}
		return -1;
	}
	
    public int solution(int X, int[] A) {
        int steps = X;
        boolean[] bitmap = new boolean[steps+1];
        for(int i = 0; i < A.length; i++){
            if(!bitmap[A[i]]){
                bitmap[A[i]] = true;
                steps--;
            }
            if(steps == 0) return i;
        }
        return -1;
    }
    
    public static int solution_4_FrogRiverOne(int X, int[] A) {
    	 
        int jumpCounter = X;
        int[] positionArray = new int[X + 1];
     
        for (int i = 0; i < A.length; i++) {
     
            if (positionArray.length >= A[i]) {
//                System.out.println(i);
//                System.out.println(positionArray[A[i]]);
                if (positionArray[A[i]] == 0)
                    jumpCounter--;
     
                if (jumpCounter == 0)
                    return i;
     
                positionArray[A[i]]++;
            }
     
        }
     
        return -1;
    }
}
