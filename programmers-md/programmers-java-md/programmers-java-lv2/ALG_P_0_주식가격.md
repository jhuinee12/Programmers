> 최초작성 : 2021.01.27

## ******Level2 - 주식가격**** (java)**

 [코딩테스트 연습 - 주식가격](https://programmers.co.kr/learn/courses/30/lessons/42584#)

| **문제 설명** |
| --- |
| 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,<br>가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요. |

| **제한 조건** |
| --- |
|-   prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.|
|-   prices의 길이는 2 이상 100,000 이하입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| prices | return |
| \[1, 2, 3, 2, 3\] | \[4, 3, 1, 1, 0\] |

입출력 예#1
-   1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
-   2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
-   3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
-   4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
-   5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.

​

### _**나의 풀이**_

1\. 리턴할 answer 배열을 생성하고 이중 for문을 만든다.

2\. 일단 answer의 값은 주식이 떨어지지 않았을 경우의 최대 유지 시간으로 초기화해둔다.

3\. 만약 다음 배열에서 나보다 더 낮은 수가 있으면 그 수의 위치에서 현재의 위치를 뺀 값을 answer에 넣는다.

4\. if문을 타지 않으면 주식은 떨어지지 않은 것으로 간주하고 원래 초기화된 값을 유지한 채 리턴한다.

```java
class Solution {
  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];

    for (int i=0; i<prices.length-1; i++) {
      answer[i] = prices.length-i-1;
      for (int j=i+1; j<prices.length-1; j++)
      {
        if (prices[i] > prices[j]) 
        {
          answer[i] = j-i;
          break;
        }
      }
    }
    return answer;
  }
}
```

<center>

|eclipse를 통해서 모든 코드를 돌렸을 때 왠만한 값들이 다 정상적으로 출력됐는데,<br>채점만 하면 1번 빼고 다 실패가 떴는지 이해를 못하고 계속 삽질했다.<br>알고보니 복붙을 잘못함 ㅋㅋㅋ쿠ㅠㅜㅜㅠㅜㅠ 어이없엉...😂|
|:--:|

</center>

### _**JAVA1 코드 정리**_

1\. answer를 prices의 길이만큼 배열을 선언해준다.

2\. 이중 for문을 만들어주고, for문이 돌아갈 때마다 answer\[i\]의 값도 증가시켜준다.

3\. prices\[i\]가 prices\[j\]보다 크면 answer\[i+1\]로 넘어간다.

4\. answer를 리턴한다.

```java
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}
```

<center>

|내가 복붙을 잘못했을 때 엉뚱한 걸로 삽질해서 이 코드랑 똑같이 짰었다.<br>나는 answer 값을 먼저 선언해주고 만약 가격이 떨어질 경우 그 위치값을 통해 answer를 구했는데<br>이건 for문을 돌 때마다 answer를 더해주는 방식이다.<br>뭐가 더 나은지는 모르겠지만, 이 소스가 조금 더 직관적인 느낌?|
|:--:|

</center>

### _**JAVA2 코드 정리**_

1\. beginIdxs라는 스택 클래스를 선언해주고 리턴해줄 terms 배열을 선언해준다.

2\. 스택클래스에 초기화된 i 값을 push한다.

3\. for문 배열을 도는데 스택이 비어있지 않거나 현재 prices가 스택 가장 상위에 있는 값의 주소 prices보다 작은 경우 계속 반복한다.

4\. 스택이 없어지는 순간은 주식 가격이 떨어졌다는 것이고, 이 경우 스택의 top 값을 이용하여 terms 배열이 채워진다.

5\. 다음 반복문에서 스택이 비어있지 않다는 건 현재 terms에 비어있는 값이 있다는 것이고 역시 스택의 top 값을 이용해 terms 배열을 채운다.

```java
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}
```

* stack의 top 값은 언제나 i 값보다 하나 작다. 따라서 i와 i-1을 비교한다고 생각하면 된다.

<center>

|이 문제는 처음부터 스택/큐를 이용해야하는 문제라고 명시되어있다.<br>근데 내가 문제를 풀 때에는 스택/큐를 어떻게 사용하라는지 감이 오지 않아<br>그냥 이중 반복문으로 대체를 했는데 이렇게 스택을 사용하고도 문제를 풀 수 있다.|

</center>