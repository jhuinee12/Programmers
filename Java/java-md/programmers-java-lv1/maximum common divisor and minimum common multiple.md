> 최초작성 : 2020.11.10

## **Level1 - 최대공약수와  최소공배수 (java)**

 [코딩테스트 연습 - 최대공약수와 최소공배수](https://programmers.co.kr/learn/courses/30/lessons/12940)

| **문제 설명** |
| --- |
| 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해보세요.   <br> 맨 앞에 최대공약수, 그 다음 최소공배수를 넣어 반환하면 됩니다.<br>예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 \[3, 12\]를 반환해야 합니다. |

| **제한 조건** |
| --- |
|   -   두 수는 1 이상 1000000 이하의 자연수입니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| n | m | return |
| 3 | 12 | \[3,12\] |
| 2 | 5 | \[1,10\] |

### _**나의 풀이**_

1\. 삼항연산자를 이용하여 실행

2\. 최대공약수 : 나누어 떨어지는 수 중 가장 큰 수 // 최소공배수 : 최대공약수\*몫\*몫

3\. for문을 이용하여 나누어 떨어지는 수 중 가장 큰 수 n을 구해 최대공약수로 입력

4\. 구한 n을 이용하여 최소공약수 도출

```java
class Solution {
	public int[] solution(int n, int m) {
		int[] answer = {1,1}; // int[] answer = new int[2];
		
		for (int i=1; i<=n; i++) {
			answer[0] = n%i == 0 && m%i == 0 ? i : answer[0];
			answer[1] = n%i == 0 && m%i == 0 ? i * n/i * m/i : answer[1];
			// = n*m/i
		}
		
		return answer;
	}
}
```

“삼항연산자”로 실행

최대공약수 : 나누어 떨어지는 수 중 가장 큰 수

최소공배수 : 최대공약수 \* 몫 \* 몫

### _**JAVA1 코드 정리**_

1\. 재귀함수 이용 : 본인을 무한대로 호출하여 q가 0이 될 때까지!

\=> 예시 (p=3, q=12)

gcd(3,12) : 12 != 0 → gcd(12,3%12=3) → 3 != 0 → gcd(3,0) → 0 == 0 → return 12

☞ 최대공약수 도출

2\. gcd 함수에서 구해진 최대공약수를 이용해 최소공배수 도출 : 최소공배수 = n\*m/최대공약수

```java
class Solution {
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		answer[0] = gcd(n,m); // 최대공약수
		answer[1] = (a*b)/answer[0]; // = i * n/i * m/i => 최소공배수
		return answer;
	}
	public static int gcd (int p, int q) { // 최대공약수
		if(q==0) return p; // 재귀함수 종료 구간
		return gcd(q, p%q); // 다시 본인을 호출 : 재귀함수
	}
}
```

### _**JAVA2 코드 정리**_

1\. temp를 이용하여 주어진 수 a와 b를 변경하여 각각을 최대공약수, 최소공배수에 집어넣는다.

2\. int gcd는 a와 b를 곱한 수이다.

3\. temp가 0이 될 때까지 loop를 탄다.

4\. loop 안에서는 b%a를 한 수를 a에 집어넣고, b 자리에는 원래 a의 값을 넣는다.

5\. 위의 방법으로 loop를 돌았을 때 temp가 0이 되면 b에 들어간 수는 최대공약수가 나온다.

6\. 도출된 최대 공약수를 이용하여 gcd를 최대공약수로 나누었을 때 최소공배수가 도출된다.

\=> 완전 수학의원리

```java
class Solution {
	public int[] solution(int a, int b) {
		int[] answer = new int[2];
		int temp = 1;
		int gcd = a*b;
		
		while(temp != 0) {
			temp = b%a; 
			b = a;
			a = temp;
		}
		
		answer[0] = b;
		answer[1] = gcd/b;
		
		return answer;
	}
}
```

| 이번 문제는 확실히 수학적 사고력이 중요한 알고리즘이었던 것 같다.<br>열심히 머리 짜내서 생각했던 나의 최소공배수 식(i\*n/i\*m/i)도 간단하게(n\*m/i)로 줄일 수 있었는데 그 점을 내가 놓쳤었다.<br>그리고 ‘재귀함수’라는 새로운 함수를 접하게 되었다.<br>처음 이 풀이를 봤을 때는 ‘스스로를 호출한다고? 그럼 어떻게 되는거지?’ 했는데,<br>중간에 조건문 break를 넣어줘 무한루프 현상을 막아주었다.<br>이 문제는 수학적인 접근 방법과 더불어 새로운 코딩 방법을 알게되어 좋았다. |
| --- |