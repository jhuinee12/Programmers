> 최초작성 : 2021.01.20

## ******Level1 - 문자열 내림차순으로 배치하기**** (java)**

 [코딩테스트 연습 - 문자열 내림차순으로 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12917)

| **문제 설명** |
| --- |
| 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.<br>s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다. |

| **제한 조건** |
| --- |
|   -   str은 길이 1 이상인 문자열입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| s | return |
| "Zbcdefg" | "gfedcbZ" |

​

### _**나의 풀이**_

1\. 문자열 s를 한글자씩 쪼개 넣는 sol 배열을 만든다.

2\. sol 배열을 오름차순으로 정렬시킨다.

3\. 정렬시킨 sol 배열을 다시 내림차순으로 정렬시키고 StringBuilder를 통해 문자열로 변경하여 리턴한다.

```java
import java.util.Arrays;

class Solution {
  public String solution(String s) {
        char[] sol = s.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
  }
}
```

### _**JAVA1 코드 정리**_

1\. 입력받은 문자열 str을 문자 단위로 쪼갭니다.

2.  쪼갠 문자들을 내림차순으로 정렬합니다.

3\. 쪼갠 문자들(Collectors)을 합치고(joining()) 리턴합니다.

```java
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;

public class ReverseStr {
    public String reverseStr(String str){
        return Stream.of(str.split(""))
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.joining());
    }
}
```

<center>

| 난 죽었다 깨어나도 할 수 없을법한 코딩...<br>억지로 해석했는데 해석이 안되는 코딩... |
| :---: |

</center>