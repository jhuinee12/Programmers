> 최초작성 : 2021.09.24

## ******Level1 - 시저 암호**** (kotlin)**

 [코딩테스트 연습 - 시저 암호](https://programmers.co.kr/learn/courses/30/lessons/12926)

| **문제 설명** |
| --- |
| 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요. |

| **제한 조건** |
| --- |
|-   공백은 아무리 밀어도 공백입니다.|
|-   s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.|
|-   s의 길이는 8000이하입니다.|
|-   n은 1 이상, 25이하인 자연수입니다.   |

| **​입출력 예** |  |  |
| --- | --- | --- |
| s | n | result |
| "AB" | 1 | "BC" |
| "z" | 1 | "a" |
| "a B z" | 4 | "e F d" |

---

### _**나의 풀이**_

1\. s를 charArray로 변환하고 그 배열요소만큼 반복문 작성 : 요소 c

2\. c가 공백이면 answer에 공백을 추가하고 continue

3\. c가 소문자이고, c+n이 122보다 크면 c+n-26(a로 돌아감)하고 answer에 char로 바꿔 추가

4\. c가 대문자이고, c+n이 90보다 크면 c+n-26(A로 돌아감)하고 answer에 char로 바꿔 추가

5\. 위 가정에 해당되지 않으면 c+n을 char로 바꿔 answer에 추가

6\. answer 리턴

```kt
class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        for (c in s.toCharArray()) {
            if (c == ' ') {
                answer += " "
                continue
            }
            val changeChar = c.toInt() + n
            // c가 소문자이면
            if (c.isLowerCase()) {
                if (changeChar > 122) {
                    answer += (changeChar-26).toChar()
                    continue
                }
            }
            // c가 대문자이면
            else if (c.isUpperCase()) {
                if (changeChar > 90) {
                    answer += (changeChar-26).toChar()
                    continue
                }
            }
            answer += changeChar.toChar()
        }
        return answer
    }
}
```

### _**Kotlin1 코드 정리**_

1\. it : s의 각 자리 char

2\. it이 대문자이면 (in 'A'..'Z') :: (it-'A'+n)%26으로 'A'로 돌아간 증가값을 구하고 'A'부터 증가 후 toChar()

3\. it이 소문자이면 (in 'a'..'z') :: (it-'a'+n)%26으로 'a'로 돌아간 증가값을 구하고 'a'부터 증가 후 toChar()

4\. 문자열로 합치고 (jointToString("") 리턴

```kt
class Solution {
	fun solution(s: String, n: Int): String =
		s.toList().joinToString(separator = "") {
			when (it) {
				in 'A'..'Z' -> ('A'.toInt() + (it.toInt() - 'A'.toInt() + n) % ('Z' - 'A' + 1)).toChar()
				// in 'A'..'Z' -> ('A' + (it-'A'+n)%26).toChar()
				in 'a'..'z' -> ('a'.toInt() + (it.toInt() - 'a'.toInt() + n) % ('z' - 'a' + 1)).toChar()
				// in 'a'..'z' -> ('a' + (it-'a'+n)%26).toChar()
				else -> it
			}.toString()
	}
}
```