package com.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.codility.sort.Distinct;

public class DistinctTest {

	// empty_sequence
	@Test
	public void emptySequence() {
		Distinct obj = new Distinct();
		int[] A = {};
		assertEquals(0, obj.solution(A));
	}
	
	// extreme_single 
	@Test
	public void extremeSingle() {
		Distinct obj = new Distinct();
		int size = 100, value = 1;
		int[] A = new int[size];
		for (int i = 0; i < size; i++) {
			A[i] = value;
		}
		assertEquals(1, obj.solution(A));
	}
	
	// extreme_two_elems 
	@Test
	public void extremeTwoElements() {
		Distinct obj = new Distinct();
		int size = 100, value = 1;
		int[] A = new int[size];
		for (int i = 0; i < size; i++) {
			if (i == size / 2) value++;
			A[i] = value;
		}
		assertEquals(2, obj.solution(A));
	}
		
	// extreme_one_value 
//	@Test
	public void extremeOneValue() {}
		
	// extreme_negative 
	@Test
	public void extremeNegative() {
		Distinct obj = new Distinct();
		int size = 100, value = -1;
		int[] A = new int[size];
		for (int i = 0; i < size; i++) {
			A[i] = value;
		}
		assertEquals(1, obj.solution(A));
	}
	
	// extreme_big_values 
//	@Test
	public void extremeBigValues() {
		
	}
	
	// medium1, length=100
//	@Test
	public void medium1Length100() {
		
	}
	
	// large1, length=100K
//	@Test
	public void large1Length100k() {
		
	}
}
