/*
���� ����
�Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�.
n�� �� �ڸ����� ū�ͺ��� ���� ������ ������ ���ο� ������ �������ּ���.
������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.

���� ����
n�� 1�̻� 8000000000 ������ �ڿ����Դϴ�.
*/
package IntDesc;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public long solution(long n) {
		long answer = 0;
		List<Object> arr = new ArrayList<Object>();
		
	    while (n != 0)
	    {
	    	arr.add(n%10);	 
	        n /= 10;
	    }
	    
	    arr.sort(null);
	    
	    for (int i=arr.size()-1; i>=0; i--) {
	    	answer *= 10;
	    	answer += (long) arr.get(i);
	    }

		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(118372));
	}

}
