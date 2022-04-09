> 최초작성 : 2021.02.07

## ******Level2 - 위장**** (java/kotlin)**

 [코딩테스트 연습 - 위장](https://programmers.co.kr/learn/courses/30/lessons/42578)

| **문제 설명** |
| --- |
| 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.<br>예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면   다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.|

| **종류** | **이름** |
| --- | --- |
| 얼굴 | 동그란 안경, 검정 선글라스 |
| 상의 | 파란색 티셔츠 |
| 하의 | 청바지 |
| 겉옷 | 긴 코트 |

||
| --- |
| 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.|

| **제한 조건** |
| --- |
|-   clothes의 각 행은 \[의상의 이름, 의상의 종류\]로 이루어져 있습니다.|
|-   스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.|
|-   같은 이름을 가진 의상은 존재하지 않습니다.|
|-   clothes의 모든 원소는 문자열로 이루어져 있습니다.|
|-   모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '\_' 로만 이루어져 있습니다.|
|-   스파이는 하루에 최소 한 개의 의상은 입습니다.|

| **​입출력 예**    |  |
| :---: | :---: |
| clothes | return |
| \[\["yellow\_hat", "headgear"\], \["blue\_sunglasses", "eyewear"\], \["green\_turban", "headgear"\]\] | 5 |
| \[\["crow\_mask", "face"\], \["blue\_sunglasses", "face"\], \["smoky\_makeup", "face"\]\] | 3 |

입출력 예#1
- headgear에 해당하는 의상이 yellow\_hat, green\_turban이고 eyewear에 해당하는 의상이 blue\_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.
    
    1. yellow\_hat
    2. blue\_sunglasses
    3. green\_turban
    4. yellow\_hat + blue\_sunglasses
    5. green\_turban + blue\_sunglasses

입출력 예#2
- face에 해당하는 의상이 crow\_mask, blue\_sunglasses, smoky\_makeup이므로 아래와 같이 3개의 조합이 가능합니다.  

     1. crow\_mask
     2. blue\_sunglasses
     3. smoky\_makeup

​
<center>

|결국 나는 포기...<br>map 혹은 조합을 사용해서 이것저것 해보았으나...<br>진짜 도저히 모르겠다 ㅠㅠ<br>내가 제일 싫어한게 확통이었어 ㅠㅜㅠㅠㅠㅠ😪|
|:--:|

</center>

### _**JAVA1 코드 정리**_

```java
import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
```

**\* reduce() : 엘리먼트를 비교하고 컬렉션에서 하나의 값으로 연산**

| 결국은 뒤에서 정리할 JAVA2의 코드를 stream을 이용하여 한줄로 풀었다.   음... 대충 어느 풀이이다 감은 오는데 잘 모르겠는 ㅠㅜ |
| --- |

### _**JAVA2 코드 정리**_

**[2ssue.github.io/algorithm/programmers\_42578/](https://2ssue.github.io/algorithm/programmers_42578/)**

1\. 옷의 종류를 map의 키로 지정하고 종류의 개수를 value로 넣는다. _(map.get(clothes\[i\]\[1\])+1)_

2\. 경우의 수를 구한다.

3\. 하나도 안 입는 경우는 없으므로 answer에서 -1을 해주고 리턴한다.

```java
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; 

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            if(map.get(clothes[i][1]) == null)
                map.put(clothes[i][1], 1);
            else
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }

        for(String keys: map.keySet()) {
            answer *= (map.get(keys) + 1);
        }

        answer -= 1;

        return answer;
    }
}
```

<center>

| 경우의 수와 map만 이용한다면 참 간단하게 풀리는 문제였구나...<br>괜히 이상한데서 삽질 한 것 같다 ㅠㅜ<br>map을 이용해서 옷 종류의 개수를 구할 생각은 못했다. |
| --- |

</center>

<center>

| JAVA2의 풀이법을 Kotlin으로 변환한 버전 |
| :---: |

</center>