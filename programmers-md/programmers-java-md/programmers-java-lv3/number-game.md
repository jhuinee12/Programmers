> 최초작성 : 2022.08.14

## ******Level3 - 숫자 게임**** (java)**

 [코딩테스트 연습 - 숫자 게임](https://school.programmers.co.kr/learn/courses/30/lessons/12987)

| **문제 설명** |
| --- |
| xx 회사의 2xN명의 사원들은 N명씩 두 팀으로 나눠 숫자 게임을 하려고 합니다. <br>두 개의 팀을 각각 A팀과 B팀이라고 하겠습니다. <br>숫자 게임의 규칙은 다음과 같습니다.

* 먼저 모든 사원이 무작위로 자연수를 하나씩 부여받습니다.
* 각 사원은 딱 한 번씩 경기를 합니다.
* 각 경기당 A팀에서 한 사원이, B팀에서 한 사원이 나와 서로의 수를 공개합니다. 그때 숫자가 큰 쪽이 승리하게 되고, 승리한 사원이 속한 팀은 승점을 1점 얻게 됩니다.
* 만약 숫자가 같다면 누구도 승점을 얻지 않습니다.

전체 사원들은 우선 무작위로 자연수를 하나씩 부여받았습니다. <br>그다음 A팀은 빠르게 출전순서를 정했고 자신들의 출전 순서를 B팀에게 공개해버렸습니다. <br>B팀은 그것을 보고 자신들의 최종 승점을 가장 높이는 방법으로 팀원들의 출전 순서를 정했습니다. <br>이때의 B팀이 얻는 승점을 구해주세요.
<br>A 팀원들이 부여받은 수가 출전 순서대로 나열되어있는 배열 A와 i번째 원소가 B팀의 i번 팀원이 부여받은 수를 의미하는 배열 B가 주어질 때, <br>B 팀원들이 얻을 수 있는 최대 승점을 return 하도록 solution 함수를 완성해주세요.

| **제한사항** |
| --- |
|   -   A와 B의 길이는 같습니다.   |
|   -   A와 B의 길이는 1 이상 100,000 이하입니다.   |
|   -   A와 B의 각 원소는 1 이상 1,000,000,000 이하의 자연수입니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| A | B | result |
| [5,1,3,7] | [2,2,6,8] | 3 |
| [2,2,2,2] | [1,1,1,1] | 0 |

---

---

### _**나의 풀이1**_

1\. A와 B를 오름차순으로 정렬한다. (내림차순으로 정렬하고 싶었지만, 제약이 있었음)

2\. A와 B의 원소들을 각 큰 숫자 순서로 비교한다.

3\. B의 원소가 A의 원소보다 크면, 점수를 1 올리고 해당 B원소를 0으로 바꾼다. (중복 체크가 되지 않게 해당 원소 제거)


```java
import java.util.*;

class Solution {
    public int solution1(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int size = A.length;

        for (int i=size-1; i>=0; i--) {
            for (int j=size-1; j>=0; j--) {
                if (B[j] > A[i]) {
                    answer++;
                    B[j] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
```

---

### _**나의 풀이2**_

1\. A와 B를 내림차순으로 정렬한다.

2\. 오름차순으로 정렬한 배열을 큐에 쌓는다.

3\. 각 큐의 첫번째 숫자(max)를 뽑아 비교한다. (A는 poll:반환 및 제거 / B는 peek:반환)

4\. B큐의 원소가 A큐의 원소보다 크면 점수를 올리고 해당 B 원소를 큐에서 제거한다.

```java
import java.util.*;

class Solution {
    public int solution2(int[] A, int[] B) {
        int answer = 0;

        Integer[] arr1 = Arrays.stream(A).boxed().sorted().toArray(Integer[]::new);
        Integer[] arr2 = Arrays.stream(B).boxed().sorted().toArray(Integer[]::new);
        Arrays.sort(arr1, Collections.reverseOrder());
        Arrays.sort(arr2, Collections.reverseOrder());
        Queue<Integer> queueA = new LinkedList<>(Arrays.asList(arr1));
        Queue<Integer> queueB = new LinkedList<>(Arrays.asList(arr2));

        for (int i=0; i<arr1.length; i++) {
            if (queueB.peek() > queueA.poll()) {
                answer++;
                queueB.remove();
            }
        }

        return answer;
    }
```

---

### _**나의 풀이3**_

1\. A와 B를 오름차순으로 정렬한다. (내림차순으로 정렬하고 싶었지만, 제약이 있었음)

2\. A와 B의 원소들을 각 큰 숫자 순서로 비교한다.

3\. A의 원소보다 큰 B의 원소가 있으면 점수를 1점 올린다.

4\. 이미 비교한 B 원소는 비교 대상에서 제외한다. (j--)


```java
import java.util.*;

class Solution {
    public int solution3(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int j = B.length-1;
        for (int i = A.length-1; i >= 0; i--) {
            if (B[j] > A[i]) {
                answer++;
                j--;
            }
        }

        return answer;
    }
}
```

<center>

| 생각보다 금방 풀었다.<br>처음 푸는 3단계여서 걱정했는데, 2단계 수준의 문제였던 것 같다.<br><br>하지만 처음에는 이중for문을 사용해서인지 효율성 오류가 났고,<br>사람들이 올려준 힌트를 이용해 두번째는 Queue를 이용해 풀었다.<br>결국 for문을 이용해 다시 소스 정리를 하고 마무리 했다. |
| :---: |

</center>