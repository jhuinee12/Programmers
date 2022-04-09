> 최초작성 : 2021.08.17

## **Level1 - 약수의 합 (kotlin)**

 [코딩테스트 연습 - 직사각형 별찍기](https://programmers.co.kr/learn/courses/30/lessons/12969)

| **문제 설명** |
| --- |
| 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   n은 0 이상 3000 이하인 정수   |

| **​입출력 예** |  |
| --- | --- |
| n | return |
| 12 | 28 |
| 5 | 6 |

입출력 예#1
- 12의 약수는 1,2,3,4,6,12입니다. 이를 모두 더하면 28입니다.

입출력 예#2
- 5의 약수는 1,5입니다. 이를 모두 더하면 6입니다.

---

### _**나의 풀이**_

1\. 1부터 n까지의 숫자 중 n으로 나눴을 때 나누어 떨어지는 수(약수)를 모두 더하는 for문

```kt
class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        
        for (i in 1..n) {
            if (n%i == 0)
            answer += i
        }
        
        return answer
    }
}
```

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        answer = (1..n).filter { n % it == 0 }.sum()

        return answer
    }
}
```

* filter : Boolean 값에 따라 다음 함수 실행 여부 결정