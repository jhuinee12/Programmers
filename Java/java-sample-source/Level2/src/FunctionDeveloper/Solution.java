package FunctionDeveloper;

/*
���� ����
���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� ��
�� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
�۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
�۾� ������ 100 �̸��� �ڿ����Դϴ�.
�۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.

����� ��
progresses					speeds					return
[93, 30, 55]				[1, 30, 5]				[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]		[1, 3, 2]

����� �� ����
����� �� #1
ù ��° ����� 93% �Ϸ�Ǿ� �ְ� �Ϸ翡 1%�� �۾��� �����ϹǷ� 7�ϰ� �۾� �� ������ �����մϴ�.
�� ��° ����� 30%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 30%�� �۾��� �����ϹǷ� 3�ϰ� �۾� �� ������ �����մϴ�. ������ ���� ù ��° ����� ���� �ϼ��� ���°� �ƴϱ� ������ ù ��° ����� �����Ǵ� 7��° �����˴ϴ�.
�� ��° ����� 55%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 5%�� �۾��� �����ϹǷ� 9�ϰ� �۾� �� ������ �����մϴ�.
���� 7��°�� 2���� ���, 9��°�� 1���� ����� �����˴ϴ�.

����� �� #2
��� ����� �Ϸ翡 1%�� �۾��� �����ϹǷ�, �۾��� ��������� ���� �ϼ��� ���� 5��, 10��, 1��, 1��, 20��, 1���Դϴ�.
� ����� ���� �ϼ��Ǿ����� �տ� �ִ� ��� ����� �ϼ����� ������ ������ �Ұ����մϴ�.
���� 5��°�� 1���� ���, 10��°�� 3���� ���, 20��°�� 2���� ����� �����˴ϴ�.
*/


public class Solution {
	
	public int[] solution(int[] progresses, int[] speeds) {
	    int[] date = new int[progresses.length];	// �ɸ��� ��¥ �迭
	    int count = 0;	// answer�� length ���ϱ�
    	int loc=1;
	    
	    for (int i=0; i<progresses.length; i++) {
	    	int day = 100-progresses[i];

	    	date[i] = (int)day/speeds[i]<(double)day/speeds[i]?(int)day/speeds[i]+1:(int)day/speeds[i];
	    	
	    	if (i>0) {
    	    	if (date[i] < date[i-1]) date[i] = date[i-1];
    	    	if (date[i] != date[i-1]) count++;
	    	}

	    	System.out.println("date["+i+"] = " + date[i]);
	    }
	    
	    System.out.println("count�� "+count+"���Դϴ�.");
	    
	    int[] answer = new int[count+1];
	    
	    for (int i=0; i<answer.length; i++) {
	    	answer[i] = 1;
	    	for (int j=loc; j<date.length; j++) {
	    		if (date[j]==date[j-1]) answer[i] += 1;
	    		else {
	    			loc = ++j; j=date.length;
	    		}
	    		System.out.println("answer["+i+"] : "+answer[i]);
	    	}
	    }
	    
	    return answer;
	}

	public static void main(String[] args) {
		int[] progresses1 = {93,30,55};
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] progresses3 = {50, 20, 75, 83, 20, 15};
		int[] speeds1 = {1,30,5};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		int[] speeds3 = {5, 4, 5, 1, 5, 1}; // 10 20 20 20 20 85
		
		Solution sol = new Solution();
		sol.solution(progresses1, speeds1);
		sol.solution(progresses2, speeds2);
		sol.solution(progresses3, speeds3);
	}

}

