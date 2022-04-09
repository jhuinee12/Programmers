> 최초작성 : 2020.11.03

## **Level1 - 같은 숫자는 싫어 (java)**

 [코딩테스트 연습 - 같은 숫자는 싫어](https://programmers.co.kr/learn/courses/30/lessons/12906)

| **문제 설명** |
| --- |
| 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.<br>이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.<br>단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.|
|예를 들면,<br>- arr = \[1,1,3,3,0,1,1\]이면 \[1,3,0,1\] 을 return 합니다.<br>- arr = \[4,4,4,3,3\]이면 \[4,3\] 을 return 합니다.|
|배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return하는 solution 함수를 완성해 주세요. |

| **제한 조건** |
| --- |
|   -   배열 arr의 크기 : 1,000,000 이하의 자연수 -   배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수   |

| **​입출력 예**    |  |
| --- | --- |
| n | result |
| \[1,1,3,3,0,1,1\] | \[1,3,0,1\] |
| \[4,4,4,3,3\] | \[4,3\] |

​

### _**나의 풀이**_

1\. 동적 배열 list 선언

2\. arr\[0\]을 list에 제일 처음으로 추가

3\. for문으로 arr 크기만큼 반복하여 앞자리와 숫자가 다를 경우 list에 추가

4\. list를 다시 answer 배열에 입력 후 리턴

```java
class Solution {
	public int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(arr[0]);
		
		for (int i=1; i<arr.length; i++) {
			if (arr[i] != arr[i-1])
				list.add(arr[i]);
		}
		
		int answer[] = new int[list.size()];
		for (int i=0; i<answer.length; i++)
			answer[i] = list.get(i);
			
		return answer;
	}
}
```

### _**JAVA1 코드 정리**_

1\. 동적배열 tempList 선언

2\. 중복되지 않을 preNum선언 (0~9까지 숫자가 아닌 다른 수)

3\. preNum과 비교하여 같지 않을 경우 tempList에 추가 후 preNum은 해당 숫자로 변경

4\. tempList를 다시 answer 배열에 입력 후 리턴

```java
class Solution {
	public int[] solution(int[] arr) {
		ArrayList<Integer> templist = new ArrayList<>();
		int preNum = 10;
		for (int num : arr) {
			if (preNum != num)
				templist.add(num)
			preNum = num;
		}
		int [] answer = new int[templist.size()];
		for (int i=0; i<answer.length; i++) {
			answer[i] = templist.get(i).intValue();
		}
		return answer;
	}
}
```

|나의 생각|
|---|
|나는 arr\[i\]와 arr\[i-1\]을 비교하였고, 다른 분은 preNum이라는 int형 변수를 선언하여 그 숫자와 arr\[i\]를 비교하였다.<br>어느 것이 더 좋은지 판단하긴 힘드나 preNum을 생각해낸 것이 대단하다고 생각든다.|