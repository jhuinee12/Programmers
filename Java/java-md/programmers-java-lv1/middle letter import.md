> 최초작성 : 2021.08.25

## ******Level1 - 가운데 글자 가져오기**** (java)**

 [코딩테스트 연습 - 가운데 글자 가져오기](https://programmers.co.kr/learn/courses/30/lessons/12903)

| **문제 설명** |
| --- |
| 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.<br>단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다. |

| **제한 조건** |
| --- |
|   -   s는 길이가 1 이상, 100이하인 스트링입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| s | return |
| "abcde" | "c" |
| "qwer" | "we" |

---

### _**나의 풀이**_

1\. 입력받은 문자열 s의 크기와 절반 값을 저장하는 변수 생성

2\. 문자열의 길이가 짝수이면 가운데 두개의 문자 출력

3\. 문자열의 길이가 홀수이면 가운데 하나의 문자 출력

```java
public String solution(String s) {
	String answer = "";
	
    /* 입력받은 문자열 s의 크기와 절반 값을 저장하는 변수 생성 */
	int size = s.length();
	int n = size/2;

	/* 문자열의 길이가 짝수이면 가운데 두개의 문자 출력*/
	if(size % 2 == 0)
		answer = s.substring(n-1,n+1);
	/* 문자열의 길이가 홀수이면 가운데 하나의 문자 출력*/
	else
	 answer = s.substring(n,n+1);
     
	return answer;
}
```

### _**JAVA1 코드 정리**_

```java
class StringExercise{
    String getMiddle(String word){
        return word.substring((word.length()-1) / 2, word.length()/2 + 1);    
    }
}
```

<center>

| 굳이 짝수/홀수로 나누지 않고 substring 안에 바로 넣음<br>때문에 substring의 시작 지점을 2로 나누기 전 word.length()-1을 해줌!<br>훨씬 깔끔한 소스 코드가 나옴 |
| :---: |

</center>

### _**JAVA2 코드 정리**_

```java
String getMiddle(String word){
	int length = word.length();
	int mid = length / 2;
	return length%2==0 ? word.substring(mid-1, mid+1) : word.substring(mid, mid+1) ;  
}
```

<center>

| 위 코드보다 이렇게 삼항연산자로 만드니까 훨씬 가독성이 높다. |
| --- |

</center>