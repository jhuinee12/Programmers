> 최초작성 : 2021.03.17

## **Level1 - 문자열을 정수로 바꾸기 (kotlin)**

 [코딩테스트 연습 - 문자열을 정수로 바꾸기](https://programmers.co.kr/learn/courses/30/lessons/12925)

| **문제 설명** |
| --- |
| 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요. |

| **제한 조건** |
| --- |
|   -   S의 길이는 1 이상 5 이하입니다. -   S의 맨 앞에는 부호(+,-)가 올 수 있습니다. -   S는 부호와 숫자로만 이루어져 있습니다. -   S는 “0”으로 시작하지 않습니다.   |

| **​입출력 예**    |  |
| --- | --- |
| 예를 들어 str이 “1234”이면 1234를 반환하고, “-1234”이면 -1234를 반환   Str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없음 |  |

---

### _**나의 풀이**_

String을 바로 Int로 바꿔주는 내장 함수 사용

```kt
Class Solution {
	public int solution(String s) {
		return Integer.parseInt(s);
	}
}
```

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(s: String) = s.toInt()
}
```

내 풀이법과 방법은 같지만, 나는 바로 return을 한 반면 이 소스는 함수를 만들어 리턴함.

### _**Kotlin2 코드 정리**_

1\. 입력받은 문자열 s의 첫 글자가 -면 -1을 대입하고, 아니면 1을 대입함.

2\. 문자열 s가 숫자이면 int()로 변경 후 sign에 곱함

```kt
class Solution {
	fun solution(s: String) : Int { // -면 *(-1) : 음수, 아니면 *1 : 양수
		val sign:Int = if(s.first() == '-') -1 else 1
		return (s.filter { it. isDigit() }.toInt())*sign
	}
}
```

* isDigit() : 숫자 판단

* filter : 리스트 중에서 조건에 맞는 값만 리턴

<center>

| 어차피 .toInt()를 쓸거면 왜 저렇게 복잡하게 돌아갔을까?<br>\-1과 1 여부는 toInt()가 알아서 해줄텐데...<br>s.filter { it. isDigit() } 이 부분은 숫자가 아닌 문자가 들어올 경우 걸러내기 좋아 괜찮은 것 같다.<br>근데 이 줄만 있어도 괜찮을 것 같다. |
| :---: |

</center>