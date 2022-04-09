package FailureRate2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {
	
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];	// �������� ���� (������ ���� ������)
		Map<Integer, Double> failure = new HashMap<>();	// ������ ���� (Ű:��������, ���:������)
		int challenger = stages.length;	// ������ �ο���
		
		// 1���� ������������ �ݺ���
		for (int i=1; i<=N; i++) {
			int count = 0;	// �� �������� �� ������ �ο��� üũ
			
			// stages �迭�� ���� �ݺ���
			for (int j=0; j<stages.length; j++) {
				if (stages[j] == i) count++;
			}
			
			// map �ȿ� (���罺������, ������) ����
			if (count == 0 ) failure.put(i, 0.0);
			else failure.put(i,(double) count/(double)challenger);
			
			// ������ �ο������� �� ���������� ������ �ο��� ����
			challenger -= count;
		}

		// map�� value ���� ������������ ���� �� keySetList�� ����
		List<Integer> keySetList = new ArrayList<>(failure.keySet());
		Collections.sort(keySetList, (o1, o2) -> (failure.get(o2).compareTo(failure.get(o1))));
		
		// keySetList�� ����� ������ key ���� �̾� answer�� ����
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
