> 최초작성 : 2021.03.16

## **Level1 - 짝수와 홀수 (kotlin)**

 [코딩테스트 연습 - 짝수와 홀수](https://programmers.co.kr/learn/courses/30/lessons/12937)

| **문제 설명** |
| --- |
| 정수 num이 짝수일 경우 “Even”을 반환하고 홀수인 경우 “Odd”를 반환하는 함수 |

| **제한 조건** |
| --- |
|   -   num은 int 범위의 정수입니다. -   0은 짝수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| n | return |
| 3 | "Odd" |
| 4 | "Even" |

---

### _**나의 풀이**_

삼항연산자를 이용하여 num을 2로 나눴을 때 나머지가 0이면 (짝수) Even을 리턴하고 0이 아니면 (홀수) Odd를 리턴한다.

```kt
class Solution {
    fun solution(num: Int): String {
        return if(num % 2 == 0) "Even" else "Odd"
    }
}
```

### _**Kotlin1 코드 정리**_

```kt
class Solution {
	fun solution(num: Int): String {
		return if(num.and(1)==0) "Even" else "Odd"
	}
}
```

<center>

| .and(1)이 뭔지 검색을 해봐도 안나옴...ㅠㅠ |
| --- |

</center>

### _**Kotlin2 코드 정리**_

```kt
class Solution {
	fun solution(num: Int): String {
		return when(num%2) {
			0 -> "Even"
			else -> "Odd"
		}
	}
}
```

<center>

| java에서 switch ~ case 문과 흡사      num%2 == 0 -> "Even"   num%2 != 0 -> "Odd" |
| --- |

</center>