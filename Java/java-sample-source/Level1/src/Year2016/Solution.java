/*
 * 2016�� 1�� 1���� �ݿ����Դϴ�. 2016�� a�� b���� ���� �����ϱ��?
 * �� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
 * ������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT�Դϴ�.
 * ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� TUE�� ��ȯ�ϼ���.
 */


package Year2016;

import java.util.Calendar;
import java.util.Scanner;

public class Solution {
	
	  public String solution(int a, int b) {
	      String answer = "";
	        
	        Calendar cal = Calendar.getInstance();
	        cal.set(2016,a-1,b-1);

	        int dayNum = cal.get(Calendar.DAY_OF_WEEK);

	        switch (dayNum) {
	        	
	        case 1:
	        	answer = "MON";
	        	break;
	        	
	        case 2:
	        	answer = "TUE";
	        	break;
	        	
	        case 3:
	        	answer = "WED";
	        	break;
	        	
	        case 4:
	        	answer = "THU";
	        	break;
	        	
	        case 5:
	        	answer = "FRI";
	        	break;
	        	
	        case 6:
	        	answer = "SAT";
	        	break;
	        	
	        case 7:
	        	answer = "SUN";
	        	break;
	        }
	        
	        return answer;
	}
      
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.printf("�� �Է� : ");
        int a = sc.nextInt();
		System.out.printf("�� �Է� : ");
        int b = sc.nextInt();
        
        System.out.println();
        System.out.println();
        
        Solution solve = new Solution();

        System.out.println("���� : " + solve.solution(a, b));
	}

}
