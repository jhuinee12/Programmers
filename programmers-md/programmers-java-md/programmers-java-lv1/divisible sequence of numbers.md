> 최초작성 : 2021.01.17

## ******Level1 - 나누어 떨어지는 숫자 배열**** (java)**

 [코딩테스트 연습 - 나누어 떨어지는 숫자 배열](https://programmers.co.kr/learn/courses/30/lessons/12910)

| **문제 설명** |
| --- |
| array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수,<br>solution을 작성해주세요.<br>divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요. |

| **제한 조건** |
| --- |
|   -   arr은 자연수를 담은 배열입니다. <br>-   정수 i, j에 대해 i ≠ j 이면 arr\[i\] ≠ arr\[j\] 입니다. <br>-   divisor는 자연수입니다. <br>-   array는 길이 1 이상인 배열입니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| arr | divisor | return |
| \[5,9,7,10\] | 5 | \[5,10\] |
| \[2,36,1,3\] | 1 | \[1,2,3,36\] |
| \[3,2,6\] | 10 | \[-1\] |

|입출력 예#1|
|---|
|arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 \[5, 10\]을 리턴합니다.|

|입출력 예#2|
|---|
|arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 \[1, 2, 3, 36\]을 리턴합니다.|

|입출력 예#3|
|---|
|3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 \[-1\]을 리턴합니다.|

​

### _**나의 풀이**_

1\. 동적배열을 이용, 동적배열 list 선언 (=최종 리턴 배열)

2\. 입력받은 배열 arr을 divisor로 나누는 작업을 반복한 후 나누어 떨어질 때 list 배열에 넣는다.

3\. list에 아무 값이 없다면 -1을 리턴한다.

4\. list에 들어간 값들을 answer 배열에 넣고 정렬 후 return한다.

```java
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public int[] solution(int[] arr, int divisor) {

    ArrayList<Integer> list = new ArrayList<>();

    for (int i=0; i<arr.length; i++) {
      if(arr[i]%divisor == 0) 
      	list.add(arr[i]);
    }

    if (list.size() == 0)
    	list.add(-1);

    int[] answer = new int[list.size()];

    for (int i=0; i<list.size(); i++)
    	answer[i] = list.get(i);

    Arrays.sort(answer);

    return answer;
  }
}
```

### _**JAVA1 코드 정리**_

1\. lambda를 이용

2.  answer 배열에 array의 요소(factor)를 divisor로 나눠 나누어 떨어진 값을 넣는다.

3\. answer에 아무 요소가 없으면 -1을 넣고, 요소가 있을 경우 정렬시킨 후 리턴한다.

```java
import java.util.Arrays;

class Divisible {
    public int[] divisible(int[] array, int divisor) {
        int[] answer = Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0)
        	answer = new int[] {-1};
        java.util.Arrays.sort(answer);
        return answer;
    }
}
```

* stream filter : 스트림의 컨텐츠를 필터링하는 것

| 와... 내가 줄줄줄 썼던 것들이 불과 4줄만에 코딩이 완성된다.<br>난 알고리즘을 공부하기 위해 프로그래머스 문제를 푸는 거니까 내가 푼 문제가 부끄럽다거나(///)...   <br>*~(그래도 좀 불필요한 코드는 없일 필요가 있는 듯 ㅎㅎ)~*<br>하진 않은데, 그래도 저런 코드들을 알고 있으면 활용하기 편할 것 같다.<br>lambda식에 대해 다시 공부해야지! |
| --- |