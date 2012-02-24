package chapter3.mergesort;

/**
 * @author kimddochi
 *
 */
public class ChihoonMergeSort implements MergeSort{

	@Override
	public int[] sort(int[] input) {
		mergeSort(input, 0, input.length-1);
		return input;
	}


	/*
	 * 재귀호출에 따른 값 및 순서
	 * 전제조건 ==> int[] input = {22,1,3,66,8,5,34,9}; 로 가정한다.
	 * 
	 * 0. ⒜ if 조건문
	 *   : left=0, right=7   ∴ if 조건에 '참'이된다.
	 * 1. ⒝재귀호출
	 *   : left=0, right=7, middle=3   ∴ mergeSort(input, 0, 3);
	 * 2. ⒜로 이동 ⒝재귀호출
	 *   : left=0, right=3, middle=1   ∴ mergeSort(input, 0, 1);
	 * 3. ⒜로 이동 ⒝재귀호출
	 *   : left=0, right=1, middle=0   ∴ mergeSort(input, 0, 1);
	 * 4. ⒜로 이동
	 *   : left=0, right=0   ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 2번의 변수값으로 ⒞로 이동한다. 
	 * 5. ⒞재귀호출
	 *   : left=0, right=1, middle=0   ∴ mergeSort(input, 1, 1);
	 * 6. ⒜로 이동
	 *   : left=1, right=1 ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 5번의 변수값으로 ⒟로 이동한다. 
	 * 7. ⒟로 이동 후 ⒠함수 실행
	 *   : left=0, middle=0, right=1   ∴ merge(input, 0, 0, 1);	--------------------------------------> 왼쪽의 배열[0]~배열[1]을 정렬한다.
	 * 8. ⒠함수 실행 후 mergeSort함수내의 변수들은 2번의 변수값과 동일. ⒞재귀호출 
	 *   : left=0, right=3, middle=1   ∴ mergeSort(input, 2, 3);
	 * 9. ⒜로 이동 ⒝재귀호출
	 *   : left=2, right=3, middle=2   ∴ mergeSort(input, 2, 2);
	 * 10. ⒜로 이동
	 *   :left=2, right=2 ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 9번의 변수값으로 ⒞로 이동한다.
	 * 11. ⒞재귀호출
	 *   : left=2, right=3, middle=2   ∴ mergeSort(input, 3, 3);
	 * 12. ⒜로 이동
	 *   :left=3, right=3 ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 11번의 변수값으로 ⒟로 이동한다.
	 * 13. ⒟로 이동 후 ⒠함수 실행
	 *   : left=2, right=3, middle=2   ∴ merge(input, 2, 2, 3);	-----------------------------------> 왼쪽의 배열[2]~배열[3]을 정렬한다.
	 * 14. 2번의 변수값으로 ⒠함수 실행 
	 *   : left=0, rignt=3, middle=1   ∴ merge(input, 2, 2, 3);	-----------------------------------> 왼쪽의 배열[0]~배열[3]을 정렬한다.
	 * 15. 1번의 변수값으로 ⒞재귀호출
	 *   : left=0, right=7, middle=3   ∴ mergeSort(input, 4, 7);
	 * 16. ⒜로 이동 ⒝재귀호출
	 *   : left=4, right=7, middle=5   ∴ mergeSort(input, 4, 5);
	 * 17. ⒜로 이동 ⒝재귀호출
	 *   : left=4, right=5, middle=4   ∴ mergeSort(input, 4, 4);
	 * 18. ⒜로 이동
	 *   : left=4, right=4 ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 17번의 변수값으로 ⒞로 이동한다.
	 * 19. ⒞재귀호출
	 *   : left=4, right=5, middle=4   ∴ mergeSort(input, 5, 5);
	 * 20. ⒜로 이동
	 *   : left=5, right=5 ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 17번의 변수값으로 ⒟로 이동한다.
	 * 21. ⒟로 이동 후 ⒠함수 실행
	 *   : left=4, right=5, middle=4   ∴ merge(input, 4, 4, 5);	-----------------------------------> 왼쪽의 배열[4]~배열[5]을 정렬한다.
	 * 22. 16번의 변수값으로 ⒞재귀호출
	 *   : left=4, right=7, middle=5   ∴ mergeSort(input, 6, 7);
	 * 23. ⒜로 이동 ⒝재귀호출
	 *   : left=6, right=7, middle=6   ∴ mergeSort(input, 6, 7);
	 * 24. ⒜로 이동 ⒝재귀호출
	 *   : left=6, right=6, middle=5   ∴ mergeSort(input, 6, 6);
	 * 25. ⒜로 이동
	 * : left=6, right=6 ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 23번의 변수값으로 ⒞로 이동한다.
	 * 26. ⒞재귀호출
	 *   : left=6, right=7, middle=6   ∴ mergeSort(input, 7, 7);
	 * 27. ⒜로 이동
	 *   : left=7, right=7 ∴ if 조건에 '거짓'이 되므로 조건문 밖으로 빠져나가고 23번의 변수값으로 ⒟로 이동한다.
	 * 28. ⒟로 이동 후 ⒠함수 실행
	 *   : left=6, right=7, middle=6   ∴ merge(input, 6, 6, 7);	-----------------------------------> 왼쪽의 배열[6]~배열[7]을 정렬한다.
	 * 28. 16번의 변수값으로 ⒠함수 실행
	 *   : left=4, rignt=7, middle=5   ∴ merge(input, 4, 5, 7);	-----------------------------------> 왼쪽의 배열[4]~배열[7]을 정렬한다.
	 * 29. 1번의 변수값으로 ⒠함수 실행
	 *   : left=0, rignt=7, middle=3   ∴ merge(input, 0, 3, 7);	-----------------------------------> 왼쪽의 배열[4]~배열[7]을 정렬한다.
	*/
	private void mergeSort(int[] input, int left, int right) {
		if(left < right){	//.......⒜
			int middle = (left+right)/2;
			mergeSort(input, left, middle);	//왼쪽함수 분할.......⒝
			mergeSort(input, middle+1, right);	//오른쪽함수 분할.......⒞
			merge(input, left, middle, right);	//합병.......⒟
		}
	}

	private void merge(int[] input, int left, int middle, int right) {	//.......⒠
		
		int i = left;
		int j = middle+1;
		int t = 0;

		int[] temp = new int[input.length]; // 두 부분 배열의 병합에 필요한 임시 배열

		//분할된 배열에 값을 정렬한다.
		while(i <= middle && j <= right){
			if(input[i] < input[j]){
				temp[t++] = input[i++];
			}
			else temp[t++] = input[j++];
		}

		//분할 후 정렬된 왼쪽 배열을 임시배열에 담는다.
		while(i <= middle){
			temp[t++] = input[i++];
		}

		//분할 후 정렬된 오른쪽 배열을 임시배열에 담는다.
		while(j <= right) {
			temp[t++] = input[j++];
		}
		
//		System.out.println("-----------------------------");
//		for(int x : temp){
//			System.out.print("temp = ["+x+"]");
//		}
//		System.out.println("\n-----------------------------");

		// 변수 초기화
		i = left;
		t = 0;

		// 정렬
		while(i <= right){
			input[i++] = temp[t++];
		}
	}

}
