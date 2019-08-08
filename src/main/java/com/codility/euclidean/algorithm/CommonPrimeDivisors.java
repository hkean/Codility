package com.codility.euclidean.algorithm;

import java.util.ArrayList;
import java.util.List;

public class CommonPrimeDivisors {

	public static void main(String[] args) {

		new CommonPrimeDivisors();
		
//		System.out.println("Primefactors of 44");
//        for (Integer integer : p1(44)) {
//            System.out.println(integer);
//        }
		
//		int n = 44;
//		p2(n);
		
//		List<Integer> la = new ArrayList<Integer>();
//		List<Integer> lb = new ArrayList<Integer>();
//		la.add(0);
//		lb.add(0);
//		System.out.println(la==lb);
//		System.out.println(la.toString().equals(lb.toString()));
		
//		StringBuilder sa = new StringBuilder();
//		StringBuilder sb = new StringBuilder();
//		sa.append(0);
//		sa.append(1);
//		sb.append(0);
//		sb.append(1);
//		System.out.println(sa==sb);
//		System.out.println(sa.toString().equals(sb.toString()));
	}

	public CommonPrimeDivisors() {

		int[] A = { 15, 10, 3 };
		int[] B = { 75, 30, 5 };

		System.out.println(solution(A, B));
	}

	public int solution(int[] A, int[] B) {

		int count = 0;
		
		for (int i = 0; i < A.length; i++) {
			if (p2(A[i]).equals(p2(B[i])))
				count++;
		}

		return count;
	}
	
    public static List<Integer> p1(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
    
    public //static 
    String p2(int n)
	{
    	int ori = n;
    	System.out.print(n + " ");
//    	StringBuilder sb = new StringBuilder();
    	List<Integer> l = new ArrayList<Integer>();
    	
		// Print the number of 2s that divide n
		while (n%2==0)
		{
//			System.out.print("First: "+2 + " ");
//			sb.append(2);
			n /= 2;
		}
		if (ori != n)
			l.add(2);
		
		// n must be odd at this point. So we can
		// skip one element (Note i = i +2)
		for (int i = 3; i <= Math.sqrt(n); i+= 2)
		{
			// While i divides n, print i and divide n
			while (n%i == 0)
			{
//				System.out.print("Mid: "+i + " ");
//				sb.append(i);
				if (!(l.contains(i)))
					l.add(i);
				n /= i;
			}
		}

		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2)
//			System.out.print("last: " + n);
//			sb.append(n);
			l.add(n);
		
//		System.out.println(sb.toString());
		System.out.println(l.toString());
		
//		return sb.toString();
		return l.toString();
	}
}
