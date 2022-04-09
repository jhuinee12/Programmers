package NewIdRecommand;

public class Solution {
	
	/**
	 * 1. ��ħǥ�� ������ ��, ���Ű� �ȵ� ����!! (...... �Է� �� :: . ���)
	 * 2. 16�ڸ��� �Ѿ�� ��� 15�ڸ��� �߶��µ�, ��ħǥ�� �� ���� ���� ��� ����!! (��ħǥ ���߸�)
	 * 3. ����Լ��� ����ϳ�??
	 */
	
	public String solution(String new_id) {
		String answer = "";
		// 1. �ҹ��ڷ� ġȯ
		new_id = new_id.toLowerCase();
		// 2. Ư������ ����
		for (int i=0; i<new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (new_id.charAt(i) == '.' || new_id.charAt(i) == '_' || new_id.charAt(i) == '-' 
					|| Character.isLetter(new_id.charAt(i)) || Character.isDigit(new_id.charAt(i)))
				answer += new_id.charAt(i);
		}
		// 3. ��ħǥ(.) 2�� �̻� ���� -> �ϳ��� ����
		while (answer.contains(".."))
			answer = answer.replace("..", ".");
		// 4-1. ��ħǥ(.)�� �����ϸ� �ڸ���
		if (answer.startsWith(".")) answer = answer.substring(1); 
		// 4-2. ��ħǥ(.)�� ���� �ڸ���
		if (answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);	
		// 5. new_id�� �� ���ڿ��̸� "a" ����
		answer = answer.length() == 0 ? "a" : answer;	
		if (answer.length() >= 16) {
			// 6. 15��° ���ڱ��� �ڸ���
			answer = answer.substring(0, 15);	
		} else if (answer.length() <= 2)
			// 7. ������ ���� 3������ �ݺ�
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
