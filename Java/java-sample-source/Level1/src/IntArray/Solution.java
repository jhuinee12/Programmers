/*
 * �ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� �������ּ���.
 * ������� n�� 12345�̸� [5,4,3,2,1]�� �����մϴ�.
 */

package IntArray;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public int[] solution(long n) {
		
		String s = String.valueOf(n);
		String[] sArr = s.split("");

		ArrayList<String> list = new ArrayList<>();

	    Collections.reverse(list);

	    sArr = list.toArray(new String[list.size()]);
	    
	    for (int i=0; i<sArr.length; i++) 
	    	System.out.println(sArr[i]);
	    
	    int[] answer = new int[sArr.length];
		
		for (int i=0; i<sArr.length; i++) 
			answer[i] = Integer.parseInt(sArr[i]);
		
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(12345));

	}

}
