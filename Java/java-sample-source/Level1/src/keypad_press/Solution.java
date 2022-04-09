package keypad_press;

public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 01. Ű�е� �迭 ���� :: *�� #�� -1�� ǥ��
        int[][] key = {{1,4,7,-1},{2,5,8,0},{3,6,9,-1}};
        int[] rhand = {2,3}, lhand = {0,3};	// �����հ� �޼��� ��ġ ����
        
        // 02. �Է¹��� numbers�迭�� ��� num�� ���ϴ� �ݺ���
        for (int num : numbers) {
            for (int i=0; i<key.length; i++) {
            	for (int j=0; j<key[0].length; j++) {
            		if (key[i][j] == num) {
            			// 03. num�� 1,4,7 �߿� �ϳ��� answer�� L�� �����ϰ� 
            			// �ش� ������ �迭 ��ġ�� lhand�� ����
            			if (num == 1 || num == 4 || num == 7) {
                    		answer += "L"; lhand[0] = i; lhand[1] = j;
                    	} 
            			// 03. num�� 3,6,9 �߿� �ϳ��� answer�� R�� �����ϰ� 
            			// �ش� ������ �迭 ��ġ�� rhand�� ����
            			else if (num == 3 || num == 6 || num == 9) {
                    		answer += "R"; rhand[0] = i; rhand[1] = j;
                    	} 
            			// 04. �� ���� �����̸� �Է��� �� num�� ��ġ�� loc�� ����
            			else {
                    		int[] loc = {i,j};
                    		// 05. loc�� ��ġ�� �޼�/�������� ��ġ�� ���̰��� ���� lDiff/rDiff�� ��
                    		int rDiff = 
                    				Math.abs(rhand[0]-loc[0]) + Math.abs(rhand[1]-loc[1]);
                    		int lDiff = 
                    				Math.abs(lhand[0]-loc[0]) + Math.abs(lhand[1]-loc[1]);
                    		// 06. rDiff�� �� ������ answer�� R�� �����ϰ�
                    		// �ش� ������ �迭 ��ġ�� rhand�� ����
                    		if (rDiff < lDiff) { answer += "R"; rhand = loc; } 
                    		// 07. lDiff�� �� ������ answer�� L�� �����ϰ�
                    		// �ش� ������ �迭 ��ġ�� lhand�� ����
                    		else if (rDiff > lDiff) { answer += "L"; lhand = loc; }
                    		// 08. rDiff�� lDiff�� ���� ��� hand�� ���� ���尪 ����
                    		else if (rDiff == lDiff) {
                    			if (hand.equals("right")) { answer += "R"; rhand = loc; } 
                    			else if (hand.equals("left")) { answer += "L"; lhand = loc; }
                    		}
                    	}
            			continue;
            		}
            	}
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//		System.out.println(new Solution().solution(numbers1, "right"));
		System.out.println(new Solution().solution(numbers2, "left"));
//		System.out.println(new Solution().solution(numbers3, "right"));

	}

}
