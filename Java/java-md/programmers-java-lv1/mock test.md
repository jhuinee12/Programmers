> 최초작성 : 2021.01.16

## **Level1 - 모의고사 (java/kotlin)**

[코딩테스트 연습 - 모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840)

| **문제 설명** |
| --- |
| 수포자는 수학을 포기한 사람의 준말입니다.<br>수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.<br>수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.|
|1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...<br>2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...<br>3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...|
|1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,<br>가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요. |

| **제한 조건** |
| --- |
|   -   시험은 최대 10,000 문제로 구성되어있습니다.|
|   -   문제의 정답은 1, 2, 3, 4, 5중 하나입니다. |
|   -   가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.   |

| **​입출력 예**    |  |
| --- | --- |
| answer | return |
| \[1,2,3,4,5\] | \[1\] |
| \[1,3,2,4,2\] | \[1,2,3\] |

|입출력 예#1|
|---|
|- 수포자 1은 모든 문제를 맞혔습니다.|
|- 수포자 2는 모든 문제를 틀렸습니다.|
|- 수포자 3은 모든 문제를 틀렸습니다.|
|따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.|

|입출력 예#2|
|---|
|모든 사람이 2문제씩을 맞췄습니다.|

### **_나의 풀이_**

풀긴 했는데... 제출 전에 '다른 사람 코드 보기'를 해버려서 제출 불가능 ㅠ

저장해놓은 파일도 사라져서 내 코드 모른다...

(프로그래머스 입문자일때 풀었던 문제)

### **_JAVA1 코드 정리_**

1\. 세 사람의 찍기 방식을 각각의 배열에 정리하고 세 사람의 점수를 넣을 크기 3의 배열 score를 선언

2\. 입력 받은 정답(answer)를 for문을 이용하여 각각 a,b,c 배열과 비교하여 정답일 때마다 score에 입력

3\. 가장 점수를 많이 받은 받은 배열을 각각 1,2,3으로 지정하여 동적배열에 입력

(1에서 3개까지 나올 수 있기 때문에 크기를 따로 지정해주지 않고 동적배열로 선언)

```java
class Solution {
    public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
```

* Math.max(score\[1\], score\[2\])를 이용하여 나온 큰 값을 score\[0\]과 비교하여 최종적으로 가장 큰 값 구함

* _왜 (Math.max(score\[0\],score\[1\],score\[2\])로 사용하지 않았는지 의문_ : 이 함수는 **두개의 인자를 비교**하기때문

### **_JAVA2 코드 정리_**

1\. 각 세명의 학생의 찍기 방식을 2차원 배열로 선언

2\. 정답률을 기록할 hit 배열을 선언하고 정답일 때마다 +1

_(위 코드와는 다르게 이차원배열을 이용하여 이 부분도 더 깔끔하게 짜여 있음)_

3\. 역시 동적 배열을 이용하여 가장 높은 점수를 기록한 리스트를 숫자를 이용해 추가함

```java
class Solution {
    public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }
}
```

|내 기준으로는 지금까지 풀었던 프로그래머스 level1 문제 중에 가장 까다로운 문제가 아니었나 싶다.<br>제일 막막했고, 머리가 잘 안돌아갔지만 막상 정답을 알고 분석을 해보니 그리 어렵지 않았나? 싶은 느낌..<br>그래도 막상 직접 풀라고 하면 못풀걸 알기에 ㅎㅎ<br>조금 더 공부가 필요한 것 같다.|
|---|