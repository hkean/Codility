package com.codility.prefix.sum;

import java.util.Arrays;

public class GenomicRangeQuery {

	public static final int A_VALUE = 1;
	public static final int C_VALUE = 2;
	public static final int G_VALUE = 3;
	public static final int T_VALUE = 4;

	public static final char A = 'A';
	public static final char C = 'C';
	public static final char G = 'G';
	public static final char T = 'T';

	public static int[] solution(String S, int[] P, int[] Q) {
		int len = S.length();
		int[][] arr = new int[len][4];
		int[] result = new int[P.length];

		for (int i = 0; i < len; i++) {
			char c = S.charAt(i);
			if (c == 'A')
				arr[i][0] = 1;
			if (c == 'C')
				arr[i][1] = 1;
			if (c == 'G')
				arr[i][2] = 1;
			if (c == 'T')
				arr[i][3] = 1;
		}
		// compute prefixes
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] += arr[i - 1][j];
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		System.out.println(Arrays.deepToString(arr));
		for (int i = 0; i < P.length; i++) {
			int x = P[i];
			int y = Q[i];
			System.out.println(x + " " + y);
			for (int a = 0; a < 4; a++) {
				int sub = 0;
				if (x - 1 >= 0)
					sub = arr[x - 1][a];
				System.out.println(arr[y][a] + " - " + sub + " = " + (arr[y][a] - sub) + " a: " + a);
				if (arr[y][a] - sub > 0) {
					result[i] = a + 1;
					break;
				}
			}

		}
		return result;
	}

	// 1. count occurrence of each nucleotide in each row
	// 2. calculate running impact factor sum at each row
	// 3. calculate minimum impact factor by doing simple subtraction at the indices
	public int[] explanation_solution(String S, int[] P, int[] Q) {
		int[] answers = new int[P.length];
		int stringLength = S.length();

		int[][] occurrences = new int[stringLength][4];

		// step 1 - for each row, count occurrences of each nucleotide
		// (can only have 1 occurrence / row)
		// e.g. if S=CAGCCTA array will be
		// {
		// {0,1,0,0} C
		// {1,0,0,0} A
		// {0,0,1,0} G
		// {0,1,0,0} C
		// {0,1,0,0} C
		// {0,0,0,1} T
		// {1,0,0,0} A
		// }
		for (int i = 0; i < occurrences.length; i++) {
			char c = S.charAt(i);
			if (c == 'A')
				occurrences[i][0] = 1;
			else if (c == 'C')
				occurrences[i][1] = 1;
			else if (c == 'G')
				occurrences[i][2] = 1;
			else if (c == 'T')
				occurrences[i][3] = 1;
		}

		// step 2 - for each row (starting from 2nd row),
		// add up occurrences of each nucleotide by adding
		// occurrences from previous row to current row
		// now have running sum of each nucleotide for any row
		// e.g. if S=CAGCCTA array will be
		// {
		// {0,1,0,0} C
		// {1,1,0,0} A
		// {1,1,1,0} G
		// {1,2,1,0} C
		// {1,3,1,0} C
		// {1,3,1,1} T
		// {2,3,1,1} A
		// }
		for (int i = 1; i < stringLength; i++) {
			for (int j = 0; j < 4; j++) {
				occurrences[i][j] += occurrences[i - 1][j];
			}
		}

		// check each slice for min by simple subtraction
		for (int i = 0; i < P.length; i++) {
			int index1 = P[i];
			int index2 = Q[i];

			for (int j = 0; j < 4; j++) {
				// when index1 not at beginning of String
				// need to get occurrences from just before
				// beginning of slice - to see if that nucleotide occurred within slice
				// e.g. if slice is (2, 4),
				// need to check for occurrences of A, C, G, T from index 1 to 4
				int lowerIndexCount = 0;
				if (index1 - 1 >= 0)
					lowerIndexCount = occurrences[index1 - 1][j];

				if (occurrences[index2][j] - lowerIndexCount > 0) {
					answers[i] = j + 1;
					// nucleotide value is 1 more than loop value (A=1, C=2, G=3, T=4)
					// no need to keep checking since always checking from smallest impact factor
					// as soon as find occurrence, that has to be minimum, cause subsequent
					// nucleotides have
					// larger impact factor
					break;
				}
			}
		}
		return answers;
	}

	public int[] ZRonchy_solution(String S, int[] P, int[] Q) {
		// used jagged array to hold the prefix sums of each A, C and G genoms
		// we don't need to get prefix sums of T, you will see why.
		int[][] genoms = new int[3][S.length() + 1];
		// if the char is found in the index i, then we set it to be 1 else they are 0
		// 3 short values are needed for this reason
		short a, c, g;
		for (int i = 0; i < S.length(); i++) {
			a = 0;
			c = 0;
			g = 0;
			if ('A' == (S.charAt(i))) {
				a = 1;
			}
			if ('C' == (S.charAt(i))) {
				c = 1;
			}
			if ('G' == (S.charAt(i))) {
				g = 1;
			}
			// here we calculate prefix sums. To learn what's prefix sums look at here
			// https://codility.com/media/train/3-PrefixSums.pdf
			genoms[0][i + 1] = genoms[0][i] + a;
			genoms[1][i + 1] = genoms[1][i] + c;
			genoms[2][i + 1] = genoms[2][i] + g;
		}

		int[] result = new int[P.length];
		// here we go through the provided P[] and Q[] arrays as intervals
		for (int i = 0; i < P.length; i++) {
			int fromIndex = P[i] + 1;
			int toIndex = Q[i] + 1;
			// if the substring contains a, then genoms[0][toIndex] - genoms[0][fromIndex-1]
			// > 0
			if (genoms[0][toIndex] - genoms[0][fromIndex - 1] > 0) {
				result[i] = 1;
			} else if (genoms[1][toIndex] - genoms[1][fromIndex - 1] > 0) {
				result[i] = 2;
			} else if (genoms[2][toIndex] - genoms[2][fromIndex - 1] > 0) {
				result[i] = 3;
			} else {
				result[i] = 4;
			}
		}

		return result;
	}

	/* 1. Simple solution, time complexity is O(N * M) */
	public int[] simple_solution(String S, int[] P, int[] Q) {
		// write your code in Java SE 8
		int[] C = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			C[i] = factor(S, P[i], Q[i]);
		}

		return C;
	}

	public int factor(String S, int i, int j) {
		if (S.substring(i, j + 1).contains("A")) {
			return 1;
		} else if (S.substring(i, j + 1).contains("C")) {
			return 2;
		} else if (S.substring(i, j + 1).contains("G")) {
			return 3;
		}

		return 4;
	}

	public int[] my_solution(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];
		char[] tmpC = S.toCharArray();

		// loop
		for (int i = 0; i < P.length; i++) {
			// since max is 4, so set min default as 4
			int currMin = 0, min = 4;

//			// if one char
//			if (P[i] == Q[i])
//				min = findTheMin(tmpC[P[i]]);
//			else {
			// loop char
			for (int j = P[i]; j <= Q[i]; j++) {
				char tmp = tmpC[j];

				// finding the min
				currMin = findTheMin(tmp);

				// set the min if < currMin
				if (currMin < min)
					min = currMin;
			}
//			}
			// only add into result once confirm the smallest in the group
			result[i] = min;

		}

		return result;
	}

	public int findTheMin(char input) {
		if (A == input)
			return A_VALUE;
		else if (C == input)
			return C_VALUE;
		else if (G == input)
			return G_VALUE;
		else if (T == input)
			return T_VALUE;
		else
			return -1;
	}

	public GenomicRangeQuery() {
		String S = "CAGCCTA";
//		int[] P = { 2, 5, 0 };
//		int[] Q = { 4, 5, 6 };
		System.out.println(Arrays.toString(solution(S, new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 })));
		String S1 = "CCCCCCC";
		System.out.println(Arrays.toString(solution(S1, new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 })));
		String S2 = "A"; // extreme single
		System.out.println(Arrays.toString(solution(S2, new int[] { 0 }, new int[] { 0 })));
		String S3 = "TC"; // extreme double
		System.out.println(Arrays.toString(solution(S3, new int[] { 0, 0, 1 }, new int[] { 0, 1, 1 })));
	}

	public static void main(String[] args) {
		new GenomicRangeQuery();
	}

}
