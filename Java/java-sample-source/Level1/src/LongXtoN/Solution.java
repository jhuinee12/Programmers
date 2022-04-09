package LongXtoN;

public class Solution {
	public long[] solution(int x, int n) {
	      long[] answer = new long[n];
	      
	      answer[0] = 1;
	      
	      for (int i=1; i<n; i++) {
	          answer[i] = answer[i-1] + x;
	      }
	      
	      return answer;
	  }

	public static void main(String[] args) {

	}

}
