> 최초작성 : 2022.10.02

## ******Level2 - 피로도****(kotlin)**

 [코딩테스트 연습 - 피로도](https://school.programmers.co.kr/learn/courses/30/lessons/87946)

### 문제 설명
 XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
 "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며,
 "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다.
 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며,
 던전을 탐험한 후에는 피로도 20이 소모됩니다.
 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요. 

### 제한 조건
-    k는 1 이상 5,000 이하인 자연수입니다.
-    dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
-    dungeons의 가로(열) 길이는 2 입니다.
-    dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
-    "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
-    "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
-    서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.

### **​입출력 예** 
| k          | dungeons                          | return |
|------------|-----------------------------------|--------|
| 80         | \[\[80,20\],\[50,40\],\[30,10\]\] | 3      |

입출력 예
- 현재 피로도는 80입니다.
- 만약, 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험한다면
    - 현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다.
    - 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
    - 남은 피로도는 60이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다.
    - 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 20입니다.
    - 남은 피로도는 20이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30입니다. 따라서 세 번째 던전은 탐험할 수 없습니다.
- 만약, 첫 번째 → 세 번째 → 두 번째 던전 순서로 탐험한다면
    - 현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다.
    - 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
    - 남은 피로도는 60이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30이므로, 세 번째 던전을 탐험할 수 있습니다.
    - 세 번째 던전의 "소모 피로도"는 10이므로, 던전을 탐험한 후 남은 피로도는 50입니다.
    - 남은 피로도는 50이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다.
    - 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 10입니다.
- 따라서 이 경우 세 던전을 모두 탐험할 수 있으며, 유저가 탐험할 수 있는 최대 던전 수는 3입니다.
---

### _**나의 풀이**_

1\. DFS 알고리즘을 구하기 위하여 방문 여부를 판단할 visited 배열을 생성한다.

2\. 방문한 자료를 저장할 스택 picked를 생성한다.

3\. 자료는 0부터 던전의 길이만큼 배열을 돌린다. (던전의 개수만큼 순열을 구하기 위하여)

4\. 방문한 자료는 visited를 true로 변경하고 stack에 쌓는다.

5\. 스택에 쌓인 개수가 던전의 개수와 같으면 모든 자료를 방문하였다 가정하고 탐험 개수를 구한다.

6\. 탐험 개수를 구하면 차례로 스택의 자료를 제거한다.

7\. 스택의 자료가 제거되었지만, for문이 남아있는 경우 다시 방문하지 않은 노드를 방문한다.

8\. DFS 백트랙킹을 이용한 순열 알고리즘이 완성된다.

```kt
import java.util.*

class Solution {
    lateinit var visited: BooleanArray
    
    val picked = Stack<IntArray>()
    
    var answer: Int = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = BooleanArray(dungeons.size) { false }

        quest(k, dungeons)

        return answer
    }

    fun quest(k: Int, dungeons: Array<IntArray>) {
        for (i in 0 until dungeons.size) {
            if (!visited[i]) {
                picked.push(dungeons[i])
                visited[i] = true

                if (picked.size == dungeons.size) {
                    var minusFatigue = k
                    var score = 0
                    picked.forEach {
                        if (minusFatigue >= it[0]) {
                            minusFatigue -= it[1]
                            ++score
                        }
                    }

                    if (score > answer) answer = score
                } else {
                    quest(k, dungeons)
                }
                
                picked.pop()
                visited[i] = false
            }
        }
    }
}
```

<center>

###### 순열을 구하면 된다고 생각했다.<br>그 순열을 dfs로 구하기 위해서 살짝 네이버를 참고하기는 했다...ㅎㅎ<br>얼른 DFS/BFS가 익숙해져서 직접 다 구현할 수 있었으면!!

</center>

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var maxN = 0
        for (i in 0 until dungeons.count()) {
            var d = dungeons[i]
            if (k >= d[0]) {
                var subN = solution(
                    k - d[1], 
                    dungeons.sliceArray(0 .. i - 1) + 
                        dungeons.sliceArray(i + 1 .. dungeons.count() - 1))
                if (subN + 1 > maxN) maxN = subN + 1
                if (maxN == dungeons.count()) return maxN
            }
        }
        return maxN
    }
}
```