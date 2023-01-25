> 최초작성 : 2021.01.26

## ******Level2 - 기능개발****(java/kotlin)**

 [코딩테스트 연습 - 기능개발](https://programmers.co.kr/learn/courses/30/lessons/42586)

| **문제 설명** |
| --- |
| 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다.<br>각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.<br>또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,<br>이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.<br>먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때<br>각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요. |

| **제한 조건** |
| --- |
|-   작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.|
|-   작업 진도는 100 미만의 자연수입니다.|
|-   작업 속도는 100 이하의 자연수입니다.|
|-   배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.<br>예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| progress | speeds | return |
| \[93, 30, 55\] | \[1, 30, 5\] | \[2, 1\] |
| \[95, 90, 99, 99, 80, 99\] | \[1, 1, 1, 1, 1, 1\] | \[1, 3, 2\] |

입출력 예#1
- 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
- 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
- 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
- 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
- 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.

 입출력 예#2
- 모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다.
- 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
- 따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.

---

### _**나의 풀이**_

1\. 기능을 완성하는게 걸리는 날짜를 입력할 배열 date와 answer의 length를 구하기 위한 int count 선언

2\. 작업진도는 100 미만의 자연수이므로 day를 100-progress\[i\]로 설정해둔다. (남은 진도)

3\. 남은진도를 speed로 나눴을 때의 절대값이 일반 값보다 작으면 절대값+1을 해주고 아니면 절대값을 넣어준다.

    (나눴을 때 나머지가 남는다는 소리이므로 하루의 시간이 더 필요하기 때문)

4\. date\[i\] 값이 date\[i-1\]의 값보다 작으면 date\[i\]에는 date\[i-1\] 값을 넣어준다. (date\[i\]는 date\[i-1\]이 완료되기 전까지 배포 불가)

5\. (4)번 작업을 진행했을 때 date\[i\]가 date\[i-1\]과 같지 않다면 answer의 개수가 될 count를 증가시킨다.

6\. answer\[i\]는 1로 초기화시킨다.

7\. 반복문을 돌 때 date\[j\]의 값이 date\[j-1\]의 값과 같다면 answer\[i\]에 값을 증가시켜준다. (같은 날 배포되는 개수)

8\. answer 값을 리턴한다.

```java
class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
    int[] date = new int[progresses.length];	// 걸리는 날짜 배열
    int count = 0;	// answer의 length 구하기
    int loc=1;

    for (int i=0; i<progresses.length; i++) {
      int day = 100-progresses[i];

      date[i] = (int)day/speeds[i]<(double)day/speeds[i]?(int)day/speeds[i]+1:(int)day/speeds[i];

      if (i>0) {
        if (date[i] < date[i-1]) date[i] = date[i-1];
        if (date[i] != date[i-1]) count++;
      }
    }

    int[] answer = new int[count+1];

    for (int i=0; i<answer.length; i++) {
      answer[i] = 1;
      for (int j=loc; j<date.length; j++) {
        if (date[j]==date[j-1]) answer[i] += 1;
        else {
        	loc = ++j;
        	j=date.length;
        }
      }
    }

    return answer;
  }
}
```

<center>

|이건 꽤 예전에 풀었던 문제인데 긴 풀이에 비해 생각보다 빠르게 풀었던 것 같다.<br>근데 오래전이라 그런지 코드를 분석하는게 좀 까다로웠고 전체적으로 소스가 직관적이지 못하다는 단점이 있다.<br>조금 중구난방 느낌이다.|
|:--:|

</center>

### _**JAVA1 코드 정리**_

1\. 100가지를 넣을 수 있는 dayofend 배열을 선언하고 int day를 -1로 초기화해준다.

2\. int day를 이용해 배포할 수 있는 날짜를 구하고 dayofend에서 배포되는 날짜에 값을 더해주는 방법이다.

3\. dayofend에서 0이 아닌 날짜만 뽑아 배열로 바꾸고 리턴한다.

```java
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
```

<center>

|배열이 100가지나 넣을 수 있다는 점에서 공간 효율성 문제는 조금 떨어지는 듯하다.<br>확실이 람다식을 이용하면 소스 길이가 확 줄어드는 장점이 생긴다.<br>내가 푼 코드가 0.02~0.05ms 사이의 속도가 나오는 반면 이 소스는 늦으면 14.8ms까지도 나온다.<br>속도면에서는 좋은 소스는 아니지만 코드가 간결하고 보기 좋은 장점이 있다.|
|:--:|

</center>

### _**JAVA2 코드 정리**_

1\. 큐를 생성하고, answerList를 생성한다.

2\. 남은 날짜를 계산해서 remain에 넣고, 해당 값을 올림하여 int date에 넣는다. (소수점이 있을 경우 +1이 되도록)

3\. 큐가 비어있지 않거나 큐에 가장 위에있는 값이 date보다 작으면 큐의 개수를 answerList에 추가하고 q는 초기화시킨다.

4\. 큐에 date 값을 추가한다.

5\. 반복문이 종료되면 answerList에 q의 길이를 추가해준다. 

6\. answer 배열에 차례로 answerList 값을 넣고 리턴해준다.

```java
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
```

\* Math.ceil() : 올림

\* **q.offer()**는 큐가 꽉 차서 더이상 추가 할 수 없는 경우 false를 반환하고 요소가 추가되면 true를 반환하므로 예외를 throw하지 않음

<center>

|끝나는 날짜를 예측해서 구하는 방법은 나와 같았다.<br>하지만 Math.ceil()를 사용해서 내가 구현했던 부분이 바로 짧게 추려질 수 있었으며<br>큐를 사용하는 방법이 신선했다.|
|:--:|

</center>

### _**Kotlin 코드 정리**_

```
class Solution {
   fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer : MutableList<Int> = arrayListOf()
        val days = progresses

        for(i in 0 until progresses.size){
            days[i] = ((100 - progresses[i])/speeds[i])
        }

        var max = days[0]
        var releaseCount = 1

        for(i in 1 until days.size){
            if(max < days[i]){
                answer.add(releaseCount)
                releaseCount = 1
                max = days[i]
            }else{
                releaseCount ++
            }
        }

        answer.add(releaseCount)

        return answer.toIntArray()
    }
}
```

* Kotlin에서 **List는 읽기 전용**이며 **MutableList는 읽기/쓰기**가 가능
    * Kotlin에서는 List인 listOf 사용을 권장하나(코드의 선명함과 안전성때문) 동적으로 할당되는 배열을 활용하기 위해선 MutableList를 사용해야함