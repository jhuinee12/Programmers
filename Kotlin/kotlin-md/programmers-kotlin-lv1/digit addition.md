> 최초작성 : 2021.08.17

## ******Level1 - 자릿수 더하기**** (kotlin)**

 [코딩테스트 연습 - 자릿수 더하기](https://programmers.co.kr/learn/courses/30/lessons/12931)

| **문제 설명** |
| --- |
| 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.   예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다. |

| **제한 조건** |
| --- |
|   -   N의 범위 : 100,000,000 이하의 자연수   |

| **​입출력 예** |  |
| --- | --- |
| n | answer |
| 123 | 6 |
| 987 | 24 |

입출력 예#1
- 문제의 예시와 같습니다.

입출력 예#2
- 9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.

---

### _**나의 풀이**_

1\. 0부터 n의 자릿수까지 반복문 생성

2\. 가장 끝자리를 리턴변수 answer에 더하기

3\. 가장 끝 숫자를 제외하고 다시 반복

```kt
class Solution {
    fun solution(n: Int): Int {
        var answer = 0	// 리턴값
        var num = n	// n을 저장할 변수
        
        // 반복문 : 0부터 n을 string으로 변경했을 때 길이까지
        for (i in 0..n.toString().length) {
            answer += num%10	// 가장 끝자리를 answer에 더하기
            num = (num-num%10)/10	// 끝자리를 뺀 수를 num에 저장
        }
        return answer
    }
}
```

* 조금 더 이상적인 소스 : num = (num-num%10)/10 → num /= 10

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(n: Int): Int {
        var input = n
        var answer = 0

        while (input != 0) {
            answer += input % 10
            input /= 10	// 어차피 int만 남기 때문에 그냥 10을 나눠버려도 상관 없다
        }

        return answer
    }
}
```

### _**Kotlin2 코드 정리**_

```kt
class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        for (nn in n.toString()) {
            answer += (nn.toString()).toInt()
        }

        return answer
    }
}
```

<center>

| Kotlin의 for문 in을 이용하여 사용한 방법<br>String으로 바꿔서 그 안에 글자를 추출하고 다시 int로 바꿔서 계산하는 방법!<br>이게 가장 코틀린의 강점을 잘 살린 방법인 것 같다. |
| --- |

</center>