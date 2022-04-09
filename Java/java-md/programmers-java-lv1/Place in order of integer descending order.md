> 최초작성 : 2021.01.24

## ******Level1 - 정수 내림차순으로 배치하기**** (java)**

 [코딩테스트 연습 - 정수 내림차순으로 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12933)

| **문제 설명** |
| --- |
| 함수 solution은 정수 n을 매개변수로 입력받습니다.<br>n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.<br>예를들어 n이 118372면 873211을 리턴하면 됩니다. |

| **제한 조건** |
| --- |
|   -   n은 1이상 8000000000 이하인 자연수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| n | return |
| 118372 | 873211 |

​

### _**나의 풀이**_

1.  동적배열 arr을 선언한다.

2\. n이 0이 아니면, n을 10으로 나눈 나머지(맨 마지막 끝자리 숫자)를 arr 배열에 넣고

    나누기 10을 통해 그 숫자를 제거하는 반복문을 실행한다.

3\. 동적배열 arr을 정렬한다.

4\. 정렬된 arr을 반복문을 통하여 역으로 재정렬한 후 리턴한다.

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
  public long solution(long n) {
		long answer = 0;
		List<Object> arr = new ArrayList<Object>();
		
	    while (n != 0)
	    {
	    	arr.add(n%10);	 
	        n /= 10;
	    }
	    
	    arr.sort(null);
	    
	    for (int i=arr.size()-1; i>=0; i--) {
	    	answer *= 10;
	    	answer += (long) arr.get(i);
	    }

		return answer;
  }
}
```

| 동적배열을 선언해서 그 안에 숫자들을 넣는 것은 나쁘지 않은 방법이었다.   <br>, long 자체를 문자열로 변환 후 split하여 배열에 넣는 것도 괜찮았을 것 같다. |
| --- |

### _**JAVA1 코드 정리**_

1\. string res에 아무것도 없는 초기값을 선언해준다.

2\. 숫자 n을 문자열로 변환 후 char 배열로 쪼개고 배열을 오름차순으로 정렬한다.

3\. 정렬된 char배열은 각 요소들(c)를 차례로 문자열 res의 왼쪽에 붙여넣는다. (내림차순 정렬됨)

4\. 문자열 res를 Integer 형태로 변환 후 return 한다.

```java
public class ReverseInt {
    String res = "";
    public int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }
}
```

* **forEach**는 Java8에서 추가된 메소드이며, List, Map 등을 순회(Iterate)하는데 사용됨

* **람다 함수** : 프로그래밍 언어에서 사용되는 개념으로 **익명 함수(Anonymous functions)를 지칭**하는 용어
    * 람다식 사용법 : (매개변수, ...) -> { 실행문 ... }

| 람다식과 스트림을 이용하여 코드를 확 압축한 후 효율성을 높였다.<br>언젠가 나도 이런 소스를 짤 수 있을까...😪😪 |
| --- |

### _**JAVA2 코드 정리**_

1\. 매개변수 n을 문자열 형태로 변환하여 string str에 선언한다.

2\. str을 char배열로 쪼개 c라는 배열에 넣는다.

3\. c배열을 오름차순으로 정렬한 후 stringbuilder sb에 \[0\]부터 \[c.length\]까지 차례로 입력한다.

4\. sb를 역순으로 정렬하고 이를 문자열 형태로 변환한 후 정수로 변환하여 리턴한다.

```java
public class ReverseInt {
    public int reverseInt(int n){
        String str = Integer.toString(n);
        char[] c = str.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder(new String(c,0,c.length));  
        return Integer.parseInt(((sb.reverse()).toString()));
    }
}
```

| stringBuilder를 사용하여 문자를 합치고 정렬했다.<br>stringBuilder에 reverse라는 기능이 있다는 사실을 이 소스를 통해 처음 알게 되었다.<br>소스도 간결하고 나쁘지 않은 방법인 것 같다. |
| --- |