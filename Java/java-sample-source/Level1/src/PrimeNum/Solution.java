/*
 * 문제 설명
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 * 
 * 제한 조건
 * n은 2이상 1000000이하의 자연수입니다.
 */

package PrimeNum;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		
		for (int i=2; i<=n; i++) {
			
			int count = 0;
			
			for (int j=1; j<i; j++) {
				if (i%j == 0) {
					count++;
				}
			}
			
			if (count == 1) {
				System.out.println("소수:"+i);
				answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		System.out.println(sol.solution(100000));

	}

}
