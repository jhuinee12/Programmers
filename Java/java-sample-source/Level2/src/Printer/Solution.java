/*
���� ����
�Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�.
�׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�.
�̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�.
�� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.

1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
3. �׷��� ������ J�� �μ��մϴ�.
���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.

���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.

���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities��
���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��,
���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
�μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������
������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.

����� ��
priorities			location	return
[2, 1, 3, 2]			2			1
[1, 1, 9, 1, 1, 1]		0			5

����� �� ����
���� #1

������ ���� ���� �����ϴ�.

���� #2

6���� ����(A, B, C, D, E, F)�� �μ� ����Ͽ� �ְ� �߿䵵�� 1 1 9 1 1 1 �̹Ƿ� C D E F A B ������ �μ��մϴ�.
 */

package Printer;

import java.util.Arrays;

public class Solution {    
	
	public int solution(int[] priorities, int location) {
		int answer = 0;
		int len = priorities.length; // ���� len�� priorities �迭�� ����
		int[] loc = new int[len];
		
		for (int i=0; i<len; i++)
			loc[i] = i; // location ��ġ ���ϱ� ���� �迭 (answer)
		
		for (int i=0; i<len; i++) {
			for (int j=i+1; j<len; j++) {
				if (priorities[i]<priorities[j]) {
					int temp = priorities[i];
					int locTemp = loc[i];
					for (int k=i; k<len-1; k++)
					{
						priorities[k] = priorities[k+1];
						loc[k] = loc[k+1];
					}
					priorities[len-1] = temp;
					loc[len-1] = locTemp;
					j = i;
				}
			}
		}
		
		for (int i=0; i<len; i++) {
			if (loc[i] == location)
				return i+1;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] priorities = {2,4,6,8};
		int location = 0;
		
		System.out.println(sol.solution(priorities, location));
	}

}
