package com.codility.iteration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryGap {

	public static void main(String[] args) {

		new BinaryGap();
	}

	public BinaryGap() {
		solution();
		System.out.println(solution(561892));
	}

	void solution() {
		int x = 100;
		System.out.println(Integer.toBinaryString(x));
	}

	private Pattern p = Pattern.compile("1?(0+)1");

	public int binaryGap(int n) {
		int max = 0;
		String binary = Integer.toBinaryString(n).replaceAll("0+$", "");

		Matcher m = p.matcher(binary);

		while (m.find()) {
			max = Math.max(max, m.group(1).length());
		}
		return max;
	}

//	int sol(int N){
//		return 
//				Stream.of(
//						Integer.toBinaryString(N)
//						.replaceAll("0+S", "")
//						.split("1+")
//	}
//	.filter( a -> a !=null)
//	.map(String::length)
//	.max(Integer::compare)
//	.orElse(0)
//	;
//	}
	
	public int solution(int N) {
		// write your code in Java SE 8

//		System.out.println(Integer.toBinaryString(N));
		char temp[] = Integer.toBinaryString(N).toCharArray();
		
//		int curr = 0;
		int max = 0;
//		int start = 0;
		int count = 0;
//		int prev = 0;
		
		// skip first because it is always 1 
		for (int i=1; i<temp.length; i++) {
//			System.out.print(temp[i]);
			if (temp[i] == '1') {
				// check counter > maximum
				if (count > max) {
					max = count;
//					count = 0; // reset counter
//					System.out.println();
				}
				count = 0; // reset counter
			}
			// if 0 then add counter
			else {
				count++;
//				System.out.print("c"+count);
			}
		}
		
		return max;
	}
}
