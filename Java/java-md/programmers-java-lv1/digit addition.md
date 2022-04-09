> 최초작성 : 2021.01.24

## ******Level1 - 자릿수 더하기**** (java)**

 [코딩테스트 연습 - 자릿수 더하기](https://programmers.co.kr/learn/courses/30/lessons/12931)

| **문제 설명** |
| --- |
| 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.<br>예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다. |

| **제한 조건** |
| --- |
|   -   N의 범위 : 100,000,000 이하의 자연수   |

| **​입출력 예**    |  |
| --- | --- |
| n | answer |
| 123 | 6 |
| 987 | 24 |

-   입출력 예#1

문제의 예시와 같습니다.

-   입출력 예#2

9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.

---

### _**나의 풀이**_

1\. n이 0이 아니면 계속 도는 반복문을 만든다.

2\. answer는 n을 10으로 나눈 나머지(n의 가장 마지막 자리의 수)를 누적해서 더한다.

3\. n을 10으로 나누면서 n의 가장 마지막 자리의 수를 없애는 작업을 반복한다.

4\. n이 0이 되면 지금까지 누적된 answer 값을 리턴한다.

```java
import java.util.*;

public class Solution {
  public int solution(int n) {
    int answer = 0;

    while(n != 0){
      answer += (n % 10);
      n = n/10;
    }

    return answer;
  }
}
```

||
|:--:|
|이 문제는 %10 과 /10 만 생각해내면 아주 간단하게 풀리는 문제다.|
|이런 방법은 문제를 풀다보면 상당히 많이 나오는 축에 속하기에 간단하게 해결할 수 있다.|

### _**JAVA1 코드 정리**_

1\. answer는 n을 10으로 나눈 나머지(n의 가장 마지막 자리의 수)를 누적해서 더한다.

2\. n이 10보다 작으면 (1의자리 수만 남으면) while문을 빠져나오고 아니면 n의  가장 마지막 자리의 수를 없앤다.

```java
import java.util.*;

public class Solution {
  public int solution(int n) {
    int answer = 0;

    while(true){
      answer+=n%10;
      if(n<10)
     	 break;
      n=n/10;
    }
  }
}
```

||
|:--:|
|나는 while문의 조건을 n!=0으로 주었지만, 이 문제는 true로 주었다.|
|if문을 타면 while문을 빠져나오도록 만들어주었다.|

### _**JAVA2 코드 정리**_

1\. n의 길이를 구하기 위해 log(n)을 주었고 여기에 +1을 해주었다. (한자리수면 log(n)=0, 두자리수면 log(n)=1이기 때문)

2\. i는 n의 길이까지 도는 반복문을 생성한다.

3\.  answer는 n을 10으로 나눈 나머지(n의 가장 마지막 자리의 수)를 누적해서 더한다.

4. n의  가장 마지막 자리의 수를 없앤다.

```java
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int len = (int)Math.log10(n)+1;
        for(int i = 0; i < len; i++) {
            answer += n%10;
            n = n/10;   
        }
        return answer;
    }
}
```

||
|:--:|
|%10과 /10은 거의 국룰이다.|
|이 소스에서의 특이점은 'len'을 구하는 방식으로 반복문을 진행했다는 것이다.|
|숫자의 길이를 log를 쓰면 쉽게 구할 수 있다는 것을 생각해냈다는게 대단하다.|