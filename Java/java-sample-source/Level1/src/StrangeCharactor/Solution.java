/*���� ����
���ڿ� s�� �� �� �̻��� �ܾ�� �����Ǿ� �ֽ��ϴ�. �� �ܾ�� �ϳ� �̻��� ���鹮�ڷ� ���еǾ� �ֽ��ϴ�.
�� �ܾ��� ¦����° ���ĺ��� �빮�ڷ�, Ȧ����° ���ĺ��� �ҹ��ڷ� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.

���� ����
���ڿ� ��ü�� ¦/Ȧ�� �ε����� �ƴ϶�, �ܾ�(������ ����)���� ¦/Ȧ�� �ε����� �Ǵ��ؾ��մϴ�.
ù ��° ���ڴ� 0��° �ε����� ���� ¦����° ���ĺ����� ó���ؾ� �մϴ�.

����� ��
s					return
try hello world		TrY HeLlO WoRlD

����� �� ����
try hello world�� �� �ܾ� try, hello, world�� �����Ǿ� �ֽ��ϴ�.
�� �ܾ��� ¦����° ���ڸ� �빮�ڷ�, Ȧ����° ���ڸ� �ҹ��ڷ� �ٲٸ� TrY, HeLlO, WoRlD�Դϴ�.
���� TrY HeLlO WoRlD �� �����մϴ�.*/

package StrangeCharactor;

class Solution {
	public String solution(String s) {
		
		String answer = "";
		int cnt = 0;
		String[] array = s.split("");
 
		for(int i=0; i<array.length; i++) {
			cnt = array[i].contains(" ") ? 0 : cnt + 1;
			answer += cnt%2 == 0 ? array[i].toLowerCase() : array[i].toUpperCase(); 
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("try  hello world"));
		System.out.println(sol.solution("HAN JAE HEe"));
		System.out.println(sol.solution("Happy New Year"));
		System.out.println(sol.solution("sp ace"));
	}

}
