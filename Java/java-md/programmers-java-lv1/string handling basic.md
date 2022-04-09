> 최초작성 : 2020.10.24

## **Level1 - 문자열 다루기 기본 (java)**

 [코딩테스트 연습 - 문자열 다루기 기본](https://programmers.co.kr/learn/courses/30/lessons/12918)

| **문제 설명** |
| --- |
| 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성되어있는지 확인해주는 함수, solution 완성하세요.<br>예를 들어 s가 “a234”이면 False를 리턴하고 “1234”이면 True를 리턴하면 됩니다. |

| **제한 조건** |
| --- |
|   -   s는 길이 1 이상, 길이 8 이하인 문자열입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| s | return |
| "a1234" | false |
| "1234" | true |

### _**나의 풀이**_

try~catch문을 이용하여 숫자로 바꾸다가 오류가 나면 false를 리턴하고 오류가 안나면 true 리턴

```java
class Solution {
	public static boolean solution (String s) {
		boolean answer = true;
		if (s.length()==4 || s.length()==6) {
			try {
				Integer.parseInt(s);
				answer = true;
			} catch(NumberFormatException e) { // 문자 포함됨
				answer = false;
			}
		} else answer = false;
		return answer;
	}
}
```
```java
try {

           에러가 발생할 수 있는 코드

           throw new Exception(); // 강제 에러 출력

} catch (Exception e) {

           e.printStackTrace(); // 오류 출력

           throw.e; // 최상위 클래스가 아니면 무조건 던져주자

} finally {

           무조건 수행

}
```
​

### _**JAVA1 코드 정리**_

숫자임을 확인하는 정규식 이용

```java
class Solution {
	public static boolean solution (String s) {
		if (s.length()==4 || s.length()==6) {
			return s.matches("(^[0-9]*$)");
		}
		return false;
	}
}
```

^ : 문자열의 시작

$ : 문자열의 종료

. : 임의의 한 문자 (\\는 불가)

\* : 앞에 문자가 없거나 무한

\+ : 앞에 문자가 하나이상

? : 앞에 문자가 없거나 하나

\[\] : 문자의 집하이나 범위. 두 문자 사이는 -로 나타냄. \[\]내에 ^가 선행하면 not의 의미

{} : 횟수 또는 범위

() : 소괄호 안에 문자를 하나의 문자로 인식

| : 패턴 안에서 또는 연산자

\\s : 공백문자

\\S : 공백 아닌 나머지 문자

\\w : 알파벳이나 숫자

\\W : 알파벳, 숫자를 제외한 문자

\\d : 숫자 \[0-9\]와 동일

\\D : 숫자 제외 모든 문자

\\ : 확장 문자. 뒤에 일반문자가 오면 특수문자 취급. 뒤에 특수문자가 오면 그 문자 자체 의미

(?!) : 대소문자 구분 X

| try~catch를 처음 사용하여 코드를 짜 보았는데 if를 하는 방법보다 훨씬 효율적인 것 같다.<br>정규식도 생각보다 많이 복잡하지 않아서 조금 더 공부해서 정규식으로도 다시 코드를 짜보고 싶다. |
| --- |