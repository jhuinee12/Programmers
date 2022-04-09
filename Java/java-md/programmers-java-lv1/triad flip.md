> 최초작성 : 2021.10.27

## ******Level1 - 3진법 뒤집기****(java)**

 [코딩테스트 연습 - 3진법 뒤집기](https://programmers.co.kr/learn/courses/30/lessons/68935)

| **문제 설명** |
| --- |
| 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요. |

| **제한 조건** |
| --- |
|   -   n은 1 이상 100,000,000 이하인 자연수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| n | result |
| 45 | 7 |
| 125 | 229 |


입출력 예#1
- 답을 도출하는 과정은 다음과 같습니다.
    - (1) n(10진법) : 45
    - (2) n(3진법) : 1200
    - (3) 앞뒤 반전(3진법) : 0021
    - (4) 10진법으로 표현 : 7
-   따라서 7을 return 해야 합니다.

입출력 예#2
-   답을 도출하는 과정은 다음과 같습니다.
    - (1) n(10진법) : 125
    - (2) n(3진법) : 11122
    - (3) 앞뒤 반전(3진법) : 22111
    - (4) 10진법으로 표현 : 229
-   따라서 229를 return 해야 합니다.   |  |

---

### _**나의 풀이**_

1\. 입력 받은 n을 3진수로 변환할 때 역수로 저랑

2\. 3진수를 10진수로 변환 후 리턴

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        String ternary = "";	// 3진수 변환값 저장
        int div = n;
        
        // 1. n을 3진수로 변환
        while (div>=3) {
        	ternary = (div % 3) + ternary;
        	div /= 3;
        }
        ternary = div + ternary;
        
        // 2. 3진수를 10진수로 변환
        int i = 0;
        for (String t : ternary.split("")) {
        	answer += Integer.parseInt(t) * (int) Math.pow(3, i);
        	i++;
        }
        
        return answer;
    }
}
```

### _**JAVA1 코드 정리**_

1\. 입력받은 n을 3진법으로 변환

2\. 3진법으로 변환한 값을 뒤집기 : StringBuilder(a).reverse()

3\. 3진법을 10진법으로 변환 : Integer.parseInt(a,3)

```java
class Solution {
    public int solution(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    }
}
```

* 10진수 변환 방법
    * Integer.valueOf(\[값\], \[진수\])
    * Integer.parseInt(\[값\],\[진수\])