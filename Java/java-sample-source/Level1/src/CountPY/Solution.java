/*
 * �빮�ڿ� �ҹ��ڰ� �����ִ� ���ڿ� s�� �־����ϴ�.
 * s�� 'p'�� ������ 'y'�� ������ ���� ������ True, �ٸ��� False�� return �ϴ� solution�� �ϼ��ϼ���.
 * 'p', 'y' ��� �ϳ��� ���� ���� �׻� True�� �����մϴ�. ��, ������ ���� �� �빮�ڿ� �ҹ��ڴ� �������� �ʽ��ϴ�.
 * 
 * ���� ��� s�� pPoooyY�� true�� return�ϰ� Pyy��� false�� return�մϴ�.
 * 
 * ���ѻ���
 * ���ڿ� s�� ���� : 50 ������ �ڿ���
 * ���ڿ� s�� ���ĺ����θ� �̷���� �ֽ��ϴ�.
 */

package CountPY;

public class Solution {
	
	int pCount=0, yCount=0;

	boolean solution(String s) {
		
		boolean answer = true;

		// split�� ���� �ʰ� charAt�� ���!
		String[] spelling = s.split("");
		
		for(int i = 0; i<spelling.length; i++) {
			if (spelling[i].equals("p") || spelling[i].equals("P"))
				pCount++;
			else if (spelling[i].equals("y") || spelling[i].equals("Y"))
				yCount++;
		}
		
		if (pCount == yCount)
			answer = true;
		else
			answer = false;
		
        return answer;
    }
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution("pPooy"));

		System.out.println(sol.pCount);
		System.out.println(sol.yCount);
	}

}
