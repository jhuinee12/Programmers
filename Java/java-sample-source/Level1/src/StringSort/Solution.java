/*
���� ����
���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.

���� ����
str�� ���� 1 �̻��� ���ڿ��Դϴ�.
*/

package StringSort;

import java.util.Arrays;

public class Solution {
	public String solution(String s) {
		String answer = "";
		String[] arr = s.split("");
		Arrays.sort(arr);
		
		for (int i=arr.length-1; i>=0; i--)
			answer = answer + arr[i];
		
		return answer;
	}

	public static void main(String[] args) {

		Solution sol = new Solution();
		System.out.println(sol.solution("asdEdfkA"));
	}

}
