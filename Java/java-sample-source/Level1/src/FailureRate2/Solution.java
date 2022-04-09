package FailureRate2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {
	
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];	// 스테이지 저장 (실패율 높은 순으로)
		Map<Integer, Double> failure = new HashMap<>();	// 실패율 저장 (키:스테이지, 밸류:실패율)
		int challenger = stages.length;	// 도전자 인원수
		
		// 1부터 스테이지까지 반복문
		for (int i=1; i<=N; i++) {
			int count = 0;	// 각 스테이지 별 도달한 인원수 체크
			
			// stages 배열을 도는 반복문
			for (int j=0; j<stages.length; j++) {
				if (stages[j] == i) count++;
			}
			
			// map 안에 (현재스테이지, 실패율) 저장
			if (count == 0 ) failure.put(i, 0.0);
			else failure.put(i,(double) count/(double)challenger);
			
			// 도전자 인원수에서 앞 스테이지에 떨어진 인원수 제거
			challenger -= count;
		}

		// map을 value 기준 내림차순으로 정렬 후 keySetList에 저장
		List<Integer> keySetList = new ArrayList<>(failure.keySet());
		Collections.sort(keySetList, (o1, o2) -> (failure.get(o2).compareTo(failure.get(o1))));
		
		// keySetList에 저장된 값에서 key 값만 뽑아 answer에 저장
		for (int i=0; i<answer.length; i++)
			answer[i] = keySetList.get(i);
		
		return answer;
	}

	public static void main(String[] args) {
		int[] arr1 = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] arr2 = {4,4,4,4,4};
		int[] arr3 = {1, 3, 5, 2, 6, 7, 1, 2, 3, 2, 4, 6, 7, 3, 5, 8, 1, 2, 5, 3, 2};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(5, arr1)));
		System.out.println(Arrays.toString(sol.solution(4, arr2)));
		System.out.println(Arrays.toString(sol.solution(10, arr3)));
	}

}
