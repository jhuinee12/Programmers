package main.java;

import java.util.Arrays;

/*문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, CommonInt을 완성해 보세요.
배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 CommonInt(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.
입출력 예
n	m	return
3	12	[3, 12]
2	5	[1, 10]
입출력 예 설명*/

public class CommonInt {
    public int[] CommonInt(int n, int m) {
        int[] answer = {1,1};

        for (int i=1; i<=n; i++)
            answer[0] = n%i == 0 && m%i == 0 ? i : answer[0];

        for (int i=1; i<=n; i++) {
            answer[1] = n%i == 0 && m%i == 0 ? i * n/i * m/i : answer[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        CommonInt sol = new CommonInt();
        System.out.println(Arrays.toString(sol.CommonInt(100, 25)));
        System.out.println(Arrays.toString(sol.CommonInt(5, 2)));
    }

}

