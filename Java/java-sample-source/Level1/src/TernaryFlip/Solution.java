package TernaryFlip;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String ternary = "";	// 3���� ��ȯ�� ����
        int div = n;
        
        // 1. n�� 3������ ��ȯ
        while (div>=3) {
        	ternary = (div % 3) + ternary;
        	div /= 3;
        }
        ternary = div + ternary;
        
        // 2. 3������ 10������ ��ȯ
        int i = 0;
        for (String t : ternary.split("")) {
        	answer += Integer.parseInt(t) * (int) Math.pow(3, i);
        	i++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(new Solution().solution(45));
	}

}
