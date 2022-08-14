> 최초작성 : 2020.12.17

## **Level1 - 핸드폰 번호 가리기 (java)**

 [코딩테스트 연습 - 핸드폰 번호 가리기](https://programmers.co.kr/learn/courses/30/lessons/12948)

| **문제 설명** |
| --- |
| 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호 일부를 가립니다.<br>전화번호가 문자열 phone\_number로 주어졌을 때,<br>전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 \*으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   s는 길이 4 이상, 20 이하인 문자열   |

| **​입출력 예**    |  |
| --- | --- |
| phone\_number | return |
| "01033334444" | “\*\*\*\*\*\*\*4444” |
| "01022228888" | “\*\*\*\*\*\*8888” |

### _**나의 풀이**_

1, phone\_number의 각 글자를 split을 이용하여 number 배열에 넣는다

2\. number 배열의 0번부터 length-5번까지를 \*로 바꿔준다.

3\. 바뀐 number 배열을 answer에 추가한다.

```java
class Solution {
	public String solution(String phone_number) {
		String answer = "";
		String[] number;
		
		number = phone_number.split("");
		
		for (int i=number.length-5; i>=0; i--)
			number[i] = "*";
		for (int i=0; i<number.length; i++)
			answer += number[i];
		
		return answer;
	}
}
```

### _**JAVA1 코드 정리**_

1\. phone\_number을 char 배열로 넣는다. (toCharArray 이용)

2\. 배열의 0번부터 length-5번까지를 \*로 바꿔준다.

3\. Char 배열을 String 형으로 바꿔준다. (String.ValueOf 이용)

```java
class Solution {
	public String solution(String phone_number) {
		char[] ch = phone_number.toCharArray(); // phone_number을 char 배열로
		for (int i=0; i<ch.length-4; i++)
			ch[i] = "*";
		return String.ValueOf(ch); // char 배열을 string형으로 변경
	}
}
```

| 예전에 풀어본 문제를 이제 확인해보니 참 무식한 방법으로 풀었구나 싶다.<br>더 간단한 방법이 존재하는데 그 때의 내 머릿속 알고리즘은 저게 최선이었을 것이다.<br>두 달 뒤 나의 코딩을 분석하니 확실히 내 스스로가 달라짐이 느껴지고 신기하다.<br>더 의욕이 샘솟는다. |
| --- |