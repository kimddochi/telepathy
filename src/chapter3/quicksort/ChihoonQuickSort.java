package chapter3.quicksort;

public class ChihoonQuickSort implements QuickSort {

	@Override
	public int[] sort(int[] input) {
		quickSort(input, 0, input.length-1);
		return input;
	}

	private void quickSort(int[] input, int left, int end) {
		int middle = partition(input, left, end);
		quickSort(input, left, middle-1);
		quickSort(input, middle+1, end);
	}

	private int partition(int[] input, int left, int end) {
		//기준원소 설정
		int pivot = input[left];
		int swap = 0;
		int j = end;
		for(int i=left+1; i<end; i++){
			if(i>=j) break;
			if(pivot < input[i]){
				swap = input[i];
				input[i] = input[j];
				input[j] = swap;
			}
			j--;
		}
		swap = input[j];
		input[j] = pivot;
		input[left] = swap;
		

		return j;
	}

}
