> 최초작성 : 2021.01.18

## ******Level1 - 자연수 뒤집어 배열로 만들기**** (java)**

 [코딩테스트 연습 - 자연수 뒤집어 배열로 만들기](https://programmers.co.kr/learn/courses/30/lessons/12932)

| **문제 설명** |
| --- |
| 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.<br>예를들어 n이 12345이면 \[5,4,3,2,1\]을 리턴합니다. |

| **제한 조건** |
| --- |
|   -   n은 10,000,000,000이하인 자연수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| n | return |
| 12345 | \[5,4,3,2,1\] |

​

### _**나의 풀이**_

1.  string a 는 정수 n을 문자열로 변경한 것이다. : 길이를 알기 위한 용도

2\. n을 자릿수마다 쪼개서 answer 배열에 넣는다. (%10)

3\. 1의 자리부터 역순으로 넣어진 배열을 출력한다.

```java
class Solution {
  public int[] solution(long n) {
      String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt=0;
 
        while(n>0) {
            answer[cnt]=(int)(n%10);
            n/=10;
            cnt++;
        }
      return answer;
  }
}
```

| %10 만 생각할 줄 알면 아주 간단한 문제 |
| --- |

### _**JAVA1 코드 정리**_

1\. n을 string으로 바꿔 s에 저장한다.

2\. s를 stringbuilder에 넣고 reverse()를 통해 역순 정렬한다.

3\. 그렇게 정렬된 값을 자릿수마다 쪼개 ss 배열에 넣는다.

4\. ss 배열에 있는 string 값을 숫자 배열 answer에 차례로 넣고 출력한다.

```java
class Solution {
  public int[] solution(long n) {
      String s = String.valueOf(n);
      StringBuilder sb = new StringBuilder(s);
      sb = sb.reverse();
      String[] ss = sb.toString().split("");

      int[] answer = new int[ss.length];
      for (int i=0; i<ss.length; i++) {
          answer[i] = Integer.parseInt(ss[i]);
      }
      return answer;
  }
}
```

| StringBuilder를 사용하면 간편할 때가 많긴 한데, 이상하게 나는 StringBuilder를 잘 사용하지 않게 된다.<br>불편하기도 하고 뭔가 익숙치 않아서? |
| --- |