> 최초작성 : 2022.10.02

## ******Level3 - 코딩 테스트 공부**** (kotlin)**

>  [코딩테스트 연습 - 코딩 테스트 공부](https://school.programmers.co.kr/learn/courses/30/lessons/12904)

> 참고 : https://tech.kakao.com/2022/07/13/2022-coding-test-summer-internship/

| **문제 설명** |
|---|
| 당신은 코딩 테스트를 준비하기 위해 공부하려고 합니다. 코딩 테스트 문제를 풀기 위해서는 알고리즘에 대한 지식과 코드를 구현하는 능력이 필요합니다.<br>알고리즘에 대한 지식은 알고력, 코드를 구현하는 능력은 코딩력이라고 표현합니다. 알고력과 코딩력은 0 이상의 정수로 표현됩니다.<br>문제를 풀기 위해서는 문제가 요구하는 일정 이상의 알고력과 코딩력이 필요합니다.
예를 들어, 당신의 현재 알고력이 15, 코딩력이 10이라고 가정해보겠습니다.<br>　　* A라는 문제가 알고력 10, 코딩력 10을 요구한다면 A 문제를 풀 수 있습니다.<br>　　* B라는 문제가 알고력 10, 코딩력 20을 요구한다면 코딩력이 부족하기 때문에 B 문제를 풀 수 없습니다.
풀 수 없는 문제를 해결하기 위해서는 알고력과 코딩력을 높여야 합니다. 알고력과 코딩력을 높이기 위한 다음과 같은 방법들이 있습니다.<br>　　* 알고력을 높이기 위해 알고리즘 공부를 합니다. 알고력 1을 높이기 위해서 1의 시간이 필요합니다.<br>　　* 코딩력을 높이기 위해 코딩 공부를 합니다. 코딩력 1을 높이기 위해서 1의 시간이 필요합니다.<br>　　* 현재 풀 수 있는 문제 중 하나를 풀어 알고력과 코딩력을 높입니다.
각 문제마다 문제를 풀면 올라가는 알고력과 코딩력이 정해져 있습니다. <br>문제를 하나 푸는 데는 문제가 요구하는 시간이 필요하며 같은 문제를 여러 번 푸는 것이 가능합니다. <br>당신은 주어진 모든 문제들을 풀 수 있는 알고력과 코딩력을 얻는 최단시간을 구하려 합니다. <br>초기의 알고력과 코딩력을 담은 정수 alp와 cop, 문제의 정보를 담은 2차원 정수 배열 problems가 매개변수로 주어졌을 때, 모든 문제들을 풀 수 있는 알고력과 코딩력을 얻는 최단시간을 return 하도록 solution 함수를 작성해주세요. <br>모든 문제들을 1번 이상씩 풀 필요는 없습니다. 입출력 예 설명을 참고해주세요.                                                                                            | 

| **제한사항** |
| --- |
| - 초기의 알고력을 나타내는 alp와 초기의 코딩력을 나타내는 cop가 입력으로 주어집니다.|
| - 0 ≤ alp,cop ≤ 150|
| - 1 ≤ problems의 길이 ≤ 100|
| - problems의 원소는 [alp_req, cop_req, alp_rwd, cop_rwd, cost]의 형태로 이루어져 있습니다.|
| - alp_req는 문제를 푸는데 필요한 알고력입니다.|
| - 0 ≤ alp_req ≤ 150|
| - cop_req는 문제를 푸는데 필요한 코딩력입니다.|
| - 0 ≤ cop_req ≤ 150|
| - alp_rwd는 문제를 풀었을 때 증가하는 알고력입니다.|
| - 0 ≤ alp_rwd ≤ 30|
| - cop_rwd는 문제를 풀었을 때 증가하는 코딩력입니다.|
| - 0 ≤ cop_rwd ≤ 30|
| - cost는 문제를 푸는데 드는 시간입니다.|
| - 1 ≤ cost ≤ 100|

| **정확성 테스트 케이스 제한사항** |
| --- |
| - 0 ≤ alp,cop ≤ 20 |
| - 1 ≤ problems의 길이 ≤ 6 |
| -　　0 ≤ alp_req,cop_req ≤ 20 |
| -　　0 ≤ alp_rwd,cop_rwd ≤ 5 |
| -　　1 ≤ cost ≤ 10 |

<br>

---

<br>

### _**나의 풀이**_

1\. 알고력과 코딩력이 problems에서 가장 높은 alp_req, cop_req으로 달성해야 함

2\. [alp,cop]에서 [alp_req,cop_req]로 가는 최단 시간을 구해야 함

3\. dp[i][j] : [목표알고력, 목표코딩력]이 되는 최단 시간


```kt
class Solution {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        val maxAlp = problems.maxOf { it[0] }
        val maxCop = problems.maxOf { it[1] }

        if (alp >= maxAlp && cop >= maxCop) {
            return 0
        }

        // DP 배열의 값은 제일 큰 값으로 초기화하고 초기 알고력/코딩력은 0으로 초기화
        // 4,7,8,10번 런타임 에러 -> 초기값 세팅 에러
        val dp = Array(maxAlp + 1){ Array(maxCop + 1){ Integer.MAX_VALUE } }
        val initA = if (alp > maxAlp) maxAlp else alp
        val initC = if (cop > maxCop) maxCop else cop
        dp[initA][initC] = 0

        for (i in initA .. maxAlp) {
            for (j in initC .. maxCop) {
                if (i+1 <= maxAlp) { // 알고리즘 공부 -> 알고력 +1
                    dp[i+1][j] = if ( dp[i+1][j] > dp[i][j]+1 ) dp[i][j]+1 else dp[i+1][j]
                }
                if (j+1 <= maxCop) { // 코딩 공부 -> 코딩력 +1
                    dp[i][j + 1] = if (dp[i][j + 1] > dp[i][j] + 1) dp[i][j] + 1 else dp[i][j + 1]
                }

                problems.forEach { // 코딩테스트 문제 공부
                    if (i >= it[0] && j >= it[1]) {
                        val alpIndex = if ( i+it[2] > maxAlp ) maxAlp else i+it[2]
                        val copIndex = if ( j+it[3] > maxCop ) maxCop else j+it[3]

                        dp[alpIndex][copIndex] =
                            if ( dp[alpIndex][copIndex] > dp[i][j]+it[4])  dp[i][j]+it[4]
                            else dp[alpIndex][copIndex]
                    }
                }
            }
        }

        return dp[maxAlp][maxCop]
    }
}
```

<center>

| 나의 힘으로 문제를 풀었다고 보기 어렵다. 인터넷에 사람들이 올린 힌트를 많이 참고했고, 카카오톡에서 올려준 해설을 보며 그대로 구현했다. <br> 아무래도 DP에 대한 이해력이 부족해서 그런 듯 싶다. 다음주부터는 다시 Level2로 공부해야겠다. |
| :---: |

</center>