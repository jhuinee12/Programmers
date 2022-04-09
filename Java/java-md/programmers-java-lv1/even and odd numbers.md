> 최초작성 : 2020.10.28

## **Level1 - 짝수와 홀수 (java)**

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

​

### _**나의 풀이**_

삼항연산자를 이용하여 num을 2로 나눴을 때 나머지가 0이면 (짝수) Even을 리턴하고 0이 아니면 (홀수) Odd를 리턴한다.

```java
class Solution {
	public String solution (int num) {
		return (num%2 == 0) ? "Even" : "Odd"
	}
}
```

| 프로그래머스 중 가장 쉬운 난이도인 것 같다.<br>다른 사람들의 코드를 비교해봤을 때도 다 비슷비슷하다고 느껴졌다. |
| --- |