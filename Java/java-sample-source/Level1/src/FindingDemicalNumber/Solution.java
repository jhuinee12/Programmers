/* 
 ���� ����
1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.

�Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�.
(1�� �Ҽ��� �ƴմϴ�.)

���� ����
n�� 2�̻� 1000000������ �ڿ����Դϴ�.

����� ��
n	result
10	4
5	3

����� �� ����
����� �� #1
1���� 10 ������ �Ҽ��� [2,3,5,7] 4���� �����ϹǷ� 4�� ��ȯ

����� �� #2
1���� 5 ������ �Ҽ��� [2,3,5] 3���� �����ϹǷ� 3�� ��ȯ */

package FindingDemicalNumber;

public class Solution {
	public int solution(int n) {
        int answer = n-1;
		
		for (int i=4; i<=n; i++) {
			for (int j=2; j<Math.sqrt(i)+1; j++) {
				if (i%j == 0)
				{
					answer--;
					break;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(10));

	}

}
