/*
길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

제한 조건
n은 길이 10,000이하인 자연수입니다.
 */

package PatternReplay;

public class Solution {

	public String solution(int n) {
		String answer = "";
		
		/*
		 * String[] Pattern = {"수","박"};
		 * 
		 * if (n%2 == 0) { for (int i=0; i<n/2; i++) for (int j=0; j<2; j++) answer =
		 * answer+Pattern[j]; } else { for (int i=0; i<n/2; i++) for (int j=0; j<2; j++)
		 * answer = answer+Pattern[j]; answer = answer + "수"; }
		 */
		
		for (int i=0; i<n; i++)
			answer += i%2==0 ? "수" : "박";
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		System.out.println(sol.solution(5));

	}

}
