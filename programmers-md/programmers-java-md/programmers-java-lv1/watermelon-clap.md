## **Level1 - 수박수박수박수박수박수? (java)**
> 최초작성 : 2020.10.17

 [코딩테스트 연습 - 수박수박수박수박수박수?](https://programmers.co.kr/learn/courses/30/lessons/12922)

| **문제 설명** |
| --- |
| 길이가 n이고, “수박수박수박수….”와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution 완성<br>예를 들어 n=4이면, “수박수박”을 리턴하고 3이면 “수박수”리턴 |

| **제한 조건** |
| --- |
|   -   n은 길이 10,000 이하인 자연수   |

| **​입출력 예**    |  |
| --- | --- |
| x | answer |
| 3 | "수박수" |
| 4 | "수박수박" |

### _**나의 풀이**_

1\. “수”,”박”을 각각 Pattern이라는 배열에 저장

2\. for문을 돌려 n의 길이만큼 나타내기 : 홀수인 경우 한글자 누락

3\. 홀수인 경우 누락된 한 글자를 나중에 추가 : answer += “수”;

```java
class Solution {
	public String solution(int n) {
		String answer = "";
		String[] Pattern = {"수", "박"};
		
		if (n%2 == 0) {
			for (int i=0; i<n/2; i++)
				for (int j=0; j<2; j++)
					answer += Pattern[j];
		} 
		else {
			for (int i=0; i<n/2; i++)
				for (int j=0; j<2; j++)
					answer += Pattern[j];
					
			answr = answer + "수";
		}
		retrun answer;
	}
}
```

### _**JAVA1 코드 정리**_

1\. “수”,”박”을 각각 Pattern이라는 배열에 저장

2\. for문을 돌려 n의 길이만큼 나타내기 : 홀수인 경우 한글자 누락

3. 홀수인 경우 누락된 한 글자를 나중에 추가 : answer += “수”;

```java
class Solution {
	public String solution(int n) {
		return new String(new char[n/2+1]).replace("\0","수박").subString(0,n);
	}
}
```

_\* **subString(0, n)** : 0부터 n까지 자르는 함수_

1. new String() 생성자 키워드 안에 char 배열을 넣으면 String 객체로 변환

2. 빈 char 배열이 생성되면 그 안에는 \\0으로 생성​

### _**JAVA2 코드 정리**_

삼항연산자를 이용하여 자릿수(for문 중 i)가 홀수면 “수”, 짝수면 “박”

```java
class Solution {
	public String solution(int n) {
		String result = "";
		for (int i=0; i<n; i++)
			result += i%2==0 ? "수" : "박";
		return result;
	}
}
```

### _**JAVA3 코드 정리**_

StringBuffer를 이용하여 Java2의 풀이법을 sf에 넣어 나중에 String으로 바꿔 출력

```java
class Solution {
	public String solution(int n) {
		StringBuffer sf = new StringBuffer();
		for (int i=0; i<n; i++)
			sf.append(i%2==1 ? "수" : "박");
		return sf.toString();
	}
}
```

\* **StringBuffer** : 문자열 추가 or 변경시 사용

\- insert : 특정위치 문자열 삽입

\- append : 문자열 추가

​

| 이번에는 다양한 방법이 존재했다.<br>그 중에서 나의 코드가 제일 비효율적이고 길었다.<br>나의 코드에서도 일단 if문과 else를 합쳐서 좀 더 짧게 쓸 수 있었는데 그 생각을 하지 못했다.<br>다양한 방법 중 가장 좋았던 것은 char 배열을 string으로 고친 후 replace와 subString을 써서 한줄로 표현한 방법이었다.<br>다 아는 문법들이었지만, 이런 방법은 생각하지 못했었다.<br>그리고 StringBuffer도 다른 사람들에 풀이에 비하면 굳이?라는 생각이 들긴 하지만,<br>StringBuffer라는 새로운 것을 사용했다는 점이 좋아 풀이 방법에 추가하였다 |
| --- |