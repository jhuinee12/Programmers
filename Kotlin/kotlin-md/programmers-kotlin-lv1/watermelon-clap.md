> 최초작성 : 2021.05.01

## **Level1 - 수박수박수박수박수박수? (kotlin)**

 [코딩테스트 연습 - 수박수박수박수박수박수?](https://programmers.co.kr/learn/courses/30/lessons/12922)

| **문제 설명** |
| --- |
| 길이가 n이고, “수박수박수박수….”와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution 완성   예를 들어 n=4이면, “수박수박”을 리턴하고 3이면 “수박수”리턴 |

| **제한 조건** |
| --- |
|   -   n은 길이 10,000 이하인 자연수   |

| **​입출력 예**    |  |
| --- | --- |
| x | answer |
| 3 | "수박수" |
| 4 | "수박수박" |

---

### _**나의 풀이**_

1\. 입력받은 매개변수 n을 2로 나눈 수만큼 "수박" 글자를 추가함

2\. 만약 n이 홀수이면 끝에 "수"를 추가하고 리턴, 짝수이면 그냥 리턴

```kt
class Solution {
    fun solution(n: Int): String {
        var answer = ""
        var div = n/2
        while (div!=0) {
            answer += "수박"
            div--
        }
        if (n%2==0) return answer
        else return answer+"수"
    }
}
```

### _**Kotlin1 코드 정리**_

1\. isEven이란 함수 생성 : i를 n만큼 증가, 숫자가 홀수이면 "수", 짝수이면 "박"

2\. isEven에서 나온 값들을 jointToString을 통해 합쳐주는 getStringPattern 함수 생성

3\. getStringPattern 함수를 리턴하며 종료

```kt
class Solution {
	fun solution(n: Int): String = getStringPattern()
	fun isEven(v: Int) = if(v%2==0) "수" else "박"
	fun getStringPattern(n: Int): String {
		return Array(n){ i -> isEven(i) }.joinToString(" ")
	}
}
```

<center>

| 나는 늘 코틀린의 함수를 해석하는게 너무 힘들다..<br>너무 생소한 느낌이라. 함수를 바로 변수처럼 선언하는게 코틀린의 장점이면서도 어려운 부분 ㅠ<br>람다함수 표현도 조금 더 딥하게 공부해야겠다. |
| :---: |

</center>

### _**Kotlin2 코드 정리**_

1\. n만큼 i를 증가시켜 i가 홀수면 "수", 짝수면 "박"을 입력받는 CharArray를 String으로 변환시켜 리턴

```kt
class Solution {
	fun solution(n: Int): String = String(CharArray(n, {i -> if(i%2 == 0) '수' else '박'})
}
```

<center>

| 코틀린의 장점 극대화 ㅁㅊ |
| --- |

</center>

### _**Kotlin3 코드 정리**_

```kt
class Solution {
	fun solution(n: Int): String {
		var answer = ""
		for (i in 0..(n/2+1)) {
			answer += "수박"
		}
		return answer.subString(0..n+1) // n+1까지 자르기
	}
}
```

<center>

| 나의 소스를 조금 더 압축시킨 버전 |
| --- |

</center>