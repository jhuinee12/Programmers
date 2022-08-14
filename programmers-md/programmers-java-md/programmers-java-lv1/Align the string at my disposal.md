> 최초작성 : 2021.01.24

## ******Level1 - 문자열 내 마음대로 정렬하기**** (java)**

 [코딩테스트 연습 - 문자열 내 마음대로 정렬하기](https://programmers.co.kr/learn/courses/30/lessons/12915)

| **문제 설명** |
| --- |
| 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,<br>각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.<br>예를 들어 strings가 \[sun, bed, car\]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다. |

| **제한 조건** |
| --- |
|-   strings는 길이 1 이상, 50이하인 배열입니다.|
|-   strings의 원소는 소문자 알파벳으로 이루어져 있습니다.|
|-   strings의 원소는 길이 1 이상, 100이하인 문자열입니다.|
|-   모든 strings의 원소의 길이는 n보다 큽니다.|
|-   인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.|

| **​입출력 예**    |  |  |
| --- | --- | --- |
| **strings** | **n** | **return** |
| \[sun, bed, car\] | 1 | \[car, bed, sun\] |
| \[abce, abcd, cdx\] | 2 | \[abcd, abce, cdx\] |

-   입출력 예#1

sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 \[car, bed, sun\] 입니다.

-   입출력 예#2

abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다.
<br>abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 \[abcd, abce, cdx\] 입니다.

---


### _**나의 풀이**_

1\. HashMap을 사용하여 비교할 문자 전까지를 mapA, 비교할 문자부터 마지막 문자까지를 mapB에 넣는다.

2\. 이때 key값은 차례대로 번호를 부여한다.

3\. mapB를 오름차순 정렬을 하면 비교할 문자부터 '사전순'으로 정렬이 된다.

4\. mapA와 mapB에 부여한 key값을 비교하여 key 값이 같다면, 두개의 문자열을 합쳐 answer 배열에 넣는다.

5\. 위 작업이 완료되면 answer 배열을 리턴한다.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        HashMap<Integer,String> mapA = new HashMap<>();
        HashMap<Integer,String> mapB = new HashMap<>();
		int a=0;
        
        
        for(int i=0; i<strings.length; i++)
        {
        	mapA.put(i,strings[i].substring(0,n));
        	mapB.put(i,String.valueOf(strings[i].substring(n,strings[i].length())));
        }
        
		List<Integer> keySetListA = new ArrayList<>(mapA.keySet());
		List<Integer> keySetListB = new ArrayList<>(mapB.keySet());
		
		Collections.sort(keySetListB, (o1, o2) -> (mapB.get(o1).compareTo(mapB.get(o2))));
		
		for(Integer keyB:keySetListB)
		{
			for (Integer keyA:keySetListA)
			{
				if (keyA == keyB)
				{
					answer[a] = mapA.get(keyA) + mapB.get(keyB);
					System.out.println(answer[a]);
					a++;
				}
			}
		}
		
        return answer;
    }
}
```

HashMap을 사용하여 key 값으로 비교해 정렬하였지만,

채점에서 25.0을 맞고 광탈..

그리고 '질문하기' 탭을 미친듯이 찾아본 결과 원인을 발견했다.

바로 **'마지막 제한조건' : 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.**

그래서 바로 코드를 수정했다. 소스가 완전 더러워졌다 ㅎㅎ

1\. 문자열 strings를 오름차순 정렬한다. (마지막 제한조건)

2\. HashMap을 사용하여 비교할 문자 전까지를 mapA, 비교할 문자를 mapB에 넣는다. (비교할 문자로만 정렬하기 위하여)

3\. 비교할 문자부터 마지막 문자까지를 mapC에 넣는다.

4\. 이때 key값은 차례대로 번호를 부여한다.

5\. mapB를 오름차순 정렬을 하면 비교할 문자가 '사전순'으로 정렬이 된다.

6\. mapA와 mapB와 mapC에 부여한 key값을 비교하여 key 값이 모두 일치하면, 세개의 문자열을 합쳐 answer 배열에 넣는다.

5\. 위 작업이 완료되면 answer 배열을 리턴한다.

```java
import java.util.*;
public class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        String[] answer = new String[strings.length];
        HashMap<Integer,String> mapA = new HashMap<>();
        HashMap<Integer,String> mapB = new HashMap<>();
        HashMap<Integer,String> mapC = new HashMap<>();
        int a=0;

        for(int i=0; i<strings.length; i++)
        {
            mapA.put(i,strings[i].substring(0,n));
            mapB.put(i,String.valueOf(strings[i].charAt(n)));
            mapC.put(i,String.valueOf(strings[i].substring(n+1,strings[i].length())));
        }

        List<Integer> keySetListA = new ArrayList<>(mapA.keySet());
        List<Integer> keySetListB = new ArrayList<>(mapB.keySet());
        List<Integer> keySetListC = new ArrayList<>(mapC.keySet());

        Collections.sort(keySetListB, (o1, o2) -> (mapB.get(o1).compareTo(mapB.get(o2))));

        for(Integer keyB:keySetListB)
        {
            for (Integer keyA:keySetListA)
            {
                for (Integer keyC:keySetListC)
                {
                    if (keyA == keyB && keyB == keyC)
                    {
                        answer[a] = mapA.get(keyA) + mapB.get(keyB) + mapC.get(keyC);
                        System.out.println(answer[a]);
                        a++;
                    }
                }
            }
        }
        return answer;
    }
}
```
<center>

| 이건 뭐 백퍼센트 나보다 효율적인 소스는 넘쳐날 것이다.<br>하지만 내가 이틀 내내 낑낑거리며 짠 소스는 이게 최선이다...<br>난 스스로 hashMap을 생각해낸 자체만으로 그냥 축하함..<br>이것도 뭐 새로운 방법이 될 수 있겠지 ㅎㅎ 거지같지만.. 좀만 다듬으면 될거야... |
| :---: |

</center>

### _**JAVA1 코드 정리**_

1\. arr 동적 배열을 선언한다.

2\. arr에는 strings 문자열에서 비교할 문자와 strings 문자열을 차례로 넣는다.

   (ex. bed 에서 e가 비교할 문자 -> ebed 로 arr에 입력)

3\. arr을 오름차순으로 정렬한다.

4\. answer는 arr에 입력된 문자만큼(=strings.length) 크기를 부여한다.

5\. answer는 arr에서 앞 문자를 제외하기 위해 1부터 arr의 마지막까지를 넣는다.

6\. answer를 리턴한다.

```java
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }
}
```

<center>

| 그저 비교할 문자를 맨 앞으로 빼서 정렬하고 그걸 빼버리면 되는데<br>그런 간단한 생각을 하지 못했다...<br>머리가 띵함... |
| :---: |

</center>