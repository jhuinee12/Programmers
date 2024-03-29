> 최초작성 : 2023.01.07

## ******Level3 - 합승 택시 요금**** (kotlin)**

 [코딩테스트 연습 - 합승 택시 요금](https://school.programmers.co.kr/learn/courses/30/lessons/72413)

### **문제 설명**
밤늦게 귀가할 때 안전을 위해 항상 택시를 이용하던 무지는 최근 야근이 잦아져 택시를 더 많이 이용하게 되어 택시비를 아낄 수 있는 방법을 고민하고 있습니다.<br>
"무지"는 자신이 택시를 이용할 때 동료인 어피치 역시 자신과 비슷한 방향으로 가는 택시를 종종 이용하는 것을 알게 되었습니다.<br>
"무지"는 "어피치"와 귀가 방향이 비슷하여 택시 합승을 적절히 이용하면 택시요금을 얼마나 아낄 수 있을 지 계산해 보고 "어피치"에게 합승을 제안해 보려고 합니다.

<br>

![](../image/lv3_kotlin_ASharedTaxiFare_img1.png)

<br>

위 예시 그림은 택시가 이동 가능한 반경에 있는 6개 지점 사이의 이동 가능한 택시노선과 예상요금을 보여주고 있습니다.<br>
그림에서 A와 B 두 사람은 출발지점인 4번 지점에서 출발해서 택시를 타고 귀가하려고 합니다.<br>
A의 집은 6번 지점에 있으며 B의 집은 2번 지점에 있고 두 사람이 모두 귀가하는 데 소요되는 예상 최저 택시요금이 얼마인 지 계산하려고 합니다.

<br>

- 그림의 원은 지점을 나타내며 원 안의 숫자는 지점 번호를 나타냅니다.
    - 지점이 n개일 때, 지점 번호는 1부터 n까지 사용됩니다.
- 지점 간에 택시가 이동할 수 있는 경로를 간선이라 하며, 간선에 표시된 숫자는 두 지점 사이의 예상 택시요금을 나타냅니다.
    - 간선은 편의 상 직선으로 표시되어 있습니다.
    - 위 그림 예시에서, 4번 지점에서 1번 지점으로(4→1) 가거나, 1번 지점에서 4번 지점으로(1→4) 갈 때 예상 택시요금은 10원으로 동일하며 이동 방향에 따라 달라지지 않습니다.
- 예상되는 최저 택시요금은 다음과 같이 계산됩니다.
    - 4→1→5 : A, B가 합승하여 택시를 이용합니다. 예상 택시요금은 10 + 24 = 34원 입니다.
    - 5→6 : A가 혼자 택시를 이용합니다. 예상 택시요금은 2원 입니다.
    - 5→3→2 : B가 혼자 택시를 이용합니다. 예상 택시요금은 24 + 22 = 46원 입니다.
    - A, B 모두 귀가 완료까지 예상되는 최저 택시요금은 34 + 2 + 46 = 82원 입니다.

### **문제**
지점의 개수 n, 출발지점을 나타내는 s, A의 도착지점을 나타내는 a, B의 도착지점을 나타내는 b, 지점 사이의 예상 택시요금을 나타내는 fares가 매개변수로 주어집니다.<br>
이때, A, B 두 사람이 s에서 출발해서 각각의 도착 지점까지 택시를 타고 간다고 가정할 때, 최저 예상 택시요금을 계산해서 return 하도록 solution 함수를 완성해 주세요.<br>
만약, 아예 합승을 하지 않고 각자 이동하는 경우의 예상 택시요금이 더 낮다면, 합승을 하지 않아도 됩니다.

### **제한사항**
- 지점갯수 n은 3 이상 200 이하인 자연수입니다.
- 지점 s, a, b는 1 이상 n 이하인 자연수이며, 각기 서로 다른 값입니다.
    - 즉, 출발지점, A의 도착지점, B의 도착지점은 서로 겹치지 않습니다.
- fares는 2차원 정수 배열입니다.
- fares 배열의 크기는 2 이상 n x (n-1) / 2 이하입니다.
    - 예를들어, n = 6이라면 fares 배열의 크기는 2 이상 15 이하입니다. (6 x 5 / 2 = 15)
    - fares 배열의 각 행은 [c, d, f] 형태입니다.
    - c지점과 d지점 사이의 예상 택시요금이 f원이라는 뜻입니다.
    - 지점 c, d는 1 이상 n 이하인 자연수이며, 각기 서로 다른 값입니다.
    - 요금 f는 1 이상 100,000 이하인 자연수입니다.
    - fares 배열에 두 지점 간 예상 택시요금은 1개만 주어집니다. 즉, [c, d, f]가 있다면 [d, c, f]는 주어지지 않습니다.
- 출발지점 s에서 도착지점 a와 b로 가는 경로가 존재하는 경우만 입력으로 주어집니다.


### **입출력 예**
|n	|s	|a	|b	|fares	|result|
|--|--|--|--|--|--|
|6	|4	|6	|2	|[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]	|82|
|7	|3	|4	|1	|[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]	|14|
|6	|4	|5	|6	|[[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]	|18|


### **입출력 예 설명**
#### 입출력 예 #1
문제 예시와 같습니다.


#### 입출력 예 #2
![](../image/lv3_kotlin_ASharedTaxiFare_img2.png)
합승을 하지 않고, B는 3→2→1, A는 3→6→4 경로로 각자 택시를 타고 가는 것이 최저 예상 택시요금입니다.<br>
따라서 최저 예상 택시요금은 (3 + 6) + (1 + 4) = 14원 입니다.

#### 입출력 예 #3
![](../image/lv3_kotlin_ASharedTaxiFare_img3.png)
A와 B가 4→6 구간을 합승하고 B가 6번 지점에서 내린 후, A가6→5` 구간을 혼자 타고 가는 것이 최저 예상 택시요금입니다.<br>
따라서 최저 예상 택시요금은 7 + 11 = 18원 입니다.

<br>

---

<br>

### _**나의 풀이**_

1\. a와 b가 s에 도달하기 위에 거치는 지점 x를 구하기 위한 다익스트라 알고리즘

2\. s,a,b 지점을 각각 시작점으로 하여 그 외 모든 지점의 최단 거리를 구한다.

3\. a-x, b-x, s-x 거리의 합이 최소인 지점 x를 비교하여 리턴

```kt
import java.util.*

class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE

        val distance = Array(n+1) { IntArray(n+1) { Int.MAX_VALUE } }
        val graph = Array(n+1) { ArrayList<Pair<Int,Int>>() }

        fares.forEach {
            graph[it[0]].add(Pair(it[1], it[2]))
            graph[it[1]].add(Pair(it[0], it[2]))
        }

        fun dijkstraSearch(start: Int) {
            val q = PriorityQueue<Node>()

            q.add(Node(start, 0))
            distance[start][start] = 0

            while (q.isNotEmpty()) {
                val (now, dist) = q.poll()
                if (distance[start][now] < dist) continue

                for (i in graph[now]) {
                    val cost = dist + i.second
                    
                    if (cost < distance[start][i.first]) {
                        distance[start][i.first] = cost
                        q.add(Node(i.first, cost))
                    }
                }
            }
        }

        // s,a,b를 시작으로 모든 거리의 최단경로를 구함
        dijkstraSearch(s)
        dijkstraSearch(a)
        dijkstraSearch(b)

        // s->x, a->x, b->x 거리의 합이 최소인 경우를 찾음
        for (i in 0 .. n) {
            val sum = distance[s][i] + distance[a][i] + distance[b][i]
            if (sum < answer) answer = sum
        }

        return answer
    }

    // 거리 순으로 정렬
    data class Node(val index : Int, val value : Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = value - other.value
    }
}
```
#### 스터디 풀이
- 플로이드-와샬 기법 사용
- 3중 for문을 통해 최단 거리를 계산하는 방법임
    - 중간 지점을 for문의 가장 첫번째로 사용해야함.
    - 시작점을 중간 for문으로 사용.
    - 종료지점을 마지막 for문으로 사용
- 모든 거리의 최단거리를 구하는 방법임

##### 스터디를 진행해보니 나 외의 대부분의 사람들은 플로이드-와샬 기법을 사용하였다.
##### 그래도 s-a-b를 시작지점으로 하여 최단 거리를 구한다는 나의 접근법도 괜찮은 것 같다.
##### 시간적 효율성을 따져보면 위 기법과 크게 차이나지 않는다.