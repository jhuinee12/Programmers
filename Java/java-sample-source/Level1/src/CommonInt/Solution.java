/*���� ����
�� ���� �Է¹޾� �� ���� �ִ������� �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� ������.
�迭�� �� �տ� �ִ�����, �״��� �ּҰ������ �־� ��ȯ�ϸ� �˴ϴ�.
���� ��� �� �� 3, 12�� �ִ������� 3, �ּҰ������ 12�̹Ƿ� solution(3, 12)�� [3, 12]�� ��ȯ�ؾ� �մϴ�.

���� ����
�� ���� 1�̻� 1000000������ �ڿ����Դϴ�.
����� ��
n	m	return
3	12	[3, 12]
2	5	[1, 10]
����� �� ����*/

package CommonInt;

import java.util.Arrays;

public class Solution {
	public int[] solution(int n, int m) {
		int[] answer = {1,1};
		
		for (int i=1; i<=n; i++)
			answer[0] = n%i == 0 && m%i == 0 ? i : answer[0];
		
		for (int i=1; i<=n; i++) {
			answer[1] = n%i == 0 && m%i == 0 ? i * n/i * m/i : answer[1];
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(100, 25)));
		System.out.println(Arrays.toString(sol.solution(5, 2)));
	}

}
