/*
���� ����
� ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�.
���� ��� AB�� 1��ŭ �и� BC�� �ǰ�, 3��ŭ �и� DE�� �˴ϴ�.
z�� 1��ŭ �и� a�� �˴ϴ�.
���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.

���� ����
������ �ƹ��� �о �����Դϴ�.
s�� ���ĺ� �ҹ���, �빮��, �������θ� �̷���� �ֽ��ϴ�.
s�� ���̴� 8000�����Դϴ�.
n�� 1 �̻�, 25������ �ڿ����Դϴ�.
 */

package CaesarPassword;

class Solution {
	public String solution(String s, int n) {
		char[] charArr = s.toCharArray();
			for(int i = 0 ;i < charArr.length; i++) {
				if(charArr[i]==' ')
					continue;
				else if(charArr[i]<='Z'&&charArr[i]>='A'&&charArr[i]+n>'Z')
					charArr[i] = (char) (charArr[i] + n - 26);
				else if(charArr[i]+n>'z')
					charArr[i] = (char) (charArr[i] + n - 26);
				else
					charArr[i] = (char) (charArr[i] + n);
			}
			
			return new String(charArr);
	}

	public static void main(String[] args) {

		Solution sol = new Solution();
		System.out.println(sol.solution("AZ", 1));
		System.out.println();
		System.out.println(sol.solution("z", 2));
		System.out.println();
		System.out.println(sol.solution("a B z", 4));

	}

}
