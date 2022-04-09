/*
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
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
