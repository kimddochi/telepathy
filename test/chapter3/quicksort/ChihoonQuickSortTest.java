package chapter3.quicksort;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ChihoonQuickSortTest {

	@Test
	public void quickSortTest() throws Exception {
		int[] input = {5,3,7,6,2,1,4};
		int[] output = {1,2,3,4,5,6,7};
		
		QuickSort quick = new ChihoonQuickSort();
		
		int[] result = quick.sort(input);
		
		for(int i=0; i<output.length; i++){
			assertThat(output[i], is(result[i]));
		}
	}
}
