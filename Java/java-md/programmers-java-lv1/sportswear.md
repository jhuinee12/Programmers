> 최초작성 : 2021.01.18

**[\[프로그래머스\]Level1 - 체육복 (kotlin)](https://anovice-dp.tistory.com/entry/프로그래머스Level1-체육복-kotlin)**

## ******Level1 - 체육복**** (java)**

 [코딩테스트 연습 - 체육복](https://programmers.co.kr/learn/courses/30/lessons/42862)

| **문제 설명** |
| --- |
| 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.<br>다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.<br>학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.<br>예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.<br>체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.<br>전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,<br>여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,<br>체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요. |

| **제한 조건** |
| --- |
|   -   전체 학생의 수는 2명 이상 30명 이하입니다. <br>-   체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. <br>-   여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. <br>-   여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다. <br>-   여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.<br>이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.   |

| **​입출력 예**    |  |  |  |
| --- | --- | --- | --- |
| n | lost | reserve | return |
| 5 | \[2,4\] | \[1, 3, 5\] | 5 |
| 5 | \[2,4\] | \[3\] | 4 |
| 3 | \[3\] | \[1\] | 2 |

-   입출력 예#1

1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다. 

-   입출력 예#2

3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

​

### _**나의 풀이**_

1\. answer값은 현재 체육복을 가져온 학생 수에서 수업을 들을 수 있는 학생을 추가하는 식으로 진행했다.

2\. 체육복 한벌을 도난당한 학생이 여벌 체육복을 챙겨온 학생이라면 수업 들을 수 있는 학생을 추가하고, 중복되지 않게 -1로 바꾼다.

3\. 체육복을 도난 당한 학생 번호와 여벌 체육복을 챙겨온 학생 번호가 1 차이 난다면,

   해당 학생의 체육복은 다른 사람에게 빌려주지 않도록 -1을 반환하고 answer를 추가한다.

4\. for문을 벗어나기 위해 j=reserve.length-1를 사용하였는데, 그냥 break;

```java
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    j = reserve.length-1;
                }
            }
        }
        
        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (Math.abs(lost[i]-reserve[j]) == 1) {
                    reserve[j] = -1;
                    answer++;
                    j = reserve.length-1;
                }
            }
        }
        
        return answer;
    }
}
```

| for문 안에서 if를 탔을 때 다음 for문으로 넘어가고 싶으면 break;만 넣어주면 된다.<br>그 부분을 생각하지 못했다는 것 자체가 꽤 예전에 코딩했다는 것을 알 수 있다.<br>이걸 어떻게 조금 더 효율적으로 그리고 간단하게 코딩할지 좀 더 연구해봐야겠다. |
| --- |

### _**JAVA1 코드 정리**_

1\. 학생 수 길이만큼 people이라는 배열을 만들고, answer는 학생수로 초기화한다.

2.  l은 lost 안에서 반복하는 반복문을 만들고 lost 학생의 위치를 -1로 넣는다.

3\. r을 reserve 안에서 반복하는 반복문을 만들고 reserve 학생의 위치를 1로 넣는다.

4\. people 배열에서 lost 학생을 만나면, reserve학생과 1차이가 나는 경우 그 학생의 값을 0으로 바꾸고,

   빌려준 학생 또한 0으로 바꾼다.

5\. 체육복을 빌리지 못한 경우 answer 값을 다운시킨다.

```java
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}
```

| lost와 reserve를 하나의 배열 안에서 비교한다는 생각 자체가 놀랍다.<br>숫자 하나로 빌려주고, 빌리고, 혹은 빌리지 못하고를 판단하는 발상이 신기하다.<br>알고리즘도 깔끔하고, 배울점이 많다. |
| --- |

### _**JAVA2 코드 정리**_

1\. rent를 false로 초기화하고, true가 될 때까지 반복하는 반복문을 만든다.

2\. j는 reserve 배열의 길이라거나 lost와 reserve 학생이 같거나 lost 학생과 reserve 학생이 1차이가 나면

    while 반복문은 멈춰진다.

3\. rent가 false라면(빌리지 못했다면) answer를 다운시킨다. (초기 answer는 학생 수)

```java
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n;

        for(int i = 0; i < lost.length; i++) {
            boolean rent = false;
            int j = 0;
            while(!rent) {
                if(j == reserve.length)                   break;
                if(lost[i] == reserve[j])                {reserve[j] = -1; rent=true;}
                else if(lost[i] - reserve[j] == 1 )      {reserve[j] = -1; rent=true;}
                else if(lost[i] - reserve[j] == -1)      {reserve[j] = -1; rent=true;}
                else                                     {j++;                      }
            }
            if(!rent) answer--;
        }
        return answer;
    }
}
```

| 내가 짠 코드랑 조금 비슷했다.<br>lost 학생과 reserve 학생이 같거나, 1차이가 난다면 reserve에 -1을 넣고, 빌려주는거.<br>근데 이건 boolean으로 판단해 answer를 계산했고, while문 안에 코드가 상당히 깔끔하게 보인다. |
| --- |

### _**_**JAVA3 코드 정리**_**_

1\. HashSet의 resList와 losList를 생성한다.

2\. resList에 i를 넣는다.

3\. resList에 i가 있다면 해당 값을 제거하고, 아니라면 i를 losList에 추가한다.

4\. losList에 i가 있는데, resList에 i-1이 있으면 resList에 i-1를 제거하고, resList에 i+1이 있으면 resList에 i+1을 제거하고,

    아니면 answer 값을 다운시킨다. (answer는 총 학생 수)

```java
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashSet<Integer> resList = new HashSet<>();
        HashSet<Integer> losList = new HashSet<>();

        for (int i : reserve)
            resList.add(i);
        for (int i : lost) {
            if(resList.contains(i))
                resList.remove(i);
            else
                losList.add(i);
        }
        for (int i : lost) {
            if(losList.contains(i)) {
                if(resList.contains(i-1))
                    resList.remove(i-1);
                else if(resList.contains(i+1))
                    resList.remove(i+1);
                else
                    answer--;
            }
        } 
        return answer;
    }
}
```

\* HashSet이란, Set인터페이스의 구현 클래스 (Set은 객체를 중복해서 저장할 수 없고 하나의 null 값만 저장)

└ Set의 큰 장점은 중독을 자동 제거해줌

HashSet<Integer> set = new HashSet<Integer>();  //HashSet생성

set.add(1);  //값 추가

set.remove(1); //값 1 제거

set.clear(); //모든 값 제거

| HashSet이라는게 있는 줄 몰랐다.<br>HashSet에 대한 개념을 아주 간단하게 겉핥기 식으로만 찾아봤는데,v조금 더 자세하게 공부해야겠다. |
| --- |