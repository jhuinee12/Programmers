/*
���� ����
�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��

array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
array�� ���̴� 1 �̻� 100 �����Դϴ�.
array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
commands�� ���̴� 1 �̻� 50 �����Դϴ�.
commands�� �� ���Ҵ� ���̰� 3�Դϴ�.
*/

package NumberK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];
    	
    	for (int i=0; i<commands.length; i++) {
        	ArrayList<Integer> list = new ArrayList<>();
        	
        	for (int j=commands[i][0]-1; j<=commands[i][1]-1; j++)
        		list.add(array[j]);
        	
        	Collections.sort(list);
        	
        	answer[i] = list.get(commands[i][2]-1);
    	}
    	
        return answer;
    }

	public static void main(String[] args) {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		Solution sol = new Solution();
		
		System.out.println(Arrays.toString(sol.solution(array, commands)));
		
	}

}