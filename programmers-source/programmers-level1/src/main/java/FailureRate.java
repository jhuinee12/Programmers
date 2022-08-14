package main.java;

/*문제 설명

슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다.
그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
오렐리를 위해 실패율을 구하는 코드를 완성하라.

실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가매개변수로 주어질 때,
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 FailureRate 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

입출력 예
N	stages						result
5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
4	[4,4,4,4,4]					[4,1,2,3]

입출력 예 설명
입출력 예 #1
1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다.
따라서 1번 스테이지의 실패율은 다음과 같다.

1 번 스테이지 실패율 : 1/8
2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다.
따라서 2번 스테이지의 실패율은 다음과 같다.

2 번 스테이지 실패율 : 3/7
마찬가지로 나머지 스테이지의 실패율은 다음과 같다.

3 번 스테이지 실패율 : 2/4
4번 스테이지 실패율 : 1/2
5번 스테이지 실패율 : 0/1
각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.

[3,4,2,1,5]

입출력 예 #2

모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.

[4,1,2,3]*/

import java.util.*;

public class FailureRate {
    public int[] FailureRate(int N, int[] stages) {
        int[] answer = new int[N];
        int[] num = new int[N]; // 통과하지 못한 사람 수
        int[] total = new int[N]; // 도달한 사람 수
        double[][] fail = new double[N][N];

        Arrays.sort(stages);

        // 초기화
        for (int i=0; i<N; i++) {
            num[i] = 0;
            total[i] = 0;
        }

        // fail[0][i] : 단계 저장, fail[1][i] : 실패율 저장
        for (int i=1; i<=N; i++) {
            for (int j=0; j<stages.length; j++) {
                if (stages[j] == i)
                    num[i-1]++;
                if (stages[j] >= i)
                    total[i-1]++;
            }
            if (total[i-1]==0)
                fail[1][i-1] = 0.0;
            else
                fail[1][i-1] = (double)num[i-1] / total[i-1];
            fail[0][i-1] = (double)i;
        }

        for (int i=0; i<2; i++) {
            for (int j=0; j<N; j++) {
                System.out.println("fail["+i+"]["+j+"] : "+fail[i][j]);
            }
        }

        // 실패율이 높은 순서대로 정렬 : 같을 경우 더 낮은 레벨이 앞으로
        for (int i=0; i<N; i++) {
            double temp = 0.0;
            for (int j=0; j<N; j++) {
                if (fail[1][i] > fail[1][j]) {
                    temp = fail[1][i];
                    fail[1][i] = fail[1][j];
                    fail[1][j] = temp;

                    temp = fail[0][i];
                    fail[0][i] = fail[0][j];
                    fail[0][j] = temp;
                }
                else if (fail[1][i] == fail[1][j]) {
                    if (fail[0][i]<fail[0][j]) {
                        temp = fail[1][i];
                        fail[1][i] = fail[1][j];
                        fail[1][j] = temp;

                        temp = fail[0][i];
                        fail[0][i] = fail[0][j];
                        fail[0][j] = temp;
                    }
                }
            }
        }

        // 출력
        for (int i=0; i<N; i++) {
            answer[i] = (int) fail[0][i];
        }

        return answer;
    }

    public int[] solution2(int N, int[] stages) {
        int[] answer = new int[N];	// 스테이지 저장 (실패율 높은 순으로)
        Map<Integer, Double> failure = new HashMap<>();	// 실패율 저장 (키:스테이지, 밸류:실패율)
        int challenger = stages.length;	// 도전자 인원수

        // 1부터 스테이지까지 반복문
        for (int i=1; i<=N; i++) {
            int count = 0;	// 각 스테이지 별 도달한 인원수 체크

            // stages 배열을 도는 반복문
            for (int j=0; j<stages.length; j++) {
                if (stages[j] == i) count++;
            }

            // map 안에 (현재스테이지, 실패율) 저장
            if (count == 0 ) failure.put(i, 0.0);
            else failure.put(i,(double) count/(double)challenger);

            // 도전자 인원수에서 앞 스테이지에 떨어진 인원수 제거
            challenger -= count;
        }

        // map을 value 기준 내림차순으로 정렬 후 keySetList에 저장
        List<Integer> keySetList = new ArrayList<>(failure.keySet());
        Collections.sort(keySetList, (o1, o2) -> (failure.get(o2).compareTo(failure.get(o1))));

        // keySetList에 저장된 값에서 key 값만 뽑아 answer에 저장
        for (int i=0; i<answer.length; i++)
            answer[i] = keySetList.get(i);

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] arr2 = {4,4,4,4,4};
        int[] arr3 = {1, 3, 5, 2, 6, 7, 1, 2, 3, 2, 4, 6, 7, 3, 5, 8, 1, 2, 5, 3, 2};

        FailureRate sol = new FailureRate();
        System.out.println(Arrays.toString(sol.FailureRate(5, arr1)));
        System.out.println(Arrays.toString(sol.FailureRate(4, arr2)));
        System.out.println(Arrays.toString(sol.FailureRate(10, arr3)));

        System.out.println(Arrays.toString(sol.solution2(5, arr1)));
        System.out.println(Arrays.toString(sol.solution2(4, arr2)));
        System.out.println(Arrays.toString(sol.solution2(10, arr3)));
    }

}
