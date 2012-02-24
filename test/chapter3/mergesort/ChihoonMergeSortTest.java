package chapter3.mergesort;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ChihoonMergeSortTest {
	
	@Test
	public void mergeSortTest() throws Exception {
		int[] input = {22,1,3,66,8,5,34,9};
		int[] output = {1,3,5,8,9,22,34,66};
		
		MergeSort merge = new ChihoonMergeSort();
		int[] result = merge.sort(input);
		
		for(int i=0; i<output.length; i++){
			assertThat(output[i], is(result[i]));
		}
	}

}
