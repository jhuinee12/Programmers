/*
���̰� n�̰�, ���ڼ��ڼ��ڼ�....�� ���� ������ �����ϴ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
������� n�� 4�̸� ���ڼ����� �����ϰ� 3�̶�� ���ڼ��� �����ϸ� �˴ϴ�.

���� ����
n�� ���� 10,000������ �ڿ����Դϴ�.
 */

package PatternReplay;

public class Solution {

	public String solution(int n) {
		String answer = "";
		
		/*
		 * String[] Pattern = {"��","��"};
		 * 
		 * if (n%2 == 0) { for (int i=0; i<n/2; i++) for (int j=0; j<2; j++) answer =
		 * answer+Pattern[j]; } else { for (int i=0; i<n/2; i++) for (int j=0; j<2; j++)
		 * answer = answer+Pattern[j]; answer = answer + "��"; }
		 */
		
		for (int i=0; i<n; i++)
			answer += i%2==0 ? "��" : "��";
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		System.out.println(sol.solution(5));

	}

}
