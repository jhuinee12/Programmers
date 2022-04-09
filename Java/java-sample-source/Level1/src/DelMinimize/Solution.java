/*���� ����
������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���.
������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.

���� ����
arr�� ���� 1 �̻��� �迭�Դϴ�.
�ε��� i, j�� ���� i �� j�̸� arr[i] �� arr[j] �Դϴ�.*/

package DelMinimize;

import java.util.Arrays;

public class Solution {
	
	public int[] solution(int[] arr) {
		
		if (arr.length == 1) {
			int[] answer = {-1};
			return answer;
		}
		else {
			
			int[] answer = new int[arr.length-1];
			
			int[] arr2 = new int[arr.length];
			
			for (int i=0; i<arr.length; i++) {
				arr2[i] = arr[i];
			}
			
			Arrays.sort(arr);
			
			int a=0;
			
			for (int i=0; i<arr.length; i++) {
				if (arr2[i] == arr[0])
					a = i;
			}
			
			for (int i=0; i<a; i++) {
				answer[i] = arr2[i];
			}
			
			for (int i=a; i<arr.length-1; i++) {
				answer[i] = arr2[i+1];
			}
			
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] arr1 = {4,3,2,1};
		int[] arr2= {10};
		
		Solution sol = new Solution();
		
		System.out.println(Arrays.toString(sol.solution(arr1)));
		System.out.println(Arrays.toString(sol.solution(arr2)));
	}

}
