> 최초작성 : 2021.01.17

## **Level2 - 소수찾기(java)**

 [코딩테스트 연습 - 소수 찾기](https://programmers.co.kr/learn/courses/30/lessons/12921)

| **문제 설명** |
| --- |
| 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.<br>소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.<br>(1은 소수가 아닙니다.) |

| **제한 조건** |
| --- |
|   -   n은 2이상 1000000이하의 자연수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| n | return |
| 10 | 4 |
| 5 | 3 |

|입출력 예#1|
|---|
|1부터 10 사이의 소수는 \[2,3,5,7\] 4개가 존재하므로 4를 반환|

|입출력 예#2|
|---|
|1부터 5 사이의 소수는 \[2,3,5\] 3개가 존재하므로 3를 반환|

​

### _**나의 풀이**_

1\. answer는 모든 숫자의 개수 (n-1)

2\. n이 4 이상의 수이면 4부터 n까지 for문을 돌림

3\. 2부터 위 n의 위치(i)의 제곱근 +1 까지 for문을 돌려 나누어 떨어지는 순간 answer--

(소수가 아닐 경우 answer에서 제거하는 방식)

```java
class Solution {
  public int solution(int n) {
    int answer = n-1;

    for (int i=4; i<=n; i++) {
      for (int j=2; j<Math.sqrt(i)+1; j++) {
        if (i%j == 0)
        {
          answer--;
          break;
        }
      }
    }

    return answer;
  }
}
```

* 이중for문에서 n/2+1까지 돌리면 효율성0, 테스트 통과X -> Math.sqrt를 사용하면 통과_

**\* 이 문제는 에라토스테네스의 체를 활용하여 풀이해야함**_

**[https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98\_%EC%B2%B4](https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4)**

 * [에라토스테네스의 체 - 위키백과](https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4)

### _**JAVA 1코드 정리**_

1\. 소수 여부를 판별하는 배열 checked 선언

2\. 2부터 n까지 반복

3\. j는 n의 위치(i)부터 n까지 반복하여 소수에 해당하지 않는 수는 true 처리

4\. false만 카운트

```java
class Solution {
  public int solution(int n) {
    int answer = 0;
    boolean[] checked = new boolean[n + 1];

    for (int i = 2; i <= n; i++) {
      if (!checked[i])
        answer++;
      for (int j = i; j <= n; j += i) {
        if (!checked[j])
        checked[j] = true;
      }
    }      
    return answer;
  }
}
```

### _**JAVA 2코드 정리**_

1.  i는 2부터 n까지, j는 2부터 i까지 이중 for문

2\. i가 j로 나누어 떨어지면 다음 반복, 아니면 result에 추가

~_(왜 if(j==i)로 result를 계산하는지 의문...)_~

```java
class NumOfPrime {
  int numberOfPrime(int n) {
    int result = 0;
    
    for(int i=2; i<=n; i++){
      for(int j=2; j<=i; j++){
        if(j == i){
          ++result;
         } else if(i%j == 0){
          break;
        }
      }
    }

    return result;
  }
}
```

|또한 소수 찾기의 가장 큰 핵심은 '에라토스테네의 체'라는데 아무리 읽어도 내가 코드했던 부분이랑 뭐가 다른지 의문이었다.<br>그랬는데 /2 때문이었다니.. 허무...<br>Math.sqrt와 /2 의 계산 효율성 차이가 큰 줄 처음 알았다.|
|---|