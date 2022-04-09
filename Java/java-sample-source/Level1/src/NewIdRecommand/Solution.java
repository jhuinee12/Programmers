package NewIdRecommand;

public class Solution {
	
	/**
	 * 1. 마침표만 남았을 때, 제거가 안됨 문제!! (...... 입력 시 :: . 출력)
	 * 2. 16자리가 넘어갔을 경우 15자리로 잘랐는데, 마침표가 맨 끝에 있을 경우 문제!! (마침표 안잘림)
	 * 3. 재귀함수를 써야하나??
	 */
	
	public String solution(String new_id) {
		String answer = "";
		// 1. 소문자로 치환
		new_id = new_id.toLowerCase();
		// 2. 특수문자 제거
		for (int i=0; i<new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (new_id.charAt(i) == '.' || new_id.charAt(i) == '_' || new_id.charAt(i) == '-' 
					|| Character.isLetter(new_id.charAt(i)) || Character.isDigit(new_id.charAt(i)))
				answer += new_id.charAt(i);
		}
		// 3. 마침표(.) 2번 이상 연속 -> 하나로 변경
		while (answer.contains(".."))
			answer = answer.replace("..", ".");
		// 4-1. 마침표(.)로 시작하면 자르기
		if (answer.startsWith(".")) answer = answer.substring(1); 
		// 4-2. 마침표(.)로 끝면 자르기
		if (answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);	
		// 5. new_id가 빈 문자열이면 "a" 대입
		answer = answer.length() == 0 ? "a" : answer;	
		if (answer.length() >= 16) {
			// 6. 15번째 문자까지 자르기
			answer = answer.substring(0, 15);	
		} else if (answer.length() <= 2)
			// 7. 마지막 문자 3개까지 반복
			while (answer.length() < 3 )
				answer += answer.substring(answer.length()-1);
		
		if (answer.startsWith(".") 
				|| answer.endsWith(".")
				|| answer.length() >= 16
				|| answer.length() <= 2)
			return solution(answer);
		
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("dkslqpslekflsc.q"));
		System.out.println(sol.solution("...!@BaT#*....y.abcdefghijklm"));
		System.out.println(sol.solution("bat.y.abcdefghi"));
	}

}
