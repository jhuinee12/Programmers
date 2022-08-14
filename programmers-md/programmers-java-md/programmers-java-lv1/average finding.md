> 최초작성 : 2020.12.17

## **Level1 - 평균 구하기 (java)**

 [코딩테스트 연습 - 평균 구하기](https://programmers.co.kr/learn/courses/30/lessons/12944)

| **문제 설명** |
| --- |
| 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요 |

| **제한 조건** |
| --- |
|   -   arr은 길이 1 이상, 100 이하인 배열입니다.|
|   -   arr의 원소는 -10000 이상 10,000 이하인 정수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| arr | return |
| \[1,2,3,4\] | 2.5 |
| \[5,5\] | 5 |

​

### _**나의 풀이**_

1\. arr의 길이만큼 for문을 돌려서 총 합을 구한다.

2\. 구한 합을 다시 arr의 길이로 나눠서 평균을 구한다.

```java
class Solution {
	public double solution(int[] arr) {
		double answer = 0;
		int sum = 0;
		for (int i=0; i<arr.length; i++)
			sum += arr[i];
		answer = (double) sum/arr.length;
		return answer;
	}
}
```

### _**JAVA1 코드 정리**_

내장 average()함수를 사용 -> average 값이 있으면 average 리턴, 없으면 0 리턴

```java
class Solution {
	public int solution(int[] arr) {
		retrun (int) Arrays.stream(array).average().orElse(0);
	}
}
```

\* orElse(double other) : average의 값이 있으면 average를 리턴하고 없으면 double other을 리턴

| Stream을 활용하면 확실히 코드의 길이가 줄어든다.<br>내 코드가 잘못된 코드는 아니지만 Stream을 사용하지 않고 처음부터 다 코드를 만들다 보니<br>상대적으로 많이 길게 느껴진다. Stream을 더 잘 활용할 수 있도록 해야겠다. |
| --- |