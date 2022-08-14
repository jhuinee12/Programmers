> 최초작성 : 2021.01.27

## ******Level2 - 전화번호 목록**** (java)**

 [코딩테스트 연습 - 전화번호 목록](https://programmers.co.kr/learn/courses/30/lessons/42577)

| **문제 설명** |
| --- |
| 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.<br>전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.|
|-   구조대 : 119 -   박준영 : 97 674 223<br>-   지영석 : 11 9552 4421|
|전화번호부에 적힌 전화번호를 담은 배열 phone\_book 이 solution 함수의 매개변수로 주어질 때,<br>어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요. |

| **제한 조건** |
| --- |
|   -   phone\_book의 길이는 1 이상 1,000,000 이하입니다. -   각 전화번호의 길이는 1 이상 20 이하입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| phone\_book | return |
| \["119", "97674223", "1195524421"\] | false |
| \["123", "456", "789"\] | true |
| \["12", "123", "1235", "567", "88"\] | false |

입출력 예#1
- 앞에서 설명한 예와 같습니다.

입출력 예#2
- 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

입출력 예#3
- 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.

---

### _**나의 풀이**_

1\. phoneBook을 도는 이중 반복문을 선언한다.

2\. j가 i가 아닐 때, phoneBook\[i\]가 phoneBook\[j\]의 시작 문자열이면 false를 리턴한다.

3\. 리턴된 값이 없으면 true를 리턴한다.

```java
class Solution {
  public boolean solution(String[] phoneBook) {
    for(int i=0; i<phoneBook.length; i++){
      for(int j=0; j<phoneBook.length; j++){  
        if(i != j){
          if(phoneBook[j].startsWith(phoneBook[i])){
          	return false;
          }
        }
      }
    }
    return true;
  }
}
```

* startsWith(String \_) : 비교 대상 문자열이 입력된 문자열 값으로 시작되는지 여부 확인

<center>

|레벨2 치고는 비교적 간단하게 해결되는 문제|
|:--:|

</center>

### _**JAVA1 코드 정리**_

1\. j는 i+1부터 시작되는 반복문 생성

2\. phoneBook\[j\]가 phoneBook\[i\]로 시작되면 false 리턴 / phoneBook\[i\]가 phoneBook\[j\]로 시작되면 false 리턴

3\. 리턴 값이 없으면 true 리턴

```java
class Solution {
    public boolean solution(String[] phoneBook) {
       for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}
```

<center>

|내용을 분석해보면 내 코드와 크게 다르지 않다.<br>startsWith를 쓴게 같기 때문.|
|:--:|

</center>

### _**JAVA2 코드 정리**_

1\. phoneBook을 오름차순으로 정렬한다.

2\. phoneBook을 도는 반복문을 생성하고, phoneBook\[i+1\]에 phoneBook\[i\]가 포함되어있으면 false를 리턴한다.

3\. 리턴값이 없으면 true를 리턴한다.

```java
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
```

<center>

|이건 우선 '정렬'을 시킨 후 앞 뒤 값을 비교하는 방법으로 진행되었다.<br>그러다보니 반복문을 한번만 하면 된다는 장점이 생긴다. ㅇㅈ|
|:--:|

</center>