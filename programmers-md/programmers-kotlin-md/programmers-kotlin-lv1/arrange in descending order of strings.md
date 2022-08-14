> 최초작성 : 2021.09.24

## ******Level1 - 문자열 내림차순으로 배치하기**** (kotlin)**

 [코딩테스트 연습 - 문자열 내림차순으로 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12917)

| **문제 설명** |
| --- |
| 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.<br>s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다. |

| **제한 조건** |
| --- |
|   -   str은 길이 1 이상인 문자열입니다.   |

| **​입출력 예** |  |
| --- | --- |
| s | return |
| "Zbcdefg" | "gfedcbZ" |

---

### _**나의 풀이**_

1\. s를 char로 쪼개 배열로 생성 (toCharArray())

2\. 1에서 만든 배열을 내림차순으로 정렬 **(sortedDescending())**

3\. 2의 배열을 string으로 결합 (joinToString(""))

```kt
class Solution {
    fun solution(s: String): String = s.toCharArray().sortedDescending().joinToString("")
}
```

### _**Kotlin1 코드 정리**_

1\. s를 char로 쪼개 배열로 생성 (toCharArray())

2\. 1에서 만든 배열을 내림차순으로 정렬 **(sortedWith(Comparator {a,b -> b,a}))**

3\. 2의 배열을 string으로 결합 (joinToString(""))

```kt
class Solution {
    fun solution(s: String): String {
        return s.toCharArray()
            .sortedWith(Comparator { a, b -> b - a })
            .joinToString("")
    }
}
```