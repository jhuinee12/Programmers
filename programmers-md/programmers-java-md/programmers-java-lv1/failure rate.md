> 최초작성 : 2021.08.16

## ******Level1 - 실패율**** (java)**

 [코딩테스트 연습 - 실패율](https://programmers.co.kr/learn/courses/30/lessons/42889)

| **문제 설명** |
| --- |
| 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.<br>이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.<br>-   실패율은 다음과 같이 정의한다.<br>-   스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수  전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라. |

| **제한 조건** |
| --- |
|   -   스테이지의 개수 N은 1 이상 500 이하의 자연수이다.<br>-   stages의 길이는 1 이상 200,000 이하이다.<br>-   stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.<br>-   각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.<br>-   단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.<br>-   만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.<br>-   스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.   |

| **​입출력 예** |  |  |
| --- | --- | --- |
| N | stages | result |
| 5 | \[2,1,2,6,2,4,3,3\] | \[3,4,2,1,5\] |
| 4 | \[4,4,4,4,4\] | \[4,1,2,3\] |

**입출력 예#1**
- 1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
    -   1 번 스테이지 실패율 : 1/8
- 2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
    -   2 번 스테이지 실패율 : 3/7
- 마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
    -   3 번 스테이지 실패율 : 2/4
    -   4번 스테이지 실패율 : 1/2
    -   5번 스테이지 실패율 : 0/1
- 각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
    -   \[3,4,2,1,5\]
    
**입출력 예#2**
- 모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
    -   \[4,1,2,3\]

---

### _**나의 풀이**_

1\. 스테이지 번호를 키값으로 하고, 각 스테이지의 실패율을 밸류값으로 갖는 Map 생성

2\. 각 스테이지의 실패율을 반복문을 이용하여 계산하고, Map에 put

3\. Map의 밸류값을 내림차순으로 정렬하고, 키값을 answer 배열에 넣고 리턴

```java
public int[] solution(int N, int[] stages) {
	int[] answer = new int[N];	// 스테이지 저장 (실패율 높은 순으로)
	Map<Integer, Double> failure = new HashMap<>();	// 실패율 저장 (키:스테이지, 밸류:실패율)
	int challenger = stages.length;	// 도전자 인원수
	
	// 1부터 스테이지까지 반복문
	for (int i=1; i<=N; i++) {
		int count = 0;	// 각 스테이지 별 도달한 인원수 체크
		
		// stages 배열을 도는 반복문
		for (int j=0; j<stages.length; j++) {
			if (stages[j] == i) count++;
		}
		
		// map 안에 (현재스테이지, 실패율) 저장
		if (count == 0 ) failure.put(i, 0.0);
		else failure.put(i,(double) count/(double)challenger);
		
		// 도전자 인원수에서 앞 스테이지에 떨어진 인원수 제거
		challenger -= count;
	}

	// map을 value 기준 내림차순으로 정렬 후 keySetList에 저장
	List<Integer> keySetList = new ArrayList<>(failure.keySet());
	Collections.sort(keySetList, (o1, o2) -> (failure.get(o2).compareTo(failure.get(o1))));
	
	// keySetList에 저장된 값에서 key 값만 뽑아 answer에 저장
	for (int i=0; i<answer.length; i++)
		answer[i] = keySetList.get(i);
	
	return answer;
}
```

<center>

| 이게 예전에 풀다가 포기한 문제였다.<br>그리고 오늘 새로운 마음으로 시작하고자 까먹은 문제를 다시 읽고, 새로 문제 풀이를 시작했다.<br>그리고 거의 한시간 만에 풀었다... 전에 왜 포기했지?<br>예전에 풀었던 소스코드를 보니 참담했다 ㅋㅋㅋㅋㅋ... 어디 내놓기 창피한 코드<br>그때도 나름 다 풀긴 했는데, 테스트케이스 2개가 실패가 떠서 완료를 못했는데...<br>음, 못할만 했던 코드다 |
| :---: |

</center>

### _**JAVA1 코드 정리**_

1\. 각 스테이지 별로 실패한 인원수 체크해서 answer 배열에 차례대로 저장

2\. answer 배열을 이용하여 실패율 계산하고 tempArr 배열에 저장

3\. answer 배열에는 1부터 N까지 차례로 스테이지 저장

4\. tempArr 배열을 내림차순으로 정렬하고, 이에 맞춰 동시에 answer 배열도 옮김

```java
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];	// 스테이지를 저장할 정답 배열
        double[] tempArr = new double[N];	// 실패율을 저장할 배열
        int arrLength = stages.length;	// 도전자 인원수
        int idx = arrLength;
        double tempD = 0;	// 실패율 정렬을 위해 사용할 변수
        int tempI = 0;	// 스테이지 정렬을 위해 사용할 변수
		
        /*각 스테이지 별로 실패한 인원수 체크*/
        for (int i = 0; i < arrLength; i++) {
            int stage = stages[i];
            if (stage != N + 1)	// 현재 스테이지가 최상단 스테이지가 아니면
                answer[stage - 1] += 1;	// 해당 스테이지(배열에서 index값)의 도전자 개수 추가
        }
        
        /*실패율 계산해서 tempArr 배열에 저장*/
        for (int i = 0; i < N; i++) {
            int personNum = answer[i];
            tempArr[i] = (double) personNum / idx;
            idx -= personNum;	// 다음 반복문에서는 앞 인원수 제외하고 계산
            answer[i] = i + 1;	// answer 배열에는 1부터 N까지 값을 저장
        }

        /*배열 내림차순 정렬*/
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
            	// tempArr에 맞춰서 동시에 answer도 정렬
                if (tempArr[j - 1] < tempArr[j]) {
                    tempD = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = tempD;

                    tempI = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = tempI;
                }
            }
        }
        return answer;
    }
}
```

<center>

| 내가 처음 사용하려고 했던 방식.<br>이런식으로 하면 import에 의존하지 않고 정말 '알고리즘'으로 푸는 것이라 좋은 것 같다.<br>나도 동시에 바꾸는 걸 생각하고 소스를 짜봤는데, 이렇게 깔끔하게는 나오지 않았다...ㅜ |
| :---: |

</center>