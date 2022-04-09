/*
 * array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ�ϴ� �Լ�, solution�� �ۼ����ּ���.
 * divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.
 * 
 * ���ѻ���
 * arr�� �ڿ����� ���� �迭�Դϴ�.
 * ���� i, j�� ���� i �� j �̸� arr[i] �� arr[j] �Դϴ�.
 * divisor�� �ڿ����Դϴ�.
 * array�� ���� 1 �̻��� �迭�Դϴ�.
 */

package DivNumArr;

import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
	
	public int[] solution(int[] arr, int divisor) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
//		if (divisor == 1) {
//			for (int i=0; i<arr.length; i++)
//				list.add(arr[i]);
//		} else {
//		    for (int i=0; i<arr.length; i++) {
//		    	if(arr[i]%divisor == 0) 
//		    		list.add(arr[i]);
//		    }
//		    
//		    if (list.size() == 0)
//		    	list.add(-1);
//		}
		
		for (int i=0; i<arr.length; i++) {
	    	if(arr[i]%divisor == 0) 
	    		list.add(arr[i]);
	    }
	    
	    if (list.size() == 0)
	    	list.add(-1);

		int[] answer = new int[list.size()];

	    for (int i=0; i<list.size(); i++)
	    	answer[i] = list.get(i);
	    
	    Arrays.sort(answer);
		
		return answer;
	  }

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr = {3,9,8,2};

		System.out.println(Arrays.toString(sol.solution(arr,1)));
	}

}
