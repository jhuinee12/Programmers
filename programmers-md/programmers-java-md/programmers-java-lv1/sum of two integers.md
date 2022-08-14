> 최초작성 : 2020.10.19

## **Level1 - 두 정수 사이의 합 (java)**

 [코딩테스트 연습 - 두 정수 사이의 합](https://programmers.co.kr/learn/courses/30/lessons/12912)

| **문제 설명** |
| --- |
| 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수,   solution을 완성하세요.<br>예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다. |

| **제한 조건** |
| --- |
|   -   a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요. -   a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다. -   a와 b의 대소관계는 정해져있지 않습니다.​   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| a | b | return |
| 3 | 5 | 12 |
| 3 | 3 | 3 |
| 5 | 3 | 12 |

​

### _**나의 풀이**_

1\. a와 b의 대소관계 구분

2\. 작은 수부터 큰 수까지 for문을 이용하여 모든 숫자 합하기

```java
class Solution {
	public long solution(int a, int b) {
		long answer = 0;
		
		if (a < b) {
			for (int i=a; i<=b; i++)
				answer = answer+i;
		} else if (a > b) {
			for (int i=b; i<=a; i++)
				answer = answer+i;
		} else answer = a;
		
		return answer;
	}
}
```

​

### _**JAVA1 코드 정리**_

1\. 새로운 함수 sumAtoB 생성

2\. Math.min(), Math.max()를 이용하여 대소관계 구분

3\. 등차수열의 합 공식을 이용하여 모든 숫자의 합 구함

(등차수열의 합 공식 : (2a+(n-1)d)/2

```java
class Solution {
	public long solution(int a, int b) {
		return sumAtoB(Math.min(a,b), Math.max(b,a)); // 대소관계 구분 내장함수
	}
	
	private long sumAtoB(long a, long b) {
		return (b - a +1) * (a + b) / 2; // 등차수열의 합 공식
	}
}
```

### _**JAVA2 코드 정리**_

1\. 삼항연산자를 이용하여 for문 안에 대소관계 구분

2\. 작은 수부터 큰 수까지 for문을 이용하여 숫자 합하기

```java
class Solution {
	public long solution(int a, int b) {
		long answer = 0;
		for (int i=((a<b)?a:b); i<=((a<b)?a:b); i++)
			answer += i; // 나의 식 한줄요약
			
		return answer;
	}
}
```

| 좀 창피한 코딩이었다.<br>훨씬 압축해서 줄일 수 있는 것을 미련하게 줄줄줄줄 쓴 느낌이다.<br>문제 자체가 쉬워서 코딩이 길지는 않았지만, 그래도 좀 아쉬움이 많이 남는 코딩이다.<br>새롭게 배운 점은 ‘등차수열’이다. 그동안 배운 수학을 알고리즘에서도 사용할 수 있으니 참 새로웠다.<br>저런 아이디어를 바로 적용할 수 있는 사람들이 놀랍다. |
| --- |