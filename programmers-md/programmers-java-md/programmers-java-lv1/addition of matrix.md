> 최초작성 : 2020.12.17

## **Level1 - 행렬의 덧셈 (java)**

 [코딩테스트 연습 - 행렬의 덧셈](https://programmers.co.kr/learn/courses/30/lessons/12950)

| **문제 설명** |
| --- |
| 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.<br>2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| arr | arr2 | return |
| \[\[1,2\],\[2,3\]\] | \[\[3,4\],\[5,6\]\] | \[\[4,6\],\[7,9\]\] |
| \[\[1\],\[2\]\] | \[\[3\],\[4\]\] | \[\[4\],\[6\]\] |

​

### _**나의 풀이**_

1\. arr1 배열의 크기만큼 answer 배열을 선언한다.

2\. arr1과 arr2의 2차 배열의 합을 구하고 1차 배열의 크기를 올려 계속 합을 구해 저장한다.

```java
class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length]; // 2차 배열 크기 구하기
		
		for (int i=0; i<arr1.length; i++)
			for (int j=0; j<arr1[0]; j++)
				answer[i][j] = arr1[i][j] + arr2[i][j];
				
		return answer;
	}
}
```

\* 다차원 배열 길이 = arr.length / arr\[0\].length

<center>

| 오랜만에 보니 나도 헷갈린다.<br>특히 2중 for문에 2차 배열이니 더 머리가 복잡해 연습장을 펼쳐놓고 직접 풀어봤다.<br>과거의 나 존경한다 ㅠㅜ |
| :---: |

</center>