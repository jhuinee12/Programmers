> 최초작성 : 2020.10.19

## **Level1 - 약수의 합 (java)**

 [코딩테스트 연습 - 직사각형 별찍기](https://programmers.co.kr/learn/courses/30/lessons/12969)

| **문제 설명** |
| --- |
| 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   n은 0 이상 3000 이하인 정수   |

| **​입출력 예**    |  |
| --- | --- |
| n | return |
| 12 | 28 |
| 5 | 6 |
|   -   입출력 예#1       12의 약수는 1,2,3,4,6,12입니다. 이를 모두 더하면 28입니다. -   입출력 예#2       5의 약수는 1,5입니다. 이를 모두 더하면 6입니다.   |  |

### _**나의 풀이**_

1\. 1부터 n까지의 숫자 중 n으로 나눴을 때 나누어 떨어지는 수(약수)를 모두 더하는 for문

```java
class Solution {
	public int solution(int n) {
		int answer = 0;

		for (int i=1; i<=n; i++)
			if (n%i == 0)
				answer += i;

		return answer;
	}
}
```

​

### _**JAVA1 코드 정리**_

1\. 1부터 n의 제곱근까지 for문을 돌려 n으로 나눴을 때 나누어 떨어지는 수(약수)를 모두 더함

2\. return할 때 마지막 n을 더해줌 (소수 중 2가 제일 작으므로 남는 건 n 밖에 없음)

```java
class Solution {
	public int solution(int n) {
		int answer = 0;

		for (int i=1; i<=n/2; i++) // 정확히는 ‘제곱근’까지
			if(n%i == 0)
				answer += i;

		return answer+n;
	}
}
```

n/2까지만 돌아도 되는 이유 : 소수 중 2가 제일 작음

if 짝수 : 1 2 … n // for문 돌리면 남는건 n

| 제곱근까지만 돌아도 된다는 사실을 생각하지 못했다.<br>그럼 루프 횟수가 절반으로 줄어 훨씬 효율적인 코드가 나온다.<br>이런 간단한 생각을 하지 못했었다. |
| --- |