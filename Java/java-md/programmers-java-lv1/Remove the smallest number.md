> 최초작성 : 2021.11.08

## **Level1 - 제일 작은 수 제거하기 (java)**

 [코딩테스트 연습 - 제일 작은 수 제거하기](https://programmers.co.kr/learn/courses/30/lessons/12935)

| **문제 설명** |
| --- |
| 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.<br>단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.<br>예를들어 arr이 \[4,3,2,1\]인 경우는 \[4,3,2\]를 리턴 하고, \[10\]면 \[-1\]을 리턴 합니다. |

| **제한 조건** |
| --- |
|   -   arr은 길이 1 이상인 배열입니다.|
|   -   인덱스 i, j에 대해 i ≠ j이면 arr\[i\] ≠ arr\[j\] 입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| arr | return |
| \[4,3,2,1\] | \[4,3,2\] |
| \[10\] | \[-1\] |

​

### _**나의 풀이**_

1\. 입력받은 배열(arr)의 길이가 1인 경우 -1 리턴 (빈 배열)

2\. arr 배열의 길이가 1 이상인 경우 arr2 배열에 arr 배열 삽입

3\. 기존 arr 배열 정렬 (Arrays.sort 이용)

4\. arr2와 arr을 비교하여 가장 작은 수가 있는 위치를 찾아 변수 a에 저장

5\. a위치 값을 제외하고 나머지 수를 원래 arr 순서대로 answer 배열에 저장 후 리턴

```java
import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr) {
		if (arr.length == 1) {
			int[] answer = {-1};
			return answer;
		} else {
			int[] answer = new int[arr.length-1];
			int[] arr2 = new int[arr.length];
			
			for (int i=0; i<arr.length; i++) {
				arr2[i] = arr[i];
			}
			Arrays.sort(arr);
			int a=0;
			for (int i=0; i<arr.length; i++) {
				if (arr2[i] == arr[0])
					a = i;
			}
			for (int i=0; i<a; i++) {
				answer[i] = arr2[i];
			}
			for (int i=a; i<arr.length-1; i++) {
				answer[i] = arr2[i+1];
			}
			return answer;
		}
	}
}
```

### _**JAVA1 코드 정리**_

1\. 입력받은 배열(arr) 길이가 1 이하인 경우 -1 리턴

2\. 가장 작은 수(min)은 함수 이용하여 구함 : Arrays.stream(arr).min().getAsInt();

3\. i가 min이 아닐 경우 arr 배열에 다시 넣고 리턴

```java
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

class Solution {
  public int[] solution(int[] arr) {
      if (arr.length <= 1) return new int[]{ -1 };
      int min = Arrays.stream(arr).min().getAsInt(); // 작은수 구하는 함수
      return Arrays.stream(arr).filter(i -> i != min).toArray();
  }
}
```

| 오랜만에 예전에 코드를 보는데 이해하기가 쉽지 않았다.<br>조금 더 간단히 구현할 수 있는 걸 멀리 돌아가면서 코딩해서 그런지 답답하기도 하고 황당하기도 했다.   <br> 다른 사람들의 풀이는 간단하고 심플하다. |
| --- |