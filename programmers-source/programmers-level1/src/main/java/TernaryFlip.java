package main.java;

public class TernaryFlip {
    public int solution(int n) {
        int answer = 0;
        String ternary = "";	// 3진수 변환값 저장
        int div = n;

        // 1. n을 3진수로 변환
        while (div>=3) {
            ternary = (div % 3) + ternary;
            div /= 3;
        }
        ternary = div + ternary;

        // 2. 3진수를 10진수로 변환
        int i = 0;
        for (String t : ternary.split("")) {
            answer += Integer.parseInt(t) * (int) Math.pow(3, i);
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new TernaryFlip().solution(45));
    }

}