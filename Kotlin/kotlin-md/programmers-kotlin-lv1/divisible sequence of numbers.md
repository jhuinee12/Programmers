> 최초작성 : 2021.09.23

## ******Level1 - 나누어 떨어지는 숫자 배열**** (kotlin)**

 [코딩테스트 연습 - 나누어 떨어지는 숫자 배열](https://programmers.co.kr/learn/courses/30/lessons/12910)

| **문제 설명** |
| --- |
| array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수,   solution을 작성해주세요.   divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요. |

| **제한 조건** |
| --- |
|   -   arr은 자연수를 담은 배열입니다. -   정수 i, j에 대해 i ≠ j 이면 arr\[i\] ≠ arr\[j\] 입니다. -   divisor는 자연수입니다. -   array는 길이 1 이상인 배열입니다.   |

| **​입출력 예** |  |  |
| --- | --- | --- |
| arr | divisor | return |
| \[5,9,7,10\] | 5 | \[5,10\] |
| \[2,36,1,3\] | 1 | \[1,2,3,36\] |
| \[3,2,6\] | 10 | \[-1\] |

입출력 예#1
- arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 \[5, 10\]을 리턴합니다.

입출력 예#2
- arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 \[1, 2, 3, 36\]을 리턴합니다.

입출력 예#3
- 3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 \[-1\]을 리턴합니다.

---

### _**나의 풀이**_

1\. filter를 이용하여 arr의 요소 중 divisor에 나누어떨어지는 값들의 배열을 answer에 넣기

2\. answer를 오름차순으로 정렬

3\. answer가 비어있으면 {-1} 리턴, 비어있지 않으면 answer 리턴

```kt
class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer: IntArray = arr.filter { it % divisor == 0 }.toIntArray()
        answer.sort()
        return if (answer.isEmpty()) intArrayOf(-1)
            else answer
    }
}
```

### _**Kotlin 코드 정리**_

1\. forEach를 이용하여 arr의 요소 중 divisor로 나누어떨어지는 값을 answer에 저장

2\. answer 오름차순 정렬

3\. answer가 비어있으면 {-1} 리턴하고, 비어있지 않으면 answer 리턴

```kt
class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()

        arr.forEach { if (it % divisor == 0) answer += it }
        answer.sort()

        if (answer.size == 0) answer += -1

        return answer
    }
}
```

* it은 배열의 요소