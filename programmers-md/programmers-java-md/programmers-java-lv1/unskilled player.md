> 최초작성 : 2021.01.19

## ******Level1 - 완주하지 못한 선수**** (java)**

 [코딩테스트 연습 - 완주하지 못한 선수](https://programmers.co.kr/learn/courses/30/lessons/42576)

| **문제 설명** |
| --- |
| 수많은 마라톤 선수들이 마라톤에 참여하였습니다.<br>단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.<br>마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,<br>완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요. |

| **제한 조건** |
| --- |
|-   마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.|
|-   completion의 길이는 participant의 길이보다 1 작습니다.|
|-   참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.\
|-   참가자 중에는 동명이인이 있을 수 있습니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| **participantparticipant** | **completion** | **return** |
| \[leo, kiki, eden\] | \[eden, kiki\] | "leo" |
| \[marina, josipa, nikola, vinko, filipa\] | \[josipa, filipa, marina, nikola\] | "vinko" |
| \[mislav, stanko, mislav, ana\] | \[stanko, ana, mislav\] | "mislav" |

-   ​입출력 예#1

leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

-   입출력 예#2

vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

-   입출력 예#3

mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

---

### _**나의 풀이**_

1.  우선 participant와 completion을 오름차순으로 정렬한다.

2\. participant와 completion의 명단을 하나하나 비교한다.

3\. completion의 길이는 participant의 길이보다 1 작으므로 완주하지 못한 선수는 한명이다.

4\. 명단  비교 후, completion에 없는 명단이 생길 경우 해당 값을 리턴한다.

```java
import java.util.Arrays;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
   
       // 배열 오름차순 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
    
        
        for (int i=0; i<completion.length; i++)
        {
           if(!participant[i].equals(completion[i])) {
              // 다른값이면 리턴
              answer = participant[i]; 
               break;
           } else {
              answer = participant[i+1]; 
           }
    }
    
    return answer;
    }
}
```

||
|:---:|
|문제만 보면 어렵지만, 조금만 생각해보면 간단한 문제다.|
|그냥 두개의 배열을 비교만 하면 해결!|

### _**JAVA1 코드 정리**_

1\. HashMap을 생성하고, 키값으로 participant와 completion의 이름을 입력한다.

2\. (중복제거) key값이 존재하면 해당 값을 넣어주고 없다면 0, 그리고 +1

3\. 같은 이름일 경우 +1과 -1이 작업되면서 0만 남을 것이고, 완주하지 못한 경우 1만 남을 것이다.

4\. 0이 아닌 값을 리턴한다.

```java
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
```

* HashMap : Map 인터페이스를 구현한 대표적인 Map 컬렉션
    * 키와 값으로 구성된 Entry 객체를 저장하는 구조
    * 값은 중복 가능하지만 키는 중복 불가능

```java
HashMap<Integer,String> map = new HashMap<>(); //new에서 타입 파라미터 생략가능

map.put(key,value); //값 추가
```
* getOrDefault() : 찾는 키가 존재하면 해당 키의 값을 반환하고, 없으면 기본값 반환

---

||
|:---:|
|HashMap은 잘 모르는 부분이라 해석하기 까다로웠다.|
|실은 아직도 정확하게 모르겠다..|
|굳이 이 부분에서 getOfDefault를 써야하는가...?|