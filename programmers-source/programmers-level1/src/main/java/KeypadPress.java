package main.java;

public class KeypadPress {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 01. 키패드 배열 생성 :: *과 #은 -1로 표시
        int[][] key = {{1,4,7,-1},{2,5,8,0},{3,6,9,-1}};
        int[] rhand = {2,3}, lhand = {0,3};	// 오른손과 왼손의 위치 저장

        // 02. 입력받은 numbers배열의 요소 num을 구하는 반복문
        for (int num : numbers) {
            for (int i=0; i<key.length; i++) {
                for (int j=0; j<key[0].length; j++) {
                    if (key[i][j] == num) {
                        // 03. num이 1,4,7 중에 하나면 answer에 L을 저장하고
                        // 해당 숫자의 배열 위치를 lhand에 저장
                        if (num == 1 || num == 4 || num == 7) {
                            answer += "L"; lhand[0] = i; lhand[1] = j;
                        }
                        // 03. num이 3,6,9 중에 하나면 answer에 R을 저장하고
                        // 해당 숫자의 배열 위치를 rhand에 저장
                        else if (num == 3 || num == 6 || num == 9) {
                            answer += "R"; rhand[0] = i; rhand[1] = j;
                        }
                        // 04. 그 외의 숫자이면 입력할 값 num의 위치를 loc에 저장
                        else {
                            int[] loc = {i,j};
                            // 05. loc의 위치와 왼손/오른손의 위치의 차이값을 각각 lDiff/rDiff에 저
                            int rDiff =
                                    Math.abs(rhand[0]-loc[0]) + Math.abs(rhand[1]-loc[1]);
                            int lDiff =
                                    Math.abs(lhand[0]-loc[0]) + Math.abs(lhand[1]-loc[1]);
                            // 06. rDiff가 더 가까우면 answer에 R을 저장하고
                            // 해당 숫자의 배열 위치를 rhand에 저장
                            if (rDiff < lDiff) { answer += "R"; rhand = loc; }
                            // 07. lDiff가 더 가까우면 answer에 L을 저장하고
                            // 해당 숫자의 배열 위치를 lhand에 저장
                            else if (rDiff > lDiff) { answer += "L"; lhand = loc; }
                            // 08. rDiff와 lDiff가 같은 경우 hand에 따라 저장값 고나리
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
//		System.out.println(new KeypadPress().solution(numbers1, "right"));
        System.out.println(new KeypadPress().solution(numbers2, "left"));
//		System.out.println(new KeypadPress().solution(numbers3, "right"));

    }

}

