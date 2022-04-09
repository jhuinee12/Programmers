/*���� ����
������ ���� ���� n�� ����, n�� � ���� ���� x�� �������� �ƴ��� �Ǵ��Ϸ� �մϴ�.
n�� ���� ���� x�� �����̶�� x+1�� ������ �����ϰ�, n�� ���� ���� x�� ������ �ƴ϶�� -1�� �����ϴ� �Լ��� �ϼ��ϼ���.

���� ����
n�� 1�̻�, 50000000000000 ������ ���� �����Դϴ�.

����� ��
n	return
121	144
3	-1*/

package SquareRoot;

public class Solution {
	public long solution(long n) {
		if(Math.pow((int)Math.sqrt(n), 2) == n)
			return (long) Math.pow(Math.sqrt(n) + 1, 2);
		return -1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(257));
		System.out.println(sol.solution(4));
	}

}
