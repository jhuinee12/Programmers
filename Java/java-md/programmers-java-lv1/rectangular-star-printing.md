## **Level1 - 직사각형 별찍기 (java)**
> 최초작성 : 2020.10.18

 [코딩테스트 연습 - x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954)

| **문제 설명** |
| --- |
| 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.<br>별(\*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 평태를 출력해보세요. |

| **제한 조건** |
| --- |
|   -   n과 m은 각각 1000 이하인 자연수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| 입력예시 | 출력예시 |
| 5 3 | \*\*\*\*\*   \*\*\*\*\*   \*\*\*\*\* |

​

### _**나의 풀이**_

1\. for문

```java
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for (int i=0; i<b; i++){
			for (int j=0; j<a; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
```

​

### _**JAVA1 코드 정리**_

1\. StringBuilder에 하나씩 넣고 toString으로 string형 출력

```java
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<a; i++) // a크기만큼 sb 저장
			sb.append("*");
		for (int i=0; i<b; i++) // b 개수만큼 출력
			System.out.println(sb.toString());
	}
}
```

| 이번 코드는 Scanner를 사용해야해서 그런가 다른 코드들과는 다르게 main 클래스에서 실행을 했다.<br>상대적으로 쉬운 코드였고, 확실히 코드가 간결했다.<br>for문으로 다 출력하는 방법도 있고 StringBuilder를 써도 되는구나를 알게되었다. |
| --- |