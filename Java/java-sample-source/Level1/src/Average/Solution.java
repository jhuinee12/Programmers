/*
 ���� ����
������ ��� �ִ� �迭 arr�� ��հ��� return�ϴ� �Լ�, solution�� �ϼ��غ�����.

���ѻ���
arr�� ���� 1 �̻�, 100 ������ �迭�Դϴ�.
arr�� ���Ҵ� -10,000 �̻� 10,000 ������ �����Դϴ�.
*/

package Average;

public class Solution {
	
	public double solution(int[] arr) {
		double answer = 0;
		int sum=0;
		
		for (int i=0; i<arr.length; i++)
			sum += arr[i];
		
		answer = (double)sum/arr.length;
		
		return answer;
	}
	  
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		int[] arr = {2,3,4,5};
		
		System.out.println(sol.solution(arr));
			
	}

}
