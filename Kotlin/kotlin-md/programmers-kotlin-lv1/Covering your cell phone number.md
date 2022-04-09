> 최초작성 : 2021.09.15

## **Level1 - 핸드폰 번호 가리기 (kotlin)**

 [코딩테스트 연습 - 핸드폰 번호 가리기](https://programmers.co.kr/learn/courses/30/lessons/12948)

| **문제 설명** |
| --- |
| 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호 일부를 가립니다.<br>전화번호가 문자열 phone\_number로 주어졌을 때,<br>전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 \*으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   s는 길이 4 이상, 20 이하인 문자열   |

| **​입출력 예** |  |
| --- | --- |
| phone\_number | return |
| "01033334444" | “\*\*\*\*\*\*\*4444” |
| "01022228888" | “\*\*\*\*\*\*8888” |

---

### _**나의 풀이**_

1\. answer에 phone\_number에서 4자리가 빠진 길이만큼 \*을 추가

2\. phone\_number에서 마지막 4자리를 answer에 더해주고 리턴

```kt
class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        for (i in 0..phone_number.length-5) answer += "*"
        answer += phone_number.substring(phone_number.length-4 until phone_number.length)
        return answer
    }
}
```

<center>

| 좀 더 간결하고 깔끔하게 짜고 싶었으나 이게 최선... |
| --- |

</center>

### _**Kotlin1 코드 정리**_

```kt
class Solution {
	fun solution (phone_number: String): String {
		var answer = ""
		
		for ((i,c) in phone_number.withIndex()) {
			if (phone_number.length-4 <= i) { // i : 배열 자릿수 [0],[1]… 의미
				answer += c // c는 전화번호
			} else {
				answer += "*"
			}
		}
		
		return answer
	}
}
```

<center>

| for문을 사용할 때 인자를 (i,c) 이렇게 두개를 사용해본 적이 없어서 신박 |
| --- |

</center>

  
**Kotlin2 코드 정리**

1\. mapIndexed()를 이용하여 리턴

2\. phone\_number의 index가 phone\_number.length-5보다 작으면 "\*", 크면 phone\_number의 개체 리턴

```kt
class Solution {
	fun solution (phone_number: String): String {
		return phone_number.mapIndexed { // index : 자릿수 [0],[1]…  c : 전화번호
			index, c -> if(phone_number.length-5 < index) c else '*' 
		}.joinToString(separator="")
	}
}
```

* map() : 집합 객체의 데이터 수만큼 반복하여 실행하는 것이 동일하나 forEach()와 유사하나 forEach()와는 다르게 반환값이 있음
* mapIndexed() : map() 함수와 동일하지만 람다 함수에 인덱스까지 전달해주는 함수