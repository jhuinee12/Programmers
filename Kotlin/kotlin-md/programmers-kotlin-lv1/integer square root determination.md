> 최초작성 : 2021.09.22

## **Level1 - 정수 제곱근  판별 (kotlin)**

 [코딩테스트 연습 - 정수 제곱근 판별](https://programmers.co.kr/learn/courses/30/lessons/12934)

| **문제 설명** |
| --- |
| 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.   n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요. |

| **제한 조건** |
| --- |
|   -   n은 1이상, 50000000000000 이하인 양의 정수입니다.   |

| **​입출력 예** |  |
| --- | --- |
| n | return |
| 121 | 144 |
| 3 | \-1 |
|   -   입출력 예#1       121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다. -   입출력 예#2       3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.   |  |

---

### _**나의 풀이**_

1\. n의 제곱근을 변수 sqrt에 대입

2\. sqrt의 제곱이 n과 같으면 sqrt+1의 제곱을 리턴

3\. sqrt의 제곱이 n과 다르면 -1 리턴

```kt
class Solution {
    fun solution(n: Long): Long {
        val sqrt = kotlin.math.sqrt(n.toDouble()).toLong()
        return if (sqrt*sqrt == n) (sqrt+1)*(sqrt+1)
            else -1
    }
}
```

<center>

| 처음엔 sqrt\*sqrt 가 아니라 pow를 써서 제곱을 구했는데, 그때는 3번과 6번에서 실패가 떴다.<br>아마 double과 long을 왔다갔다하면서 발생된 문제가 아닐까 싶다. |
| --- |

</center>

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(n: Long): Long {
        val sqrt = Math.sqrt(n.toDouble())
        return if(sqrt % 1.0 == 0.0) { // sqrt를 1로 나눈 나머지가 0이면 (sqrt가 정수이면)
            Math.pow(sqrt + 1, 2.0).toLong()
        } else {
            -1L
        }
    }
}
```