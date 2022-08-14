> 최초작성 : 2021.01.07

## **Level1 - K번째 수 (java/kotlin)**

[코딩테스트 연습 - K번째수](https://programmers.co.kr/learn/courses/30/lessons/42748)

| **문제 설명** |
| --- |
| 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.|
|예를 들어 array가 \[1, 5, 2, 6, 3, 7, 4\], i = 2, j = 5, k = 3이라면<br>1.  array의 2번째부터 5번째까지 자르면 \[5, 2, 6, 3\]입니다.<br>2.  1에서 나온 배열을 정렬하면 \[2, 3, 5, 6\]입니다.<br>3.  2에서 나온 배열의 3번째 숫자는 5입니다.|
|배열 array, \[i, j, k\]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,<br>commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록<br>solution 함수를 작성해주세요. |

| **제한 조건** |
| --- |
|   -   array의 길이는 1 이상 100 이하입니다. -   array의 각 원소는 1 이상 100 이하입니다. -   commands의 길이는 1 이상 50 이하입니다. -   commands의 각 원소는 길이가 3입니다   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| arr | commands | return |
| \[1, 5, 2, 6, 3, 7, 4\] | \[\[2, 5, 3\], \[4, 4, 1\], \[1, 7, 3\]\] | \[5, 6, 3\] |

### _**나의 풀이법**_

1.  동적배열 list를 만들고, list에 array\[commands\[i\]\[0\]\] 값부터 array\[command\[i\]\[1\]\]값까지 넣는 for문 생성

2\. list를 정렬하고 list에서 commands\[i\]\[2\]번째 숫자를 출력

3\. 1,2 과정을 for문을 통해 commands.length까지 반복하고 이를 answer에 저장해 리턴

```java
class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];
    	
    	for (int i=0; i<commands.length; i++) {
        	ArrayList<Integer> list = new ArrayList<>();
        	
        	for (int j=commands[i][0]-1; j<=commands[i][1]-1; j++)
        		list.add(array[j]);
        	
        	Collections.sort(list);
        	
        	answer[i] = list.get(commands[i][2]-1);
    	}
    	
        return answer;
    }
}
```

### _**JAVA1 코드 정리**_

1\. temp 배열을 만들어 copyOfRange를 통해 array 배열을 복사해 넣는다.

2\. temp 배열을 정렬한다.

3\. 정렬된 temp에서 원하는 위치(commands\[i\]\[2\]-1)를 answer 값에 넣고 리턴한다.

```java
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
```

\* Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준 : 배열 복사  
  

### _**JAVA2 코드 정리**_

1\. array 배열을 잘라 넣을 배열 ret를 생성 하고 ret의 길이 m을 구한다.

2\. m이 1이면 ret에는 array의 해당 자리 값을 넣는다.

3\. commands에 제시한 주소대로 array 배열을 잘라 ret에 넣는다.

4\. 정렬 sort 함수를 따로 선언해주고 ret를 정렬한다.

5\. 정렬 후 commands\[n\]\[2\]에서 요구한 자리수 ret 값을 구해 리턴한다.

```java
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
    }

    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
}
```

|나는 원래 만들어져있던 java 함수를 끌어다 사용했고, Java2는 그 함수들을 직접 풀어 메소드를 만들어 사용하였다.<br>두 방법 다 중요하지만, 알고리즘을 정확하게 공부하기 위해서는 Java2처럼 만드는 법도 익혀야한다고 생각한다.|
|---|