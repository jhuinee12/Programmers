> 최초작성 : 2021.01.25

## ******Level1 - 두 개 뽑아서 더하기**** (kotlin)**

 [코딩테스트 연습 - 두 개 뽑아서 더하기](https://programmers.co.kr/learn/courses/30/lessons/68644)

| **문제 설명** |
| --- |
| 정수 배열 numbers가 주어집니다.<br>numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를<br>배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요. |

| **제한 조건** |
| --- |
|-   numbers의 길이는 2 이상 100 이하입니다.|
|-   numbers의 모든 수는 0 이상 100 이하입니다.|

| **​입출력 예**    |  |
| --- | --- |
| numbers | result |
| \[2,1,3,4,1\] | \[2,3,4,5,6,7\] |
| \[5,0,2,7\] | \[2,5,7,9,12\] |

입출력 예#1
-   2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
-   3 = 2 + 1 입니다.
-   4 = 1 + 3 입니다.
-   5 = 1 + 4 = 2 + 3 입니다.
-   6 = 2 + 4 입니다.
-   7 = 3 + 4 입니다.
-   따라서 \[2,3,4,5,6,7\] 을 return 해야 합니다.

입출력 예#2
-   2 = 0 + 2 입니다.
-   5 = 5 + 0 입니다.
-   7 = 0 + 7 = 5 + 2 입니다.
-   9 = 2 + 7 입니다.   
-   12 = 5 + 7 입니다.
-   따라서 \[2,5,7,9,12\] 를 return 해야 합니다.
​
---

### _**나의 풀이**_

1\. 두 수를 더한 숫자를 담을 ArrayList list를 생성한다.

2\. 두 개의 숫자를 순서대로 뽑은 후 더해서 list에 추가하는데, 이 때 중복되는 값이 이미 존재하면 추가하지 않는다.

3\. 일반 배열 answer를 list의 크기 만큼 할당하여 선언해준다.

4\. answer에 list의 값들을 넣고 오름차순으로 정렬한 후 리턴한다.

```java
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = 0;

        for (int i=0; i<numbers.length; i++)
        {
            for (int j=i+1; j<numbers.length; j++)
            {
                if(!list.contains(numbers[i]+numbers[j]))
                        list.add(numbers[i]+numbers[j]);
            }
        }

        int[] answer = new int[list.size()];

        for (int i : list)
        {
            answer[a] = i;
            a++;
        }

        Arrays.sort(answer);
        return answer;
    }
}
```

| 조금 더 짧고 효율적인 코드가 나올 수 있을 것 같은데<br>짜다보니 꽤 길어졌다.   효율적인 코드는 다음 정리된 코드들에서 확인! |
| --- |

### _**JAVA1 코드 정리**_

1\. HashSet set을 생성한다.

2\. 두 수를 순서대로 뽑아내 set에 추가한다.

3\. set을 정렬한다.

```java
import java.util.*;

class Solution {
     public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
```

* **set은 list와 다르게 객체를 중복해서 저장할 수 없다.**

* mapXXX 함수들은 해당 타입의 스트림으로 바꿔준다.
* 예를들어 "1","2","3" 을 가진 스트림이 있었으면 mapToInt를 적용하면 1,2,3 을 가진 스트림으로 변환 해준다.

| list가 아닌 set을 사용하면 간결하고 한번에 해결됐을 문제.<br>set의 특징을 잘 몰라 활용하지 못한 것이 아쉽다. |
| --- |