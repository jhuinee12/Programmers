> 최초작성 : 2021.08.25

## ******Level1 - 가운데 글자 가져오기**** (kotlin)**

 [코딩테스트 연습 - 가운데 글자 가져오기](https://programmers.co.kr/learn/courses/30/lessons/12903)

| **문제 설명** |
| --- |
| 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다. |

| **제한 조건** |
| --- |
|   -   s는 길이가 1 이상, 100이하인 스트링입니다.   |

| **​입출력 예** |  |
| --- | --- |
| s | return |
| "abcde" | "c" |
| "qwer" | "we" |

---

### _**나의 풀이**_

1. 문자열의 길이가 짝수이면 가운데 두개의 문자 출력

2. 문자열의 길이가 홀수이면 가운데 하나의 문자 출력

```kt
class Solution {
    fun solution(s: String): String {
        var len = s.length / 2

        return if (s.length % 2 == 0)
            s.substring(len-1, len+1)
        else
            s.substring(len, len+1)
    }
}
```

### _**Kotlin1 코드 정리**_

```kt
class Solution {
  fun solution(s: String) =
    with(s) { substring(length / 2 - 1 + (length % 2) .. length / 2) }
}
```

* length%2 를 더해주면서 짝수/홀수 가 나눠짐 :: 짝수의 경우 length/2-1, 홀수의 경우 length/2
* .. 을 사용하면 마지막 숫자 **포함**