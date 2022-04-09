/*
 * ���� ����
 * 1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.
 * 
 * �Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�.
 * (1�� �Ҽ��� �ƴմϴ�.)
 * 
 * ���� ����
 * n�� 2�̻� 1000000������ �ڿ����Դϴ�.
 */

package PrimeNum;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		
		for (int i=2; i<=n; i++) {
			
			int count = 0;
			
			for (int j=1; j<i; j++) {
				if (i%j == 0) {
					count++;
				}
			}
			
			if (count == 1) {
				System.out.println("�Ҽ�:"+i);
				answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		System.out.println(sol.solution(100000));

	}

}
