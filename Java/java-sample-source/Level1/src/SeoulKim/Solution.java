package SeoulKim;
/*	String�� �迭 seoul�� element�� Kim�� ��ġ x�� ã��, 
�輭���� x�� �ִٴ� String�� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���. 
seoul�� Kim�� ���� �� ���� ��Ÿ���� �߸��� ���� �ԷµǴ� ���� �����ϴ�.

���� ����
seoul�� ���� 1 �̻�, 1000 ������ �迭�Դϴ�.
seoul�� ���Ҵ� ���� 1 �̻�, 20 ������ ���ڿ��Դϴ�.
Kim�� �ݵ�� seoul �ȿ� ���ԵǾ� �ֽ��ϴ�.

����� ��
seoul	return
[Jane, Kim]	�輭���� 1�� �ִ�

https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
*/

public class Solution {

public String solution(String[] seoul) { //�Լ�
	
	String answer = "";
	
	for (int i=0; i<seoul.length; i++) {
		if (seoul[i] == "kim") {
			answer = "�輭����" + i + "�� �ִ�";
		}
	}
	
	return answer;
}

}