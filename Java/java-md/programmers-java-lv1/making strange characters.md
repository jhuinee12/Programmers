> 최초작성 : 2021.01.21

## ******Level1 - 이상한 문자 만들기**** (java)**

 [코딩테스트 연습 - 이상한 문자 만들기](https://programmers.co.kr/learn/courses/30/lessons/12930)

| **문제 설명** |
| --- |
| 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.<br>각 단어는 하나 이상의 공백문자로 구분되어 있습니다.<br>각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요. |

| **제한 조건** |
| --- |
|-   문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.|
|-   첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.|

| **​입출력 예**    |  |
| --- | --- |
| s | return |
| "try hello world" | "TrY HeLlO WoRlD" |

-   입출력 예#1
    - "try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다.
    - 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다.
    - 따라서 "TrY HeLlO WoRlD" 를 리턴합니다.

​

### _**JAVA1 코드 정리**_

1\. array에 문자열 s를 문자 단위로 쪼개 넣는다.

2\. array.length까지 돌리는 반복문에서 array\[i\]가 공백문자(" ")이면, cnt는 0이고(cnt리셋), 아니면 1을 더한다.

3\. cnt가 짝수면 array\[i\]는 소문자로 변경하고 홀수면 대문자로 변경한 값을 answer에 차례로 넣고 리턴한다.

```java
class Solution {
	public String solution(String s) {
		
		String answer = "";
		int cnt = 0;
		String[] array = s.split("");
 
		for(int i=0; i<array.length; i++) {
			cnt = array[i].contains(" ") ? 0 : cnt + 1;
			answer += cnt%2 == 0 ? array[i].toLowerCase() : array[i].toUpperCase(); 
		}
		return answer;
	}
}
```

| 삼항연산자가 많이 나오는 소스이다.<br>그래서 보다 소스가 간결하고 보기 쉬운 것 같다. |
| --- |