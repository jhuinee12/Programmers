/*���� ����
���� num�� ¦���� ��� Even�� ��ȯ�ϰ� Ȧ���� ��� Odd�� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
num�� int ������ �����Դϴ�.
0�� ¦���Դϴ�.*/

package OddEven;

public class Solution {
	public String solution(int num) {
		return (num%2==0) ? "Even" : "Odd";
	}
	  
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(3));
		System.out.println(sol.solution(4));
	}

}
