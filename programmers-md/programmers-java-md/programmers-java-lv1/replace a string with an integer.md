> 최초작성 : 2020.10.26

## **Level1 - 문자열을 정수로 바꾸기 (java)**

 [코딩테스트 연습 - 문자열을 정수로 바꾸기](https://programmers.co.kr/learn/courses/30/lessons/12925)

| **문제 설명** |
| --- |
| 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요. |

| **제한 조건** |
| --- |
|   -   S의 길이는 1 이상 5 이하입니다. -   S의 맨 앞에는 부호(+,-)가 올 수 있습니다. -   S는 부호와 숫자로만 이루어져 있습니다. -   S는 “0”으로 시작하지 않습니다.   |

| **​입출력 예**    |  |
| --- | --- |
| 예를 들어 str이 “1234”이면 1234를 반환하고, “-1234”이면 -1234를 반환   Str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없음     |  |

​

### _**나의 풀이**_

String을 바로 Int로 바꿔주는 내장 함수 사용

```java
class Solution {
    fun solution(s: String): Int {
        return s.toInt()
    }
}
```

### _**JAVA1 코드 정리**_

1\. 내가 사용한 Integer.parseInt(s)를 풀어서 코딩

2\. result\*10을 이용하여 자릿수를 하나씩 위로 올림

```java
public class StrToInt {
	public int getStrToInt(String str) { // Integer.parseInt(s)를 분해한 것
		Boolean Sign = true;
		Int result = 0;
		
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '-')
				Sign = false;
			else if (ch != '+')
				result = result*10 + (ch-'0'); // 자릿수를 하나씩 위로
		}
		return Sign ? 1: -1*result;
	}
}
```