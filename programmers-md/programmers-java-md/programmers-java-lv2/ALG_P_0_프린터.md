> 최초작성 : 2021.01.26

## ******Level2 - 프린터**** (java)**

 [코딩테스트 연습 - 프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)

| **문제 설명** |
| --- |
| 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다<br>그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.<br>이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.<br>이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다. |
| 1\. 인쇄 대기 목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.<br>2\. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.<br>3\. 그렇지 않으면 J를 인쇄합니다. |
| 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.<br>내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다.<br>위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.<br>현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와<br>내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,<br>내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.|

| **제한 조건** |
| --- |
|-   현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다. |
|-   인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.|
|-   location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| priorities | location | return |
| \[2, 1, 3, 2\] | 2 | 1 |
| \[1, 1, 9, 1, 1, 1\] | 0 | 5 |

입출력 예#1
- 문제에 나온 예와 같습니다.

입출력 예#2
- 6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.

---

### _**나의 풀이**_

1\. loc 배열에 0부터 차례로 숫자를 입력한다.

2\. 만약 현재 배열 위치에 있는 데이터보다 더 큰 값이 뒤에 존재한다면, 그 값을 temp\[\]와 locTemp\[\]에 초기화 시킨다.

3\. priorities와 loc 배열의 값들을 한칸씩 앞으로 옮긴다.

4\. 아까 따로 저장한 값은 가장 끝으로 보내고 다시 for문을 돈다.

5\. 반복문이 끝나면 loc 배열과 location을 통해 해당 위치에 있는 priorities 값을 리턴한다.

```java
class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		int len = priorities.length; // 정수 len은 priorities 배열의 길이
		int[] loc = new int[len];
		
		for (int i=0; i<len; i++)
			loc[i] = i; // location 위치 구하기 위한 배열 (answer)
		
		for (int i=0; i<len; i++) {
			for (int j=i+1; j<len; j++) {
				if (priorities[i]<priorities[j]) {
					int temp = priorities[i];
					int locTemp = loc[i];
					for (int k=i; k<len-1; k++)
					{
						priorities[k] = priorities[k+1];
						loc[k] = loc[k+1];
					}
					priorities[len-1] = temp;
					loc[len-1] = locTemp;
					j = i;
				}
			}
		}
		
		for (int i=0; i<len; i++) {
			if (loc[i] == location)
				return i+1;
		}
		
		return 0;
    }
}
```

<center>

||
|:--:|
|내가 loc 배열을 선언한 이유는 priorities와 대치되는 주소값을 넣어주고 싶은 것이었는데,<br>그 경우 map을 이용하면 어땠을까?|

</center>

### _**JAVA1 코드 정리**_

1\. LinkedList의 que를 생성한다.

2\. prorities의 데이터들을 각각 que에 add하고 prorities를 오름차순으로 정렬한다.

3\. que가 비어있지 않은 상태라면 계속 도는 반복문을 생성한다.

4\. int i에 que에 가장 아래 있는 데이터를 넣는다.

5\. que의 가장 아래 있는 데이터와 prorities의 가장 끝에 있는 데이터가 같다면, answer++, l--;

6\. 만약 l(location)의 값이 0보다 작아지면 반복문을 빠져나오고 아니면 계속 반복

7\. que의 가장 아래 있는 데이터와 prorities의 가장 끝에 있는 데이터가 같지 않다면, que에 현재 i 값을 add

8\. l--, l(location)이 0보다 작으면 l=que.size()-1

9\. answer 값을 리턴한다.

```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
```

* **Linked List**는 Array List와는 다르게 엘리먼트와 엘리먼트 간의 연결(link)을 이용해서 리스트를 구현한 것
    * 데이터를 담고 있는 노드들이 연결되어 있고, 노드의 포인터가 이전 노드와 다음 노드와의 연결을 담당
    * Node는 LinkedList에 객체를 추가하거나 삭제하면 앞뒤 링크만 변경되고 나머지 링크는 변경X
    * 중간에 데이터를 추가나 삭제하더라도 전체의 인덱스가 한 칸씩 뒤로 밀리거나 당겨지는 일이 없기에

      ArrayList에 비해서 데이터의 추가나 삭제가 용이

* **que.poll():** 가장 먼저 보관한 값 꺼내기

<center>

|이해 X ... 도와주세요|
|:--:|

</center>