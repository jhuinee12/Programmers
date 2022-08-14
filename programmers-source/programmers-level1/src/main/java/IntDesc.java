package main.java;

/*
문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다.
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
*/

import java.util.ArrayList;
import java.util.List;

public class IntDesc {
    public long solution(long n) {
        long answer = 0;
        List<Object> arr = new ArrayList<Object>();

        while (n != 0)
        {
            arr.add(n%10);
            n /= 10;
        }

        arr.sort(null);

        for (int i=arr.size()-1; i>=0; i--) {
            answer *= 10;
            answer += (long) arr.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        IntDesc sol = new IntDesc();
        System.out.println(sol.solution(118372));
    }

}