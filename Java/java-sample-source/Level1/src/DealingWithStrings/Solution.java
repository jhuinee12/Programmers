/*
���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���.
���� ��� s�� a234�̸� False�� �����ϰ� 1234��� True�� �����ϸ� �˴ϴ�.

���� ����
s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.
 */

package DealingWithStrings;

public class Solution {
	public static boolean solution(String s) {
		
		boolean answer = true;
		
		if (s.length()==4 || s.length()==6) {
		  try {
		      Integer.parseInt(s);
		      answer = true;
		  } catch(NumberFormatException e) {
		      answer = false;
		  }
		} else
			answer = false;
		
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution("1"));
		System.out.println(sol.solution("12367"));

	}

}
